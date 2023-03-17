package com.havfun.adminui.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;

import com.havfun.adminui.helper.DisplayFormatHelper;

public class DateTimeFormatUtil {


	public static final String DISPLAY_DATE_FORMAT_TIME_DETAIL = "HH:mm:ss";
	public static final String DISPLAY_DATE_FORMAT_TIME = "HH:mm";
	public static final String DISPLAY_DATE_FORMAT_DATE = "MM-dd";
	public static final String DISPLAY_DATE_FORMAT_DATE_TIME = "MM-dd HH:mm";	
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE = "yyyy-MM-dd";
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE_TIME = "yyyy-MM-dd HH:mm";
	public static final String DISPLAY_DATE_FORMAT_YEAR_DATE_DETAIL_TIME = "yyyy-MM-dd HH:mm:ss";
	
	
	public static final String DATA_DATE_FORMAT_DATE = "MMdd";
	public static final String DATA_DATE_FORMAT_YEAR_DATE = "yyyyMMdd";

	public static int dateToInt( Date date ){
		
		if ( date == null ){
			
			return 0;
			
		}
		
		FastDateFormat fastDateFormat = FastDateFormat.getInstance( "yyyyMMdd", TimeZone.getTimeZone("Asia/Hong_Kong")  );
		
		String valueStr = fastDateFormat.format( date );
		
		return Integer.parseInt( valueStr );
		
	}
	
	public static String getDisplayInDateFormatWithTimestamp( long timestamp ) {
		
		if ( timestamp <= 0 ){
			
			return "-";
			
		}
		
		FastDateFormat df = FastDateFormat.getInstance(  DISPLAY_DATE_FORMAT_YEAR_DATE, TimeZone.getTimeZone("GMT+8") );
		return df.format(new Date( timestamp ) );		

	}

	public static String getDisplayInDetailTimeFormatWithTimestamp( long timestamp ) {
	
	if ( timestamp <= 0 ){
		
		return "-";
		
	}
	
	FastDateFormat df = FastDateFormat.getInstance(  DISPLAY_DATE_FORMAT_TIME_DETAIL, TimeZone.getTimeZone("GMT+8") );
	return df.format(new Date( timestamp ) );		

}
	
	public static String getDisplayInDateTimeFormatWithTimestamp( long timestamp ) {
		
		if ( timestamp <= 0 ){
			
			return "-";
			
		}
		
		FastDateFormat df = FastDateFormat.getInstance(  DISPLAY_DATE_FORMAT_YEAR_DATE_TIME, TimeZone.getTimeZone("GMT+8") );
		return df.format(new Date( timestamp ) );		

	}
	
	public static String getDisplayInDateDetailTimeFormat( long timestamp ) {
		
		if ( timestamp <= 0 ){
			
			return "-";
			
		}
		
		FastDateFormat df = FastDateFormat.getInstance(  DISPLAY_DATE_FORMAT_YEAR_DATE_DETAIL_TIME, TimeZone.getTimeZone("GMT+8") );
		return df.format(new Date( timestamp ) );		

	}
	
	public static String getDisplayInDateFormat( Integer date ) {
		
		return convertServerDateToDisplayFormat( date );

	}
	
	public static String getDisplayInDetailTimeFormat( long timestamp ) {
		
		if ( timestamp <= 0 ){
			
			return "-";
			
		}
		
		FastDateFormat df = FastDateFormat.getInstance(  DISPLAY_DATE_FORMAT_TIME_DETAIL, TimeZone.getTimeZone("GMT+8") );
		return df.format(new Date( timestamp ) );	

	}
	
	public static String getDisplayInTimeFormat( Integer time ) {
		
		return convertServerTimeToDisplayFormat( time );

	}
	
	public static String getDisplayInDetailTimeFormat( Integer time ) {
		
		return convertDetailServerTimeToDisplayFormat( time );

	}
	
	public static String convertServerMonthToDisplayFormat( Number number ){
		
		String dateStr = String.valueOf( number );
		
		String yearStr = dateStr.substring(0, 4);
		String monthStr = dateStr.substring(4, 6);
		
		return yearStr + "-" + monthStr;
		
	}
	
	public static String convertServerSimpleDateToDisplayFormat( Number number ){
		
		String dateStr = String.format("%04d", number);
		
		String monthStr = dateStr.substring(0, 2);
		String dayStr = dateStr.substring(2, 4);
		
		return monthStr + "-" + dayStr;
		
	}
	
	public static String convertServerDateToDisplayFormat( Number number ){
		
		String dateStr = String.valueOf( number );
		
		String yearStr = dateStr.substring(0, 4);
		String monthStr = dateStr.substring(4, 6);
		String dayStr = dateStr.substring(6, 8);
		
		return yearStr + "-" + monthStr + "-" + dayStr;
		
	}
	
	public static String convertServerTimeToDisplayFormat( Number number ){
		
		String timeStr = String.format("%04d", number);
		
		String hourStr = timeStr.substring(0, 2);
		String minStr = timeStr.substring(2, 4);
		
		return hourStr + ":" + minStr;
		
	}
	
	public static String convertDetailServerTimeToDisplayFormat( Number number ){
		
		String timeStr = String.format("%06d", number);
		
		String hourStr = timeStr.substring(0, 2);
		String minStr = timeStr.substring(2, 4);
		String secStr = timeStr.substring(2, 4);
		
		return hourStr + ":" + minStr + ":" + secStr ;
		
	}

	public static String getTodayServerDate(){
		
		FastDateFormat dateFormatter = FastDateFormat.getInstance(  DATA_DATE_FORMAT_YEAR_DATE, TimeZone.getTimeZone("GMT+8") );		
		
		Calendar calendar = Calendar.getInstance();
		String todayString = dateFormatter.format(calendar.getTime());
		
		return todayString;
		
	}
	
}
