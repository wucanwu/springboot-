package com.lepao.comsumer.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lepao.api.entity.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("consumer")
public class ComsumerController {

	private static final String REST_URL_PREFIX="http://PROVIDER7001";
	@Autowired
	private RestTemplate restTemplate; //得到restTemplate
	
	
	@GetMapping("/dept/add")
	public boolean add(Dept dept)
	{
		//第二个参数是参数，第三个是返回类型
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	
	@GetMapping(value="/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
	}
	
	@HystrixCommand(fallbackMethod="hiError")  //指定熔断以后需要调用的方法
	@RequestMapping(value="/dept/list")
	public List<Dept> list()
	{
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
	}
	
	
	//熔断器垄断以后需要调用的方法,参数和返回类型必须相同，5秒钟内20次调用不同就会调用熔断器方法
	public List<Dept> hiError()
	{
		Dept dept = new Dept();
		dept.setDname("wucanwu");
		dept.setDbSource("1");
		LinkedList<Dept> depts = new LinkedList<>();
		depts.add(dept);
		return depts;
	}
	
	
}
