package com.havfun.servlet;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.havfun.servlet.LoggerManager;
import com.havfun.servlet.MyListener;

@WebListener
public class MyListener implements ServletContextListener{
	private static final Logger LOGGER = LoggerManager.getLogger( MyListener.class.getName());	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		LOGGER.info("AbstractServlet contextDestroyed");
		
		LoggerManager.closeLogger();		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		LOGGER.info("AbstractServlet contextInitialized");
	} 

}

