package com.havfun.adminui.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.havfun.adminui.helper.LocalizationHelper;
import com.havfun.adminui.servlet.AbstractServlet;
import com.havfun.adminui.webcomponent.CustomizeProductBaseViewForm;
import com.havfun.adminui.webcomponent.CustomizeProductBaseViewList;
import com.havfun.adminui.webcomponent.WebComponent;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.CustomizeProductBaseViewMessage;

/**
 * Servlet implementation class EnquireCustomizeProductBaseViewRequest
 */
@WebServlet("/EnquireCustomizeProductBaseViewRequest")
public class EnquireCustomizeProductBaseViewRequest extends AbstractServlet {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomizeProductBaseViewList.class.getName());
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnquireCustomizeProductBaseViewRequest() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String indexStr = request.getParameter( "index" );
		
		int index = -1;
		
		try{

			index = Integer.parseInt( indexStr );
	
		}catch( Exception e){
			
			LOGGER.warn( "Exception ", e );
			
		}
			
		ResourceBundle resourceBundle = LocalizationHelper.getResourceBundle( "en" );
		
		CustomizeProductBaseViewMessage viewMessage = new CustomizeProductBaseViewMessage();
		
		String htmlCode = CustomizeProductBaseViewForm.renderHtml( index, viewMessage, resourceBundle, WebComponent.MODE_EDITABLE );

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("result", ErrorCode.NO_ERROR );
		
		resultMap.put("htmlCode", htmlCode );
		
		
        String json = new Gson().toJson(resultMap);
        LOGGER.info("AddCustomizeProductBaseViewRequest: process(): json:"+ json);  
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json); 
	}

}