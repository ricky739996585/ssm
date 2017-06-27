package com.ricky.bean;

public class ActyBean {
	private Integer acty_id;
	private Integer user_id;
	private String acty_title;
	private String acty_content;
	private String acty_time;
	private Integer acty_people;
	private String acty_img;
	private String acty_status;
	private String acty_type;
	
	public String getActy_type() {
		return acty_type;
	}
	public void setActy_type(String acty_type) {
		this.acty_type = acty_type;
	}
	public Integer getActy_id() {
		return acty_id;
	}
	public void setActy_id(Integer acty_id) {
		this.acty_id = acty_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getActy_title() {
		return acty_title;
	}
	public void setActy_title(String acty_title) {
		this.acty_title = acty_title;
	}
	public String getActy_content() {
		return acty_content;
	}
	public void setActy_content(String acty_content) {
		this.acty_content = acty_content;
	}
	public String getActy_time() {
		return acty_time;
	}
	public void setActy_time(String acty_time) {
		this.acty_time = acty_time;
	}
	public Integer getActy_people() {
		return acty_people;
	}
	public void setActy_people(Integer acty_people) {
		this.acty_people = acty_people;
	}
	public String getActy_img() {
		return acty_img;
	}
	public void setActy_img(String acty_img) {
		this.acty_img = acty_img;
	}
	
	public String getActy_status() {
		return acty_status;
	}
	public void setActy_status(String acty_status) {
		this.acty_status = acty_status;
	}
	public ActyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ActyBean [acty_id=" + acty_id + ", user_id=" + user_id + ", acty_title=" + acty_title
				+ ", acty_content=" + acty_content + ", acty_time=" + acty_time + ", acty_people=" + acty_people
				+ ", acty_img=" + acty_img + ", acty_status=" + acty_status + ", acty_type=" + acty_type + "]";
	}
	
	
}
