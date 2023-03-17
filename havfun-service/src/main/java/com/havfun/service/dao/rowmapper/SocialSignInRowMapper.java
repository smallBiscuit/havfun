package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.SocialSignIn;

public class SocialSignInRowMapper implements RowMapper<SocialSignIn> {

	@Override
	public SocialSignIn mapRow(ResultSet rs, int rowNum) throws SQLException {

		SocialSignIn socialSignIn = new SocialSignIn();

		socialSignIn.setSocialSignInId(rs.getInt("social_sign_in_id"));
		socialSignIn.setClientId(rs.getInt("client_id"));
		socialSignIn.setEmail(rs.getString("email"));
		socialSignIn.setPrvoider(rs.getString("prvoider"));
		socialSignIn.setIdentifier(rs.getString("identifier"));
		socialSignIn.setRegisterTimestamp(rs.getLong("register_timestamp"));
		socialSignIn.setLastVisitTimestamp(rs.getLong("last_visit_timestamp"));
		return socialSignIn;
	}

 }

