package com.ricky.service;

import java.util.ArrayList;
import java.util.Map;

import com.mysql.fabric.xmlrpc.base.Array;
import com.ricky.bean.ActyBean;
import com.ricky.bean.ActyReplyBean;
import com.ricky.bean.MusicBean;

public interface ActyService {
	// 获取所有活动
	public ArrayList<ActyBean> getAllActy();

	// 查询活动
	public ActyBean findActyByTitle(String acty_title);

	// 根据ID获取活动
	public ActyBean findActyById(Integer acty_id);

	// 根据活动状态来查询
	public ArrayList<ActyBean> findActyByStatus(String status);

	// 根据活动ID删除
	public boolean deleteActy(Integer acty_id);

	// 更新活动根据活动ID
	public boolean updateActy(ActyBean actyBean);

	// 插入新活动
	public boolean insertActy(ActyBean actyBean);

	// 获取活动评论情况
	public ArrayList<Map<String, Object>> getReply();

	// 获取一个活动的信息
	public Map<String, Object> getActy(Integer acty_id);

	// 获取审核状态的活动
	public ArrayList<ActyBean> getStatus(String status);

	// 更新活动的状态
	public boolean updateStatus(ActyBean actyBean);

	// 根据收藏量来获取热门活动
	public ArrayList<ActyBean> getHotActy();

	// 根据上映时间来获取最新活动
	public ArrayList<ActyBean> getLatestActy();

	// 获取分页活动
	public ArrayList<Map<String, Object>> getSortActy(int start, int row, int page);

	// 获取活动总数量
	public Integer getCount();

	// 根据活动类型获取活动
	public ArrayList<Map<String, Object>> getByType(String type, int start, int row, int page);

	// 获取一条活动的评论
	public ArrayList<Map<String, Object>> getReplyById(int id);

	// 根据关键词来搜索活动
	public ArrayList<Map<String, Object>> searchByKey(String key);
	
	//用户发表活动
	public boolean insertActyByUser(ActyBean actyBean);
	
	//用户对活动评论
	public boolean insertReplyByUser(ActyReplyBean actyReplyBean);
}
