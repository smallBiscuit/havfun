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
import com.havfun.service.entity.Address;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.UpdateClientAddressRequest;
import com.havfun.service.message.UpdateClientAddressResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.AddressMessage;

public class ProcessUpdateClientAddressCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessUpdateClientAddressCommand.class.getSimpleName());
	
	@Autowired
	private AddressDao addressDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		UpdateClientAddressRequest request = (UpdateClientAddressRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		AddressMessage addressMessage = request.getAddressMessage();
		
		LOGGER.info("addressMessage: " + addressMessage );
		
		Address address = AddressConvertor.convertToEntity(addressMessage);
		
		LOGGER.info("address: " + address );
		
		int addressId = addressDao.update( address );
		
		UpdateClientAddressResponse response = new UpdateClientAddressResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
