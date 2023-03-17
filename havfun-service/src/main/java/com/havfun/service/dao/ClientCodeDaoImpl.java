package com.havfun.service.dao;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import com.havfun.service.dao.ClientCodeDao;
import com.havfun.service.dao.ClientCodeDaoImpl;
import com.havfun.service.entity.ClientCode;

public class ClientCodeDaoImpl implements ClientCodeDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ClientCodeDaoImpl.class);

	private final static String CLIENT_CODE_UPDATE_SQL_BY_KEY = "update clientCode set  client_code = ?, client_id = ?, used = ? where client_code_id = ?";

	private final static String CLIENT_CODE_SELECT_SQL_BY_KEY = "select * from clientCode where client_code_id = ?";

	private final static String CLIENT_CODE_DELETE_SQL_BY_KEY = "delete from clientCode where client_code_id = ?";

//	private final static String CLIENT_CODE_SELECT_ALL_SQL = "select * from clientCode";

//	private final static String CLIENT_CODE_SELECT_SQL_BY_CLIENT_CODE_ID = "select * from clientCode where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ClientCode> rowMapper;

	@Override
	public Integer create(ClientCode newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("clientCode").usingGeneratedKeyColumns("client_code_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("client_code_id", newInstance.getClientCodeId());
		parameters.put("client_code", newInstance.getClientCode());
		parameters.put("client_id", newInstance.getClientId());
		parameters.put("used", newInstance.isUsed()?"1":"0");
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ClientCode read(Integer id) {
		ClientCode clientCode = null;
		try {
			clientCode = jdbcTemplate.queryForObject(
			CLIENT_CODE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return clientCode;
	}

	@Override
	public int update(ClientCode transientObject) {
		return jdbcTemplate.update(
				CLIENT_CODE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getClientCode(),
					transientObject.getClientId(),
					transientObject.isUsed()?"1":"0",
					transientObject.getClientCodeId(),

				}
			);
	}

	@Override
	public int delete(ClientCode persistentObject) {
		return jdbcTemplate.update(
			CLIENT_CODE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getClientCodeId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CLIENT_CODE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

