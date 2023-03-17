package com.havfun.service.message;

import java.util.List;

import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialMessage;

public class SearchMaterialResponse extends AbstractResponse{

	private List<MaterialMessage> materialMessageList;

	public SearchMaterialResponse() {
		setMessageId(MessageId.SEARCH_MATERIAL_RESPONSE);
	}

	public List<MaterialMessage> getMaterialMessageList() {
		return materialMessageList;
	}

	public void setMaterialMessageList(List<MaterialMessage> materialMessageList) {
		this.materialMessageList = materialMessageList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchMaterialResponse [materialMessageList=");
		builder.append(materialMessageList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
