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
import com.ricky.bean.MusicBean;
import com.ricky.service.MusicService;

public class MusicAction implements Action {
	private MusicService musicService;
	private MusicBean musicBean;
	private ArrayList<MusicBean> arrayListMusic;
	private HttpServletRequest request;
	private File musicImg;
	private String musicImgFileName;
	private ArrayList<Map<String, Object>> mapCollectMusic;
	private ArrayList<Map<String, Object>> mapReplyMusic;

	public MusicAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ArrayList<Map<String, Object>> getMapCollectMusic() {
		return mapCollectMusic;
	}



	public void setMapCollectMusic(ArrayList<Map<String, Object>> mapCollectMusic) {
		this.mapCollectMusic = mapCollectMusic;
	}



	public ArrayList<Map<String, Object>> getMapReplyMusic() {
		return mapReplyMusic;
	}



	public void setMapReplyMusic(ArrayList<Map<String, Object>> mapReplyMusic) {
		this.mapReplyMusic = mapReplyMusic;
	}



	public MusicService getMusicService() {
		return musicService;
	}

	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
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

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public File getMusicImg() {
		return musicImg;
	}

	public void setMusicImg(File musicImg) {
		this.musicImg = musicImg;
	}

	public String getMusicImgFileName() {
		return musicImgFileName;
	}

	public void setMusicImgFileName(String musicImgFileName) {
		this.musicImgFileName = musicImgFileName;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllMusic() {
		arrayListMusic = musicService.getAllMusic();
		return this.SUCCESS;
	}

	public String getMusic() {
		request = ServletActionContext.getRequest();
		setMusicBean(musicService.findMusicById(musicBean.getMusic_id()));
		if (musicBean.getMusic_img() != null) {
			String fName = musicBean.getMusic_img();
			String name = request.getContextPath() + "/Musicpic/" + fName.substring(fName.lastIndexOf("\\") + 1);
			request.setAttribute("musicImg", name);
			System.out.println(name);
		}
		return this.SUCCESS;
	}

	public String findMusicByName() {
		request = ServletActionContext.getRequest();
		String music_name = request.getParameter("music_name");
		arrayListMusic=musicService.findMusicByName(music_name);
		return this.SUCCESS;
	}

	public String deleteMusic() {

		musicService.deleteMusic(musicBean.getMusic_id());
		return this.SUCCESS;
	}
	
	public String updateMusic() {
		String fileName=uploadPic(musicImg, musicImgFileName);
		musicBean.setMusic_img(fileName);
		System.out.println(musicBean);
		musicService.updateMusic(musicBean);
		return this.SUCCESS;
	}
	
	public String insertMusic() {
		String time=getTime();
		String fileName=uploadPic(musicImg, musicImgFileName);
		musicBean.setMusic_img(fileName);
		musicBean.setMusic_time(time);
		musicService.insertMusic(musicBean);
		return this.SUCCESS;
	}
	
	public String getCollectMusic(){
		mapCollectMusic=new ArrayList<>();
		mapCollectMusic=musicService.getCollect();
		return this.SUCCESS;
	}
	
	public String getReplyMusic(){
		mapReplyMusic=new ArrayList<>();
		mapReplyMusic=musicService.getReply();
		return this.SUCCESS;
	}
	
	public static String getTime(){
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date=formater.format(new Date(System.currentTimeMillis()));
		return date;
	}
	
	public static String uploadPic(File pic,String picName){
		String realPath=ServletActionContext.getServletContext().getRealPath("/Musicpic");
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
