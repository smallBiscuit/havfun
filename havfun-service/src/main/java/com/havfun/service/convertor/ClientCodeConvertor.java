package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ClientCode;
import com.havfun.service.message.data.ClientCodeMessage;

public class ClientCodeConvertor {

	public final static List<ClientCode> convertToEntityList(List<ClientCodeMessage> clientCodeMessageList) {
		if (clientCodeMessageList == null) {
			return null;
		}

		List<ClientCode> clientCodeList = new ArrayList<ClientCode>();
		for (ClientCodeMessage clientCodeMessage : clientCodeMessageList) {
			clientCodeList.add(convertToEntity(clientCodeMessage));
		}

		return clientCodeList;
	}

	public final static List<ClientCodeMessage> convertToMessageList(List<ClientCode> clientCodeList) {
		if (clientCodeList == null) {
			return null;
		}

		List<ClientCodeMessage> clientCodeMessageList = new ArrayList<ClientCodeMessage>();
		for (ClientCode clientCode : clientCodeList) {
			clientCodeMessageList.add(convertToMessage(clientCode));
		}

		return clientCodeMessageList;
	}

	public final static ClientCode convertToEntity(ClientCodeMessage clientCodeMessage) {
		ClientCode clientCode = new ClientCode();

		clientCode.setClientCodeId(clientCodeMessage.getClientCodeId());
		clientCode.setClientCode(clientCodeMessage.getClientCode());
		clientCode.setClientId(clientCodeMessage.getClientId());
		clientCode.setUsed(clientCodeMessage.isUsed());

		return clientCode;
	}

	public final static ClientCodeMessage convertToMessage(ClientCode clientCode) {
		ClientCodeMessage clientCodeMessage = new ClientCodeMessage();

		clientCodeMessage.setClientCodeId(clientCode.getClientCodeId());
		clientCodeMessage.setClientCode(clientCode.getClientCode());
		clientCodeMessage.setClientId(clientCode.getClientId());
		clientCodeMessage.setUsed(clientCode.isUsed());

		return clientCodeMessage;
	}

}


