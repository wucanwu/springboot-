package com.lepao.comsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lepao.api.entity.Dept;
import com.lepao.api.service.DeptClientService;

@RestController
@RequestMapping("consumer")
public class ComsumerController {

	@Autowired
	private DeptClientService deptService;
	
	
	@GetMapping("/dept/add")
	public boolean add(Dept dept)
	{
		return deptService.add(dept);
	}
	
	@GetMapping(value="/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return deptService.get(id);
	}
	
	@RequestMapping(value="/dept/list")
	public List<Dept> list()
	{
		System.out.println("访问到我了");
		return deptService.list();
	}
}
