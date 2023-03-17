package com.havfun.adminui.helper;

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

import com.havfun.service.dao.UserDao;
import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.message.admin.AdminLoginRequest;
import com.havfun.service.message.admin.AdminLoginResponse;
import com.havfun.service.message.data.UserMessage;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.data.LoginInfo;

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
	private ConcurrentHashMap<String, BaseUser> tokenToUserMap = new ConcurrentHashMap<String, BaseUser>();
	
	private ConcurrentHashMap<Integer, String> userIdToTokenMap = new ConcurrentHashMap<Integer, String>();
	
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
		
		BaseUser baseUser = new BaseUser();
		baseUser.setUserGroup( UserGroup.ADMIN );
		request.setAttribute("logonUser", baseUser ); 
		
		return 0;
		/*
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
					
					BaseUser user = tokenToUserMap.get(token);
					
					//for normal case, Client should be found in the cache...
					//for failover case, Web server needs to ask BOS for Client Detail...
					
					
					if (user != null) { 
						if (!Integer.toString(user.getId()).equals(login)) {
							logger.info("user.getId(): " + user.getId() + ", login: " + login);
							result = AUTH_USER_LOGIN_NOT_MATCH;
						} else if (!token.equals(user.getToken())){
							result = AUTH_DB_TOKEN_NOT_MATCH;
						} else if ( !isClient && !token.equals(userIdToTokenMap.get(user.getId()))) {
							result = AUTH_DB_TOKEN_NOT_MATCH;
						} else {
							
							sessionToLoginInfoMap.put(session, loginInfo);
							//should be retrieved from BOS...

							
							result = AUTH_OK;
							request.setAttribute("logonUser", user); 
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
		*/
	}
	
	public int doLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		return doLogin(username, password,request, response);
	}
	
	public int doLogin(String username, String password,HttpServletRequest request, HttpServletResponse response) {		
		int result = LOGIN_OK;		
		logger.info("AuthHelper:: doLogin: ");					
		boolean isUserId = true;
		int userId = 0;
		String userLogin = null;
		
		//verify whether the username is userid or userlogin...
		try {
			logger.info("AuthHelper:: doLogin: try username");
			userId = Integer.parseInt(username);
		} catch (NumberFormatException e) {
			logger.info("AuthHelper:: doLogin: try username to number exception");											
			userLogin = username;
			isUserId = false;
		}
		
		//hash the password and send a login request to BOS
		logger.info("AuthHelper:: doLogin: getSha256String");													
		String hashedPassword = getSha256String(password);
		
		String token = "";
			//TODO: check the result from BOS
			logger.info("AuthHelper:: doLogin: normal user");			
			AdminLoginRequest adminLoginRequest = new AdminLoginRequest();			
			logger.info("AuthHelper:: doLogin: normal isUserId "+ isUserId);						
			if (isUserId)
				adminLoginRequest.setUserLoginId( String.valueOf(userId));
			else
				adminLoginRequest.setUserLoginId(userLogin);
			adminLoginRequest.setPasscode(hashedPassword);

			adminLoginRequest.setIpAddress( getClientIpAddr( request) );
						
			logger.info("AuthHelper:: doLogin: normal userLoginRequest "+ adminLoginRequest);									

			AdminLoginResponse userLoginResponse = ClientServiceHelper.getInstance().getClientService().invoke(adminLoginRequest);//HKList.getInstance().getBosClientService().invoke(adminLoginRequest);

			logger.info("AuthHelper:: doLogin: userLoginResponse " + userLoginResponse);
			result = userLoginResponse.getResult();
			if (result == 0)
			{
				//TODO if there are some old valid token, broadcast it and tell other nodes that those tokens are invalid...					
				long now = System.currentTimeMillis();
				UserMessage userMessage = userLoginResponse.getUserMessage();
				
				token = userLoginResponse.getToken();
				generateSession(response, now, Integer.toString( userMessage.getUserId()), token);
				BaseUser user = new BaseUser();
				user.setId(userMessage. getUserId());
				user.setEmail(userMessage.getEmail());
				user.setDisplayName(userMessage.getUserName());
				user.setUserGroup(userMessage.getUserGroup());
				user.setToken(token);
									
//				user.setActionList(adminLoginResponse.getActionCodeList());
				//store the new token into Map
				if (token != null) {
					tokenToUserMap.put(token, user);
					userIdToTokenMap.put( user.getId(), token );
				}
				if ( user != null ){
					request.setAttribute("user", user);
					request.setAttribute("isChangePassword", userLoginResponse.isChangePassword());
				}				
				
			}
		
		return result;
	}
	
	public int doLogout(HttpServletRequest request, HttpServletResponse response) {
		int result = LOGOUT_FAIL_UNKNOWN;
		
		LoginInfo loginInfo = (LoginInfo)request.getAttribute("LoginInfo");
		if (loginInfo != null) {
			BaseUser user;
			
				user = tokenToUserMap.remove(loginInfo.getToken());
//				AdminLogoutRequest adminLogoutRequest = new AdminLogoutRequest();
			//	adminLogoutRequest.setLogonUserId(user.getId());
			//	adminLogoutRequest.setLogonToken(user.getToken());
			//	AdminLogoutResponse adminLogoutResponse = BosClientHelper.getInstance().getBosClientService().invoke(adminLogoutRequest);				
			//	logger.info("doLogout: " + adminLogoutResponse);
			
			String session = CookieHelper.getCookieValue(request, "session");
			sessionToLoginInfoMap.remove(session);
			
			if (user != null) {
				result = LOGOUT_OK;
			} 
		}
		
		CookieHelper.removeCookie(response, "session");
		
		return result;
	}
	
	private String generateSession(HttpServletResponse response, long time, String clientLogin, String token) {
		String session = encryptByRSAPrivateKey(time + "|" + clientLogin + "|" + token);
		
		CookieHelper.addCookie(response, "session", session, -1);
		
		return session;
	} 

	public static String getSha256String(String string) {
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
	/*
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
	*/
	
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
