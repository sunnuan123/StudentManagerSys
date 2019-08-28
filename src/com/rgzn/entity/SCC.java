package com.rgzn.entity;

public class SCC {
	private int sno;
	private String sname;
	private String clzName;
	private int cno;
	private String cname;
	private int credit;
	private int score;
	public SCC() {
	}
	public SCC(int sno, String sname, String clzName, int cno, String cname, int credit, int score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.clzName = clzName;
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.score = score;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getClzName() {
		return clzName;
	}
	public void setClzName(String clzName) {
		this.clzName = clzName;
	}
	public int getCno() {
		return cno;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
