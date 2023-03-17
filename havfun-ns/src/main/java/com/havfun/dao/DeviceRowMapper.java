package com.havfun.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.havfun.entity.Device;
import com.havfun.service.data.DevicePlatform;

public class DeviceRowMapper implements RowMapper<Device>{

	@Override
	public Device mapRow(ResultSet rs, int rowNum) throws SQLException {

		Device device = new Device();
		device.setDeviceId( rs.getInt("device_id"));
		device.setUserId( rs.getInt("user_id"));
		device.setName( rs.getString("name"));
		device.setPlatform( DevicePlatform.fromValue( rs.getString("platform") ));
		device.setToken( rs.getString("token"));
		device.setCreateTime( rs.getLong( "create_timestamp") );
		
		return device;
	}

	
}
