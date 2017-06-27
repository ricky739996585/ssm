package com.ricky.bean;

public class ActyReplyBean {
	private Integer reply_id;
	private Integer user_id;
	private Integer acty_id;
	private String reply_content;
	private String reply_time;
	public Integer getReply_id() {
		return reply_id;
	}
	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getActy_id() {
		return acty_id;
	}
	public void setActy_id(Integer acty_id) {
		this.acty_id = acty_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_time() {
		return reply_time;
	}
	public void setReply_time(String reply_time) {
		this.reply_time = reply_time;
	}
	public ActyReplyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ActyReplyBean [reply_id=" + reply_id + ", user_id=" + user_id + ", acty_id=" + acty_id
				+ ", reply_content=" + reply_content + ", reply_time=" + reply_time + "]";
	}
	
	
}
