package com.havfun.service.entity;

public class Forwarder {

	private int forwarderId;
	
	private String nameEn;
	
	private String nameHk;
	
	private String nameCn;

	public int getForwarderId() {
		return forwarderId;
	}

	public void setForwarderId(int forwarderId) {
		this.forwarderId = forwarderId;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameHk() {
		return nameHk;
	}

	public void setNameHk(String nameHk) {
		this.nameHk = nameHk;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	@Override
	public String toString() {
		return "Forwarder [forwarderId=" + forwarderId + ", nameEn=" + nameEn + ", nameHk=" + nameHk + ", nameCn="
				+ nameCn + "]";
	}
	
	
	
}
