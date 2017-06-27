package com.ricky.PageAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.ricky.bean.BookBean;
import com.ricky.bean.BookReplyBean;
import com.ricky.bean.UserBean;
import com.ricky.service.BookService;
import com.ricky.service.FilmService;

public class BookAction implements Action {
	private BookBean bookBean;
	private ArrayList<BookBean> arrayListBook;
	private ArrayList<Map<String, Object>> arrayListHotBook;
	private ArrayList<Map<String, Object>> arrayListLatestBook;
	private ArrayList<Map<String, Object>> arrayListBookReply;
	private Map<Integer, Object> mapBookPic;
	private Map<Integer, Object> mapBookScore;
	private Map<Integer, Object> mapUserHead;
	private BookService bookService;
	private HttpServletRequest request;
	private BookReplyBean bookReplyBean;
	private int book_id;

	private int start;
	private int end;
	private final int row = 8;

	
	public BookReplyBean getBookReplyBean() {
		return bookReplyBean;
	}

	public void setBookReplyBean(BookReplyBean bookReplyBean) {
		this.bookReplyBean = bookReplyBean;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public ArrayList<Map<String, Object>> getArrayListBookReply() {
		return arrayListBookReply;
	}

	public void setArrayListBookReply(ArrayList<Map<String, Object>> arrayListBookReply) {
		this.arrayListBookReply = arrayListBookReply;
	}

	public Map<Integer, Object> getMapUserHead() {
		return mapUserHead;
	}

	public void setMapUserHead(Map<Integer, Object> mapUserHead) {
		this.mapUserHead = mapUserHead;
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

	public ArrayList<Map<String, Object>> getArrayListHotBook() {
		return arrayListHotBook;
	}

	public void setArrayListHotBook(ArrayList<Map<String, Object>> arrayListHotBook) {
		this.arrayListHotBook = arrayListHotBook;
	}

	public ArrayList<Map<String, Object>> getArrayListLatestBook() {
		return arrayListLatestBook;
	}

	public void setArrayListLatestBook(ArrayList<Map<String, Object>> arrayListLatestBook) {
		this.arrayListLatestBook = arrayListLatestBook;
	}

	public Map<Integer, Object> getMapBookPic() {
		return mapBookPic;
	}

	public void setMapBookPic(Map<Integer, Object> mapBookPic) {
		this.mapBookPic = mapBookPic;
	}

	public Map<Integer, Object> getMapBookScore() {
		return mapBookScore;
	}

	public void setMapBookScore(Map<Integer, Object> mapBookScore) {
		this.mapBookScore = mapBookScore;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String book() {
		request = ServletActionContext.getRequest();
		mapBookPic = new HashMap<>();
		if (request.getParameter("page") != null) {
			int page = Integer.parseInt(request.getParameter("page"));
			arrayListBook = bookService.getSortMusic(start, row, page);
			request.setAttribute("page", page);
		} else {
			int page = 1;
			request.setAttribute("page", page);
			arrayListBook = bookService.getSortMusic(start, row, page);
		}
		for (Iterator iterator = arrayListBook.iterator(); iterator.hasNext();) {
			BookBean bookBean = (BookBean) iterator.next();
			getImgName(bookBean.getBook_img(), "/Bookpic/", mapBookPic, request, bookBean.getBook_id());
		}
		int sum=bookService.getCount();
		if(sum%row==0){
			end=sum/row;
		}else {
			end=sum/row+1;
		}
		request.setAttribute("end", end);
		arrayListHotBook=bookService.getHotBook();
		arrayListLatestBook=bookService.getLatestBook();
		mapBookScore=new HashMap<>();
		mapBookScore=bookService.getScore();
		return this.SUCCESS;
	}

	public String bookType() {
		request=ServletActionContext.getRequest();
		String type=request.getParameter("bookType");
		mapBookPic=new HashMap<>();
		if(request.getParameter("page")!=null){
			int page=Integer.parseInt(request.getParameter("page"));
			arrayListBook=bookService.getByType(type, start, row, page);
			request.setAttribute("page", page);
		}else {
			int page=1;
			arrayListBook=bookService.getByType(type, start, row, page);
			request.setAttribute("page", page);
		}
		for (Iterator iterator = arrayListBook.iterator(); iterator.hasNext();) {
			BookBean bookBean = (BookBean) iterator.next();
			getImgName(bookBean.getBook_img(), "/Bookpic/", mapBookPic, request, bookBean.getBook_id());
		}
		int sum=bookService.getCount();
		if(sum%row==0){
			end=sum/row;
		}else {
			end=sum/row+1;
		}
		request.setAttribute("end", end);
		arrayListHotBook=bookService.getHotBook();
		arrayListLatestBook=bookService.getLatestBook();
		mapBookScore=new HashMap<>();
		mapBookScore=bookService.getScore();
		return this.SUCCESS;
	}

	public String bookSearch() {
		mapBookPic=new HashMap<>();
		request=ServletActionContext.getRequest();
		arrayListBook=bookService.findBookByName(bookBean.getBook_name());
		for (Iterator iterator = arrayListBook.iterator(); iterator.hasNext();) {
			BookBean bookBean = (BookBean) iterator.next();
			getImgName(bookBean.getBook_img(), "/Bookpic/", mapBookPic, request, bookBean.getBook_id());
		}
		arrayListHotBook=bookService.getHotBook();
		arrayListLatestBook=bookService.getLatestBook();
		mapBookScore=new HashMap<>();
		mapBookScore=bookService.getScore();
		return this.SUCCESS;
	}

	public String bookInstruct() {
		request=ServletActionContext.getRequest();
		mapUserHead=new HashMap<>();
		if(bookBean.getBook_id()==null){
			bookBean.setBook_id(1);
		}
		setBookBean(bookService.findBookById(bookBean.getBook_id()));
		arrayListBookReply=bookService.getReplyById(bookBean.getBook_id());
		for (Iterator iterator = arrayListBookReply.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("user_head").toString(), "/Headpic/", mapUserHead, request, Integer.parseInt(map.get("user_id").toString()));
		}
		mapBookScore=new HashMap<>();
		mapBookScore=bookService.getScore();
		String img=bookBean.getBook_img();
		String name=request.getContextPath()+"/Bookpic/"+img.substring(img.lastIndexOf("\\")+1);
		request.setAttribute("bookPic", name);
		return this.SUCCESS;
	}
	public String collectBook(){
		String msg="收藏成功！";
		String login="login";
		request=ServletActionContext.getRequest();
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		if(request.getSession().getAttribute("user")!=null){
			UserBean user= (UserBean) request.getSession().getAttribute("user");
			int user_id=user.getUser_id();
			if(bookService.insertCollectBook(user_id, book_id)){
				request.setAttribute("msg", msg);
			}
			return this.SUCCESS;
		}else {
			request.setAttribute("login", login);
			return "login";
		}
	}
	public String replyBook(){
		request=ServletActionContext.getRequest();
		String login="login";
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null){
			UserBean user=(UserBean) session.getAttribute("user");
			String time=getTime();
			bookReplyBean.setUser_id(user.getUser_id());
			int book=bookReplyBean.getBook_reply_score();
			bookReplyBean.setBook_reply_score(book*2);
			bookReplyBean.setBook_reply_time(time);
			setBook_id(bookReplyBean.getBook_id());
			bookService.insertReplyByUser(bookReplyBean);
			System.out.println(bookReplyBean);
			return this.SUCCESS;
		}else {
			request.setAttribute("login", login);
			return "login";
		}
	}
	public static void getImgName(String img, String type, Map<Integer, Object> map, HttpServletRequest request,Integer id) {
		String name = request.getContextPath() + type + img.substring(img.lastIndexOf("\\") + 1);
		map.put(id, name);
	}
	public static String getTime(){
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date=formater.format(new Date(System.currentTimeMillis()));
		return date;
	}
}
