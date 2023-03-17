package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Zone;

public class ZoneRowMapper implements RowMapper<Zone> {

	@Override
	public Zone mapRow(ResultSet rs, int rowNum) throws SQLException {

		Zone zone = new Zone();

		zone.setZoneId(rs.getInt("zone_id"));
		zone.setCountryId(rs.getInt("country_id"));
		zone.setName(rs.getString("name"));
		zone.setCode(rs.getString("code"));
		zone.setActive(rs.getString("active")=="1");
		return zone;
	}

 }

