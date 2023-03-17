package com.havfun.service.message.admin.material;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;

public class AdminSearchMaterialRequest extends BaseAdminRequest {
	
	private int materialGroupId;
	
	private String materialGroupTag;

	
	
	public int getMaterialGroupId() {
		return materialGroupId;
	}

	public void setMaterialGroupId(int materialGroupId) {
		this.materialGroupId = materialGroupId;
	}

	public String getMaterialGroupTag() {
		return materialGroupTag;
	}

	public void setMaterialGroupTag(String materialGroupTag) {
		this.materialGroupTag = materialGroupTag;
	}

	public AdminSearchMaterialRequest() {
		setMessageId(MessageId.ADMIN_SEARCH_MATERIAL_REQUEST);
	}

	@Override
	public String toString() {
		return "AdminSearchMaterialRequest [materialGroupId=" + materialGroupId + ", materialGroupTag=" + materialGroupTag
				+ ", loginUserId=" + loginUserId + ", token=" + token + ", clientId=" + clientId + ", messageId="
				+ messageId + "]";
	}	

}
