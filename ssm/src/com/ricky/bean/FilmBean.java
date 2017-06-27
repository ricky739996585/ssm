package com.ricky.bean;

import java.io.Serializable;
import java.util.Date;

public class FilmBean implements Serializable {
		private Integer film_id;
		private String film_name;
		private String film_diretor;
		private String film_actor;
		private String film_time;
		private String film_summary;
		private String film_detail;
		private String film_url;
		private String film_img;
		
		public FilmBean() {
			super();
		}

		public Integer getFilm_id() {
			return film_id;
		}

		public void setFilm_id(Integer film_id) {
			this.film_id = film_id;
		}

		public String getFilm_name() {
			return film_name;
		}

		public void setFilm_name(String film_name) {
			this.film_name = film_name;
		}

		public String getFilm_diretor() {
			return film_diretor;
		}

		public void setFilm_diretor(String film_diretor) {
			this.film_diretor = film_diretor;
		}

		public String getFilm_actor() {
			return film_actor;
		}

		public void setFilm_actor(String film_actor) {
			this.film_actor = film_actor;
		}

		public String getFilm_time() {
			return film_time;
		}

		public void setFilm_time(String film_time) {
			this.film_time = film_time;
		}

		public String getFilm_summary() {
			return film_summary;
		}

		public void setFilm_summary(String film_summary) {
			this.film_summary = film_summary;
		}

		public String getFilm_detail() {
			return film_detail;
		}

		public void setFilm_detail(String film_detail) {
			this.film_detail = film_detail;
		}

		public String getFilm_url() {
			return film_url;
		}

		public void setFilm_url(String film_url) {
			this.film_url = film_url;
		}

		public String getFilm_img() {
			return film_img;
		}

		public void setFilm_img(String film_img) {
			this.film_img = film_img;
		}

		@Override
		public String toString() {
			return "FilmBean [film_id=" + film_id + ", film_name=" + film_name + ", film_diretor=" + film_diretor
					+ ", film_actor=" + film_actor + ", film_time=" + film_time + ", film_summary=" + film_summary
					+ ", film_detail=" + film_detail + ", film_url=" + film_url + ", film_img=" + film_img + "]";
		}
		
}
