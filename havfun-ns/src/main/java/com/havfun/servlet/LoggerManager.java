package com.havfun.servlet;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerManager {

	private static Logger logger = Logger.getGlobal();
	
	static{
		
		
		Handler fileHandler = null;
		SimpleFormatter simpleFormatter = null;
		CustomFormatter customFormatter = null;
		
		try {
			fileHandler = new FileHandler("/tmp/havfun.log",1048576,1,true);
			customFormatter = new CustomFormatter();
			simpleFormatter = new SimpleFormatter();
			
			//fileHandler.setFormatter(customFormatter);
			fileHandler.setFormatter(simpleFormatter);
			fileHandler.setLevel(Level.ALL);			
			
			logger.addHandler(fileHandler);

			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Logger getLogger(String name){
		
		return logger;
		
	}
	
	public static void closeLogger(){
		Handler[] handlers = logger.getHandlers();
		
		for ( Handler handler : handlers ){
			handler.close();
		}		
	}
	
}

class CustomFormatter extends Formatter {
    //
    // Create a DateFormat to format the logger timestamp.
    //
    private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
 
    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1000);
        builder.append(df.format(new Date(record.getMillis()))).append(" - ");
//        builder.append("[").append(record.getSourceClassName()).append(".");
//        builder.append(record.getSourceMethodName()).append("] - ");
        builder.append("[").append(record.getLevel()).append("] - ");
        builder.append(formatMessage(record));
        builder.append("n");
        return builder.toString();
    }
 
    public String getHead(Handler h) {
        return super.getHead(h);
    }
 
    public String getTail(Handler h) {
        return super.getTail(h);
    }

}
