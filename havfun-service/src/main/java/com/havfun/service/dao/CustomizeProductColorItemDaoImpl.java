package com.havfun.service.dao;
import java.util.ArrayList;
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
import com.havfun.service.dao.CustomizeProductColorItemDao;
import com.havfun.service.dao.CustomizeProductColorItemDaoImpl;
import com.havfun.service.entity.CustomizeProductColorItem;

public class CustomizeProductColorItemDaoImpl implements CustomizeProductColorItemDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CustomizeProductColorItemDaoImpl.class);

	private final static String CUSTOMIZE_PRODUCT_COLOR_ITEM_UPDATE_SQL_BY_KEY = "update customizeProductColorItem set  base_id = ?, file_type = ?, image_url = ?, parent_image = ? where color_id = ?";

	private final static String CUSTOMIZE_PRODUCT_COLOR_ITEM_SELECT_SQL_BY_KEY = "select * from customize_product_color_item where color_id = ?";

	private final static String CUSTOMIZE_PRODUCT_COLOR_ITEM_DELETE_SQL_BY_KEY = "delete from customize_product_color_item where color_id = ?";

//	private final static String CUSTOMIZE_PRODUCT_COLOR_ITEM_SELECT_ALL_SQL = "select * from customize_product_color_item";

//	private final static String CUSTOMIZE_PRODUCT_COLOR_ITEM_SELECT_SQL_BY_COLOR_ID = "select * from customize_product_color_item where user_name = ?";

	private final static String CUSTOMIZE_PRODUCT_COLOR_ITEM_SELECT_SQL_BY_BASE_ID = "select * from customize_product_color_item where base_id = ? order by color_id";
	
	private final static String CUSTOMIZE_PRODUCT_COLOR_ITEM_REPLACE_SQL = "replace into customize_product_color_item ( color_id, base_id, file_type, image_url, parent_image ) values (?, ?, ?, ?, ?)";
	
	private final static String CUSTOMIZE_PRODUCT_COLOR_ITEM_DELETE_SQL_BY_NOT_IN_COLOR_ID = "delete from customize_product_color_item where color_id not in ";
	
	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<CustomizeProductColorItem> rowMapper;

	@Override
	public Integer create(CustomizeProductColorItem newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("customize_product_color_item").usingGeneratedKeyColumns("color_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("color_id", newInstance.getColorId());
		parameters.put("base_id", newInstance.getBaseId());
		parameters.put("file_type", newInstance.getFileType());
		parameters.put("image_url", newInstance.getImageUrl());
		parameters.put("parent_image", newInstance.getParentImage());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public CustomizeProductColorItem read(Integer id) {
		CustomizeProductColorItem customizeProductColorItem = null;
		try {
			customizeProductColorItem = jdbcTemplate.queryForObject(
			CUSTOMIZE_PRODUCT_COLOR_ITEM_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return customizeProductColorItem;
	}

	@Override
	public int update(CustomizeProductColorItem transientObject) {
		return jdbcTemplate.update(
				CUSTOMIZE_PRODUCT_COLOR_ITEM_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getBaseId(),
					transientObject.getFileType(),
					transientObject.getImageUrl(),
					transientObject.getParentImage(),
					transientObject.getColorId(),

				}
			);
	}

	@Override
	public int delete(CustomizeProductColorItem persistentObject) {
		return jdbcTemplate.update(
			CUSTOMIZE_PRODUCT_COLOR_ITEM_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getColorId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CUSTOMIZE_PRODUCT_COLOR_ITEM_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

	@Override
	public List<CustomizeProductColorItem> readByBaseId(int baseId) {
		return jdbcTemplate.query(
				CUSTOMIZE_PRODUCT_COLOR_ITEM_SELECT_SQL_BY_BASE_ID, 
				rowMapper, 
					new Object[]{
							baseId
						}
					);
	}

	@Override
	public int[] replaceByItems(List<CustomizeProductColorItem> objectList) {
		
		List<Object[]> objectsList = new ArrayList<Object[]>();
		
		for ( CustomizeProductColorItem item : objectList ){
			
				objectsList.add(
				new Object[]{
					item.getColorId(),
					item.getBaseId(),
					item.getFileType(),
					item.getImageUrl(),
					item.getParentImage()
				}
				);
		}
		
		return jdbcTemplate.batchUpdate(
				CUSTOMIZE_PRODUCT_COLOR_ITEM_REPLACE_SQL,
				objectsList
			);
		
	}

	@Override
	public void deleteByBaseIdWithNewItemList( int baseId, List<CustomizeProductColorItem> objectList) {

		String sql = CUSTOMIZE_PRODUCT_COLOR_ITEM_DELETE_SQL_BY_NOT_IN_COLOR_ID;		
		
		List<Object> parameterList = new ArrayList<Object>();
		
		boolean firstFlag = true;
		
		sql += "( ";
		
		for ( CustomizeProductColorItem item : objectList ){
			
			if ( item.getColorId() > 0 ){
				
				parameterList.add( item.getColorId() );
				
				if ( firstFlag ){
					
					firstFlag = false;
					sql += item.getColorId();
				}else{
					sql += ", " + item.getColorId();
				}
			}
		}
		
		sql += " )";
		
		LOGGER.info("rayTest: sql: " +  sql );
		
		LOGGER.info("rayTest: parameterList: " +  parameterList );
		
		jdbcTemplate.execute(
				CUSTOMIZE_PRODUCT_COLOR_ITEM_DELETE_SQL_BY_NOT_IN_COLOR_ID
			);
	}

}

