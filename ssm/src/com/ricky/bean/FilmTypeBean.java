package com.ricky.bean;

public class FilmTypeBean {
	private Integer type_id;
	private Integer film_id;
	private String type_name;
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public FilmTypeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FilmTypeBean [type_id=" + type_id + ", film_id=" + film_id + ", type_name=" + type_name + "]";
	}
	
	
}
