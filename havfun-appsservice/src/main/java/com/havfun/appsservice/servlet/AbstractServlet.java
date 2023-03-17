package com.havfun.appsservice.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.gson.Gson;
import com.havfun.appsservice.helper.AuthHelper;
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.data.Client;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.helper.DataHelper;
import com.havfun.appsservice.message.AbstractResponse;
import com.havfun.service.HavfunService;
import com.havfun.service.config.HavfunServiceConfig;
import com.havfun.service.message.constant.ErrorCode;

public class AbstractServlet extends HttpServlet {
private static final Logger LOGGER = LogManager.getLogger( AbstractServlet.class.getName() );
	
	private static final long serialVersionUID = 1L;
	
	private static Object lock = new Object();
	
	protected static ApplicationContext context;
		
	protected static HavfunService service;
	
	protected AuthHelper authHelper;
	
	protected static DataHelper dataHelper;
	
	protected static final String LOGON_CLIENT = "logonClient";	
		
	
	public static final String SYSTEM_DOMAIN_URL = "http://52.192.251.209:8080//havfun-appsservice/";
//	public static final String SYSTEM_DOMAIN_URL = "http://localhost:8080/havfun-appsservice/";
	
	protected static ConcurrentHashMap<String, BaseClient> tokenToClientMap = new ConcurrentHashMap<String, BaseClient>();
	
	protected static ConcurrentHashMap<Integer, String> clientIdToTokenMap = new ConcurrentHashMap<Integer, String>();
	
	protected static Map<String, List<CartProduct>> cartItemsMap;
	
	public AbstractServlet(){
		
		super();
		
		synchronized(lock) {
			
        	if (context == null) {
        		
        		context = new ClassPathXmlApplicationContext("applicationContext.xml");
        		
        		ApplicationContext appContext = new AnnotationConfigApplicationContext(HavfunServiceConfig.class);
        		service = (HavfunService)appContext.getBean(HavfunService.class);        		        		 	
        		
        		ClientServiceHelper clientServiceHelper = new ClientServiceHelper();
        		ClientServiceHelper.setSingleton(clientServiceHelper);
        		ClientServiceHelper.getInstance().setClientService(service);
        		
        		FileInputStream serviceAccount;
				try {
					
	        		serviceAccount =
	        				  new FileInputStream("/havfun/resource/serviceAccountKey.json");

	        				FirebaseOptions options = new FirebaseOptions.Builder()
	        				  .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
	        				  .setDatabaseUrl("https://ios-test-fe09b.firebaseio.com/")
	        				  .build();
						        		
	        		FirebaseApp.initializeApp(options);
	              		
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LOGGER.info("AbstractServlet FileNotFoundException ", e );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LOGGER.info("AbstractServlet IOException ", e );
				}

        	
        		cartItemsMap = new HashMap<String, List<CartProduct>>();

        		dataHelper = new DataHelper();
                
                dataHelper.loadAllData( service );
                
                LOGGER.info("AbstractServlet dataHelper: " + dataHelper);
        	}
        }
        
        authHelper = (AuthHelper)context.getBean("AuthHelper");
		
        
        LOGGER.info("rayTest AbstractServlet init 3 " );
		LOGGER.info("AbstractServlet init");
		

		
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("appsservice-config-dev.xml");
		
	}
	
    @Override
	public void init(ServletConfig config) throws ServletException {

    	super.init(config);

    	authHelper.init(config.getServletContext());
    	
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
				LOGGER.info("AbstractServlet doPost 1" );
				process( request, response);        		
				
			} catch ( AppsserviceException e){
				
				LOGGER.info("AbstractServlet doPost AppsserviceException ", e );
				
				AbstractResponse abstractResponse = new AbstractResponse();
				abstractResponse.setResult( e.getErrorCode() );
				abstractResponse.setReason( "servlet exception " + e );
				Gson gson = new Gson();
				String json = gson.toJson( abstractResponse );
				response.getWriter().write( json );
				
			} catch ( IOException e ){
				
				LOGGER.info("AbstractServlet doPost IOException ", e );
				
				AbstractResponse abstractResponse = new AbstractResponse();
				abstractResponse.setResult( -999 );
				abstractResponse.setReason( "servlet exception" );
				Gson gson = new Gson();
				String json = gson.toJson( abstractResponse );
				response.getWriter().write( json );
			}
		}
	}
	
	protected boolean preprocess( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		LOGGER.info("AbstractServlet preprocess");
		
		if ( !isAuthenticationRequired() ){
			
			return true;
			
		}
		
		int result = authHelper.doAuth(request, response);
		
		if ( result == ErrorCode.NO_ERROR ){
			
			return true;
			
		}else if ( result < 0 ){
			
			AbstractResponse abstractResponse = new AbstractResponse();
			abstractResponse.setResult( -2 );
			abstractResponse.setReason( "unauth" );
			Gson gson = new Gson();
			String json = gson.toJson( abstractResponse );
			response.getWriter().write( json );
			
		}
		
		return false;
		
	}
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		LOGGER.info("AbstractServlet process");
	}

	protected boolean isAuthenticationRequired(){
		return false;
	}
	
}
