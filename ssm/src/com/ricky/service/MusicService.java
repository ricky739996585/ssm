package com.ricky.service;

import java.util.ArrayList;
import java.util.Map;

import com.ricky.bean.ActyBean;
import com.ricky.bean.FilmReplyBean;
import com.ricky.bean.MusicBean;
import com.ricky.bean.MusicReplyBean;
import com.ricky.bean.UserBean;

public interface MusicService {
	// 获取所有音乐
	public ArrayList<MusicBean> getAllMusic();

	// 查询音乐
	public ArrayList<MusicBean> findMusicByName(String music_name);

	// 根据ID获取音乐
	public MusicBean findMusicById(Integer music_id);

	// 根据音乐ID删除
	public boolean deleteMusic(Integer music_id);

	// 更新音乐根据音乐ID
	public boolean updateMusic(MusicBean musicBean);

	// 插入新音乐
	public boolean insertMusic(MusicBean musicBean);

	// 获取音乐收藏情况
	public ArrayList<Map<String, Object>> getCollect();

	// 获取音乐评论情况
	public ArrayList<Map<String, Object>> getReply();

	// 根据收藏量来获取热门歌曲
	public ArrayList<Map<String, Object>> getHotMusic();

	// 根据上架时间来获取最新歌曲
	public ArrayList<Map<String, Object>> getLatestMusic();

	// 获取分页音乐
	public ArrayList<MusicBean> getSortMusic(int start, int row, int page);

	// 获取音乐总数量
	public Integer getCount();

	// 根据音乐类型获取音乐
	public ArrayList<MusicBean> getByType(String type, int start, int row, int page);

	// 获取音乐的平均评价
	public Map<Integer, Object> getScore();

	// 获取一条音乐的评论
	public ArrayList<Map<String, Object>> getReplyById(int id);

	// 根据关键词来搜索音乐
	public ArrayList<MusicBean> searchByKey(String key);
	
	//根据用户收藏来获取音乐
	public ArrayList<Map<String, Object>> getCollectByUser(int id);
	
	//用户收藏音乐操作
	public boolean insertCollectMusic(int user_id,int music_id);
	
	//用户对音乐进行评论
	public boolean insertReplyByUser(MusicReplyBean musicReplyBean);
}
