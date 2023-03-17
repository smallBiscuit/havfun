package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.UserLoginHistory;
import com.havfun.service.message.data.UserLoginHistoryMessage;

public class UserLoginHistoryConvertor {
	
	public final static List<UserLoginHistory> convertToEntityList(List<UserLoginHistoryMessage> userLoginHistoryMessageList) {
		if (userLoginHistoryMessageList == null) {
			return null;
		}
		
		List<UserLoginHistory> userLoginHistoryList = new ArrayList<UserLoginHistory>();
		for (UserLoginHistoryMessage userLoginMessageHistory : userLoginHistoryMessageList) {
			userLoginHistoryList.add(convertToEntity(userLoginMessageHistory));
		}
		
		return userLoginHistoryList;
	}

	public final static List<UserLoginHistoryMessage> convertToMessageList(List<UserLoginHistory> userLoginHistoryList) {
		if (userLoginHistoryList == null) { 
			return null;
		}
		
		List<UserLoginHistoryMessage> userLoginHistoryMessageList = new ArrayList<UserLoginHistoryMessage>();
		for (UserLoginHistory userLoginHistory : userLoginHistoryList) {
			userLoginHistoryMessageList.add(convertToMessage(userLoginHistory));
		}
		
		return userLoginHistoryMessageList;
	}
	
	public final static UserLoginHistory convertToEntity(UserLoginHistoryMessage userLoginHistoryMessage) {
		UserLoginHistory userLoginHistory = new UserLoginHistory();
		
		userLoginHistory.setUserLoginHistoryId(userLoginHistoryMessage.getUserLoginHistoryId());
		userLoginHistory.setUserId(userLoginHistoryMessage.getUserId());
		userLoginHistory.setLoginToken(userLoginHistoryMessage.getLoginToken());
		userLoginHistory.setIpAddress(userLoginHistoryMessage.getIpAddress());
		userLoginHistory.setLoginTimestamp(userLoginHistoryMessage.getLoginTimestamp());
		userLoginHistory.setLogoutTimestamp(userLoginHistoryMessage.getLogoutTimestamp());
		userLoginHistory.setLoginStatus(userLoginHistoryMessage.getLoginStatus());
		
		return userLoginHistory;
	}
	
	public final static UserLoginHistoryMessage convertToMessage(UserLoginHistory userLoginHistory) {
		UserLoginHistoryMessage userLoginHistoryMessage = new UserLoginHistoryMessage();
		
		userLoginHistoryMessage.setUserLoginHistoryId(userLoginHistory.getUserLoginHistoryId());
		userLoginHistoryMessage.setUserId(userLoginHistory.getUserId());
		userLoginHistoryMessage.setLoginToken(userLoginHistory.getLoginToken());
		userLoginHistoryMessage.setIpAddress(userLoginHistory.getIpAddress());
		userLoginHistoryMessage.setLoginTimestamp(userLoginHistory.getLoginTimestamp());
		userLoginHistoryMessage.setLogoutTimestamp(userLoginHistory.getLogoutTimestamp());
		userLoginHistoryMessage.setLoginStatus(userLoginHistory.getLoginStatus());
		
		return userLoginHistoryMessage;
	}
}
