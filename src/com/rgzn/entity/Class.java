package com.rgzn.entity;

public class Class {
	private int classno;
	private String cname;
	private String cteacher;
	private String classroom;
	
	public Class() {
	}

	public Class(int classno, String cname, String cteacher, String classroom) {
		this.classno = classno;
		this.cname = cname;
		this.cteacher = cteacher;
		this.classroom = classroom;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCteacher() {
		return cteacher;
	}

	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Class [classno=" + classno + ", cname=" + cname + ", cteacher=" + cteacher + ", classroom=" + classroom
				+ "]";
	}
	
	
}
