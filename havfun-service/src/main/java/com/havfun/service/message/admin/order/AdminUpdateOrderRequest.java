package com.havfun.service.message.admin.order;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.OrderMessage;

public class AdminUpdateOrderRequest extends BaseAdminRequest{
	
	private OrderMessage clientMessage;
	
	public AdminUpdateOrderRequest() {
		setMessageId(MessageId.ADMIN_UPDATE_ORDER_REQUEST);
	}

	public OrderMessage getOrderMessage() {
		return clientMessage;
	}

	public void setOrderMessage(OrderMessage clientMessage) {
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUpdateOrderRequest [clientMessage=");
		builder.append(clientMessage);
		builder.append(", loginUserId=");
		builder.append(loginUserId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", messageId=");
		builder.append(messageId);
		builder.append("]");
		return builder.toString();
	}

}
