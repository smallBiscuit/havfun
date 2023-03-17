package com.havfun.adminui.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class CreateProduct
 */
@WebServlet("/" + ProductHelper.CREATE_PRODUCT)
public class CreateProduct extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProduct() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		productHelper.prepareProduct(request, ProductHelper.SERVLET_TYPE_CREATE);

		request.getRequestDispatcher(ProductHelper.PRODUCT_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuProduct";
	}

	@Override
	protected String getSubMenu() {
		return "CreateProduct";
	}

}