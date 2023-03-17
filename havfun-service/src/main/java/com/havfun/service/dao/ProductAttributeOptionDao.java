package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.ProductAttributeOption;

public interface ProductAttributeOptionDao extends GenericDao<ProductAttributeOption, Integer>{

	public List<ProductAttributeOption> readByProductId( int productId );
	
}
