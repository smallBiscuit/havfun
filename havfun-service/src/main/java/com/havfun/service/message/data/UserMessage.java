package com.havfun.service.message.data;

import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.entity.constant.UserStatus;
import com.havfun.service.message.AbstractMessage;

public class UserMessage extends AbstractMessage {

	private int userId;
	
	private UserGroup userGroup;
	
	private String userName;
	
	private String passcode;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String code;
	
	private UserStatus status;
	
	private long createTimestamp;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@Override
	public String toString() {
		return "UserMessage [userId=" + userId + ", userGroup=" + userGroup + ", userName=" + userName + ", passcode="
				+ passcode + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", code="
				+ code + ", status=" + status + ", createTimestamp=" + createTimestamp + ", messageId=" + messageId
				+ "]";
	}
	
	
}
