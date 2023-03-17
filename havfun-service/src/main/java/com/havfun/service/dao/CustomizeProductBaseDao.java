package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.CustomizeProductBase;

public interface CustomizeProductBaseDao extends GenericDao<CustomizeProductBase, Integer>{

	public List<CustomizeProductBase> readByProductId( int productId );
	
}
