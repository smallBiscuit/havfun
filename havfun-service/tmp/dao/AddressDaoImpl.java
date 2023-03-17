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
import com.havfun.service.dao.AddressDao;
import com.havfun.service.dao.AddressDaoImpl;
import com.havfun.service.entity.Address;

public class AddressDaoImpl implements AddressDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(AddressDaoImpl.class);

	private final static String ADDRESS_UPDATE_SQL_BY_KEY = "update address set  client_id = ?, first_name = ?, last_name = ?, address1 = ?, address2 = ?, city = ?, postcode = ?, country_id = ?, zone_id = ?, telephone = ?, billing_address = ?, shipping_address = ? where address_id = ?";

	private final static String ADDRESS_SELECT_SQL_BY_KEY = "select * from address where address_id = ?";

	private final static String ADDRESS_DELETE_SQL_BY_KEY = "delete from address where address_id = ?";

	private final static String ADDRESS_SELECT_ALL_SQL = "select * from address";

	private final static String ADDRESS_SELECT_SQL_BY_ADDRESS_ID = "select * from address where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Address> rowMapper;

	@Override
	public Integer create(Address newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("address").usingGeneratedKeyColumns("address_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("address_id", newInstance.getAddressId());
		parameters.put("client_id", newInstance.getClientId());
		parameters.put("first_name", newInstance.getFirstName());
		parameters.put("last_name", newInstance.getLastName());
		parameters.put("address1", newInstance.getAddress1());
		parameters.put("address2", newInstance.getAddress2());
		parameters.put("city", newInstance.getCity());
		parameters.put("postcode", newInstance.getPostcode());
		parameters.put("country_id", newInstance.getCountryId());
		parameters.put("zone_id", newInstance.getZoneId());
		parameters.put("telephone", newInstance.getTelephone());
		parameters.put("billing_address", newInstance.isBillingAddress()?"1":"0");
		parameters.put("shipping_address", newInstance.isShippingAddress()?"1":"0");
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Address read(Integer id) {
		Address address = null;
		try {
			address = jdbcTemplate.queryForObject(
			ADDRESS_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return address;
	}

	@Override
	public int update(Address transientObject) {
		return jdbcTemplate.update(
				ADDRESS_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getClientId(),
					transientObject.getFirstName(),
					transientObject.getLastName(),
					transientObject.getAddress1(),
					transientObject.getAddress2(),
					transientObject.getCity(),
					transientObject.getPostcode(),
					transientObject.getCountryId(),
					transientObject.getZoneId(),
					transientObject.getTelephone(),
					transientObject.isBillingAddress()?"1":"0",
					transientObject.isShippingAddress()?"1":"0",
					transientObject.getAddressId(),

				}
			);
	}

	@Override
	public int delete(Address persistentObject) {
		return jdbcTemplate.update(
			ADDRESS_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getAddressId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				ADDRESS_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

