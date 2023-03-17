package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.CustomizeProductBaseView;
import com.havfun.service.message.data.CustomizeProductBaseViewMessage;

public class CustomizeProductBaseViewConvertor {

	public final static List<CustomizeProductBaseView> convertToEntityList(List<CustomizeProductBaseViewMessage> customizeProductBaseViewMessageList) {
		if (customizeProductBaseViewMessageList == null) {
			return null;
		}

		List<CustomizeProductBaseView> customizeProductBaseViewList = new ArrayList<CustomizeProductBaseView>();
		for (CustomizeProductBaseViewMessage customizeProductBaseViewMessage : customizeProductBaseViewMessageList) {
			customizeProductBaseViewList.add(convertToEntity(customizeProductBaseViewMessage));
		}

		return customizeProductBaseViewList;
	}

	public final static List<CustomizeProductBaseViewMessage> convertToMessageList(List<CustomizeProductBaseView> customizeProductBaseViewList) {
		if (customizeProductBaseViewList == null) {
			return null;
		}

		List<CustomizeProductBaseViewMessage> customizeProductBaseViewMessageList = new ArrayList<CustomizeProductBaseViewMessage>();
		for (CustomizeProductBaseView customizeProductBaseView : customizeProductBaseViewList) {
			customizeProductBaseViewMessageList.add(convertToMessage(customizeProductBaseView));
		}

		return customizeProductBaseViewMessageList;
	}

	public final static CustomizeProductBaseView convertToEntity(CustomizeProductBaseViewMessage customizeProductBaseViewMessage) {
		CustomizeProductBaseView customizeProductBaseView = new CustomizeProductBaseView();

		customizeProductBaseView.setViewId(customizeProductBaseViewMessage.getViewId());
		customizeProductBaseView.setBaseId(customizeProductBaseViewMessage.getBaseId());
		customizeProductBaseView.setTitle(customizeProductBaseViewMessage.getTitle());
		customizeProductBaseView.setBoundWidth(customizeProductBaseViewMessage.getBoundWidth());
		customizeProductBaseView.setBoundHeight(customizeProductBaseViewMessage.getBoundHeight());
		customizeProductBaseView.setX(customizeProductBaseViewMessage.getX());
		customizeProductBaseView.setY(customizeProductBaseViewMessage.getY());
		customizeProductBaseView.setZ(customizeProductBaseViewMessage.getZ());
		customizeProductBaseView.setScale(customizeProductBaseViewMessage.getScale());

		return customizeProductBaseView;
	}

	public final static CustomizeProductBaseViewMessage convertToMessage(CustomizeProductBaseView customizeProductBaseView) {
		CustomizeProductBaseViewMessage customizeProductBaseViewMessage = new CustomizeProductBaseViewMessage();

		customizeProductBaseViewMessage.setViewId(customizeProductBaseView.getViewId());
		customizeProductBaseViewMessage.setBaseId(customizeProductBaseView.getBaseId());
		customizeProductBaseViewMessage.setTitle(customizeProductBaseView.getTitle());
		customizeProductBaseViewMessage.setBoundWidth(customizeProductBaseView.getBoundWidth());
		customizeProductBaseViewMessage.setBoundHeight(customizeProductBaseView.getBoundHeight());
		customizeProductBaseViewMessage.setX(customizeProductBaseView.getX());
		customizeProductBaseViewMessage.setY(customizeProductBaseView.getY());
		customizeProductBaseViewMessage.setZ(customizeProductBaseView.getZ());
		customizeProductBaseViewMessage.setScale(customizeProductBaseView.getScale());

		return customizeProductBaseViewMessage;
	}

}


