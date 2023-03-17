package com.havfun.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.havfun.entity.Device;
import com.havfun.service.data.DevicePlatform;
import com.havfun.service.data.ErrorCode;
import com.havfun.service.message.RegisterDeviceResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/RegisterDevice")
public class RegisterDevice extends AbstractServlet{
	
	private static final Logger LOGGER = LoggerManager.getLogger( RegisterDevice.class.getName() );

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDevice() {
        super();
        // TODO Auto-generated constructor stub
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();
		RegisterDeviceResponse registerDeviceResponse = new RegisterDeviceResponse();
		
		String userIdStr = request.getParameter("userId");
		String name = request.getParameter("name");
		String platformStr = request.getParameter("platform");
		String token = request.getParameter("token");
			
		int userId = Integer.parseInt( userIdStr );
		
		DevicePlatform platform = DevicePlatform.fromValue( platformStr );
		
		
		if ( userId == 0 ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "user id is null");
			
		}
		
		if ( name == null || name.equals("") ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "name is invalid");
			
		}
		
		if ( platformStr == null ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "platform is invalid");
			
		}
		
		if ( token == null || token.equals("") ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "token is invalid");
			
		}
		
		Device device = new Device();
		device.setUserId( userId );
		device.setName( name );
		device.setPlatform( platform );
		device.setToken( token );

		Device existingDevice = deviceDao.readDeviceByUserId( userId );
		
		if (existingDevice == null ){
		
			int newDeviceId = deviceDao.create(device);
			
			if ( newDeviceId <= 0 ){
				
				throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_ACTION_FAIL, "create device fail");
				
			}
			
		}else if ( !existingDevice.getToken().equals( device.getToken() ) ){
			
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
