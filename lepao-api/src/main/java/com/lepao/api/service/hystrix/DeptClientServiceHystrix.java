package com.lepao.api.service.hystrix;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lepao.api.entity.Dept;
import com.lepao.api.service.DeptClientService;


//熔断器类
@Component
public class DeptClientServiceHystrix implements DeptClientService{

	@Override
	public Dept get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Dept> list() {
		Dept dept = new Dept();
		dept.setDname("wucanwu");
		dept.setDbSource("1");
		LinkedList<Dept> depts = new LinkedList<>();
		depts.add(dept);
		return depts;
	}

}
