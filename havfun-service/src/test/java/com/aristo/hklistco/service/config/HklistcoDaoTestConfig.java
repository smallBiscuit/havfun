package com.aristo.hklistco.service.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import com.havfun.service.config.HavfunDaoConfig;

@Configuration
@Import({HavfunDaoConfig.class})
public class HklistcoDaoTestConfig {

	@Bean(name = "hklistcoTxnManager")
	public PlatformTransactionManager hklistcoTxnManager() {
		return new DataSourceTransactionManager(hklistcoDataSource());
	}
	
	@Bean(name = "hklistcoJdbcTemplate")
	public JdbcTemplate hklistcoJdbcTemplate() {
		return new JdbcTemplate(hklistcoDataSource());
	}
	
	@Bean(name = "hklistcoDataSource")
	public DataSource hklistcoDataSource() {
		EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.addScript("/db_schema_hklistco.sql")
			.build();
		return database;
	}
}
