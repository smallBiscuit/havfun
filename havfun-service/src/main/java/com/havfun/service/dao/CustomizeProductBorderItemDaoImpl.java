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
import com.havfun.service.dao.CustomizeProductBorderItemDao;
import com.havfun.service.dao.CustomizeProductBorderItemDaoImpl;
import com.havfun.service.entity.CustomizeProductBorderItem;

public class CustomizeProductBorderItemDaoImpl implements CustomizeProductBorderItemDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CustomizeProductBorderItemDaoImpl.class);

	private final static String CUSTOMIZE_PRODUCT_BORDER_ITEM_UPDATE_SQL_BY_KEY = "update customizeProductBorderItem set view_id = ?, item_key = ?, item_type = ?, title = ?, default_option = ?, cost = ?, x = ?, y = ? width = ?, height = ? where border_id = ?";

	private final static String CUSTOMIZE_PRODUCT_BORDER_ITEM_SELECT_SQL_BY_KEY = "select * from customize_product_border_item where border_id = ?";

	private final static String CUSTOMIZE_PRODUCT_BORDER_ITEM_DELETE_SQL_BY_KEY = "delete from customize_product_border_item where border_id = ?";

//	private final static String CUSTOMIZE_PRODUCT_BORDER_ITEM_SELECT_ALL_SQL = "select * from customize_product_border_item";

//	private final static String CUSTOMIZE_PRODUCT_BORDER_ITEM_SELECT_SQL_BY_BORDER_ID = "select * from customize_product_border_item where user_name = ?";

	private final static String CUSTOMIZE_PRODUCT_BORDER_ITEM_SELECT_SQL_BY_VIEW_ID = "select * from customize_product_border_item where view_id = ? order by border_id";

	private final static String CUSTOMIZE_PRODUCT_BORDER_ITEM_REPLACE_SQL = "replace into customize_product_border_item ( border_id, view_id, item_key, item_type, title, default_option, cost, x, y, width, height ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	
	private final static String CUSTOMIZE_PRODUCT_BORDER_ITEM_DELETE_SQL_BY_NOT_IN_COLOR_ID = "delete from customize_product_border_item where view_id = ? and border_id not in ";
	
	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<CustomizeProductBorderItem> rowMapper;

	@Override
	public Integer create(CustomizeProductBorderItem newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("customize_product_border_item").usingGeneratedKeyColumns("border_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("border_id", newInstance.getBorderId());
		parameters.put("view_id", newInstance.getViewId());
		parameters.put("item_key", newInstance.getItemKey());
		parameters.put("item_type", newInstance.getItemType());
		parameters.put("title", newInstance.getTitle());
		parameters.put("default_option", newInstance.isDefaultOption()?"1":"0");
		parameters.put("cost", newInstance.getCost());
		parameters.put("x", newInstance.getX());
		parameters.put("t", newInstance.getY());		
		parameters.put("width", newInstance.getWidth());
		parameters.put("height", newInstance.getHeight());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public CustomizeProductBorderItem read(Integer id) {
		CustomizeProductBorderItem customizeProductBorderItem = null;
		try {
			customizeProductBorderItem = jdbcTemplate.queryForObject(
			CUSTOMIZE_PRODUCT_BORDER_ITEM_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return customizeProductBorderItem;
	}

	@Override
	public int update(CustomizeProductBorderItem transientObject) {
		return jdbcTemplate.update(
				CUSTOMIZE_PRODUCT_BORDER_ITEM_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getViewId(),
					transientObject.getItemKey(),
					transientObject.getItemType(),
					transientObject.getTitle(),
					transientObject.isDefaultOption()?"1":"0",
					transientObject.getCost(),
					transientObject.getX(),
					transientObject.getY(),					
					transientObject.getWidth(),
					transientObject.getHeight(),
					transientObject.getBorderId(),

				}
			);
	}

	@Override
	public int delete(CustomizeProductBorderItem persistentObject) {
		return jdbcTemplate.update(
			CUSTOMIZE_PRODUCT_BORDER_ITEM_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getBorderId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CUSTOMIZE_PRODUCT_BORDER_ITEM_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

	@Override
	public List<CustomizeProductBorderItem> readByViewId(int viewId) {
		return jdbcTemplate.query(
				CUSTOMIZE_PRODUCT_BORDER_ITEM_SELECT_SQL_BY_VIEW_ID, 
				rowMapper, 
					new Object[]{
							viewId
						}
					);
	}

	@Override
	public int[] replaceByItems(List<CustomizeProductBorderItem> objectList) {
		
		List<Object[]> objectsList = new ArrayList<Object[]>();
		
		for ( CustomizeProductBorderItem item : objectList ){
			
			objectsList.add(
					new Object[]{
					item.getBorderId(),
					item.getViewId(),
					item.getItemKey(),
					item.getItemType(),
					item.getTitle(),
					item.isDefaultOption(),
					item.getCost(),
					item.getX(),
					item.getY(),  											
					item.getWidth(),
					item.getHeight()  						
					}
			);

		}
		
		return jdbcTemplate.batchUpdate(
				CUSTOMIZE_PRODUCT_BORDER_ITEM_REPLACE_SQL,
				objectsList
			);
		
	}

	@Override
	public int deleteByViewIdWithNewItemList( int viewId, List<CustomizeProductBorderItem> objectList) {

		String sql = CUSTOMIZE_PRODUCT_BORDER_ITEM_DELETE_SQL_BY_NOT_IN_COLOR_ID;		
		
		List<Object> parameterList = new ArrayList<Object>();
		
		boolean firstFlag = true;
		
		parameterList.add( viewId );
		
		sql += "( ";
		
		for ( CustomizeProductBorderItem item : objectList ){
			
			if ( item.getBorderId() > 0 ){
				
				parameterList.add( item.getBorderId() );
				
				if ( firstFlag ){
					
					firstFlag = false;
					sql += "?";
				}else{
					sql += ", ?";
				}
			}
		}
		
		sql += " )";
		
		return jdbcTemplate.update(
				sql,
				parameterList.toArray()
			);
	}

}

