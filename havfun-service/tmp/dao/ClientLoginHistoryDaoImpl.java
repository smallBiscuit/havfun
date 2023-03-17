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
import com.havfun.service.dao.ClientLoginHistoryDao;
import com.havfun.service.dao.ClientLoginHistoryDaoImpl;
import com.havfun.service.entity.ClientLoginHistory;

public class ClientLoginHistoryDaoImpl implements ClientLoginHistoryDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ClientLoginHistoryDaoImpl.class);

	private final static String CLIENT_LOGIN_HISTORY_UPDATE_SQL_BY_KEY = "update clientLoginHistory set  client_id = ?, login_token = ?, ip_address = ?, login_timestamp = ?, logout_timestamp = ?, login_status = ? where client_login_history_id = ?";

	private final static String CLIENT_LOGIN_HISTORY_SELECT_SQL_BY_KEY = "select * from client_login_history where client_login_history_id = ?";

	private final static String CLIENT_LOGIN_HISTORY_DELETE_SQL_BY_KEY = "delete from client_login_history where client_login_history_id = ?";

	private final static String CLIENT_LOGIN_HISTORY_SELECT_ALL_SQL = "select * from client_login_history";

	private final static String CLIENT_LOGIN_HISTORY_SELECT_SQL_BY_CLIENT_LOGIN_HISTORY_ID = "select * from client_login_history where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ClientLoginHistory> rowMapper;

	@Override
	public Integer create(ClientLoginHistory newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("client_login_history").usingGeneratedKeyColumns("client_login_history_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("client_login_history_id", newInstance.getClientLoginHistoryId());
		parameters.put("client_id", newInstance.getClientId());
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
	public ClientLoginHistory read(Integer id) {
		ClientLoginHistory clientLoginHistory = null;
		try {
			clientLoginHistory = jdbcTemplate.queryForObject(
			CLIENT_LOGIN_HISTORY_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return clientLoginHistory;
	}

	@Override
	public int update(ClientLoginHistory transientObject) {
		return jdbcTemplate.update(
				CLIENT_LOGIN_HISTORY_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getClientId(),
					transientObject.getLoginToken(),
					transientObject.getIpAddress(),
					transientObject.getLoginTimestamp(),
					transientObject.getLogoutTimestamp(),
					transientObject.getLoginStatus().getValue(),
					transientObject.getClientLoginHistoryId(),

				}
			);
	}

	@Override
	public int delete(ClientLoginHistory persistentObject) {
		return jdbcTemplate.update(
			CLIENT_LOGIN_HISTORY_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getClientLoginHistoryId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CLIENT_LOGIN_HISTORY_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

