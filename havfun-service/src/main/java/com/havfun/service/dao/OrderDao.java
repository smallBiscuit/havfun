package com.havfun.service.dao;

import java.util.List;
import com.havfun.service.entity.Order;
import com.havfun.service.entity.constant.OrderStatus;

public interface OrderDao extends GenericDao<Order, Integer>{

	public Integer create2( Order order);
	
	public List<Order> readAll();
	
	public int updateOrderStatus( int orderId, OrderStatus orderStatus );
	
}
