package com.havfun.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.havfun.entity.Notification;
import com.havfun.servlet.LoggerManager;

public class NotificationDaoImpl implements NotificationDao{
	private static final Logger LOGGER = LoggerManager.getLogger( NotificationDaoImpl.class.getName() );
	
//	private static String NOTIFICATION_INSERT_SQL = "insert into notification ( user_id, name, platform, token) values ( ?, ?, ?, ?);";
	
	private static String NOTIFICATION_SELECT_SQL_BY_KEY = "select * from notification where notification_id = ?";
	
	private static String NOTIFICATION_UPDATE_SQL_BY_KEY = "update notification set user_id = ?, type = ?, message = ? where notification_id = ?";
	
	private static String NOTIFICATION_DELETE_SQL_BY_KEY = "delete from notification where notification_id = ?";
	
	private DataSource dataSource;	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected NotificationRowMapper rowMapper;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public Integer create(Notification newInstance) {
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("notification").usingGeneratedKeyColumns("notification_id");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", newInstance.getUserId() );
		parameters.put("type", newInstance.getType() );
		parameters.put("message", newInstance.getMessage() );
		
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if ( key != null ){			
			return key.intValue();			
		}
		return 0;

	}

	@Override
	public Notification read(Integer id) {
		
		Notification notification = null;
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		try{			
			notification = jdbcTemplate.queryForObject(
					NOTIFICATION_SELECT_SQL_BY_KEY, 
					new NotificationRowMapper(), 
					new Object[]{
							id					
			});			
		}catch( IncorrectResultSizeDataAccessException e ){			
			return null;			
		}
		return notification;		
	}
	
	@Override
	public int update(Notification persistentObject) {
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		return jdbcTemplate.update(
				NOTIFICATION_UPDATE_SQL_BY_KEY,
				new Object[]{
						persistentObject.getUserId(),
						persistentObject.getType(),
						persistentObject.getMessage(),
						persistentObject.getNotificationId()
				});
	}

	@Override
	public int deleteByKey(Integer id) {
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		return jdbcTemplate.update(
				NOTIFICATION_DELETE_SQL_BY_KEY,
				new Object[]{
					id
				});
	}


}