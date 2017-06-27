package com.ricky.service;

import java.util.ArrayList;
import java.util.Map;

import com.ricky.bean.ActyBean;
import com.ricky.bean.BookBean;
import com.ricky.bean.BookReplyBean;
import com.ricky.bean.MusicBean;

public interface BookService {
	// 获取所有图书
	public ArrayList<BookBean> getAllBook();

	// 查询图书
	public ArrayList<BookBean> findBookByName(String book_name);

	// 根据ID获取图书
	public BookBean findBookById(Integer book_id);

	// 根据图书ID删除
	public boolean deleteBook(Integer book_id);

	// 更新图书根据图书ID
	public boolean updateBook(BookBean bookBean);

	// 插入新图书
	public boolean insertBook(BookBean bookBean);

	// 获取图书收藏情况
	public ArrayList<Map<String, Object>> getCollect();

	// 获取图书评论情况
	public ArrayList<Map<String, Object>> getReply();

	// 根据收藏量来获取热门图书
	public ArrayList<Map<String, Object>> getHotBook();

	// 根据上映时间来获取最新图书
	public ArrayList<Map<String, Object>> getLatestBook();

	// 获取分页图书
	public ArrayList<BookBean> getSortMusic(int start, int row, int page);

	// 获取图书总数量
	public Integer getCount();

	// 根据图书类型获取图书
	public ArrayList<BookBean> getByType(String type, int start, int row, int page);

	// 获取图书的平均评价
	public Map<Integer, Object> getScore();

	// 获取一条图书的评论
	public ArrayList<Map<String, Object>> getReplyById(int id);

	// 根据关键词来搜索图书
	public ArrayList<BookBean> searchByKey(String key);

	// 根据用户收藏来获取图书
	public ArrayList<Map<String, Object>> getCollectByUser(int id);

	// 用户收藏图书操作
	public boolean insertCollectBook(int user_id, int book_id);
	
	//用户对图书进行评论
	public boolean insertReplyByUser(BookReplyBean bookReplyBean);
}
