package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.CustomizeProductBorderItem;
import com.havfun.service.message.data.CustomizeProductBorderItemMessage;

public class CustomizeProductBorderItemConvertor {

	public final static List<CustomizeProductBorderItem> convertToEntityList(List<CustomizeProductBorderItemMessage> customizeProductBorderItemMessageList) {
		if (customizeProductBorderItemMessageList == null) {
			return null;
		}

		List<CustomizeProductBorderItem> customizeProductBorderItemList = new ArrayList<CustomizeProductBorderItem>();
		for (CustomizeProductBorderItemMessage customizeProductBorderItemMessage : customizeProductBorderItemMessageList) {
			customizeProductBorderItemList.add(convertToEntity(customizeProductBorderItemMessage));
		}

		return customizeProductBorderItemList;
	}

	public final static List<CustomizeProductBorderItemMessage> convertToMessageList(List<CustomizeProductBorderItem> customizeProductBorderItemList) {
		if (customizeProductBorderItemList == null) {
			return null;
		}

		List<CustomizeProductBorderItemMessage> customizeProductBorderItemMessageList = new ArrayList<CustomizeProductBorderItemMessage>();
		for (CustomizeProductBorderItem customizeProductBorderItem : customizeProductBorderItemList) {
			customizeProductBorderItemMessageList.add(convertToMessage(customizeProductBorderItem));
		}

		return customizeProductBorderItemMessageList;
	}

	public final static CustomizeProductBorderItem convertToEntity(CustomizeProductBorderItemMessage customizeProductBorderItemMessage) {
		CustomizeProductBorderItem customizeProductBorderItem = new CustomizeProductBorderItem();

		customizeProductBorderItem.setBorderId(customizeProductBorderItemMessage.getBorderId());
		customizeProductBorderItem.setViewId(customizeProductBorderItemMessage.getViewId());
		customizeProductBorderItem.setItemKey(customizeProductBorderItemMessage.getItemKey());
		customizeProductBorderItem.setItemType(customizeProductBorderItemMessage.getItemType());
		customizeProductBorderItem.setTitle(customizeProductBorderItemMessage.getTitle());
		customizeProductBorderItem.setDefaultOption(customizeProductBorderItemMessage.isDefaultOption());
		customizeProductBorderItem.setCost(customizeProductBorderItemMessage.getCost());
		customizeProductBorderItem.setWidth(customizeProductBorderItemMessage.getWidth());
		customizeProductBorderItem.setHeight(customizeProductBorderItemMessage.getHeight());

		return customizeProductBorderItem;
	}

	public final static CustomizeProductBorderItemMessage convertToMessage(CustomizeProductBorderItem customizeProductBorderItem) {
		CustomizeProductBorderItemMessage customizeProductBorderItemMessage = new CustomizeProductBorderItemMessage();

		customizeProductBorderItemMessage.setBorderId(customizeProductBorderItem.getBorderId());
		customizeProductBorderItemMessage.setViewId(customizeProductBorderItem.getViewId());
		customizeProductBorderItemMessage.setItemKey(customizeProductBorderItem.getItemKey());
		customizeProductBorderItemMessage.setItemType(customizeProductBorderItem.getItemType());
		customizeProductBorderItemMessage.setTitle(customizeProductBorderItem.getTitle());
		customizeProductBorderItemMessage.setDefaultOption(customizeProductBorderItem.isDefaultOption());
		customizeProductBorderItemMessage.setCost(customizeProductBorderItem.getCost());
		customizeProductBorderItemMessage.setWidth(customizeProductBorderItem.getWidth());
		customizeProductBorderItemMessage.setHeight(customizeProductBorderItem.getHeight());

		return customizeProductBorderItemMessage;
	}

}


