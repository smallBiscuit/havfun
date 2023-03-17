package com.havfun.appsservice.message;

import com.havfun.appsservice.data.Cart;

public class EnquireCartDetailsResponse extends AbstractResponse{

	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "EnquireCartDetailsResponse [cart=" + cart + ", result=" + result + ", reason=" + reason + "]";
	}
	

	
	
}
