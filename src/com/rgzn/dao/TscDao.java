package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Course;

public interface TscDao {
	//添加
	public int insertTsc(int sno, int tno, int cno);
	//根据学号查询
	public List<Course> selectAllBySno(int sno);
	//删除一条数据
	public int delOne(int sno, int tno, int cno);
	
}
