package com.havfun.adminui.material;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.data.BaseUser;
import com.havfun.adminui.helper.ClientServiceHelper;
import com.havfun.adminui.materialgroup.MaterialGroupHelperImpl;
import com.havfun.adminui.servlet.AbstractServlet;
import com.havfun.service.message.admin.material.AdminSearchMaterialRequest;
import com.havfun.service.message.admin.material.AdminSearchMaterialResponse;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.service.message.data.MaterialMessage;

/**
 * Servlet implementation class SearchMaterial
 */
@WebServlet("/SearchMaterial")
public class SearchMaterial extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(SearchMaterial.class.getName());
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchMaterial() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String materialGroupId = request.getParameter( "materialGroupId" );
		
		if ( materialGroupId != null ){
			
			request.setAttribute( "materialGroupId", materialGroupId );
			
		}
		
		request.setAttribute("materialGroupValueList", dataHelper.getMaterialGroupValueList() );
		
		request.setAttribute("materialGroupLabelList", dataHelper.getMaterialGroupLabelList() );

		request.getRequestDispatcher("/WEB-INF/searchMaterial.jsp").forward(request, response);

	}
	
	
}