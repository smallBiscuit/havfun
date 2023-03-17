package com.havfun.service.engine;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class DaoImplFileGenerator {

	public static void fileRendering( String packagePrefix, String keyword ){
		
		try{		
		
		String keywordLowercase = keyword.substring(0, 1).toLowerCase() + keyword.substring(1, keyword.length());

		String projectName = "havfun";
		String filePath = "";
		String fileName = "tmp/dao/" + keyword + "DaoImpl.java";
	
		String keywordValueName = FileGeneratorHelper.convertFieldNameToValueName( keyword );
		
		String keywordTableName = FileGeneratorHelper.convertFieldNameToDBName( keyword );
		
		Field[] fields = Class.forName( packagePrefix + ".entity." + keyword).getDeclaredFields();

		String keyFieldGetSetValueName = FileGeneratorHelper.convertFieldNameToGetSetValueName( fields[0].getName() );
		
		String keyFieldDbName = FileGeneratorHelper.convertFieldNameToDBName( fields[0].getName() );
		
		String keywordSqlConstant = FileGeneratorHelper.convertFieldNameToSqlConstant( keyword );
		
		String keyFieldSqlConstant = FileGeneratorHelper.convertFieldNameToSqlConstant( fields[0].getName() );
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append( "package " + packagePrefix + ".dao;" ).append("\n");
		stringBuilder.append( "import java.util.Date;" ).append("\n");
		stringBuilder.append( "import java.util.HashMap;" ).append("\n");
		stringBuilder.append( "import java.util.List;" ).append("\n");
		stringBuilder.append( "import java.util.Map;" ).append("\n");
		stringBuilder.append( "import javax.annotation.Resource;" ).append("\n");
		stringBuilder.append( "import org.apache.logging.log4j.LogManager;" ).append("\n");
		stringBuilder.append( "import org.apache.logging.log4j.Logger;" ).append("\n");
		stringBuilder.append( "import org.springframework.beans.factory.annotation.Autowired;" ).append("\n");
		stringBuilder.append( "import org.springframework.dao.IncorrectResultSizeDataAccessException;" ).append("\n");
		stringBuilder.append( "import org.springframework.jdbc.core.JdbcTemplate;" ).append("\n");
		stringBuilder.append( "import org.springframework.jdbc.core.RowMapper;" ).append("\n");
		stringBuilder.append( "import org.springframework.jdbc.core.simple.SimpleJdbcInsert;" ).append("\n");		
		stringBuilder.append( "import org.apache.logging.log4j.LogManager;" ).append("\n");
		stringBuilder.append( "import org.apache.logging.log4j.Logger;" ).append("\n");
		stringBuilder.append( "import " + packagePrefix + ".dao." + keyword + "Dao;" ).append("\n");
		stringBuilder.append( "import " + packagePrefix + ".dao." + keyword + "DaoImpl;" ).append("\n");
		stringBuilder.append( "import " + packagePrefix + ".entity." + keyword + ";" ).append("\n");
		
		stringBuilder.append("\n");
		stringBuilder.append( "public class " + keyword + "DaoImpl implements " + keyword + "Dao {" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	/** logger **/" ).append("\n");
		stringBuilder.append(  "	private final static Logger LOGGER = LogManager.getLogger(" + keyword + "DaoImpl.class);" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	private final static String " + keywordSqlConstant + "_UPDATE_SQL_BY_KEY = \"update " + keywordLowercase + " set  " );
		
		for ( int i = 1; i < fields.length; i ++ ){
			
			Field field = fields[i];
			
			if ( i != 1 ){
				stringBuilder.append(", ");
			}
			
			String dbName = FileGeneratorHelper.convertFieldNameToDBName( field.getName() );
			
			stringBuilder.append( dbName  + " = ?");
			
		}
		
		stringBuilder.append(  " where " + keyFieldDbName + " = ?\";" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	private final static String " + keywordSqlConstant + "_SELECT_SQL_BY_KEY = \"select * from " + keywordTableName + " where " + keyFieldDbName + " = ?\";" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	private final static String " + keywordSqlConstant + "_DELETE_SQL_BY_KEY = \"delete from " + keywordTableName + " where " + keyFieldDbName + " = ?\";" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	private final static String " + keywordSqlConstant + "_SELECT_ALL_SQL = \"select * from " + keywordTableName + "\";" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	private final static String " + keywordSqlConstant + "_SELECT_SQL_BY_" + keyFieldSqlConstant + " = \"select * from " + keywordTableName + " where user_name = ?\";" ).append("\n");
		stringBuilder.append("\n");		
		stringBuilder.append(  "	/** jdbc template **/" ).append("\n");
		stringBuilder.append(  "	@Resource(name = \"" + projectName + "JdbcTemplate\")" ).append("\n");
		stringBuilder.append(  "	protected JdbcTemplate jdbcTemplate;" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	/** row mapper **/" ).append("\n");
		stringBuilder.append(  "	@Autowired" ).append("\n");
		stringBuilder.append(  "	protected RowMapper<" + keyword + "> rowMapper;" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	@Override" ).append("\n");
		stringBuilder.append(  "	public Integer create(" + keyword + " newInstance) {" ).append("\n");
		stringBuilder.append("\n");		
		stringBuilder.append(  "		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName(\"" + keywordTableName + "\").usingGeneratedKeyColumns(\"" + keyFieldDbName + "\");" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "		Map<String, Object> parameters = new HashMap<String, Object>();" ).append("\n");
		
		for ( int i = 0; i < fields.length; i ++ ){
			
			Field field = fields[i];
			
			String valueName = FileGeneratorHelper.convertFieldNameToGetSetValueName( field.getName() );
			String dbName = FileGeneratorHelper.convertFieldNameToDBName( field.getName() );
			
			//timestamp
			//date
			
			if ( field.getType().getSimpleName().equals( "int" ) ){
       		 
				stringBuilder.append(  "		parameters.put(\"" + dbName + "\", newInstance.get" + valueName + "());" ).append("\n");
        		 
        	}else if ( field.getType().getSimpleName().equals( "long" ) ){
        		 
        		stringBuilder.append(  "		parameters.put(\"" + dbName + "\", newInstance.get" + valueName + "());" ).append("\n");
        		
        	}else if ( field.getType().getSimpleName().equals( "String" ) 
        			|| field.getType().getSimpleName().equals( "BigDecimal" ) 
        			|| field.getType().getSimpleName().equals( "byte[]" )         			
        			){
        		 
        		stringBuilder.append(  "		parameters.put(\"" + dbName + "\", newInstance.get" + valueName + "());" ).append("\n");
        		
        	}else if ( field.getType().getSimpleName().equals( "boolean" ) ){
        		
        		stringBuilder.append(  "		parameters.put(\"" + dbName + "\", newInstance.is" + valueName + "()?\"1\":\"0\");" ).append("\n");
        		
        	}else{
        		
        		stringBuilder.append(  "		parameters.put(\"" + dbName + "\", newInstance.get" + valueName+ "()==null?null:newInstance.get" + valueName + "().getValue());" ).append("\n");
        		
        	}
			
		}		
		

		stringBuilder.append(  "		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);" ).append("\n");
		stringBuilder.append(  "		if (key != null) {" ).append("\n");
		stringBuilder.append(  "			return key.intValue();" ).append("\n");
		stringBuilder.append(  "		}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "		return null;" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	@Override" ).append("\n");
		stringBuilder.append(  "	public " + keyword + " read(Integer id) {" ).append("\n");
		stringBuilder.append(  "		" + keyword + " " + keywordValueName + " = null;" ).append("\n");
		stringBuilder.append(  "		try {" ).append("\n");
		stringBuilder.append(  "			" + keywordValueName + " = jdbcTemplate.queryForObject(" ).append("\n");
		stringBuilder.append(  "			" + keywordSqlConstant + "_SELECT_SQL_BY_KEY," ).append("\n");
		stringBuilder.append(  "			rowMapper," ).append("\n");
		stringBuilder.append(  "			new Object [] {" ).append("\n");
		stringBuilder.append(  "			id" ).append("\n");
		stringBuilder.append(  "			}" ).append("\n");
		stringBuilder.append(  "				);" ).append("\n");
		stringBuilder.append(  "			} catch (IncorrectResultSizeDataAccessException e) {" ).append("\n");
		stringBuilder.append(  "			return null;" ).append("\n");
		stringBuilder.append(  "		}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "		return " + keywordValueName + ";" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	@Override" ).append("\n");
		stringBuilder.append(  "	public int update(" + keyword + " transientObject) {" ).append("\n");
		stringBuilder.append(  "		return jdbcTemplate.update(" ).append("\n");
		stringBuilder.append(  "				" + keywordSqlConstant + "_UPDATE_SQL_BY_KEY," ).append("\n");
		stringBuilder.append(  "				new Object [] {" ).append("\n");
		
		for ( int i = 1; i < fields.length; i ++ ){
			
			Field field = fields[i];
			
			String valueName = FileGeneratorHelper.convertFieldNameToGetSetValueName( field.getName() );
			String dbName = FileGeneratorHelper.convertFieldNameToDBName( field.getName() );
			
			//timestamp
			//date
			
			if ( field.getType().getSimpleName().equals( "int" ) ){
	       		 
				stringBuilder.append(  "					transientObject.get" + valueName + "()," ).append("\n");
        		 
        	}else if ( field.getType().getSimpleName().equals( "long" ) ){
        		 
        		stringBuilder.append(  "					transientObject.get" + valueName + "()," ).append("\n");
        		
        	}else if ( field.getType().getSimpleName().equals( "String" ) 
            			|| field.getType().getSimpleName().equals( "BigDecimal" ) 
            			|| field.getType().getSimpleName().equals( "byte[]" )         			
            			){
        		
        		stringBuilder.append(  "					transientObject.get" + valueName + "()," ).append("\n");
        		
        	}else if ( field.getType().getSimpleName().equals( "boolean" ) ){
        	
        		stringBuilder.append(  "					transientObject.is" + valueName + "()?\"1\":\"0\"," ).append("\n");
        		
        	}else{
        		
        		System.out.println( "field.getType().getSimpleName(): " + field.getType().getSimpleName() );
        		
        		stringBuilder.append(  "					transientObject.get" + valueName + "().getValue()," ).append("\n");
        		
        	}
			
		}	
       		 
		stringBuilder.append(  "					transientObject.get" + keyFieldGetSetValueName + "()," ).append("\n");
		
		stringBuilder.append("\n");							
		stringBuilder.append(  "				}" ).append("\n");
		stringBuilder.append(  "			);" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");		
		stringBuilder.append(  "	@Override" ).append("\n");
		stringBuilder.append(  "	public int delete(" + keyword + " persistentObject) {" ).append("\n");
		stringBuilder.append(  "		return jdbcTemplate.update(" ).append("\n");
		stringBuilder.append(  "			" + keywordSqlConstant + "_DELETE_SQL_BY_KEY," ).append("\n");
		stringBuilder.append(  "			new Object [] {" ).append("\n");
		stringBuilder.append(  "					persistentObject.get" + keyFieldGetSetValueName + "()" ).append("\n");
		stringBuilder.append(  "			}" ).append("\n");
		stringBuilder.append(  "			);" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(  "	@Override" ).append("\n");
		stringBuilder.append(  "	public int deleteByKey(Integer id) {" ).append("\n");
		stringBuilder.append(  "		return jdbcTemplate.update(" ).append("\n");
		stringBuilder.append(  "				" + keywordSqlConstant + "_DELETE_SQL_BY_KEY," ).append("\n");
		stringBuilder.append(  "				new Object [] {" ).append("\n");
		stringBuilder.append(  "						id" ).append("\n");
		stringBuilder.append(  "				}" ).append("\n");
		stringBuilder.append(  "				);" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		/*
		stringBuilder.append(  "	@Override" ).append("\n");		
		stringBuilder.append(  "	public List<" + keyword + "> readAll() {" ).append("\n");
		stringBuilder.append(  "		return jdbcTemplate.query(" ).append("\n");
		stringBuilder.append(  "				" + keywordSqlConstant + "_SELECT_ALL_SQL," ).append("\n");
		stringBuilder.append(  "				rowMapper);" ).append("\n");
		stringBuilder.append(  "	}" ).append("\n");
		stringBuilder.append("\n");
		*/

		stringBuilder.append(  "}" ).append("\n");
		
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
}
