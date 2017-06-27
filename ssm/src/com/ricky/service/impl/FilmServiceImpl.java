package com.ricky.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ricky.bean.FilmBean;
import com.ricky.bean.FilmPicBean;
import com.ricky.bean.FilmReplyBean;
import com.ricky.bean.FilmTypeBean;
import com.ricky.dao.FilmDao;
import com.ricky.service.FilmService;

public class FilmServiceImpl implements FilmService{
	private FilmDao filmDao;
	
	
	
	public FilmServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FilmDao getFilmDao() {
		return filmDao;
	}

	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}

	@Override
	public ArrayList<FilmBean> getAllFilm() {
		
		return filmDao.getAllFilm();
	}

	@Override
	public ArrayList<FilmBean> findFilmByName(String film_name) {
		// TODO Auto-generated method stub
		return filmDao.selectByName(film_name);
	}

	@Override
	public FilmBean findFilmById(Integer film_id) {
		// TODO Auto-generated method stub
		return filmDao.selectById(film_id);
	}

	@Override
	public boolean deleteFilm(Integer film_id) {
		// TODO Auto-generated method stub
		return filmDao.deleteById(film_id);
	}

	@Override
	public boolean updateFilm(FilmBean filmBean) {
		// TODO Auto-generated method stub
		return filmDao.updateById(filmBean);
	}

	@Override
	public boolean insertFilm(FilmBean filmBean) {
		filmDao.insert(filmBean);
		return false;
	}

	@Override
	public ArrayList<Map<String, Object>> getCollect() {
		// TODO Auto-generated method stub
		return filmDao.getCollect();
	}

	@Override
	public ArrayList<Map<String, Object>> getReply() {
		// TODO Auto-generated method stub
		return filmDao.getReply();
	}

	@Override
	public ArrayList<FilmTypeBean> getFilmType(Integer film_id) {
		// TODO Auto-generated method stub
		return filmDao.selectFilmType(film_id);
	}

	@Override
	public boolean insertFilmType(ArrayList<FilmTypeBean> arrayListFilmType) {
		for (Iterator iterator = arrayListFilmType.iterator(); iterator.hasNext();) {
			FilmTypeBean filmTypeBean = (FilmTypeBean) iterator.next();
			filmDao.insertType(filmTypeBean);
		}
		return false;
	}

	@Override
	public ArrayList<Map<String, Object>> getHotFilm() {
		// TODO Auto-generated method stub
		return filmDao.orderByCollect();
	}

	@Override
	public ArrayList<Map<String, Object>> getLatestFilm() {
		// TODO Auto-generated method stub
		return filmDao.orderByTime();
	}

	@Override
	public ArrayList<FilmBean> getSortFilm(int start, int row, int page) {
		// TODO Auto-generated method stub
		start=(page-1)*row;
		return filmDao.selectSort(start, row);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return filmDao.getCount();
	}

	@Override
	public ArrayList<Map<String, Object>> getByType(String type, int start, int row, int page) {
		// TODO Auto-generated method stub
		start=(page-1)*row;
		return filmDao.selectByType(type, start, row);
	}

	@Override
	public Map<Integer, Object> getScore() {
		Map<Integer, Object> map1=new HashMap<>();
		ArrayList<Map<String, Object>> arrayList=filmDao.getScore();
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			Map<String, Object> map2 = (Map<String, Object>) iterator.next();
			double score=Double.parseDouble(map2.get("score").toString());
			double people=Double.parseDouble(map2.get("num").toString());
			double svg=score/people;
			map1.put((Integer) map2.get("film_id"), svg);
		}
		return map1;
	}

	@Override
	public ArrayList<Map<String, Object>> getReplyById(int id) {
		// TODO Auto-generated method stub
		return filmDao.getReplyById(id);
	}

	@Override
	public boolean insertPic(FilmPicBean filmPicBean) {
		// TODO Auto-generated method stub
		return filmDao.insertFilmPic(filmPicBean);
	}

	@Override
	public ArrayList<FilmPicBean> getFilmStills(int id) {
		// TODO Auto-generated method stub
		return filmDao.getFilmStills(id);
	}

	@Override
	public ArrayList<FilmBean> searchByKey(String key) {
		// TODO Auto-generated method stub
		key="%"+key+"%";
		return filmDao.searchByKey(key);
	}

	@Override
	public ArrayList<Map<String, Object>> getCollectByUser(int id) {
		// TODO Auto-generated method stub
		return filmDao.getCollectById(id);
	}

	@Override
	public boolean insertCollectFilm(int user_id, int film_id) {
		// TODO Auto-generated method stub
		return filmDao.insertCollectFilm(user_id, film_id);
	}

	@Override
	public boolean insertReplyByUser(FilmReplyBean filmReplyBean) {
		// TODO Auto-generated method stub
		return filmDao.insertReplyByUser(filmReplyBean);
	}

}
