package com.havfun.adminui.client;


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

import com.havfun.service.message.admin.client.AdminUpdateClientRequest;
import com.havfun.service.message.admin.client.AdminUpdateClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.service.utils.LabelUtil;
import com.google.gson.Gson;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.helper.LocalizationHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class UpdateClientRequest
 */
@WebServlet("/" + ClientHelper.UPDATE_CLIENT_REQUEST)
public class UpdateClientRequest extends AbstractServlet {
	
	private static final Logger LOGGER = LogManager.getLogger(UpdateClientRequest.class.getName());
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientRequest() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int result = ErrorCode.NO_ERROR;
		
		ClientMessage clientMessage = clientHelper.getClientMessage(request);		
		
		AdminUpdateClientRequest updateRequest = new AdminUpdateClientRequest();
		
		BaseUser baseUser = (BaseUser)request.getAttribute(LOGON_USER);
		
		updateRequest.setLoginUserId(baseUser.getId());
		updateRequest.setToken(baseUser.getToken());
		updateRequest.setClientMessage( clientMessage );
		
		AdminUpdateClientResponse updateResponse = ClientServiceHelper.getInstance().getClientService().invoke(updateRequest);
		
		if (updateResponse != null) {
			result = updateResponse.getResult();
		}else{
			result = -999;
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String lang = (String) request.getAttribute("SelectedLang");
		ResourceBundle labels = LocalizationHelper.getResourceBundle("Result", lang);
		
		if ( updateResponse == null) {

			resultMap.put("resultCode", ErrorCode.INTERNAL_ERROR);
			resultMap.put("resultMessage", LabelUtil.getDisplayValueFromResourceBundle(labels , "error_result.-999") );
			
		} else {			
			
			resultMap.put("resultCode", updateResponse.getResult());
			resultMap.put("resultMessage", LabelUtil.getDisplayValueFromResourceBundle(labels , "error_result." + updateResponse.getResult() ) );
			resultMap.put("redirectUrl", "#" );
			
		}
		response.setCharacterEncoding("UTF-8");
		String resultJSON = new Gson().toJson(resultMap);
		response.getWriter().write(resultJSON);
        
	}

}