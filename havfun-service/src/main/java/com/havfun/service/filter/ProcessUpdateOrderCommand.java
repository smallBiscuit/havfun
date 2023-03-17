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
import com.havfun.service.message.UpdateOrderRequest;
import com.havfun.service.message.UpdateOrderResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.OrderMessage;

public class ProcessUpdateOrderCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessUpdateOrderCommand.class.getSimpleName());
	
	@Autowired
	private OrderDao orderDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		UpdateOrderRequest request = (UpdateOrderRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		OrderMessage orderMessage = request.getOrderMessage();
		
		if (orderMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "orderMessage is null");
		}
		
		LOGGER.info("orderMessage : {}", orderMessage);
		
		Order order = orderDao.read( orderMessage.getOrderId() );
		
		if ( order == null ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "order not exist");
			
		}
		
		orderDao.updateOrderStatus( orderMessage.getOrderId(), orderMessage.getStatus() );
		
		UpdateOrderResponse response = new UpdateOrderResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
