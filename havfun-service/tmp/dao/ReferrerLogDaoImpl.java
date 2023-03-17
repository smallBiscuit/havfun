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
import com.havfun.service.dao.ReferrerLogDao;
import com.havfun.service.dao.ReferrerLogDaoImpl;
import com.havfun.service.entity.ReferrerLog;

public class ReferrerLogDaoImpl implements ReferrerLogDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ReferrerLogDaoImpl.class);

	private final static String REFERRER_LOG_UPDATE_SQL_BY_KEY = "update referrerLog set  client_id = ?, referrer = ?, order_id = ?, total = ?, price = ?, create_timestamp = ? where log_id = ?";

	private final static String REFERRER_LOG_SELECT_SQL_BY_KEY = "select * from referrer_log where log_id = ?";

	private final static String REFERRER_LOG_DELETE_SQL_BY_KEY = "delete from referrer_log where log_id = ?";

	private final static String REFERRER_LOG_SELECT_ALL_SQL = "select * from referrer_log";

	private final static String REFERRER_LOG_SELECT_SQL_BY_LOG_ID = "select * from referrer_log where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ReferrerLog> rowMapper;

	@Override
	public Integer create(ReferrerLog newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("referrer_log").usingGeneratedKeyColumns("log_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("log_id", newInstance.getLogId());
		parameters.put("client_id", newInstance.getClientId());
		parameters.put("referrer", newInstance.getReferrer());
		parameters.put("order_id", newInstance.getOrderId());
		parameters.put("total", newInstance.getTotal());
		parameters.put("price", newInstance.getPrice());
		parameters.put("create_timestamp", newInstance.getCreateTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ReferrerLog read(Integer id) {
		ReferrerLog referrerLog = null;
		try {
			referrerLog = jdbcTemplate.queryForObject(
			REFERRER_LOG_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return referrerLog;
	}

	@Override
	public int update(ReferrerLog transientObject) {
		return jdbcTemplate.update(
				REFERRER_LOG_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getClientId(),
					transientObject.getReferrer(),
					transientObject.getOrderId(),
					transientObject.getTotal(),
					transientObject.getPrice(),
					transientObject.getCreateTimestamp(),
					transientObject.getLogId(),

				}
			);
	}

	@Override
	public int delete(ReferrerLog persistentObject) {
		return jdbcTemplate.update(
			REFERRER_LOG_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getLogId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				REFERRER_LOG_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

