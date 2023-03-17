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
import com.havfun.service.convertor.OrderProductConvertor;
import com.havfun.service.dao.OrderDao;
import com.havfun.service.dao.OrderProductDao;
import com.havfun.service.entity.Order;
import com.havfun.service.entity.OrderProduct;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.order.AdminEnquireOrderRequest;
import com.havfun.service.message.admin.order.AdminEnquireOrderResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.OrderMessage;
import com.havfun.service.message.data.OrderProductMessage;

public class ProcessAdminEnquireOrderCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminEnquireOrderCommand.class.getSimpleName());
	
	@Autowired
	private OrderProductDao orderProductDao;
	
	@Autowired
	private OrderDao orderDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminEnquireOrderRequest request = (AdminEnquireOrderRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int orderId = request.getOrderId();
		
		LOGGER.info("orderId: {}", orderId);
		
		Order order = orderDao.read(orderId);
		
		if (order == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot read order");
		}
		
		OrderMessage orderMessage = OrderConvertor.convertToMessage(order);
		
		List<OrderProduct> orderProductList = orderProductDao.readByOrderId(orderId);
		
		if ( orderProductList != null ){
		
			List<OrderProductMessage> orderProductMessageList = OrderProductConvertor.convertToMessageList(orderProductList);
		
			orderMessage.setOrderProductList(orderProductMessageList);
			
		}
		
		
		AdminEnquireOrderResponse response = new AdminEnquireOrderResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setOrderMessage(orderMessage);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
