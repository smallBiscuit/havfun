package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.CustomizeProductBorderItem;

public interface CustomizeProductBorderItemDao extends GenericDao<CustomizeProductBorderItem, Integer>{

	public List<CustomizeProductBorderItem> readByViewId( int viewId );

	public int[] replaceByItems(List<CustomizeProductBorderItem> objectList);
	
	public int deleteByViewIdWithNewItemList( int baseId, List<CustomizeProductBorderItem> objectList );
	
}
