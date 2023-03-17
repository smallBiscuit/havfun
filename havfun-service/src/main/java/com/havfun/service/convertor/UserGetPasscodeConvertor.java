package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.UserGetPasscode;
import com.havfun.service.message.data.UserGetPasscodeMessage;

public class UserGetPasscodeConvertor {

	public final static List<UserGetPasscode> convertToEntityList(List<UserGetPasscodeMessage> userGetPasscodeMessageList) {
		if (userGetPasscodeMessageList == null) {
			return null;
		}

		List<UserGetPasscode> userGetPasscodeList = new ArrayList<UserGetPasscode>();
		for (UserGetPasscodeMessage userGetPasscodeMessage : userGetPasscodeMessageList) {
			userGetPasscodeList.add(convertToEntity(userGetPasscodeMessage));
		}

		return userGetPasscodeList;
	}

	public final static List<UserGetPasscodeMessage> convertToMessageList(List<UserGetPasscode> userGetPasscodeList) {
		if (userGetPasscodeList == null) {
			return null;
		}

		List<UserGetPasscodeMessage> userGetPasscodeMessageList = new ArrayList<UserGetPasscodeMessage>();
		for (UserGetPasscode userGetPasscode : userGetPasscodeList) {
			userGetPasscodeMessageList.add(convertToMessage(userGetPasscode));
		}

		return userGetPasscodeMessageList;
	}

	public final static UserGetPasscode convertToEntity(UserGetPasscodeMessage userGetPasscodeMessage) {
		UserGetPasscode userGetPasscode = new UserGetPasscode();

		userGetPasscode.setUserId(userGetPasscodeMessage.getUserId());
		userGetPasscode.setGeneratedToken(userGetPasscodeMessage.getGeneratedToken());
		userGetPasscode.setExpiryTime(userGetPasscodeMessage.getExpiryTime());
		userGetPasscode.setUserGetPasscodeStatus(userGetPasscodeMessage.getUserGetPasscodeStatus());

		return userGetPasscode;
	}

	public final static UserGetPasscodeMessage convertToMessage(UserGetPasscode userGetPasscode) {
		UserGetPasscodeMessage userGetPasscodeMessage = new UserGetPasscodeMessage();

		userGetPasscodeMessage.setUserId(userGetPasscode.getUserId());
		userGetPasscodeMessage.setGeneratedToken(userGetPasscode.getGeneratedToken());
		userGetPasscodeMessage.setExpiryTime(userGetPasscode.getExpiryTime());
		userGetPasscodeMessage.setUserGetPasscodeStatus(userGetPasscode.getUserGetPasscodeStatus());

		return userGetPasscodeMessage;
	}

}


