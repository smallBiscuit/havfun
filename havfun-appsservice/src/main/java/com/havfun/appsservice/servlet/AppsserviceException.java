package com.havfun.appsservice.servlet;

public class AppsserviceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
    private int errorCode;

    /**
     * Constructs a new servlet exception.
     *
     */
    public AppsserviceException( int errorCode, String message) {
    	super( errorCode + " : " + message );
    	this.errorCode = errorCode;
    }
    
    public AppsserviceException( int errorCode) {
    	super( errorCode + "");
    	this.errorCode = errorCode;
    }
 
    
    public int getErrorCode(){    	
    	return errorCode;
    	
    }
}