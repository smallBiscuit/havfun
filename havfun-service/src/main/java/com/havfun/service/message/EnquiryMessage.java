package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class EnquiryMessage extends AbstractMessage {
	
	private int enquiryId;
	
	private String stockCode;
	
	private String name;
	
	private String companyName;
	
	private String phone;
	
	private String email;
	
	private String detail;
	
	private long createTime;
	
	public EnquiryMessage() {
		setMessageId(MessageId.ENQUIRY_MESSAGE);
	}

	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnquiryMessage [enquiryId=");
		builder.append(enquiryId);
		builder.append(", stockCode=");
		builder.append(stockCode);
		builder.append(", name=");
		builder.append(name);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", detail=");
		builder.append(detail);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
