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
import com.havfun.service.dao.CountryDao;
import com.havfun.service.dao.CountryDaoImpl;
import com.havfun.service.entity.Country;

public class CountryDaoImpl implements CountryDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CountryDaoImpl.class);

	private final static String COUNTRY_UPDATE_SQL_BY_KEY = "update country set  country_code = ?, name_en = ?, name_hk = ?, name_cn = ?, active = ? where country_id = ?";

	private final static String COUNTRY_SELECT_SQL_BY_KEY = "select * from country where country_id = ?";

	private final static String COUNTRY_DELETE_SQL_BY_KEY = "delete from country where country_id = ?";

	private final static String COUNTRY_SELECT_ALL_SQL = "select * from country";

	private final static String COUNTRY_SELECT_SQL_BY_COUNTRY_ID = "select * from country where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Country> rowMapper;

	@Override
	public Integer create(Country newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("country").usingGeneratedKeyColumns("country_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("country_id", newInstance.getCountryId());
		parameters.put("country_code", newInstance.getCountryCode());
		parameters.put("name_en", newInstance.getNameEn());
		parameters.put("name_hk", newInstance.getNameHk());
		parameters.put("name_cn", newInstance.getNameCn());
		parameters.put("active", newInstance.isActive()?"1":"0");
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Country read(Integer id) {
		Country country = null;
		try {
			country = jdbcTemplate.queryForObject(
			COUNTRY_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return country;
	}

	@Override
	public int update(Country transientObject) {
		return jdbcTemplate.update(
				COUNTRY_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getCountryCode(),
					transientObject.getNameEn(),
					transientObject.getNameHk(),
					transientObject.getNameCn(),
					transientObject.isActive()?"1":"0",
					transientObject.getCountryId(),

				}
			);
	}

	@Override
	public int delete(Country persistentObject) {
		return jdbcTemplate.update(
			COUNTRY_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getCountryId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				COUNTRY_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

