package com.havfun.adminui.menu;

public class SubMenu {
	private String key;
	private String url;
	
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

	@Override
	public String toString() {
		return "SubMenu [key=" + key + ", url=" + url + "]";
	}
}

