package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.Client;

public interface ClientDao extends GenericDao<Client, Integer>{

	public List<Client> readAll();
	
	public Client readByEmail( String email);
	
}
