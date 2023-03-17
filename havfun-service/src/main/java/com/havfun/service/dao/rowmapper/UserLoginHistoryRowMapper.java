package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.UserLoginHistory;
import com.havfun.service.entity.constant.LoginStatus;

public class UserLoginHistoryRowMapper implements RowMapper<UserLoginHistory> {

	@Override
	public UserLoginHistory mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserLoginHistory userLoginHistory = new UserLoginHistory();

		userLoginHistory.setUserLoginHistoryId(rs.getInt("user_login_history_id"));
		userLoginHistory.setUserId(rs.getInt("user_id"));
		userLoginHistory.setLoginToken(rs.getString("login_token"));
		userLoginHistory.setIpAddress(rs.getString("ip_address"));
		userLoginHistory.setLoginTimestamp(rs.getLong("login_timestamp"));
		userLoginHistory.setLogoutTimestamp(rs.getLong("logout_timestamp"));
		userLoginHistory.setLoginStatus(LoginStatus.fromValue(rs.getString("login_status")));
		return userLoginHistory;
	}

 }

