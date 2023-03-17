package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.CustomizeProductColorItem;

public interface CustomizeProductColorItemDao extends GenericDao<CustomizeProductColorItem, Integer>{

	public List<CustomizeProductColorItem> readByBaseId( int baseId );
	
	public int[] replaceByItems(List<CustomizeProductColorItem> objectList);
	
	public void deleteByBaseIdWithNewItemList( int baseId, List<CustomizeProductColorItem> objectList );
	
}
