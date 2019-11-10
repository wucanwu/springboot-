package com.lepao.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lepao.api.entity.Dept;

public interface DeptMapper extends BaseMapper<Dept> {

	@Select("select * from dept")
	public List<Dept> findAll();
	
	@Select("select * from dept where deptno=#{deptno}")
	public Dept findById(Long deptno);
}
