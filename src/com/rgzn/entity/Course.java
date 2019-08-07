package com.rgzn.entity;

import java.util.Date;

public class Course {
	private String cno;
	private String cname;
	private String credit;
	private Date periodStart;
	private Date periodEnd;

	public Course() {
	}
	public Course(String cno, String cname, String credit, Date periodStart, Date periodEnd) {
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
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
