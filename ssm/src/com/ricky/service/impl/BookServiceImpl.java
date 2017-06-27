package com.ricky.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ricky.bean.BookBean;
import com.ricky.bean.BookReplyBean;
import com.ricky.dao.BookDao;
import com.ricky.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;
	
	
	public BookServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public ArrayList<BookBean> getAllBook() {
		// TODO Auto-generated method stub
		return bookDao.getAllBook();
	}

	@Override
	public ArrayList<BookBean> findBookByName(String book_name) {
		// TODO Auto-generated method stub
		return bookDao.selectByName(book_name);
	}

	@Override
	public BookBean findBookById(Integer book_id) {
		// TODO Auto-generated method stub
		return bookDao.selectById(book_id);
	}

	@Override
	public boolean deleteBook(Integer book_id) {
		// TODO Auto-generated method stub
		return bookDao.deleteById(book_id);
	}

	@Override
	public boolean updateBook(BookBean bookBean) {
		// TODO Auto-generated method stub
		return bookDao.updateById(bookBean);
	}

	@Override
	public boolean insertBook(BookBean bookBean) {
		// TODO Auto-generated method stub
		return bookDao.insert(bookBean);
	}

	@Override
	public ArrayList<Map<String, Object>> getCollect() {
		// TODO Auto-generated method stub
		return bookDao.getCollect();
	}

	@Override
	public ArrayList<Map<String, Object>> getReply() {
		// TODO Auto-generated method stub
		return bookDao.getReply();
	}

	@Override
	public ArrayList<Map<String, Object>> getHotBook() {
		// TODO Auto-generated method stub
		return bookDao.orderByCollect();
	}

	@Override
	public ArrayList<Map<String, Object>> getLatestBook() {
		// TODO Auto-generated method stub
		return bookDao.orderByTime();
	}

	@Override
	public ArrayList<BookBean> getSortMusic(int start, int row, int page) {
		// TODO Auto-generated method stub
		start=(page-1)*row;
		return bookDao.selectSort(start, row);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return bookDao.getCount();
	}

	@Override
	public ArrayList<BookBean> getByType(String type, int start, int row, int page) {
		// TODO Auto-generated method stub
		start=(page-1)*row;
		return bookDao.selectByType(type, start, row);
	}

	@Override
	public Map<Integer, Object> getScore() {
		Map<Integer, Object> map1=new HashMap<>();
		ArrayList<Map<String, Object>> arrayList=bookDao.getScore();
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			Map<String, Object> map2 = (Map<String, Object>) iterator.next();
			double score=Double.parseDouble(map2.get("score").toString());
			double people=Double.parseDouble(map2.get("num").toString());
			double svg=score/people;
			map1.put((Integer) map2.get("book_id"), svg);
		}
		return map1;
	}

	@Override
	public ArrayList<Map<String, Object>> getReplyById(int id) {
		// TODO Auto-generated method stub
		return bookDao.getReplyById(id);
	}

	@Override
	public ArrayList<BookBean> searchByKey(String key) {
		// TODO Auto-generated method stub
		key="%"+key+"%";
		return bookDao.searchByKey(key);
	}

	@Override
	public ArrayList<Map<String, Object>> getCollectByUser(int id) {
		// TODO Auto-generated method stub
		return bookDao.getCollectByUser(id);
	}

	@Override
	public boolean insertCollectBook(int user_id, int book_id) {
		// TODO Auto-generated method stub
		return bookDao.insertCollectBook(user_id, book_id);
	}

	@Override
	public boolean insertReplyByUser(BookReplyBean bookReplyBean) {
		// TODO Auto-generated method stub
		return bookDao.insertReplyByUser(bookReplyBean);
	}

}
