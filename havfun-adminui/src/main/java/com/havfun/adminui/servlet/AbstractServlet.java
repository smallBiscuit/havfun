package com.havfun.adminui.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.havfun.adminui.client.ClientHelperImpl;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.data.Parameter;
import com.havfun.adminui.helper.AuthHelper;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.helper.CookieHelper;
import com.havfun.adminui.helper.DataHelper;
import com.havfun.adminui.helper.UserGroupHelper;
import com.havfun.adminui.materialgroup.MaterialGroupHelperImpl;
import com.havfun.adminui.menu.MenuHelper;
import com.havfun.adminui.order.OrderHelperImpl;
import com.havfun.adminui.product.ProductHelperImpl;
import com.havfun.adminui.productgroup.ProductGroupHelperImpl;
import com.havfun.adminui.material.MaterialHelperImpl;
import com.havfun.adminui.materialgroup.MaterialGroupHelperImpl;
import com.havfun.adminui.user.UserHelperImpl;
import com.havfun.service.HavfunService;
import com.havfun.service.config.HavfunServiceConfig;


public abstract class AbstractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(AbstractServlet.class.getName());
	
	public static final String LOGON_USER = "logonUser";
//	public static BosClientService bosClientService;
	
	//in seconds...
	private static final int TEN_YEAR = 60 * 60 * 24 * 365 * 10;
	
	protected static final String PARAMETER_NAME_LANG = "lang";
	protected static final String PARAMETER_NAME_USERNAME = "username";
	protected static final String PARAMETER_NAME_PASSWORD = "password";
	protected static final String PARAMETER_NAME_REF = "ref";
	
	private static final String LANG_EN = "en";
	private static final String LANG_ZH_CN = "zh_CN";
	private static final String LANG_ZH_HK = "zh_HK";
	
	private static String defaultLang = LANG_ZH_HK;
	private static Map<String, String> langMap = new HashMap<String, String>();
	
	protected static String SYSTEM_DOMAIN_URL = "http://54.64.110.130:8080/havfun-adminui/";	
