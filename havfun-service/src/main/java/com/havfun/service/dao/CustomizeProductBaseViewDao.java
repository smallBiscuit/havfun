package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.CustomizeProductBaseView;

public interface CustomizeProductBaseViewDao extends GenericDao<CustomizeProductBaseView, Integer>{

	public List<CustomizeProductBaseView> readByBaseId( int baseId );
	
	public int replaceByCustomizeProductBaseView( CustomizeProductBaseView transientObject);
	
}
