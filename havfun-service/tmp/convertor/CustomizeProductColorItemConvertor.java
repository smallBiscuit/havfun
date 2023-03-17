package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.CustomizeProductColorItem;
import com.havfun.service.message.data.CustomizeProductColorItemMessage;

public class CustomizeProductColorItemConvertor {

	public final static List<CustomizeProductColorItem> convertToEntityList(List<CustomizeProductColorItemMessage> customizeProductColorItemMessageList) {
		if (customizeProductColorItemMessageList == null) {
			return null;
		}

		List<CustomizeProductColorItem> customizeProductColorItemList = new ArrayList<CustomizeProductColorItem>();
		for (CustomizeProductColorItemMessage customizeProductColorItemMessage : customizeProductColorItemMessageList) {
			customizeProductColorItemList.add(convertToEntity(customizeProductColorItemMessage));
		}

		return customizeProductColorItemList;
	}

	public final static List<CustomizeProductColorItemMessage> convertToMessageList(List<CustomizeProductColorItem> customizeProductColorItemList) {
		if (customizeProductColorItemList == null) {
			return null;
		}

		List<CustomizeProductColorItemMessage> customizeProductColorItemMessageList = new ArrayList<CustomizeProductColorItemMessage>();
		for (CustomizeProductColorItem customizeProductColorItem : customizeProductColorItemList) {
			customizeProductColorItemMessageList.add(convertToMessage(customizeProductColorItem));
		}

		return customizeProductColorItemMessageList;
	}

	public final static CustomizeProductColorItem convertToEntity(CustomizeProductColorItemMessage customizeProductColorItemMessage) {
		CustomizeProductColorItem customizeProductColorItem = new CustomizeProductColorItem();

		customizeProductColorItem.setColorId(customizeProductColorItemMessage.getColorId());
		customizeProductColorItem.setBaseId(customizeProductColorItemMessage.getBaseId());
		customizeProductColorItem.setFileType(customizeProductColorItemMessage.getFileType());
		customizeProductColorItem.setImageUrl(customizeProductColorItemMessage.getImageUrl());
		customizeProductColorItem.setParentImage(customizeProductColorItemMessage.getParentImage());

		return customizeProductColorItem;
	}

	public final static CustomizeProductColorItemMessage convertToMessage(CustomizeProductColorItem customizeProductColorItem) {
		CustomizeProductColorItemMessage customizeProductColorItemMessage = new CustomizeProductColorItemMessage();

		customizeProductColorItemMessage.setColorId(customizeProductColorItem.getColorId());
		customizeProductColorItemMessage.setBaseId(customizeProductColorItem.getBaseId());
		customizeProductColorItemMessage.setFileType(customizeProductColorItem.getFileType());
		customizeProductColorItemMessage.setImageUrl(customizeProductColorItem.getImageUrl());
		customizeProductColorItemMessage.setParentImage(customizeProductColorItem.getParentImage());

		return customizeProductColorItemMessage;
	}

}


