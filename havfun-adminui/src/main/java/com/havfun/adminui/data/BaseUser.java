package com.havfun.adminui.data;


import java.util.List;

import com.havfun.service.entity.constant.UserGroup;

public class BaseUser {
	private int id;
	private String email;
	private String displayName;
	private String token;
	private UserGroup userGroup;
	private List<String> actionList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	public List<String> getActionList() {
		return actionList;
	}
	public void setActionList(List<String> actionList) {
		this.actionList = actionList;
	}
	@Override
	public String toString() {
		return "BaseUser [id=" + id + ", email=" + email + ", displayName=" + displayName + ", token=" + token
				+ ", userGroup=" + userGroup + ", actionList=" + actionList + "]";
	}
	
	


}