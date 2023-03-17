package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.UserGetPasscode;
import com.havfun.service.entity.constant.UserGetPasscodeStatus;

public class UserGetPasscodeRowMapper implements RowMapper<UserGetPasscode> {

	@Override
	public UserGetPasscode mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserGetPasscode userGetPasscode = new UserGetPasscode();

		userGetPasscode.setUserId(rs.getInt("user_id"));
		userGetPasscode.setGeneratedToken(rs.getString("generated_token"));
		userGetPasscode.setExpiryTime(rs.getLong("expiry_time"));
		userGetPasscode.setUserGetPasscodeStatus(UserGetPasscodeStatus.fromValue(rs.getString("user_get_passcode_status")));
		return userGetPasscode;
	}

 }

