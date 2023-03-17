package com.havfun.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.havfun.dao.DeviceDao;
import com.havfun.dao.NotificationDao;
import com.havfun.service.message.AbstractResponse;

public class AbstractServlet extends HttpServlet {
private static final Logger LOGGER = LoggerManager.getLogger( AbstractServlet.class.getName() );
	
	private static final long serialVersionUID = 1L;
	
	protected static DeviceDao deviceDao;
	
	protected static NotificationDao notificationDao;
	
	private static Object lock = new Object();
	
	protected static ApplicationContext context;

	
	AbstractServlet(){
		
		super();
		
		synchronized( lock ){
			
			if ( context == null ){
				
//				ApplicationContext appContext = new AnnotationConfigApplicationContext( ServiceConfig.class);
				
			}
			
		}
		
		LOGGER.info("AbstractServlet init");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

		deviceDao = (DeviceDao) context.getBean("deviceDao");
		
		notificationDao = (NotificationDao) context.getBean( "notificationDao" ); 
		
	}
		
	@Override    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("AbstractServlet doGet");
		process( request, response);        		
		
	}
	
	@Override    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("AbstractServlet doPost request: " + request);
		
		long time = System.currentTimeMillis();
		boolean result = preprocess( request, response );
		
		if ( result ){
			
			try{
				
				process( request, response);        		
				
			} catch ( AppsserviceException e){
				
				AbstractResponse abstractResponse = new AbstractResponse();
				abstractResponse.setResult( e.getErrorCode() );
				abstractResponse.setReason( "servlet exception " + e );
				Gson gson = new Gson();
				String json = gson.toJson( abstractResponse );
				response.getWriter().write( json );
				
			} catch ( IOException e ){
				AbstractResponse abstractResponse = new AbstractResponse();
				abstractResponse.setResult( -999 );
				abstractResponse.setReason( "servlet exception" );
				Gson gson = new Gson();
				String json = gson.toJson( abstractResponse );
				response.getWriter().write( json );
			}
		}
	}
	
	protected boolean preprocess( HttpServletRequest request, HttpServletResponse response ) {
		
		LOGGER.info("AbstractServlet preprocess");
		return true;
	}
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		LOGGER.info("AbstractServlet process");
	}

	
}
