package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import com.havfun.appsservice.convertor.AddressConvertor;
import com.havfun.appsservice.data.Address;
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.data.Cart;
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.data.Client;
import com.havfun.appsservice.data.PaymentMethod;
import com.havfun.appsservice.data.ShippingMethod;
import com.havfun.appsservice.message.EnquireCheckoutInfoRequest;
import com.havfun.appsservice.message.EnquireCheckoutInfoResponse;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.service.message.data.CourierMessage;

/**
 * Servlet implementation class EnquireCheckoutInfo
 */
@WebServlet("/EnquireCheckoutInfo")
public class EnquireCheckoutInfo extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(EnquireCheckoutInfo.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquireCheckoutInfo() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		EnquireCheckoutInfoRequest enquireCheckoutInfoRequest = gson.fromJson(reader, EnquireCheckoutInfoRequest.class);
		EnquireCheckoutInfoResponse enquireCheckoutInfoResponse = new EnquireCheckoutInfoResponse();

		BaseClient client = (BaseClient)request.getAttribute( LOGON_CLIENT );
		LOGGER.info("EnquireCheckoutInfo client: "+ client );

		
		BigDecimal totalWeight = getTotalWeightOfOrder( request );
		
		enquireCheckoutInfoResponse.setTotalWeight( totalWeight );
		
		List<Address> addressList = new ArrayList<Address>();
		
		List<List<ShippingMethod>> shippingMethodsList = new ArrayList<List<ShippingMethod>>();
		
		if ( client != null ){
			
			ClientMessage clientMessage = dataHelper.getClientMap().get( client.getClientId() );
			
			addressList = AddressConvertor.convertMessageToDataList( clientMessage.getAddressList() );
			
			enquireCheckoutInfoResponse.setAddressList( addressList );
			
		}
		
		LOGGER.info("rayTest addressList: " + addressList );
		
		for ( Address address : addressList ){
			
			String countryCode = address.getCountryCode();
			
			if ( countryCode == null ){
				
				countryCode = "HK";
				
				for ( int i = 0; i < dataHelper.getCountryList().size(); i ++ ){
					
					if ( address.getCountryId() == dataHelper.getCountryList().get(i).getCountryId() ){
						
						countryCode =  dataHelper.getCountryList().get(i).getCountryCode();
						
					}
					
				}
				
			}
			
			List<ShippingMethod> shippingMethods = getAvailableShippingMethodListWithCountryCode( countryCode, totalWeight );
			
			shippingMethodsList.add(shippingMethods);
			
		}
		
		enquireCheckoutInfoResponse.setShippingMethodsList(shippingMethodsList);
		
		List<PaymentMethod> paymentMethodList = getAvailablePaymentMethodList();
		
		enquireCheckoutInfoResponse.setPaymentMethodList(paymentMethodList);
		
		String json =gson.toJson( enquireCheckoutInfoResponse );
		LOGGER.info("EnquireCheckoutInfo json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
	private List<ShippingMethod> getAvailableShippingMethodListWithCountryCode( String countryCode, BigDecimal totalWeight ){
		
		List<CourierMessage> courierList = dataHelper.getCourierList();
		
		List<ShippingMethod> shippingMethodList = new ArrayList<ShippingMethod>();
		
		if ( countryCode == null || countryCode.equals("HK") ){
			
			ShippingMethod shippingMethod = new ShippingMethod();
			
			shippingMethod.setMethodId( 0 );
			shippingMethod.setDisplayName( "Free for Hong Kong" );
			shippingMethod.setType( "" );
			shippingMethod.setFee( BigDecimal.ZERO );
			shippingMethod.setExtraFee( BigDecimal.ZERO );
			
			shippingMethodList.add(shippingMethod);
			
		}else{
		
			for ( CourierMessage courier : courierList ){
				
				if ( courier.getCountryCode().equals( countryCode ) ){
	
					if ( courier.getFromWeight().compareTo( totalWeight ) < 0 && 
							courier.getToWeight().compareTo( totalWeight ) > 0		
					){
					
						ShippingMethod shippingMethod = new ShippingMethod();
						
						String countryName = dataHelper.getCountryNameByCode( courier.getCountryCode() );
						
						shippingMethod.setMethodId( courier.getCourierId() );
						shippingMethod.setDisplayName( courier.getForwarderNameEn() + "[" + countryName + "]" );
						shippingMethod.setType( "" );
						shippingMethod.setFee( courier.getBaseCost() );
						shippingMethod.setExtraFee( courier.getChargePerTier() );
						
						shippingMethodList.add(shippingMethod);
					
					}
					
				}
				
			}
		
		}
		
		return shippingMethodList;
	}
	
	private BigDecimal getTotalWeightOfOrder( HttpServletRequest request ){
		
		BigDecimal totalWeight = BigDecimal.ZERO;
		
		String session = request.getSession().getId();
		
		if ( cartItemsMap.containsKey( session ) ){
						
			List<CartProduct> itemList = cartItemsMap.get( session );
			
			for ( CartProduct cartProduct : itemList ){
				
				totalWeight = totalWeight.add( cartProduct.getWeight().multiply( new BigDecimal( cartProduct.getQuantity() ) ) );
				
			}
			
		}
		
		return totalWeight;
	}
	
	private List<PaymentMethod> getAvailablePaymentMethodList(){
		
		List<PaymentMethod> paymentMethodList = new ArrayList<PaymentMethod>();
		
		PaymentMethod atmPaymentMethod = new PaymentMethod();
		
		atmPaymentMethod.setMethodId( 1 );
		atmPaymentMethod.setTitle( "ATM" );
		atmPaymentMethod.setReceiverId( "" );

		PaymentMethod payPalPaymentMethod = new PaymentMethod();
		
		payPalPaymentMethod.setMethodId( 2 );
		payPalPaymentMethod.setTitle( "Pay Pal" );
		payPalPaymentMethod.setReceiverId( "" );

		paymentMethodList.add(atmPaymentMethod);
		paymentMethodList.add(payPalPaymentMethod);
		
		return paymentMethodList;
	}
	
	protected boolean isAuthenticationRequired(){
		return true;
	}
	
}