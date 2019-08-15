package com.rgzn.entity;

import java.util.Date;

public class Course {
	private int cno;
	private String cname;
	private int credit;
	private Date periodStart;
	private Date periodEnd;
	private Teacher teacher;
	
	
	public Course() {
	}
	public Course(int cno, String cname, int credit, Date periodStart, Date periodEnd) {
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}
	
	public int getCno() {
		return cno;
	}
	
	
	public Course(int cno, String cname, int credit, Date periodStart, Date periodEnd, Teacher teacher) {
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
		this.teacher = teacher;
	}
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public Course(String cname, int credit, Date periodStart, Date periodEnd) {
		super();
		this.cname = cname;
		this.credit = credit;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}
	public Date getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}
	public Date getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}

	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cname=" + cname + ", credit=" + credit + ", periodStart=" + periodStart
				+ ", periodEnd=" + periodEnd + "]";
	}
	
	
	
}
