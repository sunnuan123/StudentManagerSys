package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Class;


public interface ClassDao {
	
	//查询所有的班级
	public List<Class> selectAllClass();
	
}
