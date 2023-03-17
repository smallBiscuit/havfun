package com.havfun.service.dao;

import java.util.List;
import com.havfun.service.entity.Country;

public interface CountryDao extends GenericDao<Country, Integer>{

	public List<Country> readAll();
	
}
