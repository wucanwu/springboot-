package com.lepao.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lepao.api.entity.Dept;
import com.lepao.provider.mapper.DeptMapper;

@Service
public class DeptService {
	@Autowired
	private DeptMapper deptMapper;
	
	public boolean addDept(Dept dept)
	{
		int i = deptMapper.insert(dept);
		if(i==1)
		{
			return true;
		}else{
			return false;
		}
	}
	
	public List<Dept> findAll(){
		return deptMapper.findAll();
	}
	
	public Dept findById(Long deptno)
	{
		return deptMapper.findById(deptno);
	}
}
