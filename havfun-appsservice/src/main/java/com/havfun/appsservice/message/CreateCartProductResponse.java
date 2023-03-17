package com.havfun.appsservice.message;

public class CreateCartProductResponse extends AbstractResponse{

	private long cartProductId;
	
	
	public long getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateCartProductResponse [cartProductId=");
		builder.append(cartProductId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}


	
}
