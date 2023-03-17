package com.havfun.service.dao;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import com.havfun.service.dao.ZoneToGeoZoneDao;
import com.havfun.service.dao.ZoneToGeoZoneDaoImpl;
import com.havfun.service.entity.ZoneToGeoZone;

public class ZoneToGeoZoneDaoImpl implements ZoneToGeoZoneDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ZoneToGeoZoneDaoImpl.class);

	private final static String ZONE_TO_GEO_ZONE_UPDATE_SQL_BY_KEY = "update zoneToGeoZone set  country_id = ?, zone_id = ?, create_timestamp = ?, last_modified_timestamp = ? where zone_to_geo_zone = ?";

	private final static String ZONE_TO_GEO_ZONE_SELECT_SQL_BY_KEY = "select * from zoneToGeoZone where zone_to_geo_zone = ?";

	private final static String ZONE_TO_GEO_ZONE_DELETE_SQL_BY_KEY = "delete from zoneToGeoZone where zone_to_geo_zone = ?";

//	private final static String ZONE_TO_GEO_ZONE_SELECT_ALL_SQL = "select * from zoneToGeoZone";

//	private final static String ZONE_TO_GEO_ZONE_SELECT_SQL_BY_ZONE_TO_GEO_ZONE = "select * from zoneToGeoZone where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ZoneToGeoZone> rowMapper;

	@Override
	public Integer create(ZoneToGeoZone newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("zoneToGeoZone").usingGeneratedKeyColumns("zone_to_geo_zone");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("zone_to_geo_zone", newInstance.getZoneToGeoZone());
		parameters.put("country_id", newInstance.getCountryId());
		parameters.put("zone_id", newInstance.getZoneId());
		parameters.put("create_timestamp", newInstance.getCreateTimestamp());
		parameters.put("last_modified_timestamp", newInstance.getLastModifiedTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ZoneToGeoZone read(Integer id) {
		ZoneToGeoZone zoneToGeoZone = null;
		try {
			zoneToGeoZone = jdbcTemplate.queryForObject(
			ZONE_TO_GEO_ZONE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return zoneToGeoZone;
	}

	@Override
	public int update(ZoneToGeoZone transientObject) {
		return jdbcTemplate.update(
				ZONE_TO_GEO_ZONE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getCountryId(),
					transientObject.getZoneId(),
					transientObject.getCreateTimestamp(),
					transientObject.getLastModifiedTimestamp(),
					transientObject.getZoneToGeoZone(),

				}
			);
	}

	@Override
	public int delete(ZoneToGeoZone persistentObject) {
		return jdbcTemplate.update(
			ZONE_TO_GEO_ZONE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getZoneToGeoZone()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				ZONE_TO_GEO_ZONE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

