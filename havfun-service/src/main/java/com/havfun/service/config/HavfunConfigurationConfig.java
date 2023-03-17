package com.havfun.service.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HavfunConfigurationConfig {
	private static Logger LOGGER = LogManager.getLogger(HavfunServiceConfig.class.getSimpleName());	
	
	@Value("${hklistcoConfig.generatePasswordUrl}")
	private String generatePasswordUrl;
	
	@Value("${hklistcoConfig.loginUrl}")
	private String loginUrl;	
	
	@Bean
	public HavfunConfig hklistcoConfig() {
		HavfunConfig hklistcoConfig = new HavfunConfig();

		hklistcoConfig.setGeneratePasswordUrl(generatePasswordUrl);
		hklistcoConfig.setLoginUrl(loginUrl);
		
		return hklistcoConfig;
	}

}
