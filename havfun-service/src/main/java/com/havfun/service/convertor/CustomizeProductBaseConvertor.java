package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.CustomizeProductBase;
import com.havfun.service.message.data.CustomizeProductBaseMessage;

public class CustomizeProductBaseConvertor {

	public final static List<CustomizeProductBase> convertToEntityList(List<CustomizeProductBaseMessage> customizeProductBaseMessageList) {
		if (customizeProductBaseMessageList == null) {
			return null;
		}

		List<CustomizeProductBase> customizeProductBaseList = new ArrayList<CustomizeProductBase>();
		for (CustomizeProductBaseMessage customizeProductBaseMessage : customizeProductBaseMessageList) {
			customizeProductBaseList.add(convertToEntity(customizeProductBaseMessage));
		}

		return customizeProductBaseList;
	}

	public final static List<CustomizeProductBaseMessage> convertToMessageList(List<CustomizeProductBase> customizeProductBaseList) {
		if (customizeProductBaseList == null) {
			return null;
		}

		List<CustomizeProductBaseMessage> customizeProductBaseMessageList = new ArrayList<CustomizeProductBaseMessage>();
		for (CustomizeProductBase customizeProductBase : customizeProductBaseList) {
			customizeProductBaseMessageList.add(convertToMessage(customizeProductBase));
		}

		return customizeProductBaseMessageList;
	}

	public final static CustomizeProductBase convertToEntity(CustomizeProductBaseMessage customizeProductBaseMessage) {
		CustomizeProductBase customizeProductBase = new CustomizeProductBase();

		customizeProductBase.setBaseId(customizeProductBaseMessage.getBaseId());
//		customizeProductBase.setProductId(customizeProductBaseMessage.getProductId());

		return customizeProductBase;
	}

	public final static CustomizeProductBaseMessage convertToMessage(CustomizeProductBase customizeProductBase) {
		CustomizeProductBaseMessage customizeProductBaseMessage = new CustomizeProductBaseMessage();

		customizeProductBaseMessage.setBaseId(customizeProductBase.getBaseId());
//		customizeProductBaseMessage.setProductId(customizeProductBase.getProductId());

		return customizeProductBaseMessage;
	}

}


