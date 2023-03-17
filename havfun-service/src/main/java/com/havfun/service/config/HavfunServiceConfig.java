package com.havfun.service.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.havfun.service.HavfunService;
import com.havfun.service.HavfunServiceImpl;

@Configuration
@Import({
	HavfunServiceEventConfig.class,
	HavfunRepositoryServiceConfig.class,
	HavfunEmailSenderConfig.class,
	HavfunConfigurationConfig.class
	})
public class HavfunServiceConfig {
	
	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/conf/havfun.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}
	
	@Bean 
	public HavfunService havfunService() {
		return new HavfunServiceImpl();
	}
	
}
