package com.ricky.service;

import java.util.ArrayList;
import java.util.Map;

import com.ricky.bean.ActyBean;
import com.ricky.bean.BookReplyBean;
import com.ricky.bean.FilmBean;
import com.ricky.bean.FilmPicBean;
import com.ricky.bean.FilmReplyBean;
import com.ricky.bean.FilmTypeBean;
import com.ricky.bean.MusicBean;
import com.ricky.bean.UserBean;

public interface FilmService {
	// 获取所有电影
	public ArrayList<FilmBean> getAllFilm();

	// 查询电影
	public ArrayList<FilmBean> findFilmByName(String film_name);

	// 根据ID获取电影
	public FilmBean findFilmById(Integer film_id);

	// 根据电影ID删除
	public boolean deleteFilm(Integer film_id);

	// 更新电影根据电影ID
	public boolean updateFilm(FilmBean filmBean);

	// 插入新电影
	public boolean insertFilm(FilmBean filmBean);

	// 插入电影类型
	public boolean insertFilmType(ArrayList<FilmTypeBean> arrayListFilmType);

	// 获取电影收藏情况
	public ArrayList<Map<String, Object>> getCollect();

	// 获取电影评论情况
	public ArrayList<Map<String, Object>> getReply();

	// 获取电影类型
	public ArrayList<FilmTypeBean> getFilmType(Integer film_id);

	// 根据收藏量来获取热门电影
	public ArrayList<Map<String, Object>> getHotFilm();

	// 根据上映时间来获取最新电影
	public ArrayList<Map<String, Object>> getLatestFilm();

	// 获取分页电影
	public ArrayList<FilmBean> getSortFilm(int start, int row, int page);

	// 获取电影总数量
	public Integer getCount();

	// 根据电影类型获取电影
	public ArrayList<Map<String, Object>> getByType(String type, int start, int row, int page);

	// 获取电影的平均评价
	public Map<Integer, Object> getScore();

	// 获取一条电影的评论
	public ArrayList<Map<String, Object>> getReplyById(int id);

	// 插入电影剧照
	public boolean insertPic(FilmPicBean filmPicBean);

	// 获取电影的剧照
	public ArrayList<FilmPicBean> getFilmStills(int id);

	// 根据关键词来搜索电影
	public ArrayList<FilmBean> searchByKey(String key);

	// 根据用户收藏来获取电影
	public ArrayList<Map<String, Object>> getCollectByUser(int id);
	
	//用户收藏电影操作
	public boolean insertCollectFilm(int user_id,int film_id);
	
	//用户对电影进行评论
	public boolean insertReplyByUser(FilmReplyBean filmReplyBean);
}
