package com.havfun.service.dao;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.havfun.service.dao.GeoZoneDao;
import com.havfun.service.dao.GeoZoneDaoImpl;
import com.havfun.service.entity.GeoZone;

public class GeoZoneDaoImpl implements GeoZoneDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(GeoZoneDaoImpl.class);

	private final static String GEO_ZONE_UPDATE_SQL_BY_KEY = "update geoZone set  name = ?, description = ?, create_timestamp = ?, last_modifed_timestamp = ? where geo_zeon_id = ?";

	private final static String GEO_ZONE_SELECT_SQL_BY_KEY = "select * from geo_zone where geo_zeon_id = ?";

	private final static String GEO_ZONE_DELETE_SQL_BY_KEY = "delete from geo_zone where geo_zeon_id = ?";

	private final static String GEO_ZONE_SELECT_ALL_SQL = "select * from geo_zone";

	private final static String GEO_ZONE_SELECT_SQL_BY_GEO_ZEON_ID = "select * from geo_zone where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<GeoZone> rowMapper;

	@Override
	public Integer create(GeoZone newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("geo_zone").usingGeneratedKeyColumns("geo_zeon_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("geo_zeon_id", newInstance.getGeoZeonId());
		parameters.put("name", newInstance.getName());
		parameters.put("description", newInstance.getDescription());
		parameters.put("create_timestamp", newInstance.getCreateTimestamp());
		parameters.put("last_modifed_timestamp", newInstance.getLastModifedTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public GeoZone read(Integer id) {
		GeoZone geoZone = null;
		try {
			geoZone = jdbcTemplate.queryForObject(
			GEO_ZONE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return geoZone;
	}

	@Override
	public int update(GeoZone transientObject) {
		return jdbcTemplate.update(
				GEO_ZONE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getName(),
					transientObject.getDescription(),
					transientObject.getCreateTimestamp(),
					transientObject.getLastModifedTimestamp(),
					transientObject.getGeoZeonId(),

				}
			);
	}

	@Override
	public int delete(GeoZone persistentObject) {
		return jdbcTemplate.update(
			GEO_ZONE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getGeoZeonId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				GEO_ZONE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

