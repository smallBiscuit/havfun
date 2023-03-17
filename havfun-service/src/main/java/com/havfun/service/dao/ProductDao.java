package com.havfun.service.dao;

import java.util.List;
import com.havfun.service.entity.Product;

public interface ProductDao extends GenericDao<Product, Integer>{

	public List<Product> readAll();
	
	public List<Product> readByGroupId( int groupId );
	
	public List<Product> readByTag( String tag );
	
}
