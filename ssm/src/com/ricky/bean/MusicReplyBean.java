package com.ricky.bean;

public class MusicReplyBean {
	private Integer music_reply_id;
	private Integer music_id;
	private Integer user_id;
	private String music_reply_content;
	private Integer music_reply_score;
	private String music_reply_time;
	public Integer getMusic_reply_id() {
		return music_reply_id;
	}
	public void setMusic_reply_id(Integer music_reply_id) {
		this.music_reply_id = music_reply_id;
	}
	public Integer getMusic_id() {
		return music_id;
	}
	public void setMusic_id(Integer music_id) {
		this.music_id = music_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getMusic_reply_content() {
		return music_reply_content;
	}
	public void setMusic_reply_content(String music_reply_content) {
		this.music_reply_content = music_reply_content;
	}
	public Integer getMusic_reply_score() {
		return music_reply_score;
	}
	public void setMusic_reply_score(Integer music_reply_score) {
		this.music_reply_score = music_reply_score;
	}
	public String getMusic_reply_time() {
		return music_reply_time;
	}
	public void setMusic_reply_time(String music_reply_time) {
		this.music_reply_time = music_reply_time;
	}
	public MusicReplyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MusicReplyBean [music_reply_id=" + music_reply_id + ", music_id=" + music_id + ", user_id=" + user_id
				+ ", music_reply_content=" + music_reply_content + ", music_reply_score=" + music_reply_score
				+ ", music_reply_time=" + music_reply_time + "]";
	}
	
}
