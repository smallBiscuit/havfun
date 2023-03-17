package com.havfun.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.havfun.entity.Device;
import com.havfun.entity.Notification;
import com.havfun.service.data.ErrorCode;
import com.havfun.service.helper.NotificationHelper;
import com.havfun.service.message.CreateNotificationResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/CreateNotification")
public class CreateNotification extends AbstractServlet{
	
	private static final Logger LOGGER = LoggerManager.getLogger( CreateNotification.class.getName() );

	private static final long serialVersionUID = 1L;

//	private static final String TESTING_IOS_DEVICE_TOKEN = "9c6ae0002241cf4b524ee76c664cb2f796f7337d4324f3470a88fb3950ce53c5";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNotification() {
        super();
        // TODO Auto-generated constructor stub
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();
		CreateNotificationResponse registerDeviceResponse = new CreateNotificationResponse();
		
		String userIdStr = request.getParameter("userId");
		String typeStr = request.getParameter("type");
		String message = request.getParameter("message");
		
		int userId = 0;
		int type = 0;
		
		try{
		
			userId = Integer.parseInt( userIdStr );
		
			type = Integer.parseInt( typeStr );

		}catch( Exception e){
			
			throw new AppsserviceException( ErrorCode.ERROR_CODE_COMMON_DATA_INVALID, "user id or type is null");
			
		}
		
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
		
		if ( message != null ){

			Device device = deviceDao.readDeviceByUserId(userId);
				
			NotificationHelper.sendNotification( message, device.getToken() );
			
		}

		
		String json = gson.toJson( registerDeviceResponse);
		response.getWriter().write(json);

	}
	
}