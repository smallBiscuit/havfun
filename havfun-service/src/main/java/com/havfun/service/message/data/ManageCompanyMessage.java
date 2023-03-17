package com.havfun.service.message.data;

import com.havfun.service.message.AbstractMessage;
import com.havfun.service.message.constant.MessageId;

public class ManageCompanyMessage extends AbstractMessage {
	
	private int companyId;
	
	private int stockCode;
	
	public ManageCompanyMessage() {
		setMessageId(MessageId.MANAGE_COMPANY_MESSAGE);
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStockCode() {
		return stockCode;
	}

	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManageCompanyMessage [companyId=");
		builder.append(companyId);
		builder.append(", stockCode=");
		builder.append(stockCode);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
