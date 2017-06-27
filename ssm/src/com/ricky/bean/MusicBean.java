package com.ricky.bean;

import java.io.Serializable;
import java.util.Date;
/*
 * create table tb_music
(
   music_id             int not null auto_increment,
   music_name           char(20) not null,
   music_time           datetime not null,
   music_author         char(15) not null,
   music_num            int not null default 0,
   music_type           char(20) not null,
   primary key (music_id),
   key AK_Identifier_2 (music_name)
);

 */
public class MusicBean implements Serializable {
		private Integer music_id;
		private String music_name;
		private String music_time;
		private String music_type;
		private String music_singer;
		private String music_img;
		private String music_lyric;
		private String music_play;
		
		public MusicBean() {
			super();
		}

		public Integer getMusic_id() {
			return music_id;
		}

		public void setMusic_id(Integer music_id) {
			this.music_id = music_id;
		}

		public String getMusic_name() {
			return music_name;
		}

		public void setMusic_name(String music_name) {
			this.music_name = music_name;
		}

		public String getMusic_time() {
			return music_time;
		}

		public void setMusic_time(String music_time) {
			this.music_time = music_time;
		}

		public String getMusic_type() {
			return music_type;
		}

		public void setMusic_type(String music_type) {
			this.music_type = music_type;
		}

		public String getMusic_singer() {
			return music_singer;
		}

		public void setMusic_singer(String music_singer) {
			this.music_singer = music_singer;
		}

		public String getMusic_img() {
			return music_img;
		}

		public void setMusic_img(String music_img) {
			this.music_img = music_img;
		}

		public String getMusic_lyric() {
			return music_lyric;
		}

		public void setMusic_lyric(String music_lyric) {
			this.music_lyric = music_lyric;
		}

		public String getMusic_play() {
			return music_play;
		}

		public void setMusic_play(String music_play) {
			this.music_play = music_play;
		}

		@Override
		public String toString() {
			return "MusicBean [music_id=" + music_id + ", music_name=" + music_name + ", music_time=" + music_time
					+ ", music_type=" + music_type + ", music_singer=" + music_singer + ", music_img=" + music_img
					+ ", music_lyric=" + music_lyric + ", music_play=" + music_play + "]";
		}
		
		
}
