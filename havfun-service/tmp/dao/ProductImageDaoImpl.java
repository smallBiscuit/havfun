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
import com.havfun.service.dao.ProductImageDao;
import com.havfun.service.dao.ProductImageDaoImpl;
import com.havfun.service.entity.ProductImage;

public class ProductImageDaoImpl implements ProductImageDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ProductImageDaoImpl.class);

	private final static String PRODUCT_IMAGE_UPDATE_SQL_BY_KEY = "update productImage set  product_id = ?, image = ?, sorting_order = ? where product_image_id = ?";

	private final static String PRODUCT_IMAGE_SELECT_SQL_BY_KEY = "select * from product_image where product_image_id = ?";

	private final static String PRODUCT_IMAGE_DELETE_SQL_BY_KEY = "delete from product_image where product_image_id = ?";

	private final static String PRODUCT_IMAGE_SELECT_ALL_SQL = "select * from product_image";

	private final static String PRODUCT_IMAGE_SELECT_SQL_BY_PRODUCT_IMAGE_ID = "select * from product_image where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ProductImage> rowMapper;

	@Override
	public Integer create(ProductImage newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("product_image").usingGeneratedKeyColumns("product_image_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("product_image_id", newInstance.getProductImageId());
		parameters.put("product_id", newInstance.getProductId());
		parameters.put("image", newInstance.getImage());
		parameters.put("sorting_order", newInstance.getSortingOrder());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ProductImage read(Integer id) {
		ProductImage productImage = null;
		try {
			productImage = jdbcTemplate.queryForObject(
			PRODUCT_IMAGE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return productImage;
	}

	@Override
	public int update(ProductImage transientObject) {
		return jdbcTemplate.update(
				PRODUCT_IMAGE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getProductId(),
					transientObject.getImage(),
					transientObject.getSortingOrder(),
					transientObject.getProductImageId(),

				}
			);
	}

	@Override
	public int delete(ProductImage persistentObject) {
		return jdbcTemplate.update(
			PRODUCT_IMAGE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getProductImageId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				PRODUCT_IMAGE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

