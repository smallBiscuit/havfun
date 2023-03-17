package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.SocialSignIn;
import com.havfun.service.message.data.SocialSignInMessage;

public class SocialSignInConvertor {

	public final static List<SocialSignIn> convertToEntityList(List<SocialSignInMessage> socialSignInMessageList) {
		if (socialSignInMessageList == null) {
			return null;
		}

		List<SocialSignIn> socialSignInList = new ArrayList<SocialSignIn>();
		for (SocialSignInMessage socialSignInMessage : socialSignInMessageList) {
			socialSignInList.add(convertToEntity(socialSignInMessage));
		}

		return socialSignInList;
	}

	public final static List<SocialSignInMessage> convertToMessageList(List<SocialSignIn> socialSignInList) {
		if (socialSignInList == null) {
			return null;
		}

		List<SocialSignInMessage> socialSignInMessageList = new ArrayList<SocialSignInMessage>();
		for (SocialSignIn socialSignIn : socialSignInList) {
			socialSignInMessageList.add(convertToMessage(socialSignIn));
		}

		return socialSignInMessageList;
	}

	public final static SocialSignIn convertToEntity(SocialSignInMessage socialSignInMessage) {
		SocialSignIn socialSignIn = new SocialSignIn();

		socialSignIn.setSocialSignInId(socialSignInMessage.getSocialSignInId());
		socialSignIn.setClientId(socialSignInMessage.getClientId());
		socialSignIn.setEmail(socialSignInMessage.getEmail());
		socialSignIn.setPrvoider(socialSignInMessage.getPrvoider());
		socialSignIn.setIdentifier(socialSignInMessage.getIdentifier());
		socialSignIn.setRegisterTimestamp(socialSignInMessage.getRegisterTimestamp());
		socialSignIn.setLastVisitTimestamp(socialSignInMessage.getLastVisitTimestamp());

		return socialSignIn;
	}

	public final static SocialSignInMessage convertToMessage(SocialSignIn socialSignIn) {
		SocialSignInMessage socialSignInMessage = new SocialSignInMessage();

		socialSignInMessage.setSocialSignInId(socialSignIn.getSocialSignInId());
		socialSignInMessage.setClientId(socialSignIn.getClientId());
		socialSignInMessage.setEmail(socialSignIn.getEmail());
		socialSignInMessage.setPrvoider(socialSignIn.getPrvoider());
		socialSignInMessage.setIdentifier(socialSignIn.getIdentifier());
		socialSignInMessage.setRegisterTimestamp(socialSignIn.getRegisterTimestamp());
		socialSignInMessage.setLastVisitTimestamp(socialSignIn.getLastVisitTimestamp());

		return socialSignInMessage;
	}

}


