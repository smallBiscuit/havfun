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
import com.havfun.service.dao.UserGetPasscodeDao;
import com.havfun.service.dao.UserGetPasscodeDaoImpl;
import com.havfun.service.entity.UserGetPasscode;

public class UserGetPasscodeDaoImpl implements UserGetPasscodeDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(UserGetPasscodeDaoImpl.class);

	private final static String USER_GET_PASSCODE_UPDATE_SQL_BY_KEY = "update userGetPasscode set  generated_token = ?, expiry_time = ?, user_get_passcode_status = ? where user_id = ?";

	private final static String USER_GET_PASSCODE_SELECT_SQL_BY_KEY = "select * from user_get_passcode where user_id = ?";

	private final static String USER_GET_PASSCODE_DELETE_SQL_BY_KEY = "delete from user_get_passcode where user_id = ?";

	private final static String USER_GET_PASSCODE_SELECT_ALL_SQL = "select * from user_get_passcode";

	private final static String USER_GET_PASSCODE_SELECT_SQL_BY_USER_ID = "select * from user_get_passcode where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<UserGetPasscode> rowMapper;

	@Override
	public Integer create(UserGetPasscode newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user_get_passcode").usingGeneratedKeyColumns("user_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", newInstance.getUserId());
		parameters.put("generated_token", newInstance.getGeneratedToken());
		parameters.put("expiry_time", newInstance.getExpiryTime());
		parameters.put("user_get_passcode_status", newInstance.getUserGetPasscodeStatus()==null?null:newInstance.getUserGetPasscodeStatus().getValue());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public UserGetPasscode read(Integer id) {
		UserGetPasscode userGetPasscode = null;
		try {
			userGetPasscode = jdbcTemplate.queryForObject(
			USER_GET_PASSCODE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return userGetPasscode;
	}

	@Override
	public int update(UserGetPasscode transientObject) {
		return jdbcTemplate.update(
				USER_GET_PASSCODE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getGeneratedToken(),
					transientObject.getExpiryTime(),
					transientObject.getUserGetPasscodeStatus().getValue(),
					transientObject.getUserId(),

				}
			);
	}

	@Override
	public int delete(UserGetPasscode persistentObject) {
		return jdbcTemplate.update(
			USER_GET_PASSCODE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getUserId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				USER_GET_PASSCODE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

