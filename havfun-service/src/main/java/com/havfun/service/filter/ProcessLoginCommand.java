package com.havfun.service.filter;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.AddressConvertor;
import com.havfun.service.convertor.ClientConvertor;
import com.havfun.service.convertor.UserConvertor;
import com.havfun.service.dao.AddressDao;
import com.havfun.service.dao.ClientDao;
import com.havfun.service.dao.SocialSignInDao;
import com.havfun.service.dao.UserDao;
import com.havfun.service.entity.Address;
import com.havfun.service.entity.Client;
import com.havfun.service.entity.SocialSignIn;
import com.havfun.service.entity.User;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.LoginRequest;
import com.havfun.service.message.LoginResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.AddressMessage;
import com.havfun.service.message.data.ClientMessage;

public class ProcessLoginCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessLoginCommand.class.getSimpleName());
	
	@Autowired
	private ClientDao clientDao;

	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private SocialSignInDao socialSignInDao;
	
	private final static Random RANDOM = new Random();
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		int result = ErrorCode.NO_ERROR;
		
		LoginRequest request = (LoginRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		LOGGER.info("ProcessLoginCommand : {}", request);
		
		Client client = clientDao.readByEmail( request.getEmail() );
		
		LOGGER.info("client : {}", client);
		
		if ( client == null ){
			
			//throw new HavfunException(ErrorCode.LOGIN_USER_NOT_FOUND, "user not found");
			
			result = ErrorCode.LOGIN_USER_NOT_FOUND;
			
		}
		
		boolean isAuth = false;
		
		String socialLoginProvider = request.getSocialLoginProvider();
		String socialLoginIdentifier = request.getSocialLoginIdentifier();
		
		if ( socialLoginProvider != null && socialLoginIdentifier != null ){
			
			SocialSignIn socialSignIn = socialSignInDao.readWithIdentifier( socialLoginProvider, socialLoginIdentifier);
			
			if ( socialSignIn != null && socialSignIn.getClientId() == client.getClientId() ){
								
				isAuth = true;				
				
			}
			
		}
		
				
		if ( !isAuth && result == ErrorCode.NO_ERROR && !client.getPasscode().equals( request.getPassword() ) ){
			
			result = ErrorCode.LOGIN_PASSCODE_INCORRECT;
			//throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "passcode is invalid");
			
		}
		
		LoginResponse response = new LoginResponse();
		
		if ( result == ErrorCode.NO_ERROR ){
			
			ClientMessage clientMessage = ClientConvertor.convertToMessage(client);
			
			List<Address> addressList = addressDao.readByClientId( client.getClientId() );
			
			List<AddressMessage> addressMessageList = AddressConvertor.convertToMessageList(addressList);
			
			clientMessage.setAddressList(addressMessageList);
			
			String token = generateLoginToken( String.valueOf( client.getClientId() ) );
			
			clientMessage.setToken( token );
			
			response.setResult(ErrorCode.NO_ERROR);

			response.setClient( clientMessage );			
			
		}else{
			
			response.setResult( result );
			
		}
		

		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	public static String generateLoginToken( String clientId ){
		
		try{
			
			String sGenLoginToken = RANDOM.nextInt( Integer.MAX_VALUE ) + clientId + System.currentTimeMillis() + RANDOM.nextInt( Integer.MAX_VALUE );
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			new ObjectOutputStream( baos ).writeObject( sGenLoginToken );
			return new String( new Base64().encode( baos.toByteArray() ) ); 
			
		}catch( Exception e){
			
			return clientId + new Timestamp( System.currentTimeMillis() );
		}
		
	}
	
}
