package com.havfun.appsservice.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.appsservice.servlet.MyListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener{
	
	private static final Logger LOGGER = LogManager.getLogger( MyListener.class.getName());	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		LOGGER.info("AbstractServlet contextDestroyed");
		
//		LogManager.closeLogger();		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		LOGGER.info("AbstractServlet contextInitialized");
	} 

}

