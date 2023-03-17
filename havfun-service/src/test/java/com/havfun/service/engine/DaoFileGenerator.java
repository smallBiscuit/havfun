package com.havfun.service.engine;

import java.io.IOException;
import java.io.PrintWriter;

public class DaoFileGenerator {

	public static void fileRendering( String packagePrefix, String keyword ){
		
		String keywordLowercase = keyword.substring(0, 1).toLowerCase() + keyword.substring(1, keyword.length());
		String LINE_PACKAGE = "package " + packagePrefix + ".dao;";
		String LINE_IMPORT_CLASS_01 = "import " + packagePrefix + ".entity.%s;";
		String LINE_CLASS_CONSTRCTOR = "public interface %sDao extends GenericDao<%s, Integer>{";
		 		 
		String filePath = "";
		String fileName = "tmp/dao/" + keyword + "Dao.java";
		 
		 try{
			    PrintWriter writer = new PrintWriter( fileName , "UTF-8");
			    writer.println( LINE_PACKAGE );		
			    
			    writer.println();	
			    
			    writer.println( String.format(LINE_IMPORT_CLASS_01, keyword) );
			    
			    writer.println();			    
			    
			    writer.println( String.format(LINE_CLASS_CONSTRCTOR, keyword, keyword) );
			    			    
			    writer.println();	
			    
			    writer.println( "}" );	
			    
			    writer.close();
			} catch (IOException e) {
				System.out.println(e);
			}
	}
	
}
