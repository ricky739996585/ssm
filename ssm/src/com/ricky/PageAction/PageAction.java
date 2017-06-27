package com.ricky.PageAction;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.ricky.bean.ActyBean;
import com.ricky.bean.BookBean;
import com.ricky.bean.FilmBean;
import com.ricky.bean.MusicBean;
import com.ricky.bean.UserBean;
import com.ricky.service.ActyService;
import com.ricky.service.BookService;
import com.ricky.service.FilmService;
import com.ricky.service.MusicService;
import com.ricky.service.UserService;

public class PageAction implements Action {
	private MusicBean musicBean;
	private ArrayList<MusicBean> arrayListMusic;
	private ArrayList<Map<String, Object>> arrayListHotMusic;
	private ArrayList<Map<String, Object>> arrayListLatestMusic;
	private ArrayList<Map<String, Object>> arrayListMusicReply;
	
	
	private FilmBean filmBean;
	private ArrayList<FilmBean> arrayListFilm;
	private ArrayList<Map<String, Object>> arrayListHotFilm;
	private ArrayList<Map<String, Object>> arrayListLatestFilm;
	
	private BookBean bookBean;
	private ArrayList<BookBean> arrayListBook;
	private ArrayList<Map<String, Object>> arrayListHotBook;
	private ArrayList<Map<String, Object>> arrayListLatestBook;
	
	private ActyBean actyBean;
	private ArrayList<ActyBean> arrayListActy;
	private ArrayList<ActyBean> arrayListHotActy;
	private ArrayList<ActyBean> arrayListLatestActy;
	private ArrayList<Map<String, Object>> arrayListMapActy;
	private ArrayList<Map<String, Object>> mapCollectMusic;
	private ArrayList<Map<String, Object>> mapCollectFilm;
	private ArrayList<Map<String, Object>> mapCollectBook;
	
	private UserBean userBean;
	private UserService userService;
	private File head;
	private String headFileName;

	private HttpServletRequest request;
	private MusicService musicService;
	private FilmService filmService;
	private BookService bookService;
	private ActyService actyService;

	private Map<Integer, Object> mapMusicPic;
	private Map<Integer, Object> mapFilmPic;
	private Map<Integer, Object> mapBookPic;
	private Map<Integer, Object> mapActyPic;
	private Map<Integer, Object> mapUserHead;
	
	private Map<Integer, Object> mapMusicScore;
	private Map<Integer, Object> mapFilmScore;
	private Map<Integer, Object> mapBookScore;
	
	private int start;
	private int end;
	private final int row=8;
	
	
	

	public File getHead() {
		return head;
	}

	public void setHead(File head) {
		this.head = head;
	}

	public String getHeadFileName() {
		return headFileName;
	}

	public void setHeadFileName(String headFileName) {
		this.headFileName = headFileName;
	}

	public ArrayList<Map<String, Object>> getMapCollectMusic() {
		return mapCollectMusic;
	}

	public void setMapCollectMusic(ArrayList<Map<String, Object>> mapCollectMusic) {
		this.mapCollectMusic = mapCollectMusic;
	}

	public ArrayList<Map<String, Object>> getMapCollectFilm() {
		return mapCollectFilm;
	}

	public void setMapCollectFilm(ArrayList<Map<String, Object>> mapCollectFilm) {
		this.mapCollectFilm = mapCollectFilm;
	}

	public ArrayList<Map<String, Object>> getMapCollectBook() {
		return mapCollectBook;
	}

