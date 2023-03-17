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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.havfun.service.dao.OrderDao;
import com.havfun.service.dao.OrderDaoImpl;
import com.havfun.service.entity.Order;
import com.havfun.service.entity.constant.OrderStatus;

public class OrderDaoImpl implements OrderDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(OrderDaoImpl.class);

	private final static String ORDER_INSERT_SQL = 
			"insert into `client_order` ( " +
			"invoice_no," +
			"store_id," +
			"store_name," +
			"store_url," +
			"client_id," +
			"client_group," +
			"first_name," +	
			"last_name," +	
			"email," +	
			"telephone," +	
			"fax," +				
			"billing_first_name," +	
			"billing_last_name," +	
			"billing_address_1," +	
			"billing_address_2," +	
			"billing_city," +	
			"billing_postcode," +	
			"billing_country_id," +	
			"billing_telephone," +				
			"shipping_first_name," +	
			"shipping_last_name," +	
			"shipping_address_1," +	
			"shipping_address_2," +	
			"shipping_city," +	
			"shipping_postcode," +	
			"shipping_country_id," +	
			"shipping_telephone," +	
			"shipping_method_id," +	
			"payment_method_id," +	
			"currency_id," +	
			"currency_code," +	
			"currency_value," +	
			"remark," +	
			"total," +	
			"status," +	
			"create_timestamp," +	
			"last_modified_timestamp) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private final static String ORDER_UPDATE_SQL_BY_KEY = "update `client_order` set invoice_no = ?, store_id = ?, store_name = ?, store_url = ?, client_id = ?, client_group = ?, first_name = ?, last_name = ?, email = ?, telephone = ?, fax = ?, billing_first_name = ?, billing_last_name = ?, billing_address_1 = ?, billing_address_2 = ?, billing_city = ?, billing_postcode = ?, billing_country_id = ?, billing_telephone = ?, shipping_first_name = ?, shipping_last_name = ?, shipping_address_1 = ?, shipping_address_2 = ?, shipping_city = ?, shipping_postcode = ?, shipping_country_id = ?, shipping_telephone = ?, shipping_method_id = ?, payment_method_id = ?, currency_id = ?, currency_code = ?, currency_value = ?, remark = ?, total = ?, status = ?, last_modified_timestamp = ? where order_id = ?";

	private final static String ORDER_UPDATE_STATUS_SQL_BY_KEY = "update `client_order` set status = ?, last_modified_timestamp = ? where order_id = ?";
	
	private final static String ORDER_SELECT_SQL_BY_KEY = "select * from `client_order` where order_id = ?";

	private final static String ORDER_DELETE_SQL_BY_KEY = "delete from `client_order` where order_id = ?";

	private final static String ORDER_SELECT_ALL_SQL = "select * from `client_order`";

