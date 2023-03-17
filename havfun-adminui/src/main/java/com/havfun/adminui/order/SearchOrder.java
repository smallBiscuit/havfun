package com.havfun.adminui.order;

import java.io.IOException;
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
import com.havfun.service.message.admin.order.AdminSearchOrderRequest;
import com.havfun.service.message.admin.order.AdminSearchOrderResponse;

/**
 * Servlet implementation class SearchOrder
 */
@WebServlet("/SearchOrder")
public class SearchOrder extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(SearchOrder.class.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchOrder() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int result = 0;
		BaseUser baseUser = (BaseUser) request.getAttribute(LOGON_USER);

		AdminSearchOrderRequest searchRequest = new AdminSearchOrderRequest();
		searchRequest.setLoginUserId(baseUser.getId());
		searchRequest.setToken(baseUser.getToken());

		LOGGER.info("SearchOrder:: process:: searchRequest:: " + searchRequest);
		AdminSearchOrderResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke(searchRequest);
		LOGGER.info("SearchOrder:: process:: searchResponse:: " + searchResponse);

		if (searchResponse != null) {
			result = searchResponse.getResult();
			request.setAttribute("orderList", searchResponse.getOrderMessageList());

			request.setAttribute(OrderHelper.NAVIGATOR, "content_order_search_order");

		} else {
			result = -999;
			/*
			 * int result = searchResponse != null ? searchResponse.getResult()
			 * : ErrorCode.UNHANDLED_ERR; response.sendRedirect("Error?ErrMsg="
			 * + ErrorCode.getErrorCode(result));
			 */
			response.sendRedirect("Error?ErrMsg=Could not connect server");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/searchOrder.jsp").forward(request, response);

	}
}