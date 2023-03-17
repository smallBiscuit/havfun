package com.havfun.service.message.admin.materialgroup;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialGroupMessage;

public class AdminCreateMaterialGroupRequest extends BaseAdminRequest{
	
	private MaterialGroupMessage materialGroupMessage;
	
	public AdminCreateMaterialGroupRequest() {
		setMessageId(MessageId.ADMIN_CREATE_MATERIAL_GROUP_REQUEST);
	}

	public MaterialGroupMessage getMaterialGroupMessage() {
		return materialGroupMessage;
	}

	public void setMaterialGroupMessage(MaterialGroupMessage materialGroupMessage) {
		this.materialGroupMessage = materialGroupMessage;
	}

	@Override
	public String toString() {
		return "AdminCreateMaterialGroupRequest [materialGroupMessage=" + materialGroupMessage + ", loginUserId="
				+ loginUserId + ", token=" + token + ", clientId=" + clientId + ", messageId=" + messageId + "]";
	}


}
