package com.lepao.comsumer.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class RestTemplateConfig {
	//配置restTemplate
	
	@Bean
	@LoadBalanced  //restTemplate开启ribbon负载均衡
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

	//重新配置随机策略来替代轮询策略
//	@Bean
//	public IRule randomRule()
//	{
//		return new RandomRule();
//	}
	
	
//	@Bean
//	public IRule randomRule()
//	{
//		//当多次访问不通的时候，轮询就不会访问他了
//		return new RetryRule();
//	}
}
