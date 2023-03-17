package com.havfun.appsservice.data;

public class PageTemplateItem {

	private String key;
	
	private String name;
	
	private String url;
	
	private String version;
	
	private String type;
	
	private String redirectPage;
	
	private String redirectPageParam;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRedirectPage() {
		return redirectPage;
	}

	public void setRedirectPage(String redirectPage) {
		this.redirectPage = redirectPage;
	}

	public String getRedirectPageParam() {
		return redirectPageParam;
	}

	public void setRedirectPageParam(String redirectPageParam) {
		this.redirectPageParam = redirectPageParam;
	}

	@Override
	public String toString() {
		return "PageTemplateItem [key=" + key + ", name=" + name + ", url=" + url + ", version=" + version + ", type="
				+ type + ", redirectPage=" + redirectPage + ", redirectPageParam=" + redirectPageParam + "]";
	}

	
}
