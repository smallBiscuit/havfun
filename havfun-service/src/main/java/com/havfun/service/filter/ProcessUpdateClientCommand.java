package com.havfun.service.filter;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.AddressConvertor;
import com.havfun.service.dao.AddressDao;
import com.havfun.service.dao.ClientDao;
import com.havfun.service.entity.Address;
import com.havfun.service.entity.Client;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.UpdateClientRequest;
import com.havfun.service.message.UpdateClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.AddressMessage;

public class ProcessUpdateClientCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessUpdateClientCommand.class.getSimpleName());
	
	@Autowired
	private ClientDao clientDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		UpdateClientRequest request = (UpdateClientRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		Client client = clientDao.read( request.getClientId() );
		LOGGER.info("rayTest client: " + client );
		if ( client == null ){
			
//			
		}
		
		if ( client.getPasscode().equals( client.getPasscode() ) ){
			
			client.setFirstName( request.getFirstName() );
			
			client.setLastName( request.getLastName() );
			
			client.setBirthDate( request.getBirthDate() );
			
			client.setGender( request.getGender() );
			
			client.setEmail( request.getEmail() );
			
			if ( request.getNewPasscode() != null ){
				
				client.setPasscode( request.getNewPasscode() );
				
			}
		}			
		LOGGER.info("rayTest client: " + client );
		int result = clientDao.update(client); 
		
		LOGGER.info("rayTest result: " + result );
		
//		if ( result )
			
		UpdateClientResponse response = new UpdateClientResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
