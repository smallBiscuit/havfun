package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.User;
import com.havfun.service.message.data.UserMessage;

public class UserConvertor {
	
	public final static List<User> convertToEntityList(List<UserMessage> userMessageList) {
		if (userMessageList == null) {
			return null;
		}
		
		List<User> userList = new ArrayList<User>();
		for (UserMessage userMessage : userMessageList) {
			userList.add(convertToEntity(userMessage));
		}
		
		return userList;
	}
	
	public final static List<UserMessage> convertToMessageList(List<User> userList) {
		if (userList == null) {
			return null;
		}
		
		List<UserMessage> userMessageList = new ArrayList<UserMessage>();
		for (User user : userList) {
			userMessageList.add(convertToMessage(user));
		}
		
		return userMessageList;
	}
	
	public final static User convertToEntity(UserMessage userMessage) {
		User user = new User();
		
		user.setUserId(userMessage.getUserId());
		user.setUserGroup(userMessage.getUserGroup());
		user.setUserName(userMessage.getUserName());
		user.setPasscode(userMessage.getPasscode());
		user.setFirstName(userMessage.getFirstName());
		user.setLastName(userMessage.getLastName());
		user.setEmail(userMessage.getEmail());
		user.setStatus(userMessage.getStatus());
		user.setCreateTimestamp(userMessage.getCreateTimestamp());
		
		return user;
	}
	
	public final static UserMessage convertToMessage(User user) {
		UserMessage userMessage = new UserMessage();
		
		userMessage.setUserId(user.getUserId());
		userMessage.setUserGroup(user.getUserGroup());
		userMessage.setUserName(user.getUserName());
		userMessage.setPasscode(user.getPasscode());
		userMessage.setFirstName(user.getFirstName());
		userMessage.setLastName(user.getLastName());
		userMessage.setEmail(user.getEmail());
		userMessage.setStatus(user.getStatus());
		userMessage.setCreateTimestamp(userMessage.getCreateTimestamp());

		return userMessage;
	}

}
