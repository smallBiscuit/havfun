package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ZoneToGeoZone;

public class ZoneToGeoZoneRowMapper implements RowMapper<ZoneToGeoZone> {

	@Override
	public ZoneToGeoZone mapRow(ResultSet rs, int rowNum) throws SQLException {

		ZoneToGeoZone zoneToGeoZone = new ZoneToGeoZone();

		zoneToGeoZone.setZoneToGeoZone(rs.getInt("zone_to_geo_zone"));
		zoneToGeoZone.setCountryId(rs.getInt("country_id"));
		zoneToGeoZone.setZoneId(rs.getInt("zone_id"));
		zoneToGeoZone.setCreateTimestamp(rs.getLong("create_timestamp"));
		zoneToGeoZone.setLastModifiedTimestamp(rs.getLong("last_modified_timestamp"));
		return zoneToGeoZone;
	}

 }

