package com.havfun.service.engine;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RowMapperFileGenerator {

	public static void fileRendering( String packagePrefix, String keyword ){
		
		try{		
			
			String keywordLowercase = keyword.substring(0, 1).toLowerCase() + keyword.substring(1, keyword.length());
	
			String projectName = "havfun";
			String filePath = "";
			String fileName = "tmp/rowmapper/" + keyword + "RowMapper.java";
		
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
		 

		    PrintWriter writer = new PrintWriter( fileName , "UTF-8");		    			    
		    
		    stringBuilder.append(  "package " + packagePrefix + ".dao.rowmapper;" ).append("\n");
		    stringBuilder.append("\n");
		    stringBuilder.append(  "import java.sql.ResultSet;" ).append("\n");
		    stringBuilder.append(  "import java.sql.SQLException;" ).append("\n");
		    stringBuilder.append(  "import org.springframework.jdbc.core.RowMapper;" ).append("\n");
		    stringBuilder.append(  "import " + packagePrefix + ".entity."+ keyword +";" ).append("\n");
		    
		    for ( String type : enumList ){
		    	
		    	stringBuilder.append(  "import " + packagePrefix + ".entity.constant."+ type +";" ).append("\n");
		    	
		    }
		    
		    stringBuilder.append("\n");
		    stringBuilder.append(  "public class "+ keyword +"RowMapper implements RowMapper<"+ keyword +"> {" ).append("\n");
		    stringBuilder.append("\n");
		    stringBuilder.append(  "	@Override" ).append("\n");
		    stringBuilder.append(  "	public "+ keyword +" mapRow(ResultSet rs, int rowNum) throws SQLException {" ).append("\n");
		    stringBuilder.append("\n");		    		
		    stringBuilder.append(  "		"+ keyword +" "+ keywordValueName +" = new "+ keyword +"();" ).append("\n");
		    stringBuilder.append("\n");		    		
		    for ( int i = 0; i < fields.length; i ++ ){
				
				Field field = fields[i];
				
				String valueName = FileGeneratorHelper.convertFieldNameToGetSetValueName( field.getName() );
				String dbName = FileGeneratorHelper.convertFieldNameToDBName( field.getName() );
				
				//timestamp
				//date
				
				if ( field.getType().getSimpleName().equals( "int" ) ){
	       		 
					stringBuilder.append(  "		"+ keywordValueName +".set" + valueName + "(rs.getInt(\"" + dbName + "\"));" ).append("\n");
	        		 
	        	}else if ( field.getType().getSimpleName().equals( "long" ) ){
	        		
	        		stringBuilder.append(  "		"+ keywordValueName +".set" + valueName + "(rs.getLong(\"" + dbName + "\"));" ).append("\n");
	        		
	        	}else if ( field.getType().getSimpleName().equals( "String" ) ){
	        		
	        		stringBuilder.append(  "		"+ keywordValueName +".set" + valueName + "(rs.getString(\"" + dbName + "\"));" ).append("\n");
	        		
	        	}else if ( field.getType().getSimpleName().equals( "BigDecimal" ) ){
	        		
	        		stringBuilder.append(  "		"+ keywordValueName +".set" + valueName + "(rs.getBigDecimal(\"" + dbName + "\"));" ).append("\n");
	        		
	        	}else if ( field.getType().getSimpleName().equals( "byte[]" ) ){
	        		
	        		stringBuilder.append(  "		"+ keywordValueName +".set" + valueName + "(rs.getBytes(\"" + dbName + "\"));" ).append("\n");
	        		
	        	}else if ( field.getType().getSimpleName().equals( "boolean" ) ){
	        		
	        		stringBuilder.append(  "		"+ keywordValueName +".set" + valueName + "(rs.getString(\"" + dbName + "\")==\"1\");" ).append("\n");
	        		
	        	}else {
	        		
	        		stringBuilder.append(  "		"+ keywordValueName +".set" + valueName + "(" + field.getType().getSimpleName() + ".fromValue(rs.getString(\"" + dbName + "\")));" ).append("\n");
	        		
	        	}
				
		    }


			stringBuilder.append(  "		return "+ keywordValueName +";" ).append("\n");
			stringBuilder.append(  "	}" ).append("\n");
			stringBuilder.append("\n");
			stringBuilder.append(  " }" ).append("\n");

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
