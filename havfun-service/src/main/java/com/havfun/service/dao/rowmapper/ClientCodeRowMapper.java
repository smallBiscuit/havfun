package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ClientCode;

public class ClientCodeRowMapper implements RowMapper<ClientCode> {

	@Override
	public ClientCode mapRow(ResultSet rs, int rowNum) throws SQLException {

		ClientCode clientCode = new ClientCode();

		clientCode.setClientCodeId(rs.getInt("client_code_id"));
		clientCode.setClientCode(rs.getString("client_code"));
		clientCode.setClientId(rs.getInt("client_id"));
		clientCode.setUsed(rs.getString("used")=="1");
		return clientCode;
	}

 }

