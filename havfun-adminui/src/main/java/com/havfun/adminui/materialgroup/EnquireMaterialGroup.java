package com.havfun.adminui.materialgroup;

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

import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class EnquireMaterialGroup
 */
@WebServlet("/" + MaterialGroupHelper.ENQUIRE_MATERIAL_GROUP)
public class EnquireMaterialGroup extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(EnquireMaterialGroup.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquireMaterialGroup() {
        super();
    }

	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String materialGroupIdStr = request.getParameter("materialGroupId");
		
		int materialGroupId = -1;
		
		try{
			
			materialGroupId = Integer.parseInt( materialGroupIdStr );
			
		}catch( Exception e){
			
			LOGGER.warn("Exception ", e);
			
		}
		
		materialGroupHelper.prepareMaterialGroup(request, MaterialGroupHelper.SERVLET_TYPE_ENQUIRE);
		
		AdminEnquireMaterialGroupRequest enquireRequest = new AdminEnquireMaterialGroupRequest();
		
		BaseUser baseUser = (BaseUser)request.getAttribute(LOGON_USER);
		
		enquireRequest.setLoginUserId( baseUser.getId());
		enquireRequest.setToken( baseUser.getToken());
		enquireRequest.setMaterialGroupId( materialGroupId );
		
		LOGGER.info("EnquireMaterialGroup:: process:: enquireRequest " + enquireRequest);
		AdminEnquireMaterialGroupResponse enquireResponse = ClientServiceHelper.getInstance().getClientService().invoke(enquireRequest);
		LOGGER.info("EnquireMaterialGroup:: process:: enquireResponse " + enquireResponse);
		
		int result = -1;
		
		if (enquireResponse != null) {
			result = enquireResponse.getResult();
		}
		
		if (result == 0) {
			
			MaterialGroupMessage bosMaterialGroupMessage = enquireResponse.getMaterialGroupMessage();

			//materialGroupMessage = MaterialGroupHelper.getMaterialGroupInformationMessageFromSession(request, MaterialGroupHelper.ENQUIRE_MATERIAL_GROUP + "_" + materialGroupMessage.getMaterialGroupId());
			
			//if (materialGroupInformationMessage != null) {
				//request.setAttribute(MaterialGroupHelper.MATERIAL_GROUP, materialGroupInformationMessage);
			//} else {
				request.setAttribute(MaterialGroupHelper.DATA_IMAGE, bosMaterialGroupMessage);
				
				
				if ( bosMaterialGroupMessage != null && bosMaterialGroupMessage.getImage() != null ){
					
					StringBuilder sb = new StringBuilder();
					sb.append("data:image/");
					sb.append("png");
					sb.append(";base64,");
					sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(bosMaterialGroupMessage.getImage(), false)));
					
					request.setAttribute( "imagePreview" , sb.toString());
					
				}
			//}
		} else {
			//show error message...
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			return;
		}
		
		request.getRequestDispatcher(MaterialGroupHelper.MATERIAL_GROUP_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuMaterialGroup";
	}
}
