package com.havfun.adminui.product;

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
import com.havfun.adminui.productgroup.ProductGroupHelperImpl;
import com.havfun.adminui.servlet.AbstractServlet;
import com.havfun.service.message.admin.product.AdminSearchProductRequest;
import com.havfun.service.message.admin.product.AdminSearchProductResponse;
import com.havfun.service.message.data.ProductGroupMessage;
import com.havfun.service.message.data.ProductMessage;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends AbstractServlet {
	private static final Logger LOGGER = LogManager.getLogger(SearchProduct.class.getName());
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchProduct() {
		super();
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int result = 0;
		BaseUser baseUser = (BaseUser) request.getAttribute(LOGON_USER);

		List<Map<String, String>> dataMapList = new ArrayList<Map<String, String>>();		
		
		ProductGroupHelperImpl productGroupHelper = new ProductGroupHelperImpl();
		Map<Integer, ProductGroupMessage> productGroupMap = productGroupHelper.searchProductGroupMessageMap(baseUser);
		
		AdminSearchProductRequest searchRequest = new AdminSearchProductRequest();
		searchRequest.setLoginUserId(baseUser.getId());
		searchRequest.setToken(baseUser.getToken());

		LOGGER.info("SearchProduct:: process:: searchRequest:: " + searchRequest);
		AdminSearchProductResponse searchResponse = ClientServiceHelper.getInstance().getClientService().invoke(searchRequest);
		LOGGER.info("SearchProduct:: process:: searchResponse:: " + searchResponse);

		if (searchResponse != null) {
			
			if ( searchResponse.getProductMessageList() != null ){
				
				for ( ProductMessage message : searchResponse.getProductMessageList() ){
					
					Map<String, String> rowDataMap = new HashMap<String, String>();
					
					rowDataMap.put( "td_product_id", "" + message.getProductId() );
					
					ProductGroupMessage productGroupMessage = productGroupMap.get( message.getProductGroupId() );
					
					if ( productGroupMessage != null ){
					
						rowDataMap.put( "td_product_group", productGroupMessage.getNameEn() + "(" + productGroupMessage.getProductGroupId() + ")" );
					
					}else{
						
						rowDataMap.put( "td_product_group", "-" );
								
					}
					
					rowDataMap.put( "td_name", "" + message.getNameEn() );
					
					rowDataMap.put( "td_price", "" + message.getPrice() );
					
					rowDataMap.put( "td_available_date", "" + message.getAvailableDate() );
					
					rowDataMap.put( "td_stock_status", "" + message.getStockStatus() );
					
					rowDataMap.put( "td_status", "" + message.getProductStatus() );
					
					dataMapList.add(rowDataMap);
					
				}
				
			}
			
			
			
		}
		
		if (searchResponse != null) {
			result = searchResponse.getResult();
			
			request.setAttribute("productList", searchResponse.getProductMessageList());
			
			request.setAttribute("dataMapList", dataMapList );

			request.setAttribute(ProductHelper.NAVIGATOR, "content_product_search_product");

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

		request.getRequestDispatcher("/WEB-INF/searchProduct.jsp").forward(request, response);

	}
}