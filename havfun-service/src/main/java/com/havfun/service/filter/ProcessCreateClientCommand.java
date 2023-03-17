package com.havfun.service.filter;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.dao.ClientDao;
import com.havfun.service.dao.SocialSignInDao;
import com.havfun.service.entity.Client;
import com.havfun.service.entity.SocialSignIn;
import com.havfun.service.entity.constant.ClientStatus;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.CreateClientRequest;
import com.havfun.service.message.CreateClientResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessCreateClientCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessCreateClientCommand.class.getSimpleName());
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private SocialSignInDao socialSignInDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		int result = ErrorCode.NO_ERROR;
		
		CreateClientRequest request = (CreateClientRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		Client existingClient = clientDao.read( request.getClientId() );

		if ( existingClient != null ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "clientId is not null");

		}
		
		Client client = new Client(); 
		
		client.setFirstName( request.getFirstName() );
		
		client.setLastName( request.getLastName() );
		
		client.setBirthDate( request.getBirthDate() );
		
		client.setGender( request.getGender() );
		
		client.setEmail( request.getEmail() );
		
		client.setPasscode( request.getPasscode() );

		client.setClientGroup( "Normal" );
		
		client.setStatus( ClientStatus.ACTIVE );
		
		LOGGER.info("rayTest client: " + client );		
		
		int newClientId = clientDao.create( client );
		
		LOGGER.info("rayTest newClientId: " + newClientId );
			
		
		if ( newClientId > 0 ){
		
//			int newClientId = clientDao.
			
			String socialSignInProvider = request.getSocialSignInProvider();
			
			String socialSignInIdentifier = request.getSocialSignInIdentifier();
			
			if ( socialSignInProvider != null && socialSignInIdentifier != null ){
				
				SocialSignIn socialSignIn = new SocialSignIn();
				
				socialSignIn.setClientId( newClientId );
				socialSignIn.setPrvoider( socialSignInProvider );
				socialSignIn.setIdentifier( socialSignInIdentifier );
				socialSignIn.setEmail( client.getEmail() );
				socialSignIn.setRegisterTimestamp( System.currentTimeMillis() );
				socialSignIn.setLastVisitTimestamp( System.currentTimeMillis() );
				
				socialSignInDao.create(socialSignIn);
			}
			
			//socialSignInDao
		
		}else{
			
			result = ErrorCode.ERROR_CODE_COMMON_ACTION_FAIL;
			
		}
		
		CreateClientResponse response = new CreateClientResponse();
		
		response.setResult( result );
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
		
	}
	
}
