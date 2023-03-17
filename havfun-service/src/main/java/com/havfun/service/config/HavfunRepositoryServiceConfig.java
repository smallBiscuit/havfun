package com.havfun.service.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@Import({ HavfunDaoConfig.class})
public class HavfunRepositoryServiceConfig {
	
	@Value("${havfunService.havfunDataSourceConfig}")
	private String havfunDataSourceConfig;
	
	@Bean(name = "havfunDataSourceProperties")
	public PropertiesFactoryBean bosDataSourceProperties() {
		System.out.println("#########havfunDataSourceConfig = " + havfunDataSourceConfig);
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource(havfunDataSourceConfig));
		return propertiesFactoryBean;
	}
	
	@Bean(name="havfunDataSource")
	public DataSource havfunDataSource(@Value("#{havfunDataSourceProperties}") Properties properties) {
		return getDataSource(properties);
	}
	
	@Bean(name = "havfunJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Value("#{havfunDataSourceProperties}") Properties properties) {
    	return new JdbcTemplate(havfunDataSource(properties));
	}
	
	@Bean(name = "havfunTxnManager")
	public PlatformTransactionManager bosCommonTxnManager(@Value("#{havfunDataSourceProperties}") Properties properties) {
	        return new DataSourceTransactionManager(havfunDataSource(properties));
	    }

	private DataSource getDataSource(Properties properties) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(properties.getProperty("driverClassName"));
		dataSource.setUrl(properties.getProperty("url"));
		dataSource.setUsername(properties.getProperty("username"));
		dataSource.setPassword(properties.getProperty("password"));
//		dataSource.setDefaultAutoCommit(Boolean.parseBoolean(properties.getProperty("defaultAutoCommit", "false")));
//		dataSource.setDefaultTransactionIsolation(Integer.parseInt(properties.getProperty("defaultTransactionIsolation", "4")));
		dataSource.setInitialSize(Integer.parseInt(properties.getProperty("initialSize", "10")));
//		dataSource.setMaxConnLifetimeMillis(Long.parseLong(properties.getProperty("maxConnLifetimeMillis", "1")));
		dataSource.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal", "10")));
		dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle", "0")));
		dataSource.setMinIdle(Integer.parseInt(properties.getProperty("minIdle", "0")));
		dataSource.setMaxWaitMillis(Long.parseLong(properties.getProperty("maxWaitMillis", "5000")));
		dataSource.setRemoveAbandonedOnMaintenance(Boolean.parseBoolean(properties.getProperty("removeAbandonedOnMaintenance", "true")));
		dataSource.setRemoveAbandonedTimeout(Integer.parseInt(properties.getProperty("removeAbandonedTimeout", "600")));
		dataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(properties.getProperty("timeBetweenEvictionRunsMillis", "1000")));
		dataSource.setMinEvictableIdleTimeMillis(Integer.parseInt(properties.getProperty("minEvictableIdleTimeMillis", "1000")));		
		return dataSource;
	}
}
