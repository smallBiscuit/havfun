package com.havfun.adminui.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.client.AdminEnquireClientRequest;
import com.havfun.service.message.admin.client.AdminEnquireClientResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class EnquireClient
 */
@WebServlet("/" + ClientHelper.ENQUIRE_CLIENT)
public class EnquireClient extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(EnquireClient.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquireClient() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String clientIdStr = request.getParameter("clientId");
		
		int clientId = -1;
		
		try{
			
			clientId = Integer.parseInt( clientIdStr );
			
		}catch( Exception e){
			
			LOGGER.warn("Exception ", e);
			
		}
		
		clientHelper.prepareClient(request, ClientHelper.SERVLET_TYPE_ENQUIRE);
		
		AdminEnquireClientRequest enquireRequest = new AdminEnquireClientRequest();
		
		BaseUser baseUser = (BaseUser)request.getAttribute(LOGON_USER);
		
		enquireRequest.setLoginUserId( baseUser.getId());
		enquireRequest.setToken( baseUser.getToken());
		enquireRequest.setClientId( clientId );
		
		LOGGER.info("EnquireClient:: process:: enquireRequest " + enquireRequest);
		AdminEnquireClientResponse enquireResponse = ClientServiceHelper.getInstance().getClientService().invoke(enquireRequest);
		LOGGER.info("EnquireClient:: process:: enquireResponse " + enquireResponse);
		
		int result = -1;
		
		if (enquireResponse != null) {
			result = enquireResponse.getResult();
		}
		
		if (result == 0) {
			
			ClientMessage bosClientMessage = enquireResponse.getClientMessage();

			//clientMessage = ClientHelper.getClientInformationMessageFromSession(request, ClientHelper.ENQUIRE_CLIENT + "_" + clientMessage.getClientId());
			
			//if (clientInformationMessage != null) {
				//request.setAttribute(ClientHelper.CLIENT, clientInformationMessage);
			//} else {
				request.setAttribute(ClientHelper.DATA_IMAGE, bosClientMessage);
			//}
		} else {
			//show error message...
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			return;
		}
		
		request.getRequestDispatcher(ClientHelper.CLIENT_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuClient";
	}
}
