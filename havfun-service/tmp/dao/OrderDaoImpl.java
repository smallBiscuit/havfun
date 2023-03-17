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
import com.havfun.service.dao.OrderDao;
import com.havfun.service.dao.OrderDaoImpl;
import com.havfun.service.entity.Order;

public class OrderDaoImpl implements OrderDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(OrderDaoImpl.class);

	private final static String ORDER_UPDATE_SQL_BY_KEY = "update order set  invoice_no = ?, store_id = ?, store_name = ?, store_url = ?, client_id = ?, client_group = ?, first_name = ?, last_name = ?, email = ?, telephone = ?, fax = ?, payment_first_name = ?, payment_last_name = ?, payment_address1 = ?, payment_address2 = ?, payment_city = ?, payment_postcode = ?, payment_country = ?, payment_country_id = ?, payment_zone = ?, payment_zone_id = ?, payment_method_id = ?, payment_code = ?, payment_telephone = ?, shipping_first_name = ?, shipping_last_name = ?, shipping_address1 = ?, shipping_address2 = ?, shipping_city = ?, shipping_postcode = ?, shipping_country = ?, shipping_country_id = ?, shipping_zone = ?, shipping_zone_id = ?, shipping_method_id = ?, shipping_code = ?, shipping_telephone = ?, comment = ?, total = ?, status = ?, currency_id = ?, currency_code = ?, currency_value = ?, create_timestamp = ?, last_modified_timestamp = ? where order_id = ?";

	private final static String ORDER_SELECT_SQL_BY_KEY = "select * from order where order_id = ?";

	private final static String ORDER_DELETE_SQL_BY_KEY = "delete from order where order_id = ?";

	private final static String ORDER_SELECT_ALL_SQL = "select * from order";

	private final static String ORDER_SELECT_SQL_BY_ORDER_ID = "select * from order where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Order> rowMapper;

	@Override
	public Integer create(Order newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("order").usingGeneratedKeyColumns("order_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("order_id", newInstance.getOrderId());
		parameters.put("invoice_no", newInstance.getInvoiceNo());
		parameters.put("store_id", newInstance.getStoreId());
		parameters.put("store_name", newInstance.getStoreName());
		parameters.put("store_url", newInstance.getStoreUrl());
		parameters.put("client_id", newInstance.getClientId());
		parameters.put("client_group", newInstance.getClientGroup());
		parameters.put("first_name", newInstance.getFirstName());
		parameters.put("last_name", newInstance.getLastName());
		parameters.put("email", newInstance.getEmail());
		parameters.put("telephone", newInstance.getTelephone());
		parameters.put("fax", newInstance.getFax());
		parameters.put("payment_first_name", newInstance.getPaymentFirstName());
		parameters.put("payment_last_name", newInstance.getPaymentLastName());
		parameters.put("payment_address1", newInstance.getPaymentAddress1());
		parameters.put("payment_address2", newInstance.getPaymentAddress2());
		parameters.put("payment_city", newInstance.getPaymentCity());
		parameters.put("payment_postcode", newInstance.getPaymentPostcode());
		parameters.put("payment_country", newInstance.getPaymentCountry());
		parameters.put("payment_country_id", newInstance.getPaymentCountryId());
		parameters.put("payment_zone", newInstance.getPaymentZone());
		parameters.put("payment_zone_id", newInstance.getPaymentZoneId());
		parameters.put("payment_method_id", newInstance.getPaymentMethodId());
		parameters.put("payment_code", newInstance.getPaymentCode());
		parameters.put("payment_telephone", newInstance.getPaymentTelephone());
		parameters.put("shipping_first_name", newInstance.getShippingFirstName());
		parameters.put("shipping_last_name", newInstance.getShippingLastName());
		parameters.put("shipping_address1", newInstance.getShippingAddress1());
		parameters.put("shipping_address2", newInstance.getShippingAddress2());
		parameters.put("shipping_city", newInstance.getShippingCity());
		parameters.put("shipping_postcode", newInstance.getShippingPostcode());
		parameters.put("shipping_country", newInstance.getShippingCountry());
		parameters.put("shipping_country_id", newInstance.getShippingCountryId());
		parameters.put("shipping_zone", newInstance.getShippingZone());
		parameters.put("shipping_zone_id", newInstance.getShippingZoneId());
		parameters.put("shipping_method_id", newInstance.getShippingMethodId());
		parameters.put("shipping_code", newInstance.getShippingCode());
		parameters.put("shipping_telephone", newInstance.getShippingTelephone());
		parameters.put("comment", newInstance.getComment());
		parameters.put("total", newInstance.getTotal());
		parameters.put("status", newInstance.getStatus()==null?null:newInstance.getStatus().getValue());
		parameters.put("currency_id", newInstance.getCurrencyId());
		parameters.put("currency_code", newInstance.getCurrencyCode());
		parameters.put("currency_value", newInstance.getCurrencyValue());
		parameters.put("create_timestamp", newInstance.getCreateTimestamp());
		parameters.put("last_modified_timestamp", newInstance.getLastModifiedTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Order read(Integer id) {
		Order order = null;
		try {
			order = jdbcTemplate.queryForObject(
			ORDER_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return order;
	}

	@Override
	public int update(Order transientObject) {
		return jdbcTemplate.update(
				ORDER_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getInvoiceNo(),
					transientObject.getStoreId(),
					transientObject.getStoreName(),
					transientObject.getStoreUrl(),
					transientObject.getClientId(),
					transientObject.getClientGroup(),
					transientObject.getFirstName(),
					transientObject.getLastName(),
					transientObject.getEmail(),
					transientObject.getTelephone(),
					transientObject.getFax(),
					transientObject.getPaymentFirstName(),
					transientObject.getPaymentLastName(),
					transientObject.getPaymentAddress1(),
					transientObject.getPaymentAddress2(),
					transientObject.getPaymentCity(),
					transientObject.getPaymentPostcode(),
					transientObject.getPaymentCountry(),
					transientObject.getPaymentCountryId(),
					transientObject.getPaymentZone(),
					transientObject.getPaymentZoneId(),
					transientObject.getPaymentMethodId(),
					transientObject.getPaymentCode(),
					transientObject.getPaymentTelephone(),
					transientObject.getShippingFirstName(),
					transientObject.getShippingLastName(),
					transientObject.getShippingAddress1(),
					transientObject.getShippingAddress2(),
					transientObject.getShippingCity(),
					transientObject.getShippingPostcode(),
					transientObject.getShippingCountry(),
					transientObject.getShippingCountryId(),
					transientObject.getShippingZone(),
					transientObject.getShippingZoneId(),
					transientObject.getShippingMethodId(),
					transientObject.getShippingCode(),
					transientObject.getShippingTelephone(),
					transientObject.getComment(),
					transientObject.getTotal(),
					transientObject.getStatus().getValue(),
					transientObject.getCurrencyId(),
					transientObject.getCurrencyCode(),
					transientObject.getCurrencyValue(),
					transientObject.getCreateTimestamp(),
					transientObject.getLastModifiedTimestamp(),
					transientObject.getOrderId(),

				}
			);
	}

	@Override
	public int delete(Order persistentObject) {
		return jdbcTemplate.update(
			ORDER_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getOrderId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				ORDER_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

