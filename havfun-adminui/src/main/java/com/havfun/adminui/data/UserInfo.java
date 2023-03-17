package com.havfun.adminui.data;

import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.entity.constant.UserStatus;

public class UserInfo {
	private int userId;
	private String userLoginId;
	private String userName;
	private String phoneNo;
	private String email;
	private UserStatus userStatus;
	private String encryptedPassword;	
	private UserGroup userGroup;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userLoginId=" + userLoginId + ", userName=" + userName + ", phoneNo="
				+ phoneNo + ", email=" + email + ", userStatus=" + userStatus + ", encryptedPassword="
				+ encryptedPassword + ", userGroup=" + userGroup + "]";
	}




	
	
}
