package com.havfun.adminui.productgroup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.admin.productgroup.AdminEnquireProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminEnquireProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ProductGroupMessage;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class EnquireProductGroup
 */
@WebServlet("/" + ProductGroupHelper.ENQUIRE_PRODUCT_GROUP)
public class EnquireProductGroup extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(EnquireProductGroup.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquireProductGroup() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String productGroupIdStr = request.getParameter("productGroupId");
		
		int productGroupId = -1;
		
		try{
			
			productGroupId = Integer.parseInt( productGroupIdStr );
			
		}catch( Exception e){
			
			LOGGER.warn("Exception ", e);
			
		}
		
		productGroupHelper.prepareProductGroup(request, ProductGroupHelper.SERVLET_TYPE_ENQUIRE);
		
		AdminEnquireProductGroupRequest enquireRequest = new AdminEnquireProductGroupRequest();
		
		BaseUser baseUser = (BaseUser)request.getAttribute(LOGON_USER);
		
		enquireRequest.setLoginUserId( baseUser.getId());
		enquireRequest.setToken( baseUser.getToken());
		enquireRequest.setProductGroupId( productGroupId );
		
		LOGGER.info("EnquireProductGroup:: process:: enquireRequest " + enquireRequest);
		AdminEnquireProductGroupResponse enquireResponse = ClientServiceHelper.getInstance().getClientService().invoke(enquireRequest);
		LOGGER.info("EnquireProductGroup:: process:: enquireResponse " + enquireResponse);
		
		int result = -1;
		
		if (enquireResponse != null) {
			result = enquireResponse.getResult();
		}
		
		if (result == 0) {
			
			ProductGroupMessage bosProductGroupMessage = enquireResponse.getProductGroupMessage();

			//productGroupMessage = ProductGroupHelper.getProductGroupInformationMessageFromSession(request, ProductGroupHelper.ENQUIRE_PRODUCT_GROUP + "_" + productGroupMessage.getProductGroupId());
			
			//if (productGroupInformationMessage != null) {
				//request.setAttribute(ProductGroupHelper.PRODUCT_GROUP, productGroupInformationMessage);
			//} else {
				request.setAttribute(ProductGroupHelper.DATA_IMAGE, bosProductGroupMessage);
				
				
				if ( bosProductGroupMessage != null && bosProductGroupMessage.getImage() != null ){
					
					StringBuilder sb = new StringBuilder();
					sb.append("data:image/");
					sb.append("png");
					sb.append(";base64,");
					sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(bosProductGroupMessage.getImage(), false)));
					
					request.setAttribute( "imagePreview" , sb.toString());
					
				}
			//}
		} else {
			//show error message...
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			return;
		}
		
		request.getRequestDispatcher(ProductGroupHelper.PRODUCT_GROUP_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuProductGroup";
	}
}
