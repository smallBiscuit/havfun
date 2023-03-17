package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.Address;

public interface AddressDao extends GenericDao<Address, Integer>{

	public List<Address> readByClientId( int clientId );
	
	public int replaceByAddress( Address transientObject );
	
	public List<Address> readAll();
	
}
