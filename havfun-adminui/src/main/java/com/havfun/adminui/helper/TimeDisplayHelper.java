package com.havfun.adminui.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TimeDisplayHelper {
	private static Logger LOGGER = LogManager.getLogger(TimeDisplayHelper.class.getSimpleName());		
	private final static long ONE_SECOND = 1000L;
	private final static long TWO_SECOND = 2*ONE_SECOND;
	private final static long ONE_MINUTE = 60*ONE_SECOND;
	private final static long TWO_MINUTE = 2*ONE_MINUTE;
	private final static long ONE_HOUR = 60*ONE_MINUTE;
	private final static long TWO_HOUR = 2*ONE_HOUR;
	private final static long ONE_DAY = 24*ONE_HOUR;
	private final static long TWO_DAY = 2*ONE_DAY;
	private final static long ONE_WEEK = 7*ONE_DAY;
	private final static long TWO_WEEK = 2*ONE_WEEK;
	private final static long ONE_MONTH = 30*ONE_DAY;
	private final static long TWO_MONTH = 2*ONE_MONTH;
	private final static long ONE_YEAR = 365*ONE_DAY;
	private final static long TWO_YEAR = 2*ONE_YEAR;	
	
	
	public static String getTimeDisplayTag(long time, String [] unitArray){
		String display = "";
		
		if (unitArray.length >= 15) {
            if (time <= 0) {
            	display = unitArray[0];
            } else if (time < TWO_SECOND) {
            	display = 1 + " " + unitArray[1];
            } else if (time < ONE_MINUTE) {
            	display = time/ONE_SECOND + " " +  unitArray[2];
            } else if (time < TWO_MINUTE) {
            	display = 1 + " " +  unitArray[3];
            } else if (time < ONE_HOUR) {
            	display = time/ONE_MINUTE + " " +  unitArray[4];
            } else if (time < TWO_HOUR) {
            	display = 1 + " " +  unitArray[5];
            } else if (time < ONE_DAY) {
            	display = time/ONE_HOUR + " " +  unitArray[6];
            } else if (time < TWO_DAY) {
            	display = 1 + " " +  unitArray[7];
            } else if (time < ONE_WEEK) {
            	display = time/ONE_DAY + " " +  unitArray[8];
            } else if (time < TWO_WEEK) {
            	display = 1 + " " +  unitArray[9];
            } else if (time < ONE_MONTH) {
            	display = time/ONE_WEEK + " " +  unitArray[10];
            } else if (time < TWO_MONTH) {
            	display = 1 + " " +  unitArray[11];
            } else if (time < ONE_YEAR) {
            	display = time/ONE_MONTH + " " +  unitArray[12];
            } else if (time < TWO_YEAR) {
            	display = 1 + " " +  unitArray[13];
            } else {
            	display = 1 + " " +  unitArray[14];
            }		
		}
        return display;		
	}
		
}