package com.havfun.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.havfun.entity.Notification;
import com.havfun.service.data.ErrorCode;
import com.havfun.service.message.CreateNotificationRequest;
import com.havfun.service.message.CreateNotificationResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/CreateNotificationJson")
public class CreateNotificationJson extends AbstractServlet{
	
	private static final Logger LOGGER = LoggerManager.getLogger( CreateNotificationJson.class.getName() );

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNotificationJson() {
        super();
        // TODO Auto-generated constructor stub
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();
		BufferedReader bufferedReader = request.getReader();
		CreateNotificationRequest registerDeviceRequest = gson.fromJson(bufferedReader, CreateNotificationRequest.class);
		CreateNotificationResponse registerDeviceResponse = new CreateNotificationResponse();
		
		int userId = registerDeviceRequest.getUserId();
		
		int type = registerDeviceRequest.getType();
		
		String message = registerDeviceRequest.getMessage();
		
		if ( userId == 0 ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "user id is null");
			
		}
		
		if ( message == null || message.equals("") ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "message is invalid");
			
		}
		

		Notification notification = new Notification();
		
		notification.setUserId(userId);
		notification.setType( type );
		notification.setMessage( message );

		int newNotificationId = notificationDao.create( notification );
		
		if ( newNotificationId <= 0 ){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_ACTION_FAIL, "create notification fail");
			
		}
		
		String json = gson.toJson( registerDeviceResponse);
		response.getWriter().write(json);

	}
}
