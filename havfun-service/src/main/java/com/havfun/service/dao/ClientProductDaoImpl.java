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
import com.havfun.service.dao.ClientProductDao;
import com.havfun.service.dao.ClientProductDaoImpl;
import com.havfun.service.entity.ClientProduct;

public class ClientProductDaoImpl implements ClientProductDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ClientProductDaoImpl.class);

	private final static String CLIENT_PRODUCT_UPDATE_SQL_BY_KEY = "update client_product set designer_client_id = ?, product_status = ?, last_modified_timestamp = ? where client_product_id = ?";

	private final static String CLIENT_PRODUCT_SELECT_SQL_BY_KEY = "select * from client_product where client_product_id = ?";

	private final static String CLIENT_PRODUCT_DELETE_SQL_BY_KEY = "delete from client_product where client_product_id = ?";


	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ClientProduct> rowMapper;

	@Override
	public Integer create(ClientProduct newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("client_product").usingGeneratedKeyColumns("client_product_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("client_product_id", newInstance.getClientProductId());
		parameters.put("designer_client_id", newInstance.getDesignerClientId());
		parameters.put("product_status", newInstance.getProductStatus()==null?null:newInstance.getProductStatus().getValue());
		parameters.put("create_timestamp", new Timestamp( System.currentTimeMillis() ));
		parameters.put("last_modified_timestamp", new Timestamp( System.currentTimeMillis() ));
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ClientProduct read(Integer id) {
		ClientProduct product = null;
		try {
			product = jdbcTemplate.queryForObject(
			CLIENT_PRODUCT_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return product;
	}

	@Override
	public int update(ClientProduct transientObject) {
		return jdbcTemplate.update(
				CLIENT_PRODUCT_UPDATE_SQL_BY_KEY,
				new Object [] {
						transientObject.getDesignerClientId(),
						transientObject.getProductStatus().getValue(),
						new Timestamp( System.currentTimeMillis() ),
						transientObject.getClientProductId(),
				}
			);
	}

	@Override
	public int delete(ClientProduct persistentObject) {
		return jdbcTemplate.update(
			CLIENT_PRODUCT_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getClientProductId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CLIENT_PRODUCT_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}


}

