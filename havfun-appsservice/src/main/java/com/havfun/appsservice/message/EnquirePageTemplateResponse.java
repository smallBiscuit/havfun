package com.havfun.appsservice.message;

import java.util.List;

import com.havfun.appsservice.data.PageTemplateItem;

public class EnquirePageTemplateResponse extends AbstractResponse{

	private List<PageTemplateItem> itemlist;

	public List<PageTemplateItem> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<PageTemplateItem> itemlist) {
		this.itemlist = itemlist;
	}

	@Override
	public String toString() {
		return "EnquirePageTemplateResponse [itemlist=" + itemlist + ", result=" + result + ", reason=" + reason + "]";
	}
	
}