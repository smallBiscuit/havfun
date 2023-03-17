package com.havfun.adminui.productgroup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class CreateProductGroup
 */
@WebServlet("/" + ProductGroupHelper.CREATE_PRODUCT_GROUP) 
public class CreateProductGroup extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductGroup() {
        super();
    }
 
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		
		productGroupHelper.prepareProductGroup(request, ProductGroupHelper.SERVLET_TYPE_CREATE);
				
		request.getRequestDispatcher(ProductGroupHelper.PRODUCT_GROUP_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuProductGroup";
	}
	
	@Override
	protected String getSubMenu() {
		return "CreateProductGroup";
	}
	
}