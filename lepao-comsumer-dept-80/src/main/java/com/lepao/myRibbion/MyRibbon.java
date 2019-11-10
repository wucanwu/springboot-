package com.lepao.myRibbion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MyRibbon {

	
	@Bean
	public IRule myRule()
	{
		//使用自定义的ribbion规则
		return new MyDefineRibbon();
	}
}
