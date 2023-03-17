package com.havfun.service.message;

import com.havfun.service.message.constant.MessageId;

public class IncorporateMessage extends AbstractMessage {
	
	private int incorporateId;
	
	private String incorporateNameEn;
	
	private String incorporateNameHk;
	
	private String incorporateNameCn;
	
	public IncorporateMessage() {
		setMessageId(MessageId.INCORPORATE_MESSAGE);
	}

	public int getIncorporateId() {
		return incorporateId;
	}

	public void setIncorporateId(int incorporateId) {
		this.incorporateId = incorporateId;
	}

	public String getIncorporateNameEn() {
		return incorporateNameEn;
	}

	public void setIncorporateNameEn(String incorporateNameEn) {
		this.incorporateNameEn = incorporateNameEn;
	}

	public String getIncorporateNameHk() {
		return incorporateNameHk;
	}

	public void setIncorporateNameHk(String incorporateNameHk) {
		this.incorporateNameHk = incorporateNameHk;
	}

	public String getIncorporateNameCn() {
		return incorporateNameCn;
	}

	public void setIncorporateNameCn(String incorporateNameCn) {
		this.incorporateNameCn = incorporateNameCn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IncorporateMessage [incorporateId=");
		builder.append(incorporateId);
		builder.append(", incorporateNameEn=");
		builder.append(incorporateNameEn);
		builder.append(", incorporateNameHk=");
		builder.append(incorporateNameHk);
		builder.append(", incorporateNameCn=");
		builder.append(incorporateNameCn);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
