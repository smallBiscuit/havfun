package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ReferrerLog;

public class ReferrerLogRowMapper implements RowMapper<ReferrerLog> {

	@Override
	public ReferrerLog mapRow(ResultSet rs, int rowNum) throws SQLException {

		ReferrerLog referrerLog = new ReferrerLog();

		referrerLog.setLogId(rs.getInt("log_id"));
		referrerLog.setClientId(rs.getInt("client_id"));
		referrerLog.setReferrer(rs.getInt("referrer"));
		referrerLog.setOrderId(rs.getInt("order_id"));
		referrerLog.setTotal(rs.getBigDecimal("total"));
		referrerLog.setPrice(rs.getBigDecimal("price"));
		referrerLog.setCreateTimestamp(rs.getLong("create_timestamp"));
		return referrerLog;
	}

 }

