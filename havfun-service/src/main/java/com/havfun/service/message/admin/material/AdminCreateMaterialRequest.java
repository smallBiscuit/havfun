package com.havfun.service.message.admin.material;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.MaterialMessage;

public class AdminCreateMaterialRequest extends BaseAdminRequest{
	
	private MaterialMessage materialMessage;
	
	public AdminCreateMaterialRequest() {
		setMessageId(MessageId.ADMIN_CREATE_MATERIAL_REQUEST);
	}

	public MaterialMessage getMaterialMessage() {
		return materialMessage;
	}

	public void setMaterialMessage(MaterialMessage materialMessage) {
		this.materialMessage = materialMessage;
	}

	@Override
	public String toString() {
		return "AdminCreateMaterialRequest [materialMessage=" + materialMessage + ", loginUserId=" + loginUserId + ", token="
				+ token + ", clientId=" + clientId + ", messageId=" + messageId + "]";
	}

	


}
