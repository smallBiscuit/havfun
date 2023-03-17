package com.havfun.service.filter.admin;

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
import com.havfun.service.message.admin.client.AdminCreateClientRequest;
import com.havfun.service.message.admin.client.AdminCreateClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ClientMessage;

public class ProcessAdminCreateClientCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminCreateClientCommand.class.getSimpleName());
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private AddressDao addressDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminCreateClientRequest request = (AdminCreateClientRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		ClientMessage clientMessage = request.getClientMessage();
		
		if (clientMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "clientMessage is null");
		}
		
		LOGGER.info("clientMessage: {}", clientMessage);
		
		Client client = ClientConvertor.convertToEntity(clientMessage);
		
		LOGGER.info("create client {}", client);
		Integer clientId = clientDao.create(client);
		
		if (clientId == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot create client");
		}
		
		List<Address> addressList = AddressConvertor.convertToEntityList( clientMessage.getAddressList() );
	
		for ( Address address : addressList ){
			
			address.setClientId( clientId );
			
			addressDao.create( address );
		}
		
//		List<Address> existingAddressList = addressDao.readByClientId( clientId );
		
		AdminCreateClientResponse response = new AdminCreateClientResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setClientId(clientId);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}

}
