package com.havfun.appsservice.helper;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.base.HavfunException;
import com.havfun.service.dao.UserDao;
import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.message.LoginRequest;
import com.havfun.service.message.LoginResponse;
import com.havfun.service.message.admin.AdminLoginRequest;
import com.havfun.service.message.admin.AdminLoginResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.service.message.data.UserMessage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.Tasks;
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.data.LoginInfo;

public class AuthHelper {
	public final static int AUTH_FAIL_UNKNOWN						= -1;
	public final static int AUTH_NO_SESSION_COOKIE 					= -2;
	public final static int AUTH_SESSION_DECODE_FAIL 				= -3;
	public final static int AUTH_DECODE_FORMAT_FAIL 				= -4;
	public final static int AUTH_DECODE_VALUE_FORMAT_FAIL 			= -5;
	public final static int AUTH_LOGIN_INFO_EMPTY 					= -6;
	public final static int AUTH_DB_TOKEN_NOT_MATCH 				= -7;
	public final static int AUTH_DB_EXPIRED							= -8;
	public final static int AUTH_USER_LOGIN_NOT_MATCH       		= -9;
	public final static int AUTH_CANNOT_FOUND_USER_IN_COMMON_SCHEMA	= -10;
	public final static int AUTH_CANNOT_FOUND_USER_IN_BOS			= -11;
	public final static int AUTH_OK 								= 0;
	public final static int AUTH_FOUND_IN_DB 						= 1;
	
	public final static int LOGIN_CANNOT_FIND_CLIENT_IN_COMMON_SCHEMA 	= -1;
	public final static int LOGIN_CANNOT_FIND_USER 	= -2;
	public final static int LOGIN_OK									= 0;
	
	public final static int LOGOUT_FAIL_UNKNOWN							= -1;
	public final static int LOGOUT_OK 									= 0;

	public final static String LOGON_CLIENT = "logonClient";		
	
	private final static String SHA_256 = "SHA-256";
//	private final static String TRIPLE_DES = "TripleDES";
	private final static String RSA = "RSA";
	
	private static final Logger logger = LogManager.getLogger(AuthHelper.class.getName());
	
	private String key;
	private String publicKeyPath;
	private String privateKeyPath;
	private long expireTime;  //30 mins...
	private long regenerationTime; //3 mins...
	
	private Boolean init = false;
	private KeyPair keyPair;
	// TODO: need to think about house keeping...
	private ConcurrentHashMap<String, BaseClient> tokenToClientMap = new ConcurrentHashMap<String, BaseClient>();
	
	private ConcurrentHashMap<Integer, String> clientIdToTokenMap = new ConcurrentHashMap<Integer, String>();
	
	// if the session cannot be found, decrypt it...
	// TODO: need to think about house keeping...
	private ConcurrentHashMap<String, LoginInfo> sessionToLoginInfoMap = new ConcurrentHashMap<String, LoginInfo>();
	
	public AuthHelper() {
	}
	
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getPublicKeyPath() {
		return this.publicKeyPath;
	}
	
	public void setPublicKeyPath(String publicKeyPath) {
		this.publicKeyPath = publicKeyPath;
	}
	
	public String getPrivateKeyPath() {
		return this.privateKeyPath;
	}
	
	public void setPrivateKeyPath(String privateKeyPath) {
		this.privateKeyPath = privateKeyPath;
	}

