package com.rgzn.entity;

public class TeaAndCou {
	private int cno;
	private int tno;
	

	public TeaAndCou(int cno, int tno) {
		this.cno = cno;
		this.tno = tno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	@Override
	public String toString() {
		return "TeaAndCou [cno=" + cno + ", tno=" + tno + "]";
	}

	
}
