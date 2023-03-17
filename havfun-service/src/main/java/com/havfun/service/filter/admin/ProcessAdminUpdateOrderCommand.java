package com.havfun.service.filter.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.OrderProductConvertor;
import com.havfun.service.convertor.OrderConvertor;
import com.havfun.service.dao.OrderDao;
import com.havfun.service.dao.OrderProductDao;
import com.havfun.service.entity.OrderProduct;
import com.havfun.service.entity.Order;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.order.AdminUpdateOrderRequest;
import com.havfun.service.message.admin.order.AdminUpdateOrderResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.OrderMessage;

public class ProcessAdminUpdateOrderCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminUpdateOrderCommand.class.getSimpleName());
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderProductDao orderProductDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminUpdateOrderRequest request = (AdminUpdateOrderRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		OrderMessage orderMessage = request.getOrderMessage();
		
		if (orderMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "orderMessage is null");
		}
		
		LOGGER.info("orderMessage: {}", orderMessage);
		
		Order order = OrderConvertor.convertToEntity(orderMessage);
		
		LOGGER.info("update order {}", order);
		
		int orderId = orderDao.update(order);
		
		if (orderId == 0) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update order");
		}
		
		List<OrderProduct> addressList = OrderProductConvertor.convertToEntityList( orderMessage.getOrderProductList() );
		
		List<OrderProduct> existingOrderProductList = orderProductDao.readByOrderId(orderId);
		
		List<OrderProduct> removingOrderProductList = new ArrayList<OrderProduct>();
		
		List<OrderProduct> updatingOrderProductList = new ArrayList<OrderProduct>();
		
		List<OrderProduct> insertingOrderProductList = new ArrayList<OrderProduct>();
		
		for ( OrderProduct currOrderProduct : addressList ){
			
			if ( currOrderProduct.getOrderProductId() == 0 ){
				
				insertingOrderProductList.add(currOrderProduct); 
				
			}
			
		}

		for ( OrderProduct existingOrderProduct : existingOrderProductList ){
			
			boolean matchFlag = false;
			
			for ( OrderProduct updatedOrderProduct : addressList ){
				
				if ( updatedOrderProduct.getOrderProductId() == existingOrderProduct.getOrderProductId() ){
					
					matchFlag = true;
					
					updatingOrderProductList.add( updatedOrderProduct );
					
				}
				
			}
			
			if ( !matchFlag ){
				
				
				removingOrderProductList.add( existingOrderProduct );		
				
			}
		}

		LOGGER.info("rayTest removingOrderProductList: " + removingOrderProductList);
		LOGGER.info("rayTest updatingOrderProductList: " + updatingOrderProductList);
		LOGGER.info("rayTest insertingOrderProductList: " + insertingOrderProductList);		
		
		for ( OrderProduct removingOrderProduct : removingOrderProductList ){
			orderProductDao.deleteByKey( removingOrderProduct.getOrderProductId() );
		}

		for ( OrderProduct updatingOrderProduct : updatingOrderProductList ){
			orderProductDao.update( updatingOrderProduct );
		}
		
		for ( OrderProduct insertingOrderProduct : insertingOrderProductList ){
			
			insertingOrderProduct.setOrderId( order.getOrderId() );
			
			orderProductDao.create( insertingOrderProduct );
			
		}

		
		AdminUpdateOrderResponse response = new AdminUpdateOrderResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