//	private final static String ORDER_SELECT_SQL_BY_ORDER_ID = "select * from `order` where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Order> rowMapper;

	@Override
	public Integer create2(Order newInstance) {	
		
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		
		try{
			
		jdbcTemplate.update(
				ORDER_INSERT_SQL,
				new Object[]{
						
						newInstance.getInvoiceNo(),
						newInstance.getStoreId(),
						newInstance.getStoreName(),
						newInstance.getStoreUrl(),
						newInstance.getClientId(),
						newInstance.getClientGroup(),
						newInstance.getFirstName(),
						newInstance.getLastName(),
						newInstance.getEmail(),
						newInstance.getTelephone(),
						newInstance.getFax(),
						
						newInstance.getBillingFirstName(),
						newInstance.getBillingLastName(),
						newInstance.getBillingAddress1(),
						newInstance.getBillingAddress2(),
						newInstance.getBillingCity(),
						newInstance.getBillingPostcode(),
						newInstance.getBillingCountryId(),
						newInstance.getBillingTelephone(),
						
						newInstance.getShippingFirstName(),
						newInstance.getShippingLastName(),
						newInstance.getShippingAddress1(),
						newInstance.getShippingAddress2(),
						newInstance.getShippingCity(),
						newInstance.getShippingPostcode(),
						newInstance.getShippingCountryId(),
						newInstance.getShippingTelephone(),
						
						newInstance.getPaymentMethodId(),
						newInstance.getShippingMethodId(),
						newInstance.getCurrencyId(),
						newInstance.getCurrencyCode(),
						newInstance.getCurrencyValue(),						
						newInstance.getRemark(),
						newInstance.getTotal(),
						newInstance.getStatus()==null?null:newInstance.getStatus().getValue(),
						new Timestamp( System.currentTimeMillis() ),
						new Timestamp( System.currentTimeMillis() )
						
				}, keyHolder);
		}catch (Exception e){
			
			LOGGER.info("OrderDaoImpl Exception " + e);
			return -1;
			
		}
		
		return keyHolder.getKey().intValue();
		
	}
	
	@Override
	public Integer create(Order newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("client_order").usingGeneratedKeyColumns("order_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		
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
		parameters.put("billing_first_name", newInstance.getBillingFirstName());
		parameters.put("billing_last_name", newInstance.getBillingLastName());
		parameters.put("billing_address_1", newInstance.getBillingAddress1());
		parameters.put("billing_address_2", newInstance.getBillingAddress2());
		parameters.put("billing_city", newInstance.getBillingCity());
		parameters.put("billing_postcode", newInstance.getBillingPostcode());
		parameters.put("billing_country_id", newInstance.getBillingCountryId());
		parameters.put("billing_telephone", newInstance.getBillingTelephone());
		parameters.put("shipping_first_name", newInstance.getShippingFirstName());
		parameters.put("shipping_last_name", newInstance.getShippingLastName());
		parameters.put("shipping_address_1", newInstance.getShippingAddress1());
		parameters.put("shipping_address_2", newInstance.getShippingAddress2());
		parameters.put("shipping_city", newInstance.getShippingCity());
		parameters.put("shipping_postcode", newInstance.getShippingPostcode());
		parameters.put("shipping_country_id", newInstance.getShippingCountryId());
		parameters.put("shipping_telephone", newInstance.getShippingTelephone());
		parameters.put("payment_method_id", newInstance.getPaymentMethodId());
		parameters.put("shipping_method_id", newInstance.getShippingMethodId());		
		parameters.put("currency_id", newInstance.getCurrencyId());
		parameters.put("currency_code", newInstance.getCurrencyCode());
		parameters.put("currency_value", newInstance.getCurrencyValue());
		parameters.put("remark", newInstance.getRemark());
		parameters.put("total", newInstance.getTotal());
		parameters.put("status", newInstance.getStatus()==null?null:newInstance.getStatus().getValue());
		parameters.put("create_timestamp", new Timestamp( System.currentTimeMillis() ) );
		parameters.put("last_modified_timestamp",  new Timestamp( System.currentTimeMillis() ) );
		
		LOGGER.info("rayTest parameters: " + parameters );
		
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
					transientObject.getBillingFirstName(),
					transientObject.getBillingLastName(),
					transientObject.getBillingAddress1(),
					transientObject.getBillingAddress2(),
					transientObject.getBillingCity(),
					transientObject.getBillingPostcode(),
					transientObject.getBillingCountryId(),
					transientObject.getBillingTelephone(),
					transientObject.getShippingFirstName(),
					transientObject.getShippingLastName(),
					transientObject.getShippingAddress1(),
					transientObject.getShippingAddress2(),
					transientObject.getShippingCity(),
					transientObject.getShippingPostcode(),
					transientObject.getShippingCountryId(),
					transientObject.getShippingTelephone(),
					transientObject.getShippingMethodId(),
					transientObject.getPaymentMethodId(),
					transientObject.getCurrencyId(),
					transientObject.getCurrencyCode(),
					transientObject.getCurrencyValue(),
					transientObject.getRemark(),
					transientObject.getTotal(),
					transientObject.getStatus().getValue(),
					new Timestamp( System.currentTimeMillis() ),
					transientObject.getOrderId(),

				}
			);
	}
	
	@Override
	public int updateOrderStatus( int orderId, OrderStatus orderStatus ) {
		
		return jdbcTemplate.update(
				ORDER_UPDATE_STATUS_SQL_BY_KEY,
				new Object [] {
					orderStatus.getValue(),
					new Timestamp( System.currentTimeMillis() ),
					orderId,

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

	@Override
	public List<Order> readAll() {
		return jdbcTemplate.query(
				ORDER_SELECT_ALL_SQL, 
				rowMapper, 
					new Object[]{
						}
					);
	}

	
}

