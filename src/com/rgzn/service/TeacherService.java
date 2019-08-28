package com.rgzn.service;

import java.util.List;

import com.rgzn.entity.SCC;
import com.rgzn.entity.Teacher;

public interface TeacherService {
	//根据名字和密码查询
	public Teacher findByNameAndPWd(String name, String pwd);
	//老师查询对应的课程
	public List<SCC> findAllStu(int tno);
	//评分
	public int setScore(int score, int sno, int cno, int tno);
}
