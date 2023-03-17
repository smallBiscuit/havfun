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
import com.havfun.service.message.admin.order.AdminCreateOrderRequest;
import com.havfun.service.message.admin.order.AdminCreateOrderResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.OrderMessage;

public class ProcessAdminCreateOrderCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminCreateOrderCommand.class.getSimpleName());
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderProductDao orderProductDao;
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminCreateOrderRequest request = (AdminCreateOrderRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		OrderMessage orderMessage = request.getOrderMessage();
		
		if (orderMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "orderMessage is null");
		}
		
		Order order = OrderConvertor.convertToEntity(orderMessage);
		
		Integer orderId = orderDao.create(order);
		
		if (orderId == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot create order");
		}
		
		List<OrderProduct> orderProductList = OrderProductConvertor.convertToEntityList( orderMessage.getOrderProductList() );
		
		for ( OrderProduct orderProduct : orderProductList ){
			
			orderProduct.setOrderId(orderId);
			
			orderProductDao.create( orderProduct );
		}
		
		AdminCreateOrderResponse response = new AdminCreateOrderResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setOrderId(orderId);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}

}
