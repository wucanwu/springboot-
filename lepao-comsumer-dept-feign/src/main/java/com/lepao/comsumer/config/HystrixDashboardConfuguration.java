package com.lepao.comsumer.config;

import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

//配置dashboard的servlet,1.0不需要配置这个servelt
@Configuration
public class HystrixDashboardConfuguration {
	
	
	@Bean
	public ServletRegistrationBean getServlet()
	{
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> registration = new ServletRegistrationBean<>(streamServlet);
		registration.setLoadOnStartup(1);
		registration.addUrlMappings("/hystrix.stream");
		registration.setName("HystrixMetricsStreamServlet");
		return registration;
		
	}
}
