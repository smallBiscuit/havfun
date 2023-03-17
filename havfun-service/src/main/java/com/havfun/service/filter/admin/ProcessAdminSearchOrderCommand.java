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
import com.havfun.service.convertor.OrderConvertor;
import com.havfun.service.dao.OrderDao;
import com.havfun.service.entity.Order;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.order.AdminSearchOrderRequest;
import com.havfun.service.message.admin.order.AdminSearchOrderResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminSearchOrderCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminSearchOrderCommand.class.getSimpleName());
	
	@Autowired
	private OrderDao orderDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminSearchOrderRequest request = (AdminSearchOrderRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		List<Order> orderList = orderDao.readAll();
		
		if (orderList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "orderList is null");
		}
		
		LOGGER.info("orderList : {}", orderList);
		
		AdminSearchOrderResponse response = new AdminSearchOrderResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setOrderMessageList(OrderConvertor.convertToMessageList(orderList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
