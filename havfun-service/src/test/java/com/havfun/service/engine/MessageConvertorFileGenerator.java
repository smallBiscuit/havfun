package com.havfun.service.engine;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MessageConvertorFileGenerator {

	public static void fileRendering( String packagePrefix, String keyword ){
		
		try{		
		
		String keywordLowercase = keyword.substring(0, 1).toLowerCase() + keyword.substring(1, keyword.length());

		String projectName = "havfun";
		String filePath = "";
		String fileName = "tmp/convertor/" + keyword + "Convertor.java";
	
		String keywordValueName = FileGeneratorHelper.convertFieldNameToValueName( keyword );
			 
		Field[] fields = Class.forName( packagePrefix + ".entity." + keyword).getDeclaredFields();

		String keyFieldGetSetValueName = FileGeneratorHelper.convertFieldNameToGetSetValueName( fields[0].getName() );
		
		String keyFieldDbName = FileGeneratorHelper.convertFieldNameToDBName( fields[0].getName() );
		
		String keywordSqlConstant = FileGeneratorHelper.convertFieldNameToSqlConstant( keyword );
		
		String keyFieldSqlConstant = FileGeneratorHelper.convertFieldNameToSqlConstant( fields[0].getName() );
		
		List<String> enumList = new ArrayList<String>();
		
		for ( Field field : fields ){
			
			if ( isEnumType( field.getType().getSimpleName() ) ){
				
				enumList.add( field.getType().getSimpleName() );
				
			}
			
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		
       	stringBuilder.append(  "package " + packagePrefix + ".convertor;" ).append("\n");
       	stringBuilder.append("\n");
       	stringBuilder.append(  "import java.util.ArrayList;" ).append("\n");
       	stringBuilder.append(  "import java.util.List;" ).append("\n");
       	stringBuilder.append("\n");
       	stringBuilder.append(  "import " + packagePrefix + ".entity." + keyword + ";" ).append("\n");
       	stringBuilder.append(  "import " + packagePrefix + ".message.data." + keyword + "Message;" ).append("\n");
        for ( String type : enumList ){
	    	
	    	stringBuilder.append(  "import " + packagePrefix + ".entity.constant."+ type +";" ).append("\n");
	    	
	    }
       	stringBuilder.append("\n");
       	stringBuilder.append(  "public class " + keyword + "Convertor {" ).append("\n");
       	stringBuilder.append("\n");
       	stringBuilder.append(  "	public final static List<" + keyword + "> convertToEntityList(List<" + keyword + "Message> " + keywordValueName + "MessageList) {" ).append("\n");
       	stringBuilder.append(  "		if (" + keywordValueName + "MessageList == null) {" ).append("\n");
       	stringBuilder.append(  "			return null;" ).append("\n");
       	stringBuilder.append(  "		}" ).append("\n");
       	stringBuilder.append("\n");
       	stringBuilder.append(  "		List<" + keyword + "> " + keywordValueName + "List = new ArrayList<" + keyword + ">();" ).append("\n");
       	stringBuilder.append(  "		for (" + keyword + "Message " + keywordValueName + "Message : " + keywordValueName + "MessageList) {" ).append("\n");
       	stringBuilder.append(  "			" + keywordValueName + "List.add(convertToEntity(" + keywordValueName + "Message));" ).append("\n");
       	stringBuilder.append(  "		}" ).append("\n");
       	stringBuilder.append("\n");
       	stringBuilder.append(  "		return " + keywordValueName + "List;" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	public final static List<" + keyword + "Message> convertToMessageList(List<" + keyword + "> " + keywordValueName + "List) {" ).append("\n");
		stringBuilder.append(  "		if (" + keywordValueName + "List == null) {" ).append("\n");
		stringBuilder.append(  "			return null;" ).append("\n");
		stringBuilder.append(  "		}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "		List<" + keyword + "Message> " + keywordValueName + "MessageList = new ArrayList<" + keyword + "Message>();" ).append("\n");
		stringBuilder.append(  "		for (" + keyword + " " + keywordValueName + " : " + keywordValueName + "List) {" ).append("\n");
		stringBuilder.append(  "			" + keywordValueName + "MessageList.add(convertToMessage(" + keywordValueName + "));" ).append("\n");
		stringBuilder.append(  "		}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "		return " + keywordValueName + "MessageList;" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	public final static " + keyword + " convertToEntity(" + keyword + "Message " + keywordValueName + "Message) {" ).append("\n");
		stringBuilder.append(  "		" + keyword + " " + keywordValueName + " = new " + keyword + "();" ).append("\n");
		stringBuilder.append("\n");
		for ( int i = 0; i < fields.length; i ++ ){
			
			Field field = fields[i];
			
			String valueName = FileGeneratorHelper.convertFieldNameToGetSetValueName( field.getName() );
			String dbName = FileGeneratorHelper.convertFieldNameToDBName( field.getName() );
			
			if ( field.getType().getSimpleName().equals( "boolean" ) ){
				
				stringBuilder.append(  "		" + keywordValueName + ".set" + valueName + "(" + keywordValueName + "Message.is" + valueName + "());" ).append("\n");
				
			}else{
				
				stringBuilder.append(  "		" + keywordValueName + ".set" + valueName + "(" + keywordValueName + "Message.get" + valueName + "());" ).append("\n");
				
			}

		}	
		stringBuilder.append("\n");
		stringBuilder.append(  "		return " + keywordValueName + ";" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	public final static " + keyword + "Message convertToMessage(" + keyword + " " + keywordValueName + ") {" ).append("\n");
		stringBuilder.append(  "		" + keyword + "Message " + keywordValueName + "Message = new " + keyword + "Message();" ).append("\n");
		stringBuilder.append("\n");
		for ( int i = 0; i < fields.length; i ++ ){
			
			Field field = fields[i];
			
			String valueName = FileGeneratorHelper.convertFieldNameToGetSetValueName( field.getName() );
			String dbName = FileGeneratorHelper.convertFieldNameToDBName( field.getName() );
			
			if ( field.getType().getSimpleName().equals( "boolean" ) ){
			
				stringBuilder.append(  "		" + keywordValueName + "Message.set" + valueName + "(" + keywordValueName + ".is" + valueName + "());" ).append("\n");
				
			}else{
				
				stringBuilder.append(  "		" + keywordValueName + "Message.set" + valueName + "(" + keywordValueName + ".get" + valueName + "());" ).append("\n");
				
			}
        		 
		}	
		stringBuilder.append("\n");
		stringBuilder.append(  "		return " + keywordValueName + "Message;" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "}" ).append("\n");
		stringBuilder.append("\n");

		    PrintWriter writer = new PrintWriter( fileName , "UTF-8");
		    writer.println( stringBuilder.toString() );		
		    			    
		    writer.close();
		    
		} catch (IOException e) {
			System.out.println(e);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
private static boolean isEnumType( String type ){
		
		if ( type.equals( "int" ) ){
      		 
			return false;
    		 
    	}else if ( type.equals( "long" ) ){
    		
    		return false;
    		
    	}else if ( type.equals( "String" ) ){
    		
    		return false;
    		
    	}else if ( type.equals( "BigDecimal" ) ){
    		
    		return false;
    		
    	}else if ( type.equals( "byte[]" ) ){
    		
    		return false;
    		
    	}else if ( type.equals( "boolean" ) ){
    		
    		return false;
    		
    	}else {
    		
    		return true; 
    		
    	}
		
	}
}
