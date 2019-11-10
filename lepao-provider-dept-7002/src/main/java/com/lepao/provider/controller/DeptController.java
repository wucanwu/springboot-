package com.lepao.provider.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lepao.api.entity.Dept;
import com.lepao.provider.service.DeptService;

@RestController
@RequestMapping("dept")
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@PostMapping("add")
	public boolean add(@RequestBody Dept dept)
	{
		return deptService.addDept(dept);
	}
	
	@GetMapping("/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return deptService.findById(id);
	}

	@GetMapping("list")
	public List<Dept> list()
	{
		return deptService.findAll();
	}
}
