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
import com.havfun.service.dao.ClientDao;
import com.havfun.service.dao.ClientDaoImpl;
import com.havfun.service.dao.rowmapper.ClientRowMapper;
import com.havfun.service.entity.Client;
import com.havfun.service.entity.User;

public class ClientDaoImpl implements ClientDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ClientDaoImpl.class);

	private final static String CLIENT_UPDATE_SQL_BY_KEY = "update client set  first_name = ?, last_name = ?, birth_date = ?, gender = ?, email = ?, telephone = ?, fax = ?, referrer_client_id = ?, store_id = ?, passcode = ?, newsletter = ?, client_group = ?, ip_address = ?, status = ?, token = ? where client_id = ?";

	private final static String CLIENT_SELECT_SQL_BY_KEY = "select * from client where client_id = ?";

	private final static String CLIENT_DELETE_SQL_BY_KEY = "delete from client where client_id = ?";

	private final static String CLIENT_SELECT_ALL_SQL = "select * from client";

	private final static String CLIENT_SELECT_SQL_BY_EMAIL = "select * from client where email = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Client> rowMapper;

	@Override
	public Integer create(Client newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("client").usingGeneratedKeyColumns("client_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("client_id", newInstance.getClientId());
		parameters.put("first_name", newInstance.getFirstName());
		parameters.put("last_name", newInstance.getLastName());
		parameters.put("birth_date", newInstance.getBirthDate());
		parameters.put("gender", newInstance.getGender());
		parameters.put("email", newInstance.getEmail());
		parameters.put("telephone", newInstance.getTelephone());
		parameters.put("fax", newInstance.getFax());
		parameters.put("referrer_client_id", newInstance.getReferrerClientId());
		parameters.put("store_id", newInstance.getStoreId());
		parameters.put("passcode", newInstance.getPasscode());
		parameters.put("newsletter", newInstance.isNewsletter()?"1":"0");
		parameters.put("client_group", newInstance.getClientGroup());
		parameters.put("ip_address", newInstance.getIpAddress());
		parameters.put("status", newInstance.getStatus()==null?null:newInstance.getStatus().getValue());
		parameters.put("token", newInstance.getToken());
		parameters.put("create_timestamp", new Timestamp( newInstance.getCreateTimestamp() ) );
		
		LOGGER.info("parameters: " + parameters);
		
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Client read(Integer id) {
		Client client = null;
		try {
			client = jdbcTemplate.queryForObject(
			CLIENT_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return client;
	}

	@Override
	public int update(Client transientObject) {
		return jdbcTemplate.update(
				CLIENT_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getFirstName(),
					transientObject.getLastName(),
					transientObject.getBirthDate(),
					transientObject.getGender(),
					transientObject.getEmail(),
					transientObject.getTelephone(),
					transientObject.getFax(),
					transientObject.getReferrerClientId(),
					transientObject.getStoreId(),
					transientObject.getPasscode(),
					transientObject.isNewsletter()?"1":"0",
					transientObject.getClientGroup(),
					transientObject.getIpAddress(),
					transientObject.getStatus().getValue(),
					transientObject.getToken(),
					transientObject.getClientId(),

				}
			);
	}

	@Override
	public int delete(Client persistentObject) {
		return jdbcTemplate.update(
			CLIENT_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getClientId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CLIENT_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

	@Override
	public List<Client> readAll() {

		return jdbcTemplate.query(
				CLIENT_SELECT_ALL_SQL, 
					new ClientRowMapper(), 
					new Object[]{
						}
					);
	}

	@Override
	public Client readByEmail( String email ) {
		Client client = null;
		try {
			client = jdbcTemplate.queryForObject(
				CLIENT_SELECT_SQL_BY_EMAIL,
				rowMapper,
				new Object [] {
						email
				}
			);
			} catch (IncorrectResultSizeDataAccessException e) {
			
				return null;
		}

		return client;
	}
}

