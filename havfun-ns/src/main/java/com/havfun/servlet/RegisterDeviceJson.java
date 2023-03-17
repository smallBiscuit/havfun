package com.havfun.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.havfun.entity.Device;
import com.havfun.service.data.ErrorCode;
import com.havfun.service.message.RegisterDeviceRequest;
import com.havfun.service.message.RegisterDeviceResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/RegisterDeviceJson")
public class RegisterDeviceJson extends AbstractServlet{
	
	private static final Logger LOGGER = LoggerManager.getLogger( RegisterDeviceJson.class.getName() );

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDeviceJson() {
        super();
        // TODO Auto-generated constructor stub
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();
		
		InputStreamReader inputStreamReader = new InputStreamReader( request.getInputStream(), "UTF-8" );
		BufferedReader bufferedReader = new BufferedReader( inputStreamReader );
		
		RegisterDeviceRequest registerDeviceRequest = gson.fromJson(bufferedReader, RegisterDeviceRequest.class);
		RegisterDeviceResponse registerDeviceResponse = new RegisterDeviceResponse();
			
		LOGGER.info("rayTest registerDeviceRequest: " + registerDeviceRequest);
		
		if ( registerDeviceRequest == null ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "json format is invalid");
			
		}
		
		if ( registerDeviceRequest.getUserId() == 0 ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "user id is null");
			
		}
		
		if ( registerDeviceRequest.getName() == null || registerDeviceRequest.getName().equals("") ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "name is invalid");
			
		}
		
		if ( registerDeviceRequest.getPlatform() == null ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "platform is invalid");
			
		}
		
		if ( registerDeviceRequest.getToken() == null || registerDeviceRequest.getToken().equals("") ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "token is invalid");
			
		}
		
		Device device = new Device();
		device.setUserId( registerDeviceRequest.getUserId() );
		device.setName( registerDeviceRequest.getName() );
		device.setPlatform( registerDeviceRequest.getPlatform() );
		device.setToken( registerDeviceRequest.getToken() );

		Device existingDevice = deviceDao.readDeviceByUserId( registerDeviceRequest.getUserId() );
		
		if ( existingDevice == null ){
			
			int newDeviceId = deviceDao.create(device);
			
			if ( newDeviceId <= 0 ){
				
				throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_ACTION_FAIL, "create device fail");
				
			}
			
		}
		else if ( !existingDevice.getToken().equals( device.getToken() ) ){
			
			int updatedDeviceId = deviceDao.update( device );
			
			if ( updatedDeviceId <= 0 ){
				
				throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_ACTION_FAIL, "update existing device fail");
				
			}
			
		}
		
		
		String json = gson.toJson( registerDeviceResponse);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}
}
