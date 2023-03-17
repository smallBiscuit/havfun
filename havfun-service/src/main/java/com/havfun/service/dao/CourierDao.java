package com.havfun.service.dao;

import java.util.List;
import com.havfun.service.entity.Courier;

public interface CourierDao extends GenericDao<Courier, Integer>{

	public List<Courier> readAll();
	
}
