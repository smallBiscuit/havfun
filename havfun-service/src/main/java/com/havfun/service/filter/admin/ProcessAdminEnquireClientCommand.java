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
import com.havfun.service.message.admin.client.AdminEnquireClientRequest;
import com.havfun.service.message.admin.client.AdminEnquireClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.AddressMessage;
import com.havfun.service.message.data.ClientMessage;

public class ProcessAdminEnquireClientCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminEnquireClientCommand.class.getSimpleName());
	
	@Autowired
	private ClientDao clientDao;

	@Autowired
	private AddressDao addressDao;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminEnquireClientRequest request = (AdminEnquireClientRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int clientId = request.getClientId();
		
		LOGGER.info("clientId: {}", clientId);
		
		Client client = clientDao.read(clientId);
		
		if (client == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot read client");
		}
		
		ClientMessage clientMessage = ClientConvertor.convertToMessage(client);
		
		List<Address> addressList = addressDao.readByClientId( clientId );
		
		if ( addressList != null ){
		
			List<AddressMessage> addressMessageList = AddressConvertor.convertToMessageList(addressList);
		
			clientMessage.setAddressList(addressMessageList);
			
		}
			
		AdminEnquireClientResponse response = new AdminEnquireClientResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setClientMessage(clientMessage);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
