package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.MaterialGroup;

public interface MaterialGroupDao extends GenericDao<MaterialGroup, Integer>{

	public List<MaterialGroup> readAll();
		
	public List<MaterialGroup> readAllBasicData();

}