//	protected static String SYSTEM_DOMAIN_URL = "http://localhost:8080/havfun-adminui/";
	
	static {
		langMap.put(LANG_EN, LANG_EN);
		langMap.put(LANG_ZH_CN, LANG_ZH_CN);
		langMap.put(LANG_ZH_HK, LANG_ZH_HK);
	}
	
	private static Object lock = new Object();
	
	protected static ApplicationContext context;
		
	protected static HavfunService service;
	
	protected AuthHelper authHelper;
	
	protected MenuHelper menuHelper;
	
	protected static DataHelper dataHelper;
	
	protected UserHelperImpl userHelper;
	
	protected ClientHelperImpl clientHelper;
	
	protected ProductGroupHelperImpl productGroupHelper;
	
	protected ProductHelperImpl productHelper;
	
	protected MaterialGroupHelperImpl materialGroupHelper;
	
	protected MaterialHelperImpl materialHelper;
	
	protected OrderHelperImpl orderHelper;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AbstractServlet() {
        super();
        
        synchronized(lock) {
        	if (context == null) {
        		
        		context = new ClassPathXmlApplicationContext("applicationContext.xml");
        		
        		ApplicationContext appContext = new AnnotationConfigApplicationContext(HavfunServiceConfig.class);
        		service = (HavfunService)appContext.getBean(HavfunService.class);        		        		 	
        		
        		ClientServiceHelper clientServiceHelper = new ClientServiceHelper();
        		ClientServiceHelper.setSingleton(clientServiceHelper);
        		ClientServiceHelper.getInstance().setClientService(service);
        		
        		dataHelper = new DataHelper();
                
                dataHelper.loadAllData( service );
                
                LOGGER.info("AbstractServlet dataHelper: " + dataHelper.getProductGroupList() );
                LOGGER.info("AbstractServlet dataHelper: " + dataHelper.getMaterialGroupList() );
        	}
        }
        
        authHelper = (AuthHelper)context.getBean("AuthHelper");
        
        menuHelper = (MenuHelper)context.getBean("MenuHelper");
        
        userHelper = new UserHelperImpl();
        
        clientHelper = new ClientHelperImpl();
        
        productGroupHelper = new ProductGroupHelperImpl();
        
        productHelper = new ProductHelperImpl();
        
        materialGroupHelper = new MaterialGroupHelperImpl();
        
        materialHelper = new MaterialHelperImpl();
        
        orderHelper = new OrderHelperImpl();
        
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		authHelper.init(config.getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long time = System.currentTimeMillis();
		boolean result = preprocess(request, response);
		
		//if result is false, redirect to another page like Login or Error.  Skip any further process...
		if (result) {
			LOGGER.info(this.getServletName() + ": " + (System.currentTimeMillis() - time) + "ms");
			process(request, response);
			LOGGER.info(this.getServletName() + ": " + (System.currentTimeMillis() - time) + "ms");
			postprocess(request, response);
		}
		LOGGER.info(this.getServletName() + ": " + (System.currentTimeMillis() - time) + "ms");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long time = System.currentTimeMillis();
		boolean result = preprocess(request, response);
		
		//if result is false, it redirect to another page like Login or Error.  Skip any further process...
		if (result) {
			LOGGER.info(this.getServletName() + ": " + (System.currentTimeMillis() - time) + "ms");
			process(request, response);
			LOGGER.info(this.getServletName() + ": " + (System.currentTimeMillis() - time) + "ms");
			postprocess(request, response);
		}
		LOGGER.info(this.getServletName() + ": " + (System.currentTimeMillis() - time) + "ms");
	}
	
	protected String getQueryStringWithoutLang(HttpServletRequest request) {
		String query = "";
		
		Enumeration<String> paramNames = request.getParameterNames();
		
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			if (!PARAMETER_NAME_LANG.equals(paramName)) {
				if (query.length() > 0) {
					query += "&";
				}
				query += paramName + "=" + request.getParameter(paramName);
			}
		}
		
		return query;
	}
	
	protected String getQueryStringWithoutUsernamePasswordRef(HttpServletRequest request) {
		String query = "";
		
		Enumeration<String> paramNames = request.getParameterNames();
		
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			if (!PARAMETER_NAME_USERNAME.equals(paramName) && !PARAMETER_NAME_PASSWORD.equals(paramName) && !PARAMETER_NAME_REF.equals(paramName)) {
				if (query.length() > 0) {
					query += "&";
				}
				query += paramName + "=" + request.getParameter(paramName);
			}
		}
		
		return query;
	}
	
	protected String getQueryString(HttpServletRequest request) {
		String query = "";
		
		Enumeration<String> paramNames = request.getParameterNames();
		
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			
			if (query.length() > 0) {
				query += "&";
			}
			query += paramName + "=" + request.getParameter(paramName);
		}
		
		return query;
	}
	
	protected List<Parameter> getQueryStringAsParameterList(HttpServletRequest request) {
		List<Parameter> parameterList = new ArrayList<Parameter>();
		
		Enumeration<String> paramNames = request.getParameterNames();
		
		while (paramNames.hasMoreElements()) {
			
			String paramName = paramNames.nextElement();
			String value = request.getParameter(paramName);
			
			parameterList.add(new Parameter(paramName, value));
		}
		
		return parameterList;
	}
	
	protected String getQueryStringWithLang(String query, String lang) {
		String newQueryString = "";
		
		if (query.length() == 0) {
			newQueryString = PARAMETER_NAME_LANG + "=" + lang;
		} else {
			newQueryString = query + "&" + PARAMETER_NAME_LANG + "=" + lang;
		}
		
		return newQueryString;
	}
	
	protected boolean preprocess(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//set no cache, force client (browser) to reload the page when clicking back button...
		//response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		//response.setHeader("Pragma", "no-cache");
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";		
		request.setAttribute("baseURL", baseURL );
		
		//need to check whether user has the right to access that servlet from action map
		//if no right, redirect to no authorization...
		String servletPage = url;
		if (url.lastIndexOf("/") >= 0) {
			servletPage = url.substring(url.lastIndexOf("/") + 1);
		}
		
		if (!servletPage.startsWith("Search"))  {
			response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
			response.setHeader("Pragma", "no-cache");
		}
		
		
		if ( isMainPage() ) {
			//lang related...
			String selectedLang = CookieHelper.getCookieValue((HttpServletRequest)request, PARAMETER_NAME_LANG);
			
			String parameterLang = request.getParameter(PARAMETER_NAME_LANG);
			
			selectedLang = langMap.get(selectedLang); 
			//may be we store the lang setting in cookie...
			
			if (selectedLang == null) { 
				selectedLang = defaultLang;
			}
			
			if (parameterLang != null) {
				selectedLang = parameterLang;
				CookieHelper.addCookie((HttpServletResponse)response, PARAMETER_NAME_LANG, selectedLang, TEN_YEAR);
				
				//we may need to store the selected lang to db...
			}
			
			request.setAttribute("SelectedLang", selectedLang);
			
			String queryStringWithoutLang = getQueryStringWithoutLang(request);
			
			request.setAttribute("URL_EN", url + "?" + getQueryStringWithLang(queryStringWithoutLang, LANG_EN));
			request.setAttribute("URL_ZH_CN", url + "?" + getQueryStringWithLang(queryStringWithoutLang, LANG_ZH_CN));
			request.setAttribute("URL_ZH_HK", url + "?" + getQueryStringWithLang(queryStringWithoutLang, LANG_ZH_HK));
		}
		
		//check whether the client has login, skip the checking for Login and LoginRequest servlet...
		if (!isAuthenticationRequired()) {
			request.setAttribute("Login", false);
		} else {
			int result = authHelper.doAuth((HttpServletRequest)request, (HttpServletResponse)response);
			
			if (result < 0) {
				String queryString = getQueryString(request);
				if (queryString != null && queryString.length() > 0) {
					response.sendRedirect("Login?ref=" + servletPage + "&" + queryString);
				} else {
					response.sendRedirect("Login?ref=" + servletPage);
				}
				return false;
			}
		}

		//if the client logged in, fill in the action map and notification list...
		boolean login = (Boolean)request.getAttribute("Login");
		
		LOGGER.info("login: " + login);
		
		if (login) {
			//get the user from attribute and set the user name and authorization....
			
			//build menu.. if the client do not have the right to see the menu, do not set the menu to attribute...
			BaseUser user = (BaseUser)request.getAttribute(LOGON_USER); 
			
			LOGGER.info("user: " + user);
			
			BaseUser user2 = (BaseUser)request.getAttribute("user");
			
			LOGGER.info("user2: " + user2);
			
			if (user != null) {
				
				Map<String, Boolean> actionMap = new HashMap<String, Boolean>();
				actionMap = UserGroupHelper.getPermissionMapByRole(user.getUserGroup() );
				LOGGER.info("AbstractServlet actionMap "+ actionMap);	
				LOGGER.info("AbstractServlet servletPage "+ servletPage);	
				LOGGER.info("AbstractServlet actionMap.get(servletPage) "+ actionMap.get(servletPage));	
				request.setAttribute("ActionMap", actionMap);

				/*
				if (false){//actionMap.get(servletPage) == null) {
					//no right to access this servlet
					String errMsg = "User does not have the right to access this servlet " + servletPage;
					LOGGER.info(errMsg);					
					if (isAuthorizationRequired()) {
						
						response.sendRedirect("Error?ErrMsg=" + URLEncoder.encode(errMsg, "UTF-8"));
						return false;
					}
				}
				*/
				
				if (isMainPage()) {
					request.setAttribute("UserName", user.getDisplayName());
					
					//Generating menu
					request.setAttribute("Menu", menuHelper.generateMenu(actionMap));
					LOGGER.info("Menu: " + menuHelper.generateMenu(actionMap));
					
					request.setAttribute("SelectedMenu", getMenu());
					request.setAttribute("SelectedSubMenu", getSubMenu());
				}
			}			
		}
		
		request.setAttribute("Now", new Date());
		
		return true;
	}
	
	protected abstract void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	protected void postprocess(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	protected boolean isAuthenticationRequired() {
		return true;
	}
	
	protected boolean isAuthorizationRequired() {
		return true;
	}
	
	protected String getMenu() {
		return "";
	}
	
	protected String getSubMenu() {
		return "";
	}
	
	protected boolean isMainPage() {
		return true;
	}
}
