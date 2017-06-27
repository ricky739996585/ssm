package com.ricky.bean;

import java.io.Serializable;
/*
 * create table tb_user
(
   user_id              int not null auto_increment,
   user_name            varchar(20) not null,
   user_psw             char(20) not null,
   user_nick            char(20) not null,
   user_time            datetime not null,
   user_status          varchar(2) not null,
   user_head        text,
   primary key (user_id),
   key AK_Identifier_2 (user_name)
);
 */
import java.util.Date;
public class UserBean implements Serializable {
	private Integer user_id;
	private String user_name;
	private String user_psw;
	private String user_sex;
	private String user_nick;
	private String user_time;
	private String user_status;
	private String user_head;
	
	public UserBean() {
		super();
	}
	
	
	public String getUser_sex() {
		return user_sex;
	}


	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}


	public UserBean(String user_name, String user_psw, String user_nick, String user_time, String user_status) {
		super();
		this.user_name = user_name;
		this.user_psw = user_psw;
		this.user_nick = user_nick;
		this.user_time = user_time;
		this.user_status = user_status;
	}

	public UserBean(String user_name, String user_psw, String user_nick, String user_status) {
		super();
		this.user_name = user_name;
		this.user_psw = user_psw;
		this.user_nick = user_nick;
		this.user_status = user_status;
	}

	

	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", user_name=" + user_name + ", user_psw=" + user_psw + ", user_sex="
				+ user_sex + ", user_nick=" + user_nick + ", user_time=" + user_time + ", user_status=" + user_status
				+ ", user_head=" + user_head + "]";
	}


	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		System.out.println("id");
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_psw() {
		return user_psw;
	}
	public void setUser_psw(String user_psw) {
		this.user_psw = user_psw;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_time() {
		return user_time;
	}
	public void setUser_time(String user_time) {
		this.user_time = user_time;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getUser_head() {
		return user_head;
	}
	public void setUser_head(String user_head) {
		this.user_head = user_head;
	}
	
}
