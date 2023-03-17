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
import com.havfun.service.dao.ZoneDao;
import com.havfun.service.dao.ZoneDaoImpl;
import com.havfun.service.entity.Zone;

public class ZoneDaoImpl implements ZoneDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ZoneDaoImpl.class);

	private final static String ZONE_UPDATE_SQL_BY_KEY = "update zone set  country_id = ?, name = ?, code = ?, active = ? where zone_id = ?";

	private final static String ZONE_SELECT_SQL_BY_KEY = "select * from zone where zone_id = ?";

	private final static String ZONE_DELETE_SQL_BY_KEY = "delete from zone where zone_id = ?";

	private final static String ZONE_SELECT_ALL_SQL = "select * from zone";

	private final static String ZONE_SELECT_SQL_BY_ZONE_ID = "select * from zone where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Zone> rowMapper;

	@Override
	public Integer create(Zone newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("zone").usingGeneratedKeyColumns("zone_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("zone_id", newInstance.getZoneId());
		parameters.put("country_id", newInstance.getCountryId());
		parameters.put("name", newInstance.getName());
		parameters.put("code", newInstance.getCode());
		parameters.put("active", newInstance.isActive()?"1":"0");
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Zone read(Integer id) {
		Zone zone = null;
		try {
			zone = jdbcTemplate.queryForObject(
			ZONE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return zone;
	}

	@Override
	public int update(Zone transientObject) {
		return jdbcTemplate.update(
				ZONE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getCountryId(),
					transientObject.getName(),
					transientObject.getCode(),
					transientObject.isActive()?"1":"0",
					transientObject.getZoneId(),

				}
			);
	}

	@Override
	public int delete(Zone persistentObject) {
		return jdbcTemplate.update(
			ZONE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getZoneId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				ZONE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

