package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ClientLoginHistory;
import com.havfun.service.message.data.ClientLoginHistoryMessage;
import com.havfun.service.entity.constant.LoginStatus;

public class ClientLoginHistoryConvertor {

	public final static List<ClientLoginHistory> convertToEntityList(List<ClientLoginHistoryMessage> clientLoginHistoryMessageList) {
		if (clientLoginHistoryMessageList == null) {
			return null;
		}

		List<ClientLoginHistory> clientLoginHistoryList = new ArrayList<ClientLoginHistory>();
		for (ClientLoginHistoryMessage clientLoginHistoryMessage : clientLoginHistoryMessageList) {
			clientLoginHistoryList.add(convertToEntity(clientLoginHistoryMessage));
		}

		return clientLoginHistoryList;
	}

	public final static List<ClientLoginHistoryMessage> convertToMessageList(List<ClientLoginHistory> clientLoginHistoryList) {
		if (clientLoginHistoryList == null) {
			return null;
		}

		List<ClientLoginHistoryMessage> clientLoginHistoryMessageList = new ArrayList<ClientLoginHistoryMessage>();
		for (ClientLoginHistory clientLoginHistory : clientLoginHistoryList) {
			clientLoginHistoryMessageList.add(convertToMessage(clientLoginHistory));
		}

		return clientLoginHistoryMessageList;
	}

	public final static ClientLoginHistory convertToEntity(ClientLoginHistoryMessage clientLoginHistoryMessage) {
		ClientLoginHistory clientLoginHistory = new ClientLoginHistory();

		clientLoginHistory.setClientLoginHistoryId(clientLoginHistoryMessage.getClientLoginHistoryId());
		clientLoginHistory.setClientId(clientLoginHistoryMessage.getClientId());
		clientLoginHistory.setLoginToken(clientLoginHistoryMessage.getLoginToken());
		clientLoginHistory.setIpAddress(clientLoginHistoryMessage.getIpAddress());
		clientLoginHistory.setLoginTimestamp(clientLoginHistoryMessage.getLoginTimestamp());
		clientLoginHistory.setLogoutTimestamp(clientLoginHistoryMessage.getLogoutTimestamp());
		clientLoginHistory.setLoginStatus(clientLoginHistoryMessage.getLoginStatus());

		return clientLoginHistory;
	}

	public final static ClientLoginHistoryMessage convertToMessage(ClientLoginHistory clientLoginHistory) {
		ClientLoginHistoryMessage clientLoginHistoryMessage = new ClientLoginHistoryMessage();

		clientLoginHistoryMessage.setClientLoginHistoryId(clientLoginHistory.getClientLoginHistoryId());
		clientLoginHistoryMessage.setClientId(clientLoginHistory.getClientId());
		clientLoginHistoryMessage.setLoginToken(clientLoginHistory.getLoginToken());
		clientLoginHistoryMessage.setIpAddress(clientLoginHistory.getIpAddress());
		clientLoginHistoryMessage.setLoginTimestamp(clientLoginHistory.getLoginTimestamp());
		clientLoginHistoryMessage.setLogoutTimestamp(clientLoginHistory.getLogoutTimestamp());
		clientLoginHistoryMessage.setLoginStatus(clientLoginHistory.getLoginStatus());

		return clientLoginHistoryMessage;
	}

}


