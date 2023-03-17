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
import com.havfun.service.convertor.ClientConvertor;
import com.havfun.service.dao.ClientDao;
import com.havfun.service.entity.Client;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.client.AdminSearchClientRequest;
import com.havfun.service.message.admin.client.AdminSearchClientResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminSearchClientCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminSearchClientCommand.class.getSimpleName());
	
	@Autowired
	private ClientDao clientDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminSearchClientRequest request = (AdminSearchClientRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		List<Client> clientList = clientDao.readAll();
		
		if (clientList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "clientList is null");
		}
		
		LOGGER.info("clientList : {}", clientList);
		
		AdminSearchClientResponse response = new AdminSearchClientResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setClientMessageList(ClientConvertor.convertToMessageList(clientList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
