package com.ricky.bean;

public class AdminBean {
	private Integer admin_id;
	private String admin_name;
	private String admin_psw;
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_psw() {
		return admin_psw;
	}
	public void setAdmin_psw(String admin_psw) {
		this.admin_psw = admin_psw;
	}
	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminBean [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_psw=" + admin_psw + "]";
	}
	
	
}
