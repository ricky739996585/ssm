package com.ricky.bean;

public class BookReplyBean {
	private Integer book_reply_id;
	private Integer book_id;
	private Integer user_id;
	private String book_reply_content;
	private Integer book_reply_score;
	private String book_reply_time;
	public Integer getBook_reply_id() {
		return book_reply_id;
	}
	public void setBook_reply_id(Integer book_reply_id) {
		this.book_reply_id = book_reply_id;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getBook_reply_content() {
		return book_reply_content;
	}
	public void setBook_reply_content(String book_reply_content) {
		this.book_reply_content = book_reply_content;
	}
	public Integer getBook_reply_score() {
		return book_reply_score;
	}
	public void setBook_reply_score(Integer book_reply_score) {
		this.book_reply_score = book_reply_score;
	}
	public String getBook_reply_time() {
		return book_reply_time;
	}
	public void setBook_reply_time(String book_reply_time) {
		this.book_reply_time = book_reply_time;
	}
	public BookReplyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookReplyBean [book_reply_id=" + book_reply_id + ", book_id=" + book_id + ", user_id=" + user_id
				+ ", book_reply_content=" + book_reply_content + ", book_reply_score=" + book_reply_score
				+ ", book_reply_time=" + book_reply_time + "]";
	}
	
}
