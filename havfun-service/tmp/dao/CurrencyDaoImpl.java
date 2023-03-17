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
import com.havfun.service.dao.CurrencyDao;
import com.havfun.service.dao.CurrencyDaoImpl;
import com.havfun.service.entity.Currency;

public class CurrencyDaoImpl implements CurrencyDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CurrencyDaoImpl.class);

	private final static String CURRENCY_UPDATE_SQL_BY_KEY = "update currency set  code = ?, symbol_left = ?, symbol_right = ?, decimal_place = ?, last_modified_timestamp = ? where currency_id = ?";

	private final static String CURRENCY_SELECT_SQL_BY_KEY = "select * from currency where currency_id = ?";

	private final static String CURRENCY_DELETE_SQL_BY_KEY = "delete from currency where currency_id = ?";

	private final static String CURRENCY_SELECT_ALL_SQL = "select * from currency";

	private final static String CURRENCY_SELECT_SQL_BY_CURRENCY_ID = "select * from currency where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Currency> rowMapper;

	@Override
	public Integer create(Currency newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("currency").usingGeneratedKeyColumns("currency_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("currency_id", newInstance.getCurrencyId());
		parameters.put("code", newInstance.getCode());
		parameters.put("symbol_left", newInstance.getSymbolLeft());
		parameters.put("symbol_right", newInstance.getSymbolRight());
		parameters.put("decimal_place", newInstance.getDecimalPlace());
		parameters.put("last_modified_timestamp", newInstance.getLastModifiedTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Currency read(Integer id) {
		Currency currency = null;
		try {
			currency = jdbcTemplate.queryForObject(
			CURRENCY_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return currency;
	}

	@Override
	public int update(Currency transientObject) {
		return jdbcTemplate.update(
				CURRENCY_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getCode(),
					transientObject.getSymbolLeft(),
					transientObject.getSymbolRight(),
					transientObject.getDecimalPlace(),
					transientObject.getLastModifiedTimestamp(),
					transientObject.getCurrencyId(),

				}
			);
	}

	@Override
	public int delete(Currency persistentObject) {
		return jdbcTemplate.update(
			CURRENCY_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getCurrencyId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CURRENCY_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

