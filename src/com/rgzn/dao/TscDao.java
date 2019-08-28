package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Course;
import com.rgzn.entity.SCC;

public interface TscDao {
	//添加
	public int insertTsc(int sno, int tno, int cno);
	//根据学号查询
	public List<Course> selectAllBySno(int sno);
	//删除一条数据
	public int delOne(int sno, int tno, int cno);
	//老师查询对应的课程并评分
	public List<SCC> selectAllStu(int tno);
	//修改t_sc表的score字段
	public int updateScore(int score, int sno, int cno, int tno);
	
}
