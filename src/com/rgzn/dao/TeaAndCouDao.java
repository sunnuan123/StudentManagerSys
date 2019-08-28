package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Course;
import com.rgzn.entity.TeaAndCou;

public interface TeaAndCouDao {
	//插入一条数据
	public int insertTeaAndCou(TeaAndCou teaAndCou);
	//删除一条数据
	public int delOneTc(int tno, int cno);
	//查询学生没有选择的老师对应的课程
	public List<Course> selectTeaAndCou(int sno);
	
	
}
