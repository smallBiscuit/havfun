package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Client;
import com.havfun.service.entity.constant.ClientStatus;

public class ClientRowMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {

		Client client = new Client();

		client.setClientId(rs.getInt("client_id"));
		client.setFirstName(rs.getString("first_name"));
		client.setLastName(rs.getString("last_name"));
		client.setBirthDate(rs.getInt("birth_date"));
		client.setGender(rs.getString("gender"));
		client.setEmail(rs.getString("email"));
		client.setTelephone(rs.getString("telephone"));
		client.setFax(rs.getString("fax"));
		client.setReferrerClientId(rs.getInt("referrer_client_id"));
		client.setStoreId(rs.getInt("store_id"));
		client.setPasscode(rs.getString("passcode"));
		client.setNewsletter(rs.getString("newsletter")=="1");
		client.setClientGroup(rs.getString("client_group"));
		client.setIpAddress(rs.getString("ip_address"));
		client.setStatus(ClientStatus.fromValue(rs.getString("status")));
		client.setToken(rs.getString("token"));
		client.setCreateTimestamp(rs.getTimestamp("create_timestamp").getTime() );
		return client;
	}

 }

