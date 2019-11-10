package com.lepao.api.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lepao.api.entity.Dept;
import com.lepao.api.service.hystrix.DeptClientServiceHystrix;

//feign的熔断本身就包含，只要打开就好
@FeignClient(value="PROVIDER7001",fallback=DeptClientServiceHystrix.class)  //添加熔断器类
public interface DeptClientService {

	@GetMapping(value="/dept/get/{id}")
	public Dept get(@PathVariable("id") long id);
	
	
	@PostMapping("/dept/add")
	public boolean add(Dept dept);
	
	@GetMapping(value="/dept/list")
	public List<Dept> list();
}
