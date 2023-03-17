package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.Material;

public interface MaterialDao extends GenericDao<Material, Integer>{

	public List<Material> readAll();
	
	public List<Material> readByGroupId( int groupId );
	
}
