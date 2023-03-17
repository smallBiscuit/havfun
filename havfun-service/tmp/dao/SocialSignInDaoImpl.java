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
import com.havfun.service.dao.SocialSignInDao;
import com.havfun.service.dao.SocialSignInDaoImpl;
import com.havfun.service.entity.SocialSignIn;

public class SocialSignInDaoImpl implements SocialSignInDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(SocialSignInDaoImpl.class);

	private final static String SOCIAL_SIGN_IN_UPDATE_SQL_BY_KEY = "update socialSignIn set  client_id = ?, email = ?, prvoider = ?, identifier = ?, register_timestamp = ?, last_visit_timestamp = ? where social_sign_in_id = ?";

	private final static String SOCIAL_SIGN_IN_SELECT_SQL_BY_KEY = "select * from social_sign_in where social_sign_in_id = ?";

	private final static String SOCIAL_SIGN_IN_DELETE_SQL_BY_KEY = "delete from social_sign_in where social_sign_in_id = ?";

	private final static String SOCIAL_SIGN_IN_SELECT_ALL_SQL = "select * from social_sign_in";

	private final static String SOCIAL_SIGN_IN_SELECT_SQL_BY_SOCIAL_SIGN_IN_ID = "select * from social_sign_in where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<SocialSignIn> rowMapper;

	@Override
	public Integer create(SocialSignIn newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("social_sign_in").usingGeneratedKeyColumns("social_sign_in_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("social_sign_in_id", newInstance.getSocialSignInId());
		parameters.put("client_id", newInstance.getClientId());
		parameters.put("email", newInstance.getEmail());
		parameters.put("prvoider", newInstance.getPrvoider());
		parameters.put("identifier", newInstance.getIdentifier());
		parameters.put("register_timestamp", newInstance.getRegisterTimestamp());
		parameters.put("last_visit_timestamp", newInstance.getLastVisitTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public SocialSignIn read(Integer id) {
		SocialSignIn socialSignIn = null;
		try {
			socialSignIn = jdbcTemplate.queryForObject(
			SOCIAL_SIGN_IN_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return socialSignIn;
	}

	@Override
	public int update(SocialSignIn transientObject) {
		return jdbcTemplate.update(
				SOCIAL_SIGN_IN_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getClientId(),
					transientObject.getEmail(),
					transientObject.getPrvoider(),
					transientObject.getIdentifier(),
					transientObject.getRegisterTimestamp(),
					transientObject.getLastVisitTimestamp(),
					transientObject.getSocialSignInId(),

				}
			);
	}

	@Override
	public int delete(SocialSignIn persistentObject) {
		return jdbcTemplate.update(
			SOCIAL_SIGN_IN_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getSocialSignInId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				SOCIAL_SIGN_IN_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

