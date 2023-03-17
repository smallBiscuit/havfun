package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Client;
import com.havfun.service.message.data.ClientMessage;

public class ClientConvertor {

	public final static List<Client> convertToEntityList(List<ClientMessage> clientMessageList) {
		if (clientMessageList == null) {
			return null;
		}

		List<Client> clientList = new ArrayList<Client>();
		for (ClientMessage clientMessage : clientMessageList) {
			clientList.add(convertToEntity(clientMessage));
		}

		return clientList;
	}

	public final static List<ClientMessage> convertToMessageList(List<Client> clientList) {
		if (clientList == null) {
			return null;
		}

		List<ClientMessage> clientMessageList = new ArrayList<ClientMessage>();
		for (Client client : clientList) {
			clientMessageList.add(convertToMessage(client));
		}

		return clientMessageList;
	}

	public final static Client convertToEntity(ClientMessage clientMessage) {
		Client client = new Client();

		client.setClientId(clientMessage.getClientId());
		client.setFirstName(clientMessage.getFirstName());
		client.setLastName(clientMessage.getLastName());
		client.setBirthDate(clientMessage.getBirthDate());
		client.setGender(clientMessage.getGender());
		client.setEmail(clientMessage.getEmail());
		client.setTelephone(clientMessage.getTelephone());
		client.setFax(clientMessage.getFax());
		client.setReferrerClientId(clientMessage.getReferrerClientId());
		client.setStoreId(clientMessage.getStoreId());
		client.setPasscode(clientMessage.getPasscode());
		client.setNewsletter(clientMessage.isNewsletter());
		client.setClientGroup(clientMessage.getClientGroup());
		client.setIpAddress(clientMessage.getIpAddress());
		client.setStatus(clientMessage.getStatus());
		client.setToken(clientMessage.getToken());
		client.setCreateTimestamp(clientMessage.getCreateTimestamp());

		return client;
	}

	public final static ClientMessage convertToMessage(Client client) {
		ClientMessage clientMessage = new ClientMessage();

		clientMessage.setClientId(client.getClientId());
		clientMessage.setFirstName(client.getFirstName());
		clientMessage.setLastName(client.getLastName());
		clientMessage.setBirthDate(client.getBirthDate());
		clientMessage.setGender(client.getGender());
		clientMessage.setEmail(client.getEmail());
		clientMessage.setTelephone(client.getTelephone());
		clientMessage.setFax(client.getFax());
		clientMessage.setReferrerClientId(client.getReferrerClientId());
		clientMessage.setStoreId(client.getStoreId());
		clientMessage.setPasscode(client.getPasscode());
		clientMessage.setNewsletter(client.isNewsletter());
		clientMessage.setClientGroup(client.getClientGroup());
		clientMessage.setIpAddress(client.getIpAddress());
		clientMessage.setStatus(client.getStatus());
		clientMessage.setToken(client.getToken());
		clientMessage.setCreateTimestamp(client.getCreateTimestamp());

		return clientMessage;
	}

}


