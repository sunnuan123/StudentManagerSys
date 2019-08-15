package com.rgzn.entity;

import java.util.Date;

public class Teacher {
	private int tno;
	private String tname;
	private String tpwd;
	private String tphone;
	private Date hireDate;
	private String remark;
	
	public Teacher() {
	}

	public Teacher(int tno, String tname, String tpwd, String tphone, Date hireDate, String remark) {
		this.tno = tno;
		this.tname = tname;
		this.tpwd = tpwd;
		this.tphone = tphone;
		this.hireDate = hireDate;
		this.remark = remark;
	}

	public Teacher(String tname, String tpwd) {
		this.tname = tname;
		this.tpwd = tpwd;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTpwd() {
		return tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", tpwd=" + tpwd + ", tphone=" + tphone + ", hireDate="
				+ hireDate + ", remark=" + remark + "]";
	}
	
	
	
}
