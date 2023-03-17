package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.User;

public interface UserDao extends GenericDao<User, Integer>{

	public List<User> readAll();
	
	public User readByUserName( String userName );
	
}
