package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ClientLoginHistory;
import com.havfun.service.entity.constant.LoginStatus;

public class ClientLoginHistoryRowMapper implements RowMapper<ClientLoginHistory> {

	@Override
	public ClientLoginHistory mapRow(ResultSet rs, int rowNum) throws SQLException {

		ClientLoginHistory clientLoginHistory = new ClientLoginHistory();

		clientLoginHistory.setClientLoginHistoryId(rs.getInt("client_login_history_id"));
		clientLoginHistory.setClientId(rs.getInt("client_id"));
		clientLoginHistory.setLoginToken(rs.getString("login_token"));
		clientLoginHistory.setIpAddress(rs.getString("ip_address"));
		clientLoginHistory.setLoginTimestamp(rs.getLong("login_timestamp"));
		clientLoginHistory.setLogoutTimestamp(rs.getLong("logout_timestamp"));
		clientLoginHistory.setLoginStatus(LoginStatus.fromValue(rs.getString("login_status")));
		return clientLoginHistory;
	}

 }

