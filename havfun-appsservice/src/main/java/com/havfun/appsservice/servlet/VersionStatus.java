package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import com.havfun.appsservice.message.VersionStatusRequest;
import com.havfun.appsservice.message.VersionStatusResponse;



/**
 * Servlet implementation class VersionStatus
 */
@WebServlet("/VersionStatus")
public class VersionStatus extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(VersionStatus.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VersionStatus() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		VersionStatusRequest versionStatusRequest = gson.fromJson(reader, VersionStatusRequest.class);
		VersionStatusResponse versionStatusResponse = new VersionStatusResponse();
		
		LOGGER.info("versionStatusRequest: " + versionStatusRequest );
		
		versionStatusResponse.setForceUpdate( true );
		
		versionStatusResponse.setCountryList( dataHelper.getCountryList() );
		
		String json =gson.toJson(versionStatusResponse);
		LOGGER.info("VersionStatus json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
}