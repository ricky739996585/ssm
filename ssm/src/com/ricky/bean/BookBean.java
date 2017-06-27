package com.ricky.bean;

public class BookBean {
	private Integer book_id;
	private String book_name;
	private String book_time;
	private String book_author;
	private String book_publish;
	private String book_img;
	private String book_url;
	private String book_type;
	private String book_summary;
	private String author_summary;
	
	
	
	public String getBook_summary() {
		return book_summary;
	}
	public void setBook_summary(String book_summary) {
		this.book_summary = book_summary;
	}
	public String getAuthor_summary() {
		return author_summary;
	}
	public void setAuthor_summary(String author_summary) {
		this.author_summary = author_summary;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_time() {
		return book_time;
	}
	public void setBook_time(String book_time) {
		this.book_time = book_time;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_publish() {
		return book_publish;
	}
	public void setBook_publish(String book_publish) {
		this.book_publish = book_publish;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public String getBook_url() {
		return book_url;
	}
	public void setBook_url(String book_url) {
		this.book_url = book_url;
	}
	public BookBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookBean [book_id=" + book_id + ", book_name=" + book_name + ", book_time=" + book_time
				+ ", book_author=" + book_author + ", book_publish=" + book_publish + ", book_img=" + book_img
				+ ", book_url=" + book_url + "]";
	}
	
	
}
