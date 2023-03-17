package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.GeoZone;

public class GeoZoneRowMapper implements RowMapper<GeoZone> {

	@Override
	public GeoZone mapRow(ResultSet rs, int rowNum) throws SQLException {

		GeoZone geoZone = new GeoZone();

		geoZone.setGeoZeonId(rs.getInt("geo_zeon_id"));
		geoZone.setName(rs.getString("name"));
		geoZone.setDescription(rs.getString("description"));
		geoZone.setCreateTimestamp(rs.getLong("create_timestamp"));
		geoZone.setLastModifedTimestamp(rs.getLong("last_modifed_timestamp"));
		return geoZone;
	}

 }