	public void setMapCollectBook(ArrayList<Map<String, Object>> mapCollectBook) {
		this.mapCollectBook = mapCollectBook;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public ArrayList<Map<String, Object>> getArrayListMapActy() {
		return arrayListMapActy;
	}

	public void setArrayListMapActy(ArrayList<Map<String, Object>> arrayListMapActy) {
		this.arrayListMapActy = arrayListMapActy;
	}

	public Map<Integer, Object> getMapFilmScore() {
		return mapFilmScore;
	}

	public void setMapFilmScore(Map<Integer, Object> mapFilmScore) {
		this.mapFilmScore = mapFilmScore;
	}

	public Map<Integer, Object> getMapBookScore() {
		return mapBookScore;
	}

	public void setMapBookScore(Map<Integer, Object> mapBookScore) {
		this.mapBookScore = mapBookScore;
	}

	public Map<Integer, Object> getMapUserHead() {
		return mapUserHead;
	}

	public void setMapUserHead(Map<Integer, Object> mapUserHead) {
		this.mapUserHead = mapUserHead;
	}

	public ArrayList<Map<String, Object>> getArrayListMusicReply() {
		return arrayListMusicReply;
	}

	public void setArrayListMusicReply(ArrayList<Map<String, Object>> arrayListMusicReply) {
		this.arrayListMusicReply = arrayListMusicReply;
	}

	public Map<Integer, Object> getMapMusicScore() {
		return mapMusicScore;
	}

	public void setMapMusicScore(Map<Integer, Object> mapMusicScore) {
		this.mapMusicScore = mapMusicScore;
	}

	public ArrayList<ActyBean> getArrayListHotActy() {
		return arrayListHotActy;
	}

	public void setArrayListHotActy(ArrayList<ActyBean> arrayListHotActy) {
		this.arrayListHotActy = arrayListHotActy;
	}

	public ArrayList<ActyBean> getArrayListLatestActy() {
		return arrayListLatestActy;
	}

	public void setArrayListLatestActy(ArrayList<ActyBean> arrayListLatestActy) {
		this.arrayListLatestActy = arrayListLatestActy;
	}

	public ArrayList<Map<String, Object>> getArrayListHotMusic() {
		return arrayListHotMusic;
	}

	public void setArrayListHotMusic(ArrayList<Map<String, Object>> arrayListHotMusic) {
		this.arrayListHotMusic = arrayListHotMusic;
	}

	public ArrayList<Map<String, Object>> getArrayListLatestMusic() {
		return arrayListLatestMusic;
	}

	public void setArrayListLatestMusic(ArrayList<Map<String, Object>> arrayListLatestMusic) {
		this.arrayListLatestMusic = arrayListLatestMusic;
	}

	public ArrayList<Map<String, Object>> getArrayListHotFilm() {
		return arrayListHotFilm;
	}

	public void setArrayListHotFilm(ArrayList<Map<String, Object>> arrayListHotFilm) {
		this.arrayListHotFilm = arrayListHotFilm;
	}

	public ArrayList<Map<String, Object>> getArrayListLatestFilm() {
		return arrayListLatestFilm;
	}

	public void setArrayListLatestFilm(ArrayList<Map<String, Object>> arrayListLatestFilm) {
		this.arrayListLatestFilm = arrayListLatestFilm;
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

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<Integer, Object> getMapMusicPic() {
		return mapMusicPic;
	}

	public void setMapMusicPic(Map<Integer, Object> mapMusicPic) {
		this.mapMusicPic = mapMusicPic;
	}

	public Map<Integer, Object> getMapFilmPic() {
		return mapFilmPic;
	}

	public void setMapFilmPic(Map<Integer, Object> mapFilmPic) {
		this.mapFilmPic = mapFilmPic;
	}

	public Map<Integer, Object> getMapBookPic() {
		return mapBookPic;
	}

	public void setMapBookPic(Map<Integer, Object> mapBookPic) {
		this.mapBookPic = mapBookPic;
	}

	public Map<Integer, Object> getMapActyPic() {
		return mapActyPic;
	}

	public void setMapActyPic(Map<Integer, Object> mapActyPic) {
		this.mapActyPic = mapActyPic;
	}

	public MusicBean getMusicBean() {
		return musicBean;
	}

	public void setMusicBean(MusicBean musicBean) {
		this.musicBean = musicBean;
	}

	public ArrayList<MusicBean> getArrayListMusic() {
		return arrayListMusic;
	}

	public void setArrayListMusic(ArrayList<MusicBean> arrayListMusic) {
		this.arrayListMusic = arrayListMusic;
	}

	public FilmBean getFilmBean() {
		return filmBean;
	}

	public void setFilmBean(FilmBean filmBean) {
		this.filmBean = filmBean;
	}

	public ArrayList<FilmBean> getArrayListFilm() {
		return arrayListFilm;
	}

	public void setArrayListFilm(ArrayList<FilmBean> arrayListFilm) {
		this.arrayListFilm = arrayListFilm;
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

	public ActyBean getActyBean() {
		return actyBean;
	}

	public void setActyBean(ActyBean actyBean) {
		this.actyBean = actyBean;
	}

	public ArrayList<ActyBean> getArrayListActy() {
		return arrayListActy;
	}

	public void setArrayListActy(ArrayList<ActyBean> arrayListActy) {
		this.arrayListActy = arrayListActy;
	}

	public MusicService getMusicService() {
		return musicService;
	}

	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}

	public FilmService getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public ActyService getActyService() {
		return actyService;
	}

	public void setActyService(ActyService actyService) {
		this.actyService = actyService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		if (userService.login(userBean)) {
			setUserBean(userService.findUserByName(userBean.getUser_name()));
			String fName=userBean.getUser_head();
			String name=request.getContextPath()+"/Headpic/"+fName.substring(fName.lastIndexOf("\\")+1);
			session.setAttribute("user", userBean);
			session.setAttribute("head", name);
			request.setAttribute("loginSuccess", "success");
		} else {
			request.setAttribute("error", "登录失败！");
		}
		return this.SUCCESS;
	}
	
	public String index(){
		request=ServletActionContext.getRequest();
		mapActyPic=new HashMap<>();
		mapBookPic=new HashMap<>();
		mapFilmPic=new HashMap<>();
		mapMusicPic=new HashMap<>();
		arrayListActy=actyService.getAllActy();
		for (Iterator iterator = arrayListActy.iterator(); iterator.hasNext();) {
			ActyBean actyBean = (ActyBean) iterator.next();
			getImgName(actyBean.getActy_img(), "/Actypic/", mapActyPic, request, actyBean.getActy_id());
		}
		arrayListBook=bookService.getAllBook();
		for (Iterator iterator = arrayListBook.iterator(); iterator.hasNext();) {
			BookBean bookBean = (BookBean) iterator.next();
			getImgName(bookBean.getBook_img(), "/Bookpic/", mapBookPic, request, bookBean.getBook_id());
		}
		arrayListFilm=filmService.getAllFilm();
		for (Iterator iterator = arrayListFilm.iterator(); iterator.hasNext();) {
			FilmBean filmBean = (FilmBean) iterator.next();
			String fName = filmBean.getFilm_img();
			String name = request.getContextPath() + "/Filmpic/" + fName.substring(fName.lastIndexOf("\\") + 1);
			mapFilmPic.put(filmBean.getFilm_id(), name);
		}
		arrayListMusic=musicService.getAllMusic();
		for (Iterator iterator = arrayListMusic.iterator(); iterator.hasNext();) {
			MusicBean musicBean = (MusicBean) iterator.next();
			String fName = musicBean.getMusic_img();
			String name = request.getContextPath() + "/Musicpic/" + fName.substring(fName.lastIndexOf("\\") + 1);
			mapMusicPic.put(musicBean.getMusic_id(), name);
		}
		arrayListHotMusic=musicService.getHotMusic();
		arrayListHotFilm=filmService.getHotFilm();
		arrayListHotBook=bookService.getHotBook();
		arrayListHotActy=actyService.getHotActy();
		mapMusicScore=new HashMap<>();
		mapMusicScore=musicService.getScore();
		mapFilmScore=new HashMap<>();
		mapFilmScore=filmService.getScore();
		mapBookScore=new HashMap<>();
		mapBookScore=bookService.getScore();
		return this.SUCCESS;
	}
	public String searchAll(){
		request =ServletActionContext.getRequest();
		String key=request.getParameter("key");
		mapActyPic=new HashMap<>();
		mapBookPic=new HashMap<>();
		mapFilmPic=new HashMap<>();
		mapMusicPic=new HashMap<>();
		arrayListMapActy=new ArrayList<>();
		arrayListMapActy=actyService.searchByKey(key);
		if(arrayListMapActy!=null){
			for (Iterator iterator = arrayListMapActy.iterator(); iterator.hasNext();) {
				Map<String, Object> map = (Map<String, Object>) iterator.next();
				getImgName(map.get("acty_img").toString(), "/Actypic/", mapActyPic, request, Integer.parseInt(map.get("acty_id").toString()));
			}
		}
		arrayListBook=bookService.searchByKey(key);
		if(arrayListBook!=null){
			for (Iterator iterator = arrayListBook.iterator(); iterator.hasNext();) {
				BookBean bookBean = (BookBean) iterator.next();
				getImgName(bookBean.getBook_img(), "/Bookpic/", mapBookPic, request, bookBean.getBook_id());
			}
		}
		arrayListFilm=filmService.searchByKey(key);
		if(arrayListFilm!=null){
			for (Iterator iterator = arrayListFilm.iterator(); iterator.hasNext();) {
				FilmBean filmBean = (FilmBean) iterator.next();
				getImgName(filmBean.getFilm_img(), "/Filmpic/", mapFilmPic, request, filmBean.getFilm_id());
			}
		}
		arrayListMusic=musicService.searchByKey(key);
		if(arrayListMusic!=null){
			for (Iterator iterator = arrayListMusic.iterator(); iterator.hasNext();) {
				MusicBean musicBean = (MusicBean) iterator.next();
				getImgName(musicBean.getMusic_img(), "/Musicpic/", mapMusicPic, request, musicBean.getMusic_id());
			}
		}
		mapMusicScore=new HashMap<>();
		mapMusicScore=musicService.getScore();
		mapFilmScore=new HashMap<>();
		mapFilmScore=filmService.getScore();
		mapBookScore=new HashMap<>();
		mapBookScore=bookService.getScore();
		arrayListHotBook=new ArrayList<>();
		arrayListHotBook=bookService.getHotBook();
		arrayListHotMusic=new ArrayList<>();
		arrayListHotMusic=musicService.getHotMusic();
		arrayListHotFilm=new ArrayList<>();
		arrayListHotFilm=filmService.getHotFilm();
		return this.SUCCESS;
	}
	public String register(){
		request=ServletActionContext.getRequest();
		String time=getTime();
		userBean.setUser_time(time);
		userBean.setUser_status("活跃");
		userService.insertUser(userBean);
		request.setAttribute("great", "注册成功！");
		return this.SUCCESS;
	}
	
	public String instructUser(){
		request=ServletActionContext.getRequest();
		mapBookPic=new HashMap<>();
		mapBookScore=new HashMap<>();
		mapCollectBook=new ArrayList<>();
		mapFilmPic=new HashMap<>();
		mapFilmScore=new HashMap<>();
		mapCollectFilm=new ArrayList<>();
		mapMusicPic=new HashMap<>();
		mapMusicScore=new HashMap<>();
		mapCollectMusic=new ArrayList<>();
		setUserBean((UserBean)request.getSession().getAttribute("user"));
		System.out.println(userBean);
		if(userBean.getUser_head()!=null){
			String img=userBean.getUser_head();
			String name=request.getContextPath()+"/Headpic/"+img.substring(img.lastIndexOf("\\")+1);
			request.setAttribute("headPic", name);
		}
		mapCollectBook=bookService.getCollectByUser(userBean.getUser_id());
		for (Iterator iterator = mapCollectBook.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("book_img").toString(),"/Bookpic/", mapBookPic, request, Integer.parseInt(map.get("book_id").toString()));
		}
		mapCollectFilm=filmService.getCollectByUser(userBean.getUser_id());
		for (Iterator iterator = mapCollectFilm.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("film_img").toString(),"/Filmpic/", mapFilmPic, request, Integer.parseInt(map.get("film_id").toString()));
		}
		mapCollectMusic=musicService.getCollectByUser(userBean.getUser_id());
		for (Iterator iterator = mapCollectMusic.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("music_img").toString(),"/Musicpic/", mapMusicPic, request, Integer.parseInt(map.get("music_id").toString()));
		}
		mapBookScore=bookService.getScore();
		mapFilmScore=filmService.getScore();
		mapMusicScore=musicService.getScore();
		return this.SUCCESS;
	}
	public String searchUser(){
		request=ServletActionContext.getRequest();
		mapBookPic=new HashMap<>();
		mapBookScore=new HashMap<>();
		mapCollectBook=new ArrayList<>();
		mapFilmPic=new HashMap<>();
		mapFilmScore=new HashMap<>();
		mapCollectFilm=new ArrayList<>();
		mapMusicPic=new HashMap<>();
		mapMusicScore=new HashMap<>();
		mapCollectMusic=new ArrayList<>();
		setUserBean(userService.findUserById(userBean.getUser_id()));
		String img=userBean.getUser_head();
		String name=request.getContextPath()+"/Headpic/"+img.substring(img.lastIndexOf("\\")+1);
		request.setAttribute("headPic", name);
		mapCollectBook=bookService.getCollectByUser(userBean.getUser_id());
		for (Iterator iterator = mapCollectBook.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("book_img").toString(),"/Bookpic/", mapBookPic, request, Integer.parseInt(map.get("book_id").toString()));
		}
		mapCollectFilm=filmService.getCollectByUser(userBean.getUser_id());
		for (Iterator iterator = mapCollectFilm.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("film_img").toString(),"/Filmpic/", mapFilmPic, request, Integer.parseInt(map.get("film_id").toString()));
		}
		mapCollectMusic=musicService.getCollectByUser(userBean.getUser_id());
		for (Iterator iterator = mapCollectMusic.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("music_img").toString(),"/Musicpic/", mapMusicPic, request, Integer.parseInt(map.get("music_id").toString()));
		}
		mapBookScore=bookService.getScore();
		mapFilmScore=filmService.getScore();
		mapMusicScore=musicService.getScore();
		return this.SUCCESS;
	}
	public String userForUpdate(){
		request=ServletActionContext.getRequest();
		setUserBean((UserBean)request.getSession().getAttribute("user"));
		System.out.println(userBean);
		if(userBean.getUser_head()!=null){
			String img=userBean.getUser_head();
			String name=request.getContextPath()+"/Headpic/"+img.substring(img.lastIndexOf("\\")+1);
			request.setAttribute("headPic", name);
		}
		return this.SUCCESS;
	}
	
	public String modifyUser(){
		try {
			request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			UserBean user=(UserBean)request.getSession().getAttribute("user");
			System.out.println(head);
			System.out.println(headFileName);
			String fileName=uploadPic(head, headFileName);
			userBean.setUser_id(user.getUser_id());
			userBean.setUser_head(fileName);
			userService.modifyUser(userBean);
			session.removeAttribute("user");
			session.setAttribute("user", userService.findUserById(userBean.getUser_id()));
			System.out.println(session.getAttribute("user")+"session");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.SUCCESS;
	}
	public String cancel(){
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		return this.SUCCESS;
	}
	
	
	public static void getImgName(String img,String type,Map<Integer, Object> map,HttpServletRequest request,Integer id){
		String name=request.getContextPath()+type+img.substring(img.lastIndexOf("\\")+1);
		map.put(id, name);
	}
	
	public static String getTime(){
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date=formater.format(new Date(System.currentTimeMillis()));
		return date;
	}
	public static String uploadPic(File pic,String picName){
		String realPath=ServletActionContext.getServletContext().getRealPath("/Headpic");
		String fileName=realPath+File.separator+picName;
		File file=new File(fileName);
		if(!file.exists()){
			try {
				FileUtils.copyFile(pic, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fileName;
	}
}
