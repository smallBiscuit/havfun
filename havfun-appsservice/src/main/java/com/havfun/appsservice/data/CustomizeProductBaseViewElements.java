package com.havfun.appsservice.data;

import java.math.BigDecimal;

public class CustomizeProductBaseViewElements {

	private String type;
	
	private String title;
	
	private CustomizeProductBaseViewElementsParams params;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CustomizeProductBaseViewElementsParams getParams() {
		return params;
	}

	public void setParams(CustomizeProductBaseViewElementsParams params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "CustomizeProductBaseViewElements [type=" + type + ", title=" + title + ", params=" + params + "]";
	}
	
	


	
}
