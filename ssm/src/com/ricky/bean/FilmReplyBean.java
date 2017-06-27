package com.ricky.bean;

public class FilmReplyBean {
	private Integer film_reply_id;
	private Integer film_id;
	private Integer user_id;
	private String film_reply_content;
	private Integer film_reply_score;
	private String film_reply_time;
	public Integer getFilm_reply_id() {
		return film_reply_id;
	}
	public void setFilm_reply_id(Integer film_reply_id) {
		this.film_reply_id = film_reply_id;
	}
	public Integer getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getFilm_reply_content() {
		return film_reply_content;
	}
	public void setFilm_reply_content(String film_reply_content) {
		this.film_reply_content = film_reply_content;
	}
	public Integer getFilm_reply_score() {
		return film_reply_score;
	}
	public void setFilm_reply_score(Integer film_reply_score) {
		this.film_reply_score = film_reply_score;
	}
	public String getFilm_reply_time() {
		return film_reply_time;
	}
	public void setFilm_reply_time(String film_reply_time) {
		this.film_reply_time = film_reply_time;
	}
	public FilmReplyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FilmReplyBean [film_reply_id=" + film_reply_id + ", film_id=" + film_id + ", user_id=" + user_id
				+ ", film_reply_content=" + film_reply_content + ", film_reply_score=" + film_reply_score
				+ ", film_reply_time=" + film_reply_time + "]";
	}
	
}
