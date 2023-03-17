package com.havfun.service.message.admin.material;

import java.util.List;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialMessage;

public class AdminSearchMaterialResponse extends AbstractResponse {
	
	private List<MaterialMessage> materialMessageList;
	
	public AdminSearchMaterialResponse() {
		setMessageId(MessageId.ADMIN_SEARCH_MATERIAL_RESPONSE);
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
		builder.append("AdminSearchMaterialResponse [materialMessageList=");
		builder.append(materialMessageList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