	public long getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}
	
	public long getRegenerationTime() {
		return this.regenerationTime;
	}
	
	public void setRegenerationTime(long regenerationTime) {
		this.regenerationTime = regenerationTime;
	}
	
	public void init(ServletContext context) {
		synchronized (init) {
			if (!init) {
				keyPair = getRSAKeyPair(context);
			}
		}
	}
	
	public int doAuth(HttpServletRequest request, HttpServletResponse response) {
		
		String session = CookieHelper.getCookieValue(request, "session");
		logger.info("AuthHelper:: doAuth: getsession : "+ session);
		request.setAttribute("Login", true);
		
		
		int result = AUTH_FAIL_UNKNOWN;

		if (session != null) {
			
			LoginInfo loginInfo = sessionToLoginInfoMap.get(session);
			logger.info("doAuth(): loginInfo: {}", loginInfo);
			
			if (loginInfo == null) {
			
				String decodedValues = decryptByRSAPublicKey(session);
				
				if (decodedValues != null) {
					String [] temp = decodedValues.split("\\|");
					
					for (String s : temp)
						logger.debug(s);
					if (temp.length == 3) 
					{						
						try {
							long time = Long.parseLong(temp[0]); // catch exception if it is not a long...
							String userLogin = temp[1];  //check for the length...
							String token = temp[2];  //check for the length...
							
							loginInfo = new LoginInfo(time, userLogin, token);
							logger.info("loginInfo: " + loginInfo);
						} catch (NumberFormatException e) {
							e.printStackTrace();
							
							result = AUTH_DECODE_FORMAT_FAIL;
						}		
					} else {
						//error
						result = AUTH_DECODE_FORMAT_FAIL;
					}
				} else {
					//error
					result = AUTH_SESSION_DECODE_FAIL;
				}
			}
			
			if (loginInfo != null) {
				
				long time = loginInfo.getTime();
				String token = loginInfo.getToken();
				String login = loginInfo.getLogin();
						
				long now = System.currentTimeMillis();
				
				if (now - expireTime > time || time + expireTime < time) {
					result = AUTH_DB_EXPIRED;
				} else if (token.length() == 0 || login.length() == 0) {
					result = AUTH_LOGIN_INFO_EMPTY;
				} else {
					
					//regenerate the token if it passes the regeneration time....
					if (time + regenerationTime < now) {
						logger.info("regenerateSession time: {}, regenerationTime: {}, now: {}", time, regenerationTime, now);
						session = this.generateSession(response, now, login, token);
						loginInfo.setTime(now);
					}
					
					BaseClient client = tokenToClientMap.get(token);
					
					//for normal case, Client should be found in the cache...
					//for failover case, Web server needs to ask BOS for Client Detail...
					
					
					if (client != null) { 
						if (!Integer.toString(client.getClientId()).equals(login)) {
							logger.info("user.getId(): " + client.getClientId() + ", login: " + login);
							result = AUTH_USER_LOGIN_NOT_MATCH;
						} else if (!token.equals(client.getToken())){
							result = AUTH_DB_TOKEN_NOT_MATCH;
						} else {
							
							sessionToLoginInfoMap.put(session, loginInfo);
							//should be retrieved from BOS...

							
							result = AUTH_OK;
							request.setAttribute(LOGON_CLIENT, client); 
							request.setAttribute("LoginInfo", loginInfo);
						}
					}
				}
			}	
		} else {
			result = AUTH_NO_SESSION_COOKIE;
		}
		
		if (result >= 0) {
			//may need to update the token to extend the session timeout...
			request.setAttribute("Login", true);
		} else {
			request.setAttribute("Login", false);
		}

		return result;
		
	}
	
	public LoginResponse doLogin(String username, String passcode, 
			String socialLoginToken,
			String socialLoginProvider, String socialLoginIdentifier, 
			HttpServletRequest request, HttpServletResponse response ) {		

		//hash the password and send a login request to 
		logger.info("AuthHelper:: doLogin: getSha256String");													
		String hashedPassword = getSha256String(passcode);
		
		
		/*
		 * verification the social sign in between create if not null
		 * */
		if ( socialLoginProvider != null ){
			FirebaseToken decodedToken;
			try {
				decodedToken = Tasks.await(FirebaseAuth.getInstance(FirebaseApp.getInstance()).verifyIdToken( socialLoginToken ));
				
				String uid = decodedToken.getUid();
				
				if ( !uid.equals( socialLoginIdentifier ) ){
					
					throw new HavfunException(ErrorCode.FAIL_TO_LOGIN, "invalid client" );
					
				}
				
			} catch (ExecutionException e) {
				throw new HavfunException(ErrorCode.FAIL_TO_LOGIN, "fail to verify" );
			} catch (InterruptedException e) {
				throw new HavfunException(ErrorCode.FAIL_TO_LOGIN, "fail to verify" );
			}
		
		}
		
		String token = "";

		LoginRequest loginRequest = new LoginRequest();			

		loginRequest.setEmail( username );
		loginRequest.setPassword( hashedPassword );
		loginRequest.setSocialLoginProvider(socialLoginProvider);
		loginRequest.setSocialLoginIdentifier(socialLoginIdentifier);

		LoginResponse loginResponse = ClientServiceHelper.getInstance().getClientService().invoke(loginRequest);
		logger.info("AuthHelper:: doLogin: loginResponse " + loginResponse);
		
		if ( loginResponse == null ){
			
			return null;
			
		}
		
		if ( loginResponse.getResult() == ErrorCode.NO_ERROR ){
			
			//TODO if there are some old valid token, broadcast it and tell other nodes that those tokens are invalid...					
			long now = System.currentTimeMillis();
			ClientMessage clientMessage = loginResponse.getClient();
			
			token = loginResponse.getClient().getToken();
			generateSession(response, now, "" + loginResponse.getClient().getClientId(), token);
			BaseClient client = new BaseClient();
			client.setClientId(clientMessage.getClientId() );
			client.setEmail(clientMessage.getEmail());
			client.setToken(token);
								
			if (token != null) {
				tokenToClientMap.put(token, client);
				clientIdToTokenMap.put( client.getClientId(), token );
			}
			
		}
	
		return loginResponse;
	}
	
	public int doLogout(HttpServletRequest request, HttpServletResponse response) {
		int result = LOGOUT_FAIL_UNKNOWN;
		
		LoginInfo loginInfo = (LoginInfo)request.getAttribute("LoginInfo");
		if (loginInfo != null) {
			BaseClient client;
			
			client = tokenToClientMap.remove(loginInfo.getToken());
//				AdminLogoutRequest adminLogoutRequest = new AdminLogoutRequest();
			//	adminLogoutRequest.setLogonUserId(user.getId());
			//	adminLogoutRequest.setLogonToken(user.getToken());
			//	AdminLogoutResponse adminLogoutResponse = BosClientHelper.getInstance().getBosClientService().invoke(adminLogoutRequest);				
			//	logger.info("doLogout: " + adminLogoutResponse);
			
			String session = CookieHelper.getCookieValue(request, "session");
			sessionToLoginInfoMap.remove(session);
			
			if (client != null) {
				result = LOGOUT_OK;
			} 
		}
		
		CookieHelper.removeCookie(response, "session");
		
		return result;
	}
	
	private String generateSession(HttpServletResponse response, long time, String clientId, String token) {
		String session = encryptByRSAPrivateKey(time + "|" + clientId + "|" + token);
		
		CookieHelper.addCookie(response, "session", session, -1);
		
		return session;
	} 

	public String getSha256String(String string) {
		try {
			MessageDigest sha256 = MessageDigest.getInstance(SHA_256);
			byte [] hashBytes = sha256.digest(string.getBytes());
			return Base64.encodeBase64URLSafeString(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/*
	private String encryptSymmetricString(String string) {
		try {
			Cipher cipher = Cipher.getInstance(TRIPLE_DES);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), TRIPLE_DES));
			byte[] encryptionBytes = cipher.doFinal(string.getBytes());
			
			return Base64.encodeBase64URLSafeString(encryptionBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private String decryptSymmetricString(String string) {
		try {
			Cipher cipher = Cipher.getInstance(TRIPLE_DES);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), TRIPLE_DES));
			
			return new String(cipher.doFinal(Base64.decodeBase64(string)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	*/
	private KeyPair getRSAKeyPair(ServletContext context) {
		try {
			InputStream is = context.getResourceAsStream(this.publicKeyPath);
			byte [] encodedPublicKey = new byte[is.available()];
			is.read(encodedPublicKey);
			is.close();
			
			is = context.getResourceAsStream(this.privateKeyPath);
			byte [] encodedPrivateKey = new byte[is.available()];
			is.read(encodedPrivateKey);
			is.close();
			
			KeyFactory keyFactory = KeyFactory.getInstance(RSA);
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
			PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
			
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
			PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
			
			return new KeyPair(publicKey, privateKey);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String encryptByRSAPrivateKey(String string) {
		Cipher cipher;
		try {
			//can borrow the Ciper from Object pool to save time for init...
			cipher = Cipher.getInstance(RSA);
			cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());

			byte [] encryptionBytes = cipher.doFinal(string.getBytes());
			
			return Base64.encodeBase64URLSafeString(encryptionBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String decryptByRSAPublicKey(String string) {
		Cipher cipher;
		try {
			//can borrow the Ciper from Object pool to save time for init...
			cipher = Cipher.getInstance(RSA);
			cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
			
			return new String(cipher.doFinal(Base64.decodeBase64(string)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	private static String getClientIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    } 
}
