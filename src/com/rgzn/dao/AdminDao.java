package com.rgzn.dao;

import com.rgzn.entity.Admin;

public interface AdminDao {
	//查询单个
	public Admin selectOne(String userName, String passWord);
	//插入数据
	public int insert(Admin admin);
	
	
}
