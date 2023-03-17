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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.havfun.service.dao.CourierDao;
import com.havfun.service.dao.CourierDaoImpl;
import com.havfun.service.dao.rowmapper.CourierRowMapper;
import com.havfun.service.entity.Courier;

public class CourierDaoImpl implements CourierDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CourierDaoImpl.class);

	private final static String COURIER_UPDATE_SQL_BY_KEY = "update courier set forwarder_id = ?, country_code = ?, from_weight = ?, to_weight = ?, base_weight = ?, base_cost = ?, weight_per_tier = ?, charge_per_tier = ?, service_charge_percentage = ?, fuel_charge_percentage = ? where courier_id = ?";

	private final static String COURIER_SELECT_SQL_BY_KEY = "select * from courier inner join forwarder on courier.forwarder_id=forwarder.forwarder_id where courier_id = ?";

	private final static String COURIER_DELETE_SQL_BY_KEY = "delete from courier where courier_id = ?";

	private final static String COURIER_SELECT_ALL_SQL = "select * from courier inner join forwarder on courier.forwarder_id=forwarder.forwarder_id";


	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Courier> rowMapper;

	@Override
	public Integer create(Courier newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("courier").usingGeneratedKeyColumns("courier");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("courier_id", newInstance.getCourierId());
		parameters.put("forwarder_id", newInstance.getForwarderId());
		parameters.put("country_code", newInstance.getCountryCode());
		parameters.put("from_weight", newInstance.getFromWeight());
		parameters.put("to_weight", newInstance.getToWeight());
		parameters.put("base_weight", newInstance.getBaseWeight());
		parameters.put("base_cost", newInstance.getBaseCost());
		parameters.put("weight_per_tier", newInstance.getWeightPerTier());
		parameters.put("charge_per_tier", newInstance.getChargePerTier());
		parameters.put("service_charge_percentage", newInstance.getServiceChargePercentage());
		parameters.put("fuel_charge_percentage", newInstance.getFuelChargePercentage());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Courier read(Integer id) {
		Courier courier = null;
		try {
			courier = jdbcTemplate.queryForObject(
			COURIER_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return courier;
	}

	@Override
	public int update(Courier transientObject) {
		return jdbcTemplate.update(
				COURIER_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getForwarderId(),
					transientObject.getCountryCode(),
					transientObject.getFromWeight(),
					transientObject.getToWeight(),
					transientObject.getBaseWeight(),
					transientObject.getBaseCost(),
					transientObject.getWeightPerTier(),
					transientObject.getChargePerTier(),
					transientObject.getServiceChargePercentage(),
					transientObject.getFuelChargePercentage(),
					transientObject.getCourierId(),

				}
			);
	}

	@Override
	public int delete(Courier persistentObject) {
		return jdbcTemplate.update(
			COURIER_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getCourierId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				COURIER_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

	@Override
	public List<Courier> readAll() {

		return jdbcTemplate.query(
				COURIER_SELECT_ALL_SQL, 
					new CourierRowMapper(), 
					new Object[]{
						}
					);
	}
}

