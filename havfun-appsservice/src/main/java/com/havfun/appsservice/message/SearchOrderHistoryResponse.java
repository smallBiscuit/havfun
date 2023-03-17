package com.havfun.appsservice.message;

import java.util.List;

import com.havfun.appsservice.data.Order;

public class SearchOrderHistoryResponse extends AbstractResponse{

	private List<Order> orderList;

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "SearchOrderHistoryResponse [orderList=" + orderList + ", result=" + result + ", reason=" + reason + "]";
	}
	
	
}
