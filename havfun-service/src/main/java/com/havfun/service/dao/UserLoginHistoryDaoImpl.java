package com.havfun.service.dao;
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
import com.havfun.service.dao.UserLoginHistoryDao;
import com.havfun.service.dao.UserLoginHistoryDaoImpl;
import com.havfun.service.entity.UserLoginHistory;

public class UserLoginHistoryDaoImpl implements UserLoginHistoryDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(UserLoginHistoryDaoImpl.class);

	private final static String USER_LOGIN_HISTORY_UPDATE_SQL_BY_KEY = "update userLoginHistory set  user_id = ?, login_token = ?, ip_address = ?, login_timestamp = ?, logout_timestamp = ?, login_status = ? where user_login_history_id = ?";

	private final static String USER_LOGIN_HISTORY_SELECT_SQL_BY_KEY = "select * from userLoginHistory where user_login_history_id = ?";

	private final static String USER_LOGIN_HISTORY_DELETE_SQL_BY_KEY = "delete from userLoginHistory where user_login_history_id = ?";

//	private final static String USER_LOGIN_HISTORY_SELECT_ALL_SQL = "select * from userLoginHistory";

//	private final static String USER_LOGIN_HISTORY_SELECT_SQL_BY_USER_LOGIN_HISTORY_ID = "select * from userLoginHistory where user_name = ?";

	private final static String USER_LOGIN_HISTORY_READ_BY_USER_ID_AND_TOKEN_SQL = "select * from user_login_history where user_id = ? and login_token = ?";
	
	private final static String USER_LOGIN_HISTORY_READ_ALL_LOGIN_BY_USER_ID = "select * from user_login_history where user_id = ? and login_status = '" + "A" + "'";

	
	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<UserLoginHistory> rowMapper;

	@Override
	public Integer create(UserLoginHistory newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("userLoginHistory").usingGeneratedKeyColumns("user_login_history_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_login_history_id", newInstance.getUserLoginHistoryId());
		parameters.put("user_id", newInstance.getUserId());
		parameters.put("login_token", newInstance.getLoginToken());
		parameters.put("ip_address", newInstance.getIpAddress());
		parameters.put("login_timestamp", newInstance.getLoginTimestamp());
		parameters.put("logout_timestamp", newInstance.getLogoutTimestamp());
		parameters.put("login_status", newInstance.getLoginStatus()==null?null:newInstance.getLoginStatus().getValue());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public UserLoginHistory read(Integer id) {
		UserLoginHistory userLoginHistory = null;
		try {
			userLoginHistory = jdbcTemplate.queryForObject(
			USER_LOGIN_HISTORY_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return userLoginHistory;
	}

	@Override
	public int update(UserLoginHistory transientObject) {
		return jdbcTemplate.update(
				USER_LOGIN_HISTORY_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getUserId(),
					transientObject.getLoginToken(),
					transientObject.getIpAddress(),
					transientObject.getLoginTimestamp(),
					transientObject.getLogoutTimestamp(),
					transientObject.getLoginStatus().getValue(),
					transientObject.getUserLoginHistoryId(),

				}
			);
	}

	@Override
	public int delete(UserLoginHistory persistentObject) {
		return jdbcTemplate.update(
			USER_LOGIN_HISTORY_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getUserLoginHistoryId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				USER_LOGIN_HISTORY_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}
	
	@Override
	public UserLoginHistory readByUserIdAndToken(int userId, String token) {
		UserLoginHistory userLoginHistory = null;
		
		try{
			userLoginHistory = jdbcTemplate.queryForObject(
					USER_LOGIN_HISTORY_READ_BY_USER_ID_AND_TOKEN_SQL,
					rowMapper,
					new Object [] {
							userId,
							token
					}
					);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return userLoginHistory;
	}

	@Override
	public List<UserLoginHistory> readAllLogin(int userId) {
		return jdbcTemplate.query( 
				USER_LOGIN_HISTORY_READ_ALL_LOGIN_BY_USER_ID,
				rowMapper,
				new Object [] {
						userId
				}
				);
	}


}

