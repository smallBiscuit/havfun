package com.havfun.service.filter;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.OrderConvertor;
import com.havfun.service.dao.OrderDao;
import com.havfun.service.entity.Order;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.EnquireOrderRequest;
import com.havfun.service.message.EnquireOrderResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessEnquireOrderCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessEnquireOrderCommand.class.getSimpleName());
	
	@Autowired
	private OrderDao orderDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		EnquireOrderRequest request = (EnquireOrderRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int orderId = request.getOrderId();
		
		if (orderId <= 0 ) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "orderId is invalid");
		}
		
		Order order = orderDao.read( orderId );
		
		if (order == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "order is null");
		}
		
		LOGGER.info("order : {}", order);
		
		EnquireOrderResponse response = new EnquireOrderResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setOrderMessage( OrderConvertor.convertToMessage( order ));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
