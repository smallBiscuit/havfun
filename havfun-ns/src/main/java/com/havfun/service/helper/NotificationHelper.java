package com.havfun.service.helper;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONException;

import com.havfun.servlet.LoggerManager;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;
import javapns.notification.ResponsePacket;

public class NotificationHelper {

	private static final Logger LOGGER = LoggerManager.getLogger( NotificationHelper.class.getName() );
	
	private static final String IOS_APN_CERT_PATH = "/tmp/havfuncartdev_apn.p12";
	private static final String IOS_APN_CERT_PASSWORD = "1029384756";
	
//	private static final String TESTING_IOS_DEVICE_TOKEN = "9c6ae0002241cf4b524ee76c664cb2f796f7337d4324f3470a88fb3950ce53c5";
	
	
	
	public static void sendNotification( String message, String token){
		
		LOGGER.info("sendNotification:  start");
		//platform
		//Device
		
		try {

	        PushNotificationPayload payload = PushNotificationPayload.complex();

	        payload.addAlert( message );
	        payload.addBadge(1);
	        payload.addSound("default");
	        payload.addCustomDictionary("id", "1");

			LOGGER.info("sendNotification:  payload: " + payload);
	        
			File file = new File( IOS_APN_CERT_PATH );
			LOGGER.info("sendNotification:  file: " + file);

			
	        List<PushedNotification> NOTIFICATIONS = Push.payload(payload, IOS_APN_CERT_PATH, IOS_APN_CERT_PASSWORD, true, token );

	        LOGGER.info("sendNotification:  1 ");
	        
	        for (PushedNotification NOTIFICATION : NOTIFICATIONS) {
	        	
	        	LOGGER.info("sendNotification:  2  NOTIFICATION " + NOTIFICATION);
	        	
	            if (NOTIFICATION.isSuccessful()) {
	                    /* APPLE ACCEPTED THE NOTIFICATION AND SHOULD DELIVER IT */  
	                    System.out.println("PUSH NOTIFICATION SENT SUCCESSFULLY TO: " +
	                                                    NOTIFICATION.getDevice().getToken());
	                    /* STILL NEED TO QUERY THE FEEDBACK SERVICE REGULARLY */  
	              
	                    LOGGER.info("sendNotification:  isSuccessful ");
	                    
	            } 
	            else {
	                    String INVALIDTOKEN = NOTIFICATION.getDevice().getToken();
	                    /* ADD CODE HERE TO REMOVE INVALIDTOKEN FROM YOUR DATABASE */  

	                    /* FIND OUT MORE ABOUT WHAT THE PROBLEM WAS */  
	                    Exception THEPROBLEM = NOTIFICATION.getException();
	                    THEPROBLEM.printStackTrace();
	                    
	                    LOGGER.info("sendNotification:  THEPROBLEM: " + THEPROBLEM );

	                    /* IF THE PROBLEM WAS AN ERROR-RESPONSE PACKET RETURNED BY APPLE, GET IT */  
	                    ResponsePacket THEERRORRESPONSE = NOTIFICATION.getResponse();
	                    
	                    LOGGER.info("sendNotification:  THEERRORRESPONSE: " + THEERRORRESPONSE );
	                    
	                    if (THEERRORRESPONSE != null) {
	                            System.out.println(THEERRORRESPONSE.getMessage());
	                            
	                            LOGGER.info("sendNotification:  fail: " + THEERRORRESPONSE.getMessage());
	                            
	                    }
	            }
	      }


	    } catch (CommunicationException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        LOGGER.info("sendNotification:  Exception: " + e);
	    } catch (KeystoreException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        LOGGER.info("sendNotification:  Exception: " + e);
	    } catch (JSONException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        LOGGER.info("sendNotification:  Exception: " + e);
	    }

		
	}
	
}
