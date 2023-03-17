package com.aristo.hklistco.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.havfun.service.HavfunService;
import com.havfun.service.HavfunServiceImpl;
import com.havfun.service.config.HavfunConfig;
import com.havfun.service.config.HavfunRepositoryServiceConfig;
import com.havfun.service.config.HavfunServiceEventConfig;

@Configuration
@Import({
	HavfunServiceEventConfig.class,
	HavfunRepositoryServiceConfig.class,
	HklistcoEmailSenderTestConfig.class,
	HklistcoDaoTestConfig.class
	})
public class HklistcoServiceTestConfig {
	
	@Value("${hklistcoConfig.generatePasswordUrl}")
	private String generatePasswordUrl;
	
	@Value("${hklistcoConfig.loginUrl}")
	private String loginUrl;
	
	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/conf/havfun.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}
	
	@Bean 
	public HavfunService hklistcoService() {
		return new HavfunServiceImpl();
	}
	
	@Bean
	public HavfunConfig hklistcoConfig() {
		HavfunConfig hklistcoConfig = new HavfunConfig();
		
		hklistcoConfig.setGeneratePasswordUrl(generatePasswordUrl);
		hklistcoConfig.setLoginUrl(loginUrl);
		
		return hklistcoConfig;
	}

}
