package com.havfun.service.filter;

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
import com.havfun.service.dao.AddressDao;
import com.havfun.service.entity.Address;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.EnquireClientAddressesRequest;
import com.havfun.service.message.EnquireClientAddressesResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessEnquireClientAddressesCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessEnquireClientAddressesCommand.class.getSimpleName());
	
	@Autowired
	private AddressDao addressDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		EnquireClientAddressesRequest request = (EnquireClientAddressesRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		List<Address> addressList = addressDao.readByClientId( request.getClientId() );
		
		LOGGER.info("addressList : {}", addressList);
		
		EnquireClientAddressesResponse response = new EnquireClientAddressesResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setAddressMessageList( AddressConvertor.convertToMessageList(addressList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
