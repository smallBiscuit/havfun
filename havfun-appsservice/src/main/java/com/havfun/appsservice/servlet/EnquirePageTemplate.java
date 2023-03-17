package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import com.havfun.appsservice.data.PageTemplateItem;
import com.havfun.appsservice.message.EnquirePageTemplateRequest;
import com.havfun.appsservice.message.EnquirePageTemplateResponse;
import com.havfun.service.message.constant.ErrorCode;



/**
 * Servlet implementation class EnquirePageTemplate
 */
@WebServlet("/EnquirePageTemplate")
public class EnquirePageTemplate extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(EnquirePageTemplate.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquirePageTemplate() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		EnquirePageTemplateRequest enquireRequest = gson.fromJson(reader, EnquirePageTemplateRequest.class);
		EnquirePageTemplateResponse enquireResponse = new EnquirePageTemplateResponse();
		
		List<PageTemplateItem> itemList = new ArrayList<PageTemplateItem>();
		
		LOGGER.info("enquireRequest: " + enquireRequest );
		
		if( enquireRequest.getKey().equals( "home" ) ){
			
			PageTemplateItem item_1 = new PageTemplateItem();
            item_1.setKey( "top_banner_1" );
            item_1.setName( "Let's start Create Product" );
            item_1.setUrl( "https://s3-ap-northeast-1.amazonaws.com/dev-mob-havfun/Mobile/Banners/banner1.jpeg" );
            item_1.setVersion( "0.1" );
            item_1.setType( "image" );
            item_1.setRedirectPage( "product_group_list" );
            
            PageTemplateItem item_2 = new PageTemplateItem();
            item_2.setKey( "top_banner_2" );
            item_2.setName( "Top banner 02" );
            item_2.setUrl( "https://s3-ap-northeast-1.amazonaws.com/dev-mob-havfun/Mobile/Banners/banner2.jpeg" );
            item_2.setVersion( "0.1" );
            item_2.setType( "image" );
            item_2.setRedirectPage( "product_list" );
            item_2.setRedirectPageParam( "1" );

            PageTemplateItem item_3 = new PageTemplateItem();
            item_3.setKey( "top_banner_3" );
            item_3.setName( "Top banner 03" );
            item_3.setUrl( "https://s3-ap-northeast-1.amazonaws.com/dev-mob-havfun/Mobile/Banners/banner3.jpeg" );
            item_3.setVersion( "0.1" );
            item_3.setType( "image" );
            item_3.setRedirectPage( "product_list" );
            item_3.setRedirectPageParam( "2" );

            PageTemplateItem item_4 = new PageTemplateItem();
            item_4.setKey( "top_banner_4" );
            item_4.setName( "Top banner 04" );
            item_4.setUrl( "https://s3-ap-northeast-1.amazonaws.com/preview-havfun/MobileResource/PageTemplate/top_banner.jpg" );
            item_4.setVersion( "0.1" );
            item_4.setType( "image" );
            item_4.setRedirectPage( "graphic_list" );
            item_4.setRedirectPageParam( "2" );

            PageTemplateItem item_5 = new PageTemplateItem();
            item_5.setKey( "left_2_icon" );
            item_5.setName( "Left 2 Icon" );
            item_5.setUrl( "https://s3-ap-northeast-1.amazonaws.com/preview-havfun/MobileResource/PageTemplate/top_banner.jpg" );
            item_5.setVersion( "0.1" );
            item_5.setType( "image" );
            item_5.setRedirectPage( "product_grup_list" );

            PageTemplateItem item_6 = new PageTemplateItem();
            item_6.setKey( "left_3_icon" );
            item_6.setName( "Left 3 Icon" );
            item_6.setUrl( "https://s3-ap-northeast-1.amazonaws.com/preview-havfun/MobileResource/PageTemplate/top_banner.jpg" );
            item_6.setVersion( "0.1" );
            item_6.setType( "image" );
            item_6.setRedirectPage( "graphic_group_list" );

            
            itemList.add( item_1 );
            itemList.add( item_2 );
            itemList.add( item_3 );
            itemList.add( item_4 );
            itemList.add( item_5 );
            itemList.add( item_6 );
            
		}else if( enquireRequest.getKey().equals( "event" ) ){
            
        	PageTemplateItem item_1 = new PageTemplateItem();
            item_1.setKey( "top_banner_1" );
            item_1.setName( "Let's start Create Product" );
            item_1.setUrl( "https://s3-ap-northeast-1.amazonaws.com/dev-mob-havfun/Mobile/Banners/banner1.jpeg" );
            item_1.setVersion( "0.1" );
            item_1.setType( "image" );
            item_1.setRedirectPage( "product_group_list" );
            
            PageTemplateItem item_2 = new PageTemplateItem();
            item_2.setKey( "top_banner_2" );
            item_2.setName( "Top banner 02" );
            item_2.setUrl( "https://s3-ap-northeast-1.amazonaws.com/dev-mob-havfun/Mobile/Banners/banner2.jpeg" );
            item_2.setVersion( "0.1" );
            item_2.setType( "image" );
            item_2.setRedirectPage( "product_list" );
            item_2.setRedirectPageParam( "categories-men" );

            PageTemplateItem item_3 = new PageTemplateItem();
            item_3.setKey( "top_banner_3" );
            item_3.setName( "Top banner 03" );
            item_3.setUrl( "https://s3-ap-northeast-1.amazonaws.com/dev-mob-havfun/Mobile/Banners/banner3.jpeg" );
            item_3.setVersion( "0.1" );
            item_3.setType( "image" );
            item_3.setRedirectPage( "graphic_list" );
            item_3.setRedirectPageParam( "5" );

            itemList.add( item_1 );
            itemList.add( item_2 );
            itemList.add( item_3 );

        }
		
		enquireResponse.setItemlist( itemList );
		enquireResponse.setResult( ErrorCode.NO_ERROR );
		
		String json =gson.toJson(enquireResponse);
		LOGGER.info("EnquirePageTemplate json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}