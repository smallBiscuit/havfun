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
import com.havfun.service.dao.ProductGroupDao;
import com.havfun.service.dao.ProductGroupDaoImpl;
import com.havfun.service.entity.ProductGroup;

public class ProductGroupDaoImpl implements ProductGroupDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ProductGroupDaoImpl.class);

	private final static String PRODUCT_GROUP_UPDATE_SQL_BY_KEY = "update productGroup set  name_en = ?, image = ?, parent_id = ?, status = ?, create_timestamp = ?, last_modified_timestamp = ? where product_group_id = ?";

	private final static String PRODUCT_GROUP_SELECT_SQL_BY_KEY = "select * from product_group where product_group_id = ?";

	private final static String PRODUCT_GROUP_DELETE_SQL_BY_KEY = "delete from product_group where product_group_id = ?";

	private final static String PRODUCT_GROUP_SELECT_ALL_SQL = "select * from product_group";

	private final static String PRODUCT_GROUP_SELECT_SQL_BY_PRODUCT_GROUP_ID = "select * from product_group where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ProductGroup> rowMapper;

	@Override
	public Integer create(ProductGroup newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("product_group").usingGeneratedKeyColumns("product_group_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("product_group_id", newInstance.getProductGroupId());
		parameters.put("name_en", newInstance.getNameEn());
		parameters.put("image", newInstance.getImage());
		parameters.put("parent_id", newInstance.getParentId());
		parameters.put("status", newInstance.getStatus()==null?null:newInstance.getStatus().getValue());
		parameters.put("create_timestamp", newInstance.getCreateTimestamp());
		parameters.put("last_modified_timestamp", newInstance.getLastModifiedTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ProductGroup read(Integer id) {
		ProductGroup productGroup = null;
		try {
			productGroup = jdbcTemplate.queryForObject(
			PRODUCT_GROUP_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return productGroup;
	}

	@Override
	public int update(ProductGroup transientObject) {
		return jdbcTemplate.update(
				PRODUCT_GROUP_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getNameEn(),
					transientObject.getImage(),
					transientObject.getParentId(),
					transientObject.getStatus().getValue(),
					transientObject.getCreateTimestamp(),
					transientObject.getLastModifiedTimestamp(),
					transientObject.getProductGroupId(),

				}
			);
	}

	@Override
	public int delete(ProductGroup persistentObject) {
		return jdbcTemplate.update(
			PRODUCT_GROUP_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getProductGroupId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				PRODUCT_GROUP_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

