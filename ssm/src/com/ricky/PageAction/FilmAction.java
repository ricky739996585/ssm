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
import com.ricky.bean.FilmBean;
import com.ricky.bean.FilmPicBean;
import com.ricky.bean.FilmReplyBean;
import com.ricky.bean.FilmTypeBean;
import com.ricky.bean.UserBean;
import com.ricky.service.FilmService;

public class FilmAction implements Action {
	private FilmBean filmBean;
	private ArrayList<FilmBean> arrayListFilm;
	private ArrayList<FilmTypeBean> arrayListFilmType;
	private ArrayList<FilmPicBean> arrayListFilmStills;
	private ArrayList<Map<String, Object>> arrayListHotFilm;
	private ArrayList<Map<String, Object>> arrayListLatestFilm;
	private ArrayList<Map<String, Object>> arrayListByTypeFilm;
	private ArrayList<Map<String, Object>> arrayListFilmReply;
	private FilmService filmService;
	private Map<Integer, Object> mapFilmPic;
	private Map<Integer, Object> mapFilmScore;
	private Map<Integer, Object> mapUserHead;
	private HttpServletRequest request;
	private FilmReplyBean filmReplyBean;
	private int film_id;
	
	private int start;
	private int end;
	private final int row=8;
	
	
	

	
	public FilmReplyBean getFilmReplyBean() {
		return filmReplyBean;
	}


	public void setFilmReplyBean(FilmReplyBean filmReplyBean) {
		this.filmReplyBean = filmReplyBean;
	}


