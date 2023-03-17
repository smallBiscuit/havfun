package com.havfun.adminui.menu;

import java.util.List;

public class Menu {
	private String key;
	private String url;
	private boolean enable;
	private List<SubMenu> subMenuList;
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<SubMenu> getSubMenuList() {
		return subMenuList;
	}
	
	public void setSubMenuList(List<SubMenu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	@Override
	public String toString() {
		return "Menu [key=" + key + ", url=" + url + ", enable=" + enable
				+ ", subMenuList=" + subMenuList + "]";
	}
	

}