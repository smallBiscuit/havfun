package com.havfun.service.filter.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.AddressConvertor;
import com.havfun.service.convertor.ClientConvertor;
import com.havfun.service.dao.AddressDao;
import com.havfun.service.dao.ClientDao;
import com.havfun.service.entity.Address;
import com.havfun.service.entity.Client;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.client.AdminUpdateClientRequest;
import com.havfun.service.message.admin.client.AdminUpdateClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ClientMessage;

public class ProcessAdminUpdateClientCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminUpdateClientCommand.class.getSimpleName());
	
	@Autowired
	private ClientDao clientDao;

	@Autowired
	private AddressDao addressDao;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminUpdateClientRequest request = (AdminUpdateClientRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		ClientMessage clientMessage = request.getClientMessage();
		
		if (clientMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "clientMessage is null");
		}
		
		LOGGER.info("clientMessage: {}", clientMessage);
		
		Client client = ClientConvertor.convertToEntity(clientMessage);
		
		LOGGER.info("update client {}", client);
		
		int clientId = clientDao.update(client);
		
		if ( clientId == 0 ) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update client");
		}
		
		List<Address> addressList = AddressConvertor.convertToEntityList( clientMessage.getAddressList() );
		
		List<Address> existingAddressList = addressDao.readByClientId( client.getClientId()  );
		
		List<Address> removingAddressList = new ArrayList<Address>();
		

		for ( Address existingAddress : existingAddressList ){
			
			boolean matchFlag = false;
			
			for ( Address updatedAddress : addressList ){
				
				if ( updatedAddress.getAddressId() == existingAddress.getAddressId() ){
					
					matchFlag = true;
					
				}
				
			}
			
			if ( !matchFlag ){
				
				
				removingAddressList.add( existingAddress );		
				
			}
		}

		LOGGER.info("rayTest removingAddressList: " + removingAddressList);
		
		for ( Address removingAddress : removingAddressList ){
			addressDao.deleteByKey( removingAddress.getAddressId() );
		}

		for ( Address replacingAddress : addressList ){
			
			replacingAddress.setClientId( client.getClientId() );
			
			addressDao.replaceByAddress( replacingAddress );
		}
		
		
		AdminUpdateClientResponse response = new AdminUpdateClientResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
