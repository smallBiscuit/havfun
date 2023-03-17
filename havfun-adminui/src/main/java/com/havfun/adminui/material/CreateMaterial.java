package com.havfun.adminui.material;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class CreateMaterial
 */
@WebServlet("/" + MaterialHelper.CREATE_MATERIAL)
public class CreateMaterial extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateMaterial() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		materialHelper.prepareMaterial(request, MaterialHelper.SERVLET_TYPE_CREATE);

		request.getRequestDispatcher(MaterialHelper.MATERIAL_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuMaterial";
	}

	@Override
	protected String getSubMenu() {
		return "CreateMaterial";
	}

}