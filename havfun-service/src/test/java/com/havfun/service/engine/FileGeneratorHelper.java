package com.havfun.service.engine;

public class FileGeneratorHelper {

	public static String convertFieldNameToDBName( String fieldName ){
		
		StringBuilder dbName = new StringBuilder();
		
		boolean firstChar = true;
		
		for(char c : fieldName.toCharArray()) {
    		
    		if( Character.isUpperCase(c) ) {

    			if (  firstChar ){
    				
    				dbName.append( String.valueOf(c).toLowerCase() );
    				
    			}else{
    			
    				dbName.append( "_" + String.valueOf(c).toLowerCase() );
    			
    			}
    	    }else{
    	    	
    	    	dbName.append( String.valueOf(c) );
    	    	
    	    }
    		
    		firstChar = false;
    	}
		
		return dbName.toString();
		
	}
	
	public static String convertFieldNameToGetSetValueName( String fieldName ){
		
		StringBuilder valueName = new StringBuilder();
		
		boolean firstChar = true;
		
		for(char c : fieldName.toCharArray()) {
    		
			if ( firstChar){
    			valueName.append(  String.valueOf(c).toUpperCase() );
    			firstChar = false;
    		}else{
    			valueName.append( String.valueOf(c) );
    		}
    		
    	}
		
		return valueName.toString();
		
	}
	
	public static String convertFieldNameToValueName( String fieldName ){
		
		StringBuilder valueName = new StringBuilder();
		
		boolean firstChar = true;
		
		for(char c : fieldName.toCharArray()) {
    		
			if ( firstChar){
    			valueName.append(  String.valueOf(c).toLowerCase() );
    			firstChar = false;
    		}else{
    			valueName.append( String.valueOf(c) );
    		}
    		
    	}
		
		return valueName.toString();
		
	}
	
	public static String convertFieldNameToSqlConstant( String fieldName ){

		StringBuilder dbName = new StringBuilder();
		
		boolean firstChar = true;
		
		for(char c : fieldName.toCharArray()) {
    		
    		if( Character.isUpperCase(c) && !firstChar ) {

    			dbName.append( "_" + String.valueOf(c).toUpperCase() );
    			
    	    }else{
    	    	
    	    	dbName.append( String.valueOf(c).toUpperCase() );
    	    	
    	    }
    		
    		firstChar = false;
    		
    	}
		
		return dbName.toString();

	}
	
}
