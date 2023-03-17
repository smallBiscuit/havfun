package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.User;
import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.entity.constant.UserStatus;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();

		user.setUserId(rs.getInt("user_id"));
		user.setUserGroup(UserGroup.fromValue(rs.getString("user_group")));
		user.setUserName(rs.getString("user_name"));
		user.setPasscode(rs.getString("passcode"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setStatus(UserStatus.fromValue(rs.getString("status")));
		user.setCreateTimestamp(rs.getTimestamp("create_timestamp").getTime() );
		return user;
	}

 }

