package com.ricky.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ricky.bean.MusicBean;
import com.ricky.bean.MusicReplyBean;
import com.ricky.dao.MusicDao;
import com.ricky.service.MusicService;

public class MusicServiceImpl implements MusicService {
	private MusicDao musicDao;
	
	
	
	public MusicServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MusicDao getMusicDao() {
		return musicDao;
	}

	public void setMusicDao(MusicDao musicDao) {
		this.musicDao = musicDao;
	}

	@Override
	public ArrayList<MusicBean> getAllMusic() {
		// TODO Auto-generated method stub
		return musicDao.getAllMusic();
	}

	@Override
	public ArrayList<MusicBean> findMusicByName(String music_name) {
		// TODO Auto-generated method stub
		return musicDao.selectByName(music_name);
	}

	@Override
	public MusicBean findMusicById(Integer music_id) {
		// TODO Auto-generated method stub
		return musicDao.selectById(music_id);
	}

	@Override
	public boolean deleteMusic(Integer music_id) {
		// TODO Auto-generated method stub
		return musicDao.deleteById(music_id);
	}

	@Override
	public boolean updateMusic(MusicBean musicBean) {
		// TODO Auto-generated method stub
		return musicDao.updateById(musicBean);
	}

	@Override
	public boolean insertMusic(MusicBean musicBean) {
		// TODO Auto-generated method stub
		return musicDao.insert(musicBean);
	}

	@Override
	public ArrayList<Map<String, Object>> getCollect() {
		// TODO Auto-generated method stub
		return musicDao.getCollect();
	}

	@Override
	public ArrayList<Map<String, Object>> getReply() {
		// TODO Auto-generated method stub
		return musicDao.getReply();
	}

	@Override
	public ArrayList<Map<String, Object>> getHotMusic() {
		// TODO Auto-generated method stub
		return musicDao.orderByCollect();
	}

	@Override
	public ArrayList<Map<String, Object>> getLatestMusic() {
		// TODO Auto-generated method stub
		return musicDao.orderByTime();
	}

	@Override
	public ArrayList<MusicBean> getSortMusic(int start, int row,int page) {
		// TODO Auto-generated method stub
		start=(page-1)*row;
		return musicDao.selectSort(start, row);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return musicDao.getCount();
	}

	@Override
	public ArrayList<MusicBean> getByType(String type, int start, int row,int page) {
		// TODO Auto-generated method stub
		start=(page-1)*row;
		return musicDao.selectByType(type, start, row);
	}

	@Override
	public Map<Integer, Object> getScore() {
		Map<Integer, Object> map1=new HashMap<>();
		ArrayList<Map<String, Object>> arrayList=musicDao.getScore();
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			Map<String, Object> map2 = (Map<String, Object>) iterator.next();
			double score=Double.parseDouble(map2.get("score").toString());
			double people=Double.parseDouble(map2.get("num").toString());
			double svg=score/people;
			map1.put((Integer) map2.get("music_id"), svg);
		}
		return map1;
	}

	@Override
	public ArrayList<Map<String, Object>> getReplyById(int id) {
		// TODO Auto-generated method stub
		return musicDao.getReplyById(id);
	}

	@Override
	public ArrayList<MusicBean> searchByKey(String key) {
		// TODO Auto-generated method stub
		key="%"+key+"%";
		return musicDao.searchByKey(key);
	}

	@Override
	public ArrayList<Map<String, Object>> getCollectByUser(int id) {
		// TODO Auto-generated method stub
		return musicDao.getCollectByUser(id);
	}

	@Override
	public boolean insertCollectMusic(int user_id, int music_id) {
		// TODO Auto-generated method stub
		return musicDao.insertCollectMusic(user_id, music_id);
	}

	@Override
	public boolean insertReplyByUser(MusicReplyBean musicReplyBean) {
		// TODO Auto-generated method stub
		return musicDao.insertReplyByUser(musicReplyBean);
	}

}
