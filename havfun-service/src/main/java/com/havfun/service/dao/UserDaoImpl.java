package com.havfun.service.dao;
import java.sql.Timestamp;
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
import com.havfun.service.dao.UserDao;
import com.havfun.service.dao.UserDaoImpl;
import com.havfun.service.dao.rowmapper.UserRowMapper;
import com.havfun.service.entity.User;

public class UserDaoImpl implements UserDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

	private final static String USER_UPDATE_SQL_BY_KEY = "update user set  user_group = ?, user_name = ?, passcode = ?, first_name = ?, last_name = ?, email = ?, status = ?, create_timestamp = ? where user_id = ?";

	private final static String USER_SELECT_SQL_BY_KEY = "select * from user where user_id = ?";

	private final static String USER_DELETE_SQL_BY_KEY = "delete from user where user_id = ?";

	private final static String USER_SELECT_SQL_READ_ALL = "select * from user";

	private final static String USER_SELECT_SQL_BY_USER_NAME = "select * from user where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<User> rowMapper;

	@Override
	public Integer create(User newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user").usingGeneratedKeyColumns("user_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", newInstance.getUserId());
		parameters.put("user_group", newInstance.getUserGroup()==null?null:newInstance.getUserGroup().getValue());
		parameters.put("user_name", newInstance.getUserName());
		parameters.put("passcode", newInstance.getPasscode());
		parameters.put("first_name", newInstance.getFirstName());
		parameters.put("last_name", newInstance.getLastName());
		parameters.put("email", newInstance.getEmail());
		parameters.put("status", newInstance.getStatus()==null?null:newInstance.getStatus().getValue());
		parameters.put("create_timestamp", new Timestamp( newInstance.getCreateTimestamp() ));
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(
			USER_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return user;
	}

	@Override
	public int update(User transientObject) {
		return jdbcTemplate.update(
				USER_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getUserGroup().getValue(),
					transientObject.getUserName(),
					transientObject.getPasscode(),
					transientObject.getFirstName(),
					transientObject.getLastName(),
					transientObject.getEmail(),
					transientObject.getStatus().getValue(),
					transientObject.getCreateTimestamp(),
					transientObject.getUserId(),

				}
			);
	}

	@Override
	public int delete(User persistentObject) {
		return jdbcTemplate.update(
			USER_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getUserId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				USER_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

	@Override
	public List<User> readAll() {

		return jdbcTemplate.query(
					USER_SELECT_SQL_READ_ALL, 
					new UserRowMapper(), 
					new Object[]{
						}
					);
	}

	@Override
	public User readByUserName(String userName) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(
			USER_SELECT_SQL_BY_USER_NAME,
			rowMapper,
			new Object [] {
					userName
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return user;
	}

}

