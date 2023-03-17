package com.havfun.adminui.materialgroup;

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

import com.havfun.adminui.servlet.AbstractServlet;
import com.havfun.service.filter.ProcessEnquireSystemDataCommand;
import com.havfun.service.message.data.MaterialGroupMessage;

/**
 * Servlet implementation class CreateMaterialGroup
 */
@WebServlet("/" + MaterialGroupHelper.CREATE_MATERIAL_GROUP) 
public class CreateMaterialGroup extends AbstractServlet {

	private static final Logger LOGGER = LogManager.getLogger(CreateMaterialGroup.class.getSimpleName());
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMaterialGroup() {
        super();
    }
 
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		
		materialGroupHelper.prepareMaterialGroup(request, MaterialGroupHelper.SERVLET_TYPE_CREATE);
		
		request.setAttribute("materialGroupValueList", dataHelper.getMaterialGroupValueList() );
		
		request.setAttribute("materialGroupLabelList", dataHelper.getMaterialGroupLabelList() );
		
		request.getRequestDispatcher(MaterialGroupHelper.MATERIAL_GROUP_JSP).forward(request, response);
		
	}

	@Override
	protected String getMenu() {
		return "MenuMaterialGroup";
	}
	
	@Override
	protected String getSubMenu() {
		return "CreateMaterialGroup";
	}
	
	
	
}