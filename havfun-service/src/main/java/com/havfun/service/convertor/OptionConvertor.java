package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Option;
import com.havfun.service.message.data.OptionMessage;

public class OptionConvertor {

	public final static List<Option> convertToEntityList(List<OptionMessage> optionMessageList) {
		if (optionMessageList == null) {
			return null;
		}

		List<Option> optionList = new ArrayList<Option>();
		for (OptionMessage optionMessage : optionMessageList) {
			optionList.add(convertToEntity(optionMessage));
		}

		return optionList;
	}

	public final static List<OptionMessage> convertToMessageList(List<Option> optionList) {
		if (optionList == null) {
			return null;
		}

		List<OptionMessage> optionMessageList = new ArrayList<OptionMessage>();
		for (Option option : optionList) {
			optionMessageList.add(convertToMessage(option));
		}

		return optionMessageList;
	}

	public final static Option convertToEntity(OptionMessage optionMessage) {
		Option option = new Option();

		option.setOrderOptionId(optionMessage.getOrderOptionId());
		option.setType(optionMessage.getType());

		return option;
	}

	public final static OptionMessage convertToMessage(Option option) {
		OptionMessage optionMessage = new OptionMessage();

		optionMessage.setOrderOptionId(option.getOrderOptionId());
		optionMessage.setType(option.getType());

		return optionMessage;
	}

}


