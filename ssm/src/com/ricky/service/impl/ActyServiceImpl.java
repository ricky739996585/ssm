package com.ricky.service.impl;

import java.util.ArrayList;
import java.util.Map;

import com.ricky.bean.ActyBean;
import com.ricky.bean.ActyReplyBean;
import com.ricky.dao.ActyDao;
import com.ricky.service.ActyService;

public class ActyServiceImpl implements ActyService {
	private ActyDao actyDao;
	
	public ActyDao getActyDao() {
		return actyDao;
	}

	public void setActyDao(ActyDao actyDao) {
		this.actyDao = actyDao;
	}

	public ActyServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ActyBean> getAllActy() {
		// TODO Auto-generated method stub
		return actyDao.getAllActy();
	}

	@Override
	public ActyBean findActyByTitle(String acty_title) {
		// TODO Auto-generated method stub
		return actyDao.selectByTitle(acty_title);
	}

	@Override
	public ActyBean findActyById(Integer acty_id) {
		// TODO Auto-generated method stub
		return actyDao.selectById(acty_id);
	}

	@Override
	public ArrayList<ActyBean> findActyByStatus(String status) {
		// TODO Auto-generated method stub
		return actyDao.selectByStatus(status);
	}

	@Override
	public boolean deleteActy(Integer acty_id) {
		// TODO Auto-generated method stub
		return actyDao.deleteById(acty_id);
	}

	@Override
	public boolean updateActy(ActyBean actyBean) {
		// TODO Auto-generated method stub
		return actyDao.updateById(actyBean);
	}

	@Override
	public boolean insertActy(ActyBean actyBean) {
		// TODO Auto-generated method stub
		return actyDao.insert(actyBean);
	}

	@Override
	public ArrayList<Map<String, Object>> getReply() {
		// TODO Auto-generated method stub
		return actyDao.getReply();
	}

	@Override
	public Map<String, Object> getActy(Integer acty_id) {
		// TODO Auto-generated method stub
		return actyDao.getActy(acty_id);
	}

	@Override
	public ArrayList<ActyBean> getStatus(String status) {
		// TODO Auto-generated method stub
		return actyDao.getStatus(status);
	}

	@Override
	public boolean updateStatus(ActyBean actyBean) {
		// TODO Auto-generated method stub
		return actyDao.updateStatus(actyBean);
	}

	@Override
	public ArrayList<ActyBean> getHotActy() {
		// TODO Auto-generated method stub
		return actyDao.orderByPeople();
	}

	@Override
	public ArrayList<ActyBean> getLatestActy() {
		// TODO Auto-generated method stub
		return actyDao.orderByTime();
	}

	@Override
	public ArrayList<Map<String, Object>> searchByKey(String key) {
		// TODO Auto-generated method stub
		key="%"+key+"%";
		return actyDao.searchByKey(key);
	}

	@Override
	public ArrayList<Map<String, Object>> getSortActy(int start, int row, int page) {
		// TODO Auto-generated method stub
		start=(page-1)*row;
		return actyDao.selectSort(start, row);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return actyDao.getCount();
	}

	@Override
	public ArrayList<Map<String, Object>> getByType(String type, int start, int row, int page) {
		// TODO Auto-generated method stub
		start=(page-1)*row;
		return actyDao.selectByType(type, start, row);
	}

	@Override
	public ArrayList<Map<String, Object>> getReplyById(int id) {
		// TODO Auto-generated method stub
		return actyDao.getReplyById(id);
	}

	@Override
	public boolean insertActyByUser(ActyBean actyBean) {
		// TODO Auto-generated method stub
		return actyDao.insertActyByUser(actyBean);
	}

	@Override
	public boolean insertReplyByUser(ActyReplyBean actyReplyBean) {
		// TODO Auto-generated method stub
		return actyDao.insertReplyByUser(actyReplyBean);
	}

}
