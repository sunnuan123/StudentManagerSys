package com.rgzn.entity;

import java.util.Date;

public class Student {
	private String sno;
	private String name;
	private String pwd;
	private String  phone;
	private String gender;
	private Date birthday;
	private int classno;
	private String remark;
	private Class clz;
	
	
	
	public Student() {
	}
	
	
	
	public Student(String name, String pwd, String phone, String gender, Date birthday, int classno, String remark) {
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
		this.classno = classno;
		this.remark = remark;
	}



	public Student(String sno, String name, String pwd, String phone, String gender, Date birthday, int classno,
			String remark) {
		this.sno = sno;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
		this.classno = classno;
		this.remark = remark;
	}
	

	
	public Student(String sno, String name, String pwd, String phone, String gender, Date birthday, int classno,
			String remark, Class clz) {
		this.sno = sno;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
		this.classno = classno;
		this.remark = remark;
		this.clz = clz;
	}



	public Class getClz() {
		return clz;
	}



	public void setClz(Class clz) {
		this.clz = clz;
	}



	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", pwd=" + pwd + ", phone=" + phone + ", gender=" + gender
				+ ", birthday=" + birthday + ", classno=" + classno + ", remark=" + remark + "]";
	}
	
	
	

}
