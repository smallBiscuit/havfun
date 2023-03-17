package com.havfun.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.havfun.entity.Notification;

public class NotificationRowMapper implements RowMapper<Notification>{

	@Override
	public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {

		Notification notification = new Notification();
		notification.setUserId( rs.getInt("user_id"));
		notification.setType( rs.getInt("type"));
		notification.setMessage( rs.getString("message"));
		
		return notification;
	}

	
}
