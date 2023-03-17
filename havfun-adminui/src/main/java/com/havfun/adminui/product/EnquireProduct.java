package com.havfun.adminui.product;

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
import com.havfun.service.message.admin.product.AdminEnquireProductRequest;
import com.havfun.service.message.admin.product.AdminEnquireProductResponse;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ProductGroupMessage;
import com.havfun.service.message.data.ProductMessage;

/**
 * Servlet implementation class EnquireProduct
 */
@WebServlet("/" + ProductHelper.ENQUIRE_PRODUCT)
public class EnquireProduct extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(EnquireProduct.class.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnquireProduct() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productIdStr = request.getParameter("productId");

		int productId = -1;

		try {

			productId = Integer.parseInt(productIdStr);

		} catch (Exception e) {

			LOGGER.warn("Exception ", e);

		}
		
		parseProductGroupList( request );

		productHelper.prepareProduct(request, ProductHelper.SERVLET_TYPE_ENQUIRE);

		AdminEnquireProductRequest enquireRequest = new AdminEnquireProductRequest();

		BaseUser baseUser = (BaseUser) request.getAttribute(LOGON_USER);

		enquireRequest.setLoginUserId(baseUser.getId());
		enquireRequest.setToken(baseUser.getToken());
		enquireRequest.setProductId(productId);

		LOGGER.info("EnquireProduct:: process:: enquireRequest " + enquireRequest);
		AdminEnquireProductResponse enquireResponse = ClientServiceHelper.getInstance().getClientService()
				.invoke(enquireRequest);
		LOGGER.info("EnquireProduct:: process:: enquireResponse " + enquireResponse);

		int result = -1;

		if (enquireResponse != null) {
			result = enquireResponse.getResult();
		}

		if (result == 0) {

			ProductMessage bosProductMessage = enquireResponse.getProductMessage();

			// productMessage =
			// ProductHelper.getProductInformationMessageFromSession(request,
			// ProductHelper.ENQUIRE_PRODUCT + "_" +
			// productMessage.getProductId());

			// if (productInformationMessage != null) {
			// request.setAttribute(ProductHelper.PRODUCT,
			// productInformationMessage);
			// } else {
			request.setAttribute(ProductHelper.DATA_IMAGE, bosProductMessage);
			// }
		} else {
			// show error message...
			response.sendRedirect("Error?ErrMsg=" + ErrorCode.getErrorCode(result));
			return;
		}

		request.getRequestDispatcher(ProductHelper.PRODUCT_JSP).forward(request, response);
	}

	private void parseProductGroupList( HttpServletRequest request ){
		
		BaseUser baseUser = (BaseUser)request.getAttribute( LOGON_USER );
		

		AdminSearchProductGroupRequest searchRequest = new AdminSearchProductGroupRequest();
		searchRequest.setLoginUserId( baseUser.getId() );
		searchRequest.setToken( baseUser.getToken() );
		
		LOGGER.info("SearchProductGroup:: process:: searchRequest:: "+ searchRequest );
		AdminSearchProductGroupResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke( searchRequest );
		LOGGER.info("SearchProductGroup:: process:: searchResponse:: "+ searchResponse );
		
		if ( searchResponse != null ){
						
			searchResponse.getProductGroupMessageList();
					
			List<String> productGroupList = new ArrayList<String>();
			List<String> productGroupLabelList = new ArrayList<String>();
			
			for ( ProductGroupMessage message : searchResponse.getProductGroupMessageList() ){
				
				productGroupList.add( "" + message.getProductGroupId() );
				
				productGroupLabelList.add( message.getNameEn() );
				
			}
			
			request.setAttribute("productGroupList", productGroupList);
			
			request.setAttribute("productGroupLabelList", productGroupLabelList);
		}
		

	}
	
	@Override
	protected String getMenu() {
		return "MenuProduct";
	}
}
