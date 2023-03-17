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
import com.havfun.service.message.admin.order.AdminEnquireOrderRequest;
import com.havfun.service.message.admin.order.AdminEnquireOrderResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.OrderMessage;

/**
 * Servlet implementation class EnquireOrder
 */
@WebServlet("/" + OrderHelper.ENQUIRE_ORDER)
public class EnquireOrder extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(EnquireOrder.class.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnquireOrder() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String orderIdStr = request.getParameter("orderId");

		int orderId = -1;

		try {

			orderId = Integer.parseInt(orderIdStr);

		} catch (Exception e) {

			LOGGER.warn("Exception ", e);

		}

		orderHelper.prepareOrder(request, OrderHelper.SERVLET_TYPE_ENQUIRE);

		AdminEnquireOrderRequest enquireRequest = new AdminEnquireOrderRequest();

		BaseUser baseUser = (BaseUser) request.getAttribute(LOGON_USER);

		enquireRequest.setLoginUserId(baseUser.getId());
		enquireRequest.setToken(baseUser.getToken());
		enquireRequest.setOrderId(orderId);

		LOGGER.info("EnquireOrder:: process:: enquireRequest " + enquireRequest);
		AdminEnquireOrderResponse enquireResponse = ClientServiceHelper.getInstance().getClientService()
				.invoke(enquireRequest);
		LOGGER.info("EnquireOrder:: process:: enquireResponse " + enquireResponse);

		int result = -1;

		if (enquireResponse != null) {
			result = enquireResponse.getResult();
		}

		if (result == 0) {

			OrderMessage bosOrderMessage = enquireResponse.getOrderMessage();

			// orderMessage =
			// OrderHelper.getOrderInformationMessageFromSession(request,
			// OrderHelper.ENQUIRE_ORDER + "_" +
			// orderMessage.getOrderId());

			// if (orderInformationMessage != null) {
			// request.setAttribute(OrderHelper.ORDER,
			// orderInformationMessage);
			// } else {
			request.setAttribute(OrderHelper.DATA_IMAGE, bosOrderMessage);
			// }
		} else {
			// show error message...
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			return;
		}

		request.getRequestDispatcher(OrderHelper.ORDER_JSP).forward(request, response);
	}

	@Override
	protected String getMenu() {
		return "MenuOrder";
	}
}
