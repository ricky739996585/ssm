package com.ricky.bean;

public class FilmPicBean {
	private Integer film_pic_id;
	private Integer film_id;
	private String film_pic_url;
	public Integer getFilm_pic_id() {
		return film_pic_id;
	}
	public void setFilm_pic_id(Integer film_pic_id) {
		this.film_pic_id = film_pic_id;
	}
	public Integer getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}
	public String getFilm_pic_url() {
		return film_pic_url;
	}
	public void setFilm_pic_url(String film_pic_url) {
		this.film_pic_url = film_pic_url;
	}
	@Override
	public String toString() {
		return "FilmPicBean [film_pic_id=" + film_pic_id + ", film_id=" + film_id + ", film_pic_url=" + film_pic_url
				+ "]";
	}
	public FilmPicBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
