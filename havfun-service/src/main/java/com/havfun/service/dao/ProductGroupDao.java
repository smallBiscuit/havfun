package com.havfun.service.dao;

import java.util.List;
import com.havfun.service.entity.ProductGroup;

public interface ProductGroupDao extends GenericDao<ProductGroup, Integer>{

	public List<ProductGroup> readAll();
	
	public List<ProductGroup> readAllBasicData();
	
}
