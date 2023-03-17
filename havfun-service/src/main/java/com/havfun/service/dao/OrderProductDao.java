package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.OrderProduct;

public interface OrderProductDao extends GenericDao<OrderProduct, Integer>{

	public List<OrderProduct> readByOrderId( int orderId );
	
}
