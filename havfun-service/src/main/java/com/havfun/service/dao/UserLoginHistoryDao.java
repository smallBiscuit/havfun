package com.havfun.service.dao;

import java.util.List;

import com.havfun.service.entity.UserLoginHistory;

public interface UserLoginHistoryDao extends GenericDao<UserLoginHistory, Integer>{

	public UserLoginHistory readByUserIdAndToken(int userId, String token);
	
	public List<UserLoginHistory> readAllLogin(int userId);

}
