package com.ricky.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.ricky.bean.BookBean;
import com.ricky.bean.MusicBean;
import com.ricky.service.BookService;
import com.ricky.service.MusicService;

public class BookAction implements Action {
	private BookService bookService;
	private BookBean bookBean;
	private ArrayList<BookBean> arrayListBook;
	private HttpServletRequest request;
	private File bookImg;
	private String bookImgFileName;
	private ArrayList<Map<String, Object>> mapCollectBook;
	private ArrayList<Map<String, Object>> mapReplyBook;

	public BookAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public BookBean getBookBean() {
		return bookBean;
	}

	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}

	public ArrayList<BookBean> getArrayListBook() {
		return arrayListBook;
	}

	public void setArrayListBook(ArrayList<BookBean> arrayListBook) {
		this.arrayListBook = arrayListBook;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public File getBookImg() {
		return bookImg;
	}

	public void setBookImg(File bookImg) {
		this.bookImg = bookImg;
	}

	public String getBookImgFileName() {
		return bookImgFileName;
	}

	public void setBookImgFileName(String bookImgFileName) {
		this.bookImgFileName = bookImgFileName;
	}

	public ArrayList<Map<String, Object>> getMapCollectBook() {
		return mapCollectBook;
	}

	public void setMapCollectBook(ArrayList<Map<String, Object>> mapCollectBook) {
		this.mapCollectBook = mapCollectBook;
	}

	public ArrayList<Map<String, Object>> getMapReplyBook() {
		return mapReplyBook;
	}

	public void setMapReplyBook(ArrayList<Map<String, Object>> mapReplyBook) {
		this.mapReplyBook = mapReplyBook;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllBook() {
		arrayListBook=bookService.getAllBook();
		return this.SUCCESS;
	}

	public String getBook() {
		request = ServletActionContext.getRequest();
		setBookBean(bookService.findBookById(bookBean.getBook_id()));
		if (bookBean.getBook_img() != null) {
			String fName = bookBean.getBook_img();
			String name = request.getContextPath() + "/Bookpic/" + fName.substring(fName.lastIndexOf("\\") + 1);
			request.setAttribute("bookImg", name);
			System.out.println(name);
		}
		return this.SUCCESS;
	}

	public String findBookByName() {
		request = ServletActionContext.getRequest();
		String book_name = request.getParameter("book_name");
		arrayListBook=bookService.findBookByName(book_name);
		return this.SUCCESS;
	}

	public String deleteBook() {

		bookService.deleteBook(bookBean.getBook_id());
		return this.SUCCESS;
	}

	public String updateBook() {
		String fileName = uploadPic(bookImg, bookImgFileName);
		bookBean.setBook_img(fileName);
		bookService.updateBook(bookBean);
		return this.SUCCESS;
	}

	public String insertBook() {
		String fileName = uploadPic(bookImg, bookImgFileName);
		bookBean.setBook_img(fileName);
		bookService.insertBook(bookBean);
		return this.SUCCESS;
	}

	public String getCollectBook() {
		mapCollectBook = new ArrayList<>();
		mapCollectBook = bookService.getCollect();
		return this.SUCCESS;
	}

	public String getReplyBook() {
		mapReplyBook = new ArrayList<>();
		mapReplyBook=bookService.getReply();
		return this.SUCCESS;
	}

	public static String getTime() {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date = formater.format(new Date(System.currentTimeMillis()));
		return date;
	}

	public static String uploadPic(File pic, String picName) {
		String realPath = ServletActionContext.getServletContext().getRealPath("/Bookpic");
		String fileName = realPath + File.separator + picName;
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				FileUtils.copyFile(pic, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fileName;
	}
}