	public int getFilm_id() {
		return film_id;
	}


	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}


	public ArrayList<FilmTypeBean> getArrayListFilmType() {
		return arrayListFilmType;
	}


	public void setArrayListFilmType(ArrayList<FilmTypeBean> arrayListFilmType) {
		this.arrayListFilmType = arrayListFilmType;
	}


	public ArrayList<FilmPicBean> getArrayListFilmStills() {
		return arrayListFilmStills;
	}


	public void setArrayListFilmStills(ArrayList<FilmPicBean> arrayListFilmStills) {
		this.arrayListFilmStills = arrayListFilmStills;
	}


	public ArrayList<Map<String, Object>> getArrayListFilmReply() {
		return arrayListFilmReply;
	}


	public void setArrayListFilmReply(ArrayList<Map<String, Object>> arrayListFilmReply) {
		this.arrayListFilmReply = arrayListFilmReply;
	}


	public Map<Integer, Object> getMapUserHead() {
		return mapUserHead;
	}


	public void setMapUserHead(Map<Integer, Object> mapUserHead) {
		this.mapUserHead = mapUserHead;
	}


	public ArrayList<Map<String, Object>> getArrayListByTypeFilm() {
		return arrayListByTypeFilm;
	}


	public void setArrayListByTypeFilm(ArrayList<Map<String, Object>> arrayListByTypeFilm) {
		this.arrayListByTypeFilm = arrayListByTypeFilm;
	}


	public Map<Integer, Object> getMapFilmScore() {
		return mapFilmScore;
	}


	public void setMapFilmScore(Map<Integer, Object> mapFilmScore) {
		this.mapFilmScore = mapFilmScore;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
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


	public FilmService getFilmService() {
		return filmService;
	}


	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}


	public Map<Integer, Object> getMapFilmPic() {
		return mapFilmPic;
	}


	public void setMapFilmPic(Map<Integer, Object> mapFilmPic) {
		this.mapFilmPic = mapFilmPic;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String film(){
		request=ServletActionContext.getRequest();
		mapFilmPic=new HashMap<>();
		if(request.getParameter("page")!=null){
			int page=Integer.parseInt(request.getParameter("page"));
			arrayListFilm=filmService.getSortFilm(start,row, page);
			request.setAttribute("page", page);
		}else{
			int page=1;
			request.setAttribute("page", page);
			arrayListFilm=filmService.getSortFilm(start,row, page);
		}
		for (Iterator iterator = arrayListFilm.iterator(); iterator.hasNext();) {
			FilmBean filmBean = (FilmBean) iterator.next();
			getImgName(filmBean.getFilm_img(), "/Filmpic/", mapFilmPic, request, filmBean.getFilm_id());
		}
		int sum=filmService.getCount();
		if(sum%row==0){
			end=sum/row;
		}else {
			end=sum/row+1;
		}
		request.setAttribute("end", end);
		arrayListHotFilm=filmService.getHotFilm();
		arrayListLatestFilm=filmService.getLatestFilm();
		mapFilmScore=new HashMap<>();
		mapFilmScore=filmService.getScore();
		return this.SUCCESS;
	}
	
	public String filmType(){
		request=ServletActionContext.getRequest();
		String type=request.getParameter("filmType");
		mapFilmPic=new HashMap<>();
		if(request.getParameter("page")!=null){
			int page=Integer.parseInt(request.getParameter("page"));
			arrayListByTypeFilm=filmService.getByType(type, start, row, page);
			request.setAttribute("page", page);
		}else {
			int page=1;
			arrayListByTypeFilm=filmService.getByType(type, start, row, page);
			request.setAttribute("page", page);
		}
		for (Iterator iterator = arrayListByTypeFilm.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("film_img").toString(), "/Filmpic/", mapFilmPic, request, Integer.parseInt(map.get("film_id").toString()));
		}
		int sum=filmService.getCount();
		if(sum%row==0){
			end=sum/row;
		}else {
			end=sum/row+1;
		}
		request.setAttribute("end", end);
		arrayListHotFilm=filmService.getHotFilm();
		arrayListLatestFilm=filmService.getLatestFilm();
		mapFilmScore=new HashMap<>();
		mapFilmScore=filmService.getScore();
		return this.SUCCESS;
	}
	
	public String filmSearch(){
		mapFilmPic=new HashMap<>();
		request=ServletActionContext.getRequest();
		arrayListFilm=filmService.findFilmByName(filmBean.getFilm_name());
		for (Iterator iterator = arrayListFilm.iterator(); iterator.hasNext();) {
			FilmBean filmBean = (FilmBean) iterator.next();
			getImgName(filmBean.getFilm_img(), "/Filmpic/", mapFilmPic, request, filmBean.getFilm_id());
		}
		arrayListHotFilm=filmService.getHotFilm();
		arrayListLatestFilm=filmService.getLatestFilm();
		mapFilmScore=new HashMap<>();
		mapFilmScore=filmService.getScore();
		return this.SUCCESS;
	}
	
	public String filmInstruct(){
		request=ServletActionContext.getRequest();
		mapUserHead=new HashMap<>();
		if(filmBean.getFilm_id()==null){
			filmBean.setFilm_id(1);
		}
		setFilmBean(filmService.findFilmById(filmBean.getFilm_id()));
		arrayListFilmReply=filmService.getReplyById(filmBean.getFilm_id());
		for (Iterator iterator = arrayListFilmReply.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("user_head").toString(), "/Headpic/", mapUserHead, request, Integer.parseInt(map.get("user_id").toString()));
		}
		mapFilmScore=new HashMap<>();
		mapFilmScore=filmService.getScore();
		arrayListFilmStills=filmService.getFilmStills(filmBean.getFilm_id());
		arrayListFilmType=filmService.getFilmType(filmBean.getFilm_id());
		for (Iterator iterator = arrayListFilmStills.iterator(); iterator.hasNext();) {
			FilmPicBean filmPicBean = (FilmPicBean) iterator.next();
			String img=filmPicBean.getFilm_pic_url();
			String fileName=request.getContextPath()+"/Filmpic/"+img.substring(img.lastIndexOf("\\")+1);
			filmPicBean.setFilm_pic_url(fileName);
		}
		String img=filmBean.getFilm_img();
		String name=request.getContextPath()+"/Filmpic/"+img.substring(img.lastIndexOf("\\")+1);
		request.setAttribute("filmPic", name);
		return this.SUCCESS;
	}
	public String collectFilm(){
		String msg="收藏成功！";
		String login="login";
		request=ServletActionContext.getRequest();
		int film_id=Integer.parseInt(request.getParameter("film_id"));
		if(request.getSession().getAttribute("user")!=null){
			UserBean user= (UserBean) request.getSession().getAttribute("user");
			int user_id=user.getUser_id();
			if(filmService.insertCollectFilm(user_id, film_id)){
				request.setAttribute("msg", msg);
			}
			return this.SUCCESS;
		}else {
			request.setAttribute("login", login);
			return "login";
		}
	}
	public String replyFilm(){
		request=ServletActionContext.getRequest();
		String login="login";
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null){
			UserBean user=(UserBean) session.getAttribute("user");
			String time=getTime();
			filmReplyBean.setUser_id(user.getUser_id());
			int film=filmReplyBean.getFilm_reply_score();
			filmReplyBean.setFilm_reply_score(film*2);
			filmReplyBean.setFilm_reply_time(time);
			setFilm_id(filmReplyBean.getFilm_id());
			filmService.insertReplyByUser(filmReplyBean);
			System.out.println(filmReplyBean);
			return this.SUCCESS;
		}else {
			request.setAttribute("login", login);
			return "login";
		}
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
}
