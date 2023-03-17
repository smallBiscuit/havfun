package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
import java.io.File;
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
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.message.UploadClientProductImageRequest;
import com.havfun.appsservice.message.UploadClientProductImageResponse;
import com.havfun.service.message.constant.ErrorCode;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class UploadClientProductImage
 */
@WebServlet("/UploadClientProductImage")
public class UploadClientProductImage extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(UploadClientProductImage.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadClientProductImage() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		UploadClientProductImageRequest uploadImageRequest = gson.fromJson(reader, UploadClientProductImageRequest.class);
		UploadClientProductImageResponse uploadImageResponse = new UploadClientProductImageResponse();

		int result = ErrorCode.NO_ERROR;
		
		LOGGER.info("UploadClientProductImage uploadImageRequest: "+ uploadImageRequest );
		
		String fileName = "client_product_image_" + uploadImageRequest.getClientProductId();
		fileName += "_" + uploadImageRequest.getViewIndex();
		fileName += "_" + uploadImageRequest.getLayerIndex();
		fileName += ".png";
		
		byte[] imageByte = Base64.decodeBase64( uploadImageRequest.getFileBase64Data().getBytes("UTF-8") );
				
//		LOGGER.info("UploadClientProductImage imageByte: "+ imageByte );
				
		String fileUrl = "/havfun/havfun_image/client_product_image/" + fileName;
		
		FileUtils.writeByteArrayToFile(new File( fileUrl ), imageByte);

		
		uploadImageResponse.setResult(result);
		
		String json = gson.toJson( uploadImageResponse );
		LOGGER.info("UploadClientProductImage json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

}
