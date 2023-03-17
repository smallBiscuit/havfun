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
import com.havfun.service.dao.OptionDao;
import com.havfun.service.dao.OptionDaoImpl;
import com.havfun.service.entity.Option;

public class OptionDaoImpl implements OptionDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(OptionDaoImpl.class);

	private final static String OPTION_UPDATE_SQL_BY_KEY = "update option set  type = ? where order_option_id = ?";

	private final static String OPTION_SELECT_SQL_BY_KEY = "select * from option where order_option_id = ?";

	private final static String OPTION_DELETE_SQL_BY_KEY = "delete from option where order_option_id = ?";

	private final static String OPTION_SELECT_ALL_SQL = "select * from option";

	private final static String OPTION_SELECT_SQL_BY_ORDER_OPTION_ID = "select * from option where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Option> rowMapper;

	@Override
	public Integer create(Option newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("option").usingGeneratedKeyColumns("order_option_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("order_option_id", newInstance.getOrderOptionId());
		parameters.put("type", newInstance.getType());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Option read(Integer id) {
		Option option = null;
		try {
			option = jdbcTemplate.queryForObject(
			OPTION_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return option;
	}

	@Override
	public int update(Option transientObject) {
		return jdbcTemplate.update(
				OPTION_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getType(),
					transientObject.getOrderOptionId(),

				}
			);
	}

	@Override
	public int delete(Option persistentObject) {
		return jdbcTemplate.update(
			OPTION_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getOrderOptionId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				OPTION_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

