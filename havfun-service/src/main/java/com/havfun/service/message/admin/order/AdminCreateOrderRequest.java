package com.havfun.service.message.admin.order;

import com.havfun.service.message.admin.BaseAdminRequest;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.OrderMessage;

public class AdminCreateOrderRequest extends BaseAdminRequest{
	
	private OrderMessage orderMessage;
	
	public AdminCreateOrderRequest() {
		setMessageId(MessageId.ADMIN_CREATE_ORDER_REQUEST);
	}

	public OrderMessage getOrderMessage() {
		return orderMessage;
	}

	public void setOrderMessage(OrderMessage orderMessage) {
		this.orderMessage = orderMessage;
	}

	@Override
	public String toString() {
		return "AdminCreateOrderRequest [orderMessage=" + orderMessage + ", loginUserId=" + loginUserId + ", token="
				+ token + ", clientId=" + clientId + ", messageId=" + messageId + "]";
	}

	


}
