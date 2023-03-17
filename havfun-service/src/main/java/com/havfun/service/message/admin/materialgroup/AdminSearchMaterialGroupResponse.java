package com.havfun.service.message.admin.materialgroup;

import java.util.List;

import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialGroupMessage;

public class AdminSearchMaterialGroupResponse extends AbstractResponse {
	
	private List<MaterialGroupMessage> materialGroupMessageList;
	
	public AdminSearchMaterialGroupResponse() {
		setMessageId(MessageId.ADMIN_SEARCH_MATERIAL_GROUP_RESPONSE);
	}

	public List<MaterialGroupMessage> getMaterialGroupMessageList() {
		return materialGroupMessageList;
	}

	public void setMaterialGroupMessageList(List<MaterialGroupMessage> materialGroupMessageList) {
		this.materialGroupMessageList = materialGroupMessageList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminSearchMaterialGroupResponse [materialGroupMessageList=");
		builder.append(materialGroupMessageList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
