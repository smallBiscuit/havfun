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
import com.havfun.service.dao.CustomizeProductBaseDao;
import com.havfun.service.dao.CustomizeProductBaseDaoImpl;
import com.havfun.service.entity.CustomizeProductBase;

public class CustomizeProductBaseDaoImpl implements CustomizeProductBaseDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CustomizeProductBaseDaoImpl.class);

	private final static String CUSTOMIZE_PRODUCT_BASE_UPDATE_SQL_BY_KEY = "update customizeProductBase set  product_id = ? where base_id = ?";

	private final static String CUSTOMIZE_PRODUCT_BASE_SELECT_SQL_BY_KEY = "select * from customize_product_base where base_id = ?";

	private final static String CUSTOMIZE_PRODUCT_BASE_DELETE_SQL_BY_KEY = "delete from customize_product_base where base_id = ?";

	private final static String CUSTOMIZE_PRODUCT_BASE_SELECT_ALL_SQL = "select * from customize_product_base";

	private final static String CUSTOMIZE_PRODUCT_BASE_SELECT_SQL_BY_BASE_ID = "select * from customize_product_base where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<CustomizeProductBase> rowMapper;

	@Override
	public Integer create(CustomizeProductBase newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("customize_product_base").usingGeneratedKeyColumns("base_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("base_id", newInstance.getBaseId());
		parameters.put("product_id", newInstance.getProductId());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public CustomizeProductBase read(Integer id) {
		CustomizeProductBase customizeProductBase = null;
		try {
			customizeProductBase = jdbcTemplate.queryForObject(
			CUSTOMIZE_PRODUCT_BASE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return customizeProductBase;
	}

	@Override
	public int update(CustomizeProductBase transientObject) {
		return jdbcTemplate.update(
				CUSTOMIZE_PRODUCT_BASE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getProductId(),
					transientObject.getBaseId(),

				}
			);
	}

	@Override
	public int delete(CustomizeProductBase persistentObject) {
		return jdbcTemplate.update(
			CUSTOMIZE_PRODUCT_BASE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getBaseId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CUSTOMIZE_PRODUCT_BASE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

