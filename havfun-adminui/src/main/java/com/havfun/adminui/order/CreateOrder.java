package com.havfun.adminui.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.havfun.adminui.servlet.AbstractServlet;

/**
 * Servlet implementation class CreateOrder
 */
@WebServlet("/" + OrderHelper.CREATE_ORDER)
public class CreateOrder extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateOrder() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		orderHelper.prepareOrder(request, OrderHelper.SERVLET_TYPE_CREATE);

		request.getRequestDispatcher(OrderHelper.ORDER_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuOrder";
	}

	@Override
	protected String getSubMenu() {
		return "CreateOrder";
	}

}