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
import com.ricky.bean.MusicBean;
import com.ricky.bean.MusicReplyBean;
import com.ricky.bean.UserBean;
import com.ricky.service.MusicService;

public class MusicAction implements Action{
	private MusicBean musicBean;
	private ArrayList<MusicBean> arrayListMusic;
	private ArrayList<Map<String, Object>> arrayListHotMusic;
	private ArrayList<Map<String, Object>> arrayListLatestMusic;
	private ArrayList<Map<String, Object>> arrayListMusicReply;
	private Map<Integer, Object> mapMusicScore;
	private Map<Integer, Object> mapMusicPic;
	private Map<Integer, Object> mapUserHead;
	private MusicService musicService;
	private HttpServletRequest request;
	private MusicReplyBean musicReplyBean;
	private int music_id;
	
	private int start;
	private int end;
	private final int row=8;
	private String msg;
	
	
	public int getMusic_id() {
		return music_id;
	}

	public void setMusic_id(int music_id) {
		this.music_id = music_id;
	}

	public MusicReplyBean getMusicReplyBean() {
		return musicReplyBean;
	}

	public void setMusicReplyBean(MusicReplyBean musicReplyBean) {
		this.musicReplyBean = musicReplyBean;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<Integer, Object> getMapUserHead() {
		return mapUserHead;
	}

	public void setMapUserHead(Map<Integer, Object> mapUserHead) {
		this.mapUserHead = mapUserHead;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
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

	public Map<Integer, Object> getMapMusicPic() {
		return mapMusicPic;
	}

	public void setMapMusicPic(Map<Integer, Object> mapMusicPic) {
		this.mapMusicPic = mapMusicPic;
	}

	public MusicService getMusicService() {
		return musicService;
	}

	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String music(){
		request=ServletActionContext.getRequest();
		mapMusicPic=new HashMap<>();
		if(request.getParameter("page")!=null){
			int page=Integer.parseInt(request.getParameter("page"));
			arrayListMusic=musicService.getSortMusic(start, row, page);
			request.setAttribute("page", page);
		}else{
			int page=1;
			request.setAttribute("page", page);
			arrayListMusic=musicService.getSortMusic(start, row, page);
		}
		for (Iterator iterator = arrayListMusic.iterator(); iterator.hasNext();) {
			MusicBean musicBean = (MusicBean) iterator.next();
			getImgName(musicBean.getMusic_img(), "/Musicpic/", mapMusicPic, request, musicBean.getMusic_id());
		}
		int sum=musicService.getCount();
		if(sum%row==0){
			end=sum/row;
		}else {
			end=sum/row+1;
		}
		request.setAttribute("end", end);
		arrayListHotMusic=musicService.getHotMusic();
		arrayListLatestMusic=musicService.getLatestMusic();
		mapMusicScore=new HashMap<>();
		mapMusicScore=musicService.getScore();
		return this.SUCCESS;
	}
	public String musicType(){
		request=ServletActionContext.getRequest();
		String type=request.getParameter("musicType");
		mapMusicPic=new HashMap<>();
		if(request.getParameter("page")!=null){
			int page=Integer.parseInt(request.getParameter("page"));
			arrayListMusic=musicService.getByType(type, start, row, page);
			request.setAttribute("page", page);
		}else{
			int page=1;
			request.setAttribute("page", page);
			arrayListMusic=musicService.getByType(type, start, row, page);
		}
		for (Iterator iterator = arrayListMusic.iterator(); iterator.hasNext();) {
			MusicBean musicBean = (MusicBean) iterator.next();
			getImgName(musicBean.getMusic_img(), "/Musicpic/", mapMusicPic, request, musicBean.getMusic_id());
		}
		int sum=musicService.getCount();
		if(sum%row==0){
			end=sum/row;
		}else {
			end=sum/row+1;
		}
		request.setAttribute("end", end);
		arrayListHotMusic=musicService.getHotMusic();
		arrayListLatestMusic=musicService.getLatestMusic();
		mapMusicScore=new HashMap<>();
		mapMusicScore=musicService.getScore();
		return this.SUCCESS;
	}
	public String musicSearch(){
		mapMusicPic=new HashMap<>();
		request=ServletActionContext.getRequest();
		arrayListMusic=musicService.findMusicByName(musicBean.getMusic_name());
		for (Iterator iterator = arrayListMusic.iterator(); iterator.hasNext();) {
			MusicBean musicBean = (MusicBean) iterator.next();
			getImgName(musicBean.getMusic_img(), "/Musicpic/", mapMusicPic, request, musicBean.getMusic_id());
		}
		arrayListHotMusic=musicService.getHotMusic();
		arrayListLatestMusic=musicService.getLatestMusic();
		mapMusicScore=new HashMap<>();
		mapMusicScore=musicService.getScore();
		return this.SUCCESS;
	}
	public String musicInstruct(){
		request=ServletActionContext.getRequest();
		mapUserHead=new HashMap<>();
		if(musicBean.getMusic_id()==null){
			musicBean.setMusic_id(1);
		}
		setMusicBean(musicService.findMusicById(musicBean.getMusic_id()));
		arrayListMusicReply=musicService.getReplyById(musicBean.getMusic_id());
		for (Iterator iterator = arrayListMusicReply.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("user_head").toString(), "/Headpic/", mapUserHead, request, Integer.parseInt(map.get("user_id").toString()));
		}
		mapMusicScore=new HashMap<>();
		mapMusicScore=musicService.getScore();
		String img=musicBean.getMusic_img();
		String name=request.getContextPath()+"/Musicpic/"+img.substring(img.lastIndexOf("\\")+1);
		request.setAttribute("musicPic", name);
		return this.SUCCESS;
	}
	
	public String collectMusic(){
		String msg="收藏成功！";
		String login="login";
		request=ServletActionContext.getRequest();
		int music_id=Integer.parseInt(request.getParameter("music_id"));
		if(request.getSession().getAttribute("user")!=null){
			UserBean user= (UserBean) request.getSession().getAttribute("user");
			int user_id=user.getUser_id();
			if(musicService.insertCollectMusic(user_id, music_id)){
				request.setAttribute("msg", msg);
			}
			return this.SUCCESS;
		}else {
			request.setAttribute("login", login);
			return "login";
		}
	}
	public String replyMusic(){
		request=ServletActionContext.getRequest();
		String login="login";
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null){
			UserBean user=(UserBean) session.getAttribute("user");
			String time=getTime();
			musicReplyBean.setUser_id(user.getUser_id());
			int music=musicReplyBean.getMusic_reply_score();
			musicReplyBean.setMusic_reply_score(music*2);
			musicReplyBean.setMusic_reply_time(time);
			setMusic_id(musicReplyBean.getMusic_id());
			musicService.insertReplyByUser(musicReplyBean);
			System.out.println(musicReplyBean);
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
