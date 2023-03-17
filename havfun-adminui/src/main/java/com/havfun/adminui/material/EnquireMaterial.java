package com.havfun.adminui.material;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.servlet.AbstractServlet;
import com.havfun.service.message.admin.material.AdminEnquireMaterialRequest;
import com.havfun.service.message.admin.material.AdminEnquireMaterialResponse;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.service.message.data.MaterialMessage;

/**
 * Servlet implementation class EnquireMaterial
 */
@WebServlet("/" + MaterialHelper.ENQUIRE_MATERIAL)
public class EnquireMaterial extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(EnquireMaterial.class.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnquireMaterial() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String materialIdStr = request.getParameter("materialId");

		int materialId = -1;

		try {

			materialId = Integer.parseInt(materialIdStr);

		} catch (Exception e) {

			LOGGER.warn("Exception ", e);

		}
		
		parseMaterialGroupList( request );

		materialHelper.prepareMaterial(request, MaterialHelper.SERVLET_TYPE_ENQUIRE);

		AdminEnquireMaterialRequest enquireRequest = new AdminEnquireMaterialRequest();

		BaseUser baseUser = (BaseUser) request.getAttribute(LOGON_USER);

		enquireRequest.setLoginUserId(baseUser.getId());
		enquireRequest.setToken(baseUser.getToken());
		enquireRequest.setMaterialId(materialId);

		LOGGER.info("EnquireMaterial:: process:: enquireRequest " + enquireRequest);
		AdminEnquireMaterialResponse enquireResponse = ClientServiceHelper.getInstance().getClientService()
				.invoke(enquireRequest);
		LOGGER.info("EnquireMaterial:: process:: enquireResponse " + enquireResponse);

		int result = -1;

		if (enquireResponse != null) {
			result = enquireResponse.getResult();
		}

		if (result == 0) {

			MaterialMessage bosMaterialMessage = enquireResponse.getMaterialMessage();

			// materialMessage =
			// MaterialHelper.getMaterialInformationMessageFromSession(request,
			// MaterialHelper.ENQUIRE_MATERIAL + "_" +
			// materialMessage.getMaterialId());

			// if (materialInformationMessage != null) {
			// request.setAttribute(MaterialHelper.MATERIAL,
			// materialInformationMessage);
			// } else {
			request.setAttribute(MaterialHelper.DATA_IMAGE, bosMaterialMessage);
			// }
		} else {
			// show error message...
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			return;
		}

		request.getRequestDispatcher(MaterialHelper.MATERIAL_JSP).forward(request, response);
	}

	private void parseMaterialGroupList( HttpServletRequest request ){
	
		if ( dataHelper.getMaterialGroupList() != null ){
						
	
			List<String> materialGroupList = new ArrayList<String>();
			List<String> materialGroupLabelList = new ArrayList<String>();
			
			for ( MaterialGroupMessage message : dataHelper.getMaterialGroupList() ){
				
				materialGroupList.add( "" + message.getMaterialGroupId() );
				
				materialGroupLabelList.add( message.getNameEn() );
				
			}
			
			request.setAttribute("materialGroupList", materialGroupList );
			
			request.setAttribute("materialGroupLabelList", materialGroupLabelList );
			
		}
		
	}

	
	@Override
	protected String getMenu() {
		return "MenuMaterial";
	}
}
