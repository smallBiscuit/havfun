package com.havfun.service.entity;

import com.havfun.service.entity.constant.LabelType;

public class Label {

	int labelId;	
	
	LabelType type;
	
	int businessId;	
	
	String labelEn;
	
	String labelHk;
	
	String labelCn;
	
	String labelJp;

	public int getLabelId() {
		return labelId;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

	public LabelType getType() {
		return type;
	}

	public void setType(LabelType type) {
		this.type = type;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getLabelEn() {
		return labelEn;
	}

	public void setLabelEn(String labelEn) {
		this.labelEn = labelEn;
	}

	public String getLabelHk() {
		return labelHk;
	}

	public void setLabelHk(String labelHk) {
		this.labelHk = labelHk;
	}

	public String getLabelCn() {
		return labelCn;
	}

	public void setLabelCn(String labelCn) {
		this.labelCn = labelCn;
	}

	public String getLabelJp() {
		return labelJp;
	}

	public void setLabelJp(String labelJp) {
		this.labelJp = labelJp;
	}

	@Override
	public String toString() {
		return "Label [labelId=" + labelId + ", type=" + type + ", businessId=" + businessId + ", labelEn=" + labelEn
				+ ", labelHk=" + labelHk + ", labelCn=" + labelCn + ", labelJp=" + labelJp + "]";
	}
	
	
}
