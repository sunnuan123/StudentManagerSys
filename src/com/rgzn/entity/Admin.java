package com.rgzn.entity;

import java.util.Date;

public class Admin {
	private String ano;
	private String name;
	private String pwd;
	private String phone;
	private String email;
	private String gender;
	private Date employdate;
	private String hobby;
	private String remark;
	
	public Admin() {
	}

	
	public Admin(String ano, String name, String pwd, String phone, String email, String gender, String remark) {
		this.ano = ano;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.remark = remark;
	}


	public Admin(String name, String pwd, String phone, String email, String gender, Date employdate, String hobby,
			String remark) {
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.employdate = employdate;
		this.hobby = hobby;
		this.remark = remark;
	}
	
	
	public Admin(String ano, String name, String pwd, String phone, String email, String gender, Date employdate,
			String hobby, String remark) {
		super();
		this.ano = ano;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.employdate = employdate;
		this.hobby = hobby;
		this.remark = remark;
	}


	public Date getEmploydate() {
		return employdate;
	}
	public void setEmploydate(Date employdate) {
		this.employdate = employdate;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "Admin [ano=" + ano + ", name=" + name + ", pwd=" + pwd + ", phone=" + phone + ", email=" + email
				+ ", gender=" + gender + ", remark=" + remark + "]";
	}
	
	
}
