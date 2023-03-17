package com.havfun.service.engine;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileGeneratorController {

	@Test
	public void testFileGeneratorController() {
		 
		List<String> keywordList = new ArrayList<String>();
		
		keywordList.add( "Address" );
		keywordList.add( "Client" );
		keywordList.add( "ClientCode" );
		keywordList.add( "ClientLoginHistory" );
		keywordList.add( "Country" );
		keywordList.add( "Coupon" );
		keywordList.add( "CouponHistory" );
		keywordList.add( "CouponProduct" );
		keywordList.add( "Currency" );
		keywordList.add( "GeoZone" );
		keywordList.add( "Option" );
		keywordList.add( "Order" );
		keywordList.add( "OrderOption" );
		keywordList.add( "OrderOptionValue" );
		keywordList.add( "OrderProduct" );
		keywordList.add( "Product" );
		keywordList.add( "ProductAttribute" );
		keywordList.add( "ProductAttributeOption" );
		keywordList.add( "ProductDiscount" );
		keywordList.add( "ProductGroup" );		
		keywordList.add( "ProductImage" );
		keywordList.add( "ReferrerLog" );
		keywordList.add( "SocialSignIn" );
//		keywordList.add( "User" );
		keywordList.add( "UserGetPasscode" );
//		keywordList.add( "UserLoginHistory" );
		keywordList.add( "Zone" );
		keywordList.add( "ZoneToGeoZone" );
		
		keywordList.add( "MaterialGroup" );
		keywordList.add( "Material" );
		
		keywordList.add( "CustomizeProductBase" );
		keywordList.add( "CustomizeProductBaseView" );
		keywordList.add( "CustomizeProductBorderItem" );
		keywordList.add( "CustomizeProductColorItem" );
		
		keywordList.add( "Courier" );
		keywordList.add( "Forwarder" );
		
		for ( int i = 0; i < keywordList.size(); i ++ ){

			String packagePrefix = "com.havfun.service";
			String keyword = keywordList.get( i );
			
			RowMapperFileGenerator.fileRendering( packagePrefix, keyword);
			DaoFileGenerator.fileRendering( packagePrefix, keyword);
			DaoImplFileGenerator.fileRendering( packagePrefix, keyword);			
			MessageConvertorFileGenerator.fileRendering( packagePrefix, keyword);
		}
		
			 
	}
	
}