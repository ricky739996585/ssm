package com.ricky.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.ricky.bean.FilmBean;
import com.ricky.bean.FilmPicBean;
import com.ricky.bean.FilmTypeBean;
import com.ricky.bean.MusicBean;
import com.ricky.dao.FilmDao;
import com.ricky.service.FilmService;
import com.ricky.service.MusicService;

public class FilmAction implements Action {
	private FilmService filmService;
	private FilmBean filmBean;
	private FilmTypeBean filmTypeBean;
	private FilmPicBean filmPicBean;
	private ArrayList<FilmBean> arrayListFilm;
	private ArrayList<FilmTypeBean> arrayListFilmType;
	private ArrayList<String> filmType;
	private HttpServletRequest request;
	private File filmImg;
	private String filmImgFileName;
	private File[] filmPic;
	private String[] filmPicFileName;
	private ArrayList<Map<String, Object>> mapCollectFilm;
	private ArrayList<Map<String, Object>> mapReplyFilm;
	private Map<Integer, Object> mapFilmType;

	public FilmAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public File[] getFilmPic() {
		return filmPic;
	}


	public void setFilmPic(File[] filmPic) {
		this.filmPic = filmPic;
	}


	public String[] getFilmPicFileName() {
		return filmPicFileName;
	}


	public void setFilmPicFileName(String[] filmPicFileName) {
		this.filmPicFileName = filmPicFileName;
	}


	public FilmPicBean getFilmPicBean() {
		return filmPicBean;
	}


	public void setFilmPicBean(FilmPicBean filmPicBean) {
		this.filmPicBean = filmPicBean;
	}


	public ArrayList<String> getFilmType() {
		return filmType;
	}


	public void setFilmType(ArrayList<String> filmType) {
		this.filmType = filmType;
	}


	public FilmTypeBean getFilmTypeBean() {
		return filmTypeBean;
	}


	public void setFilmTypeBean(FilmTypeBean filmTypeBean) {
		this.filmTypeBean = filmTypeBean;
	}


	public ArrayList<FilmTypeBean> getArrayListFilmType() {
		return arrayListFilmType;
	}


	public void setArrayListFilmType(ArrayList<FilmTypeBean> arrayListFilmType) {
		this.arrayListFilmType = arrayListFilmType;
	}


	public Map<Integer, Object> getMapFilmType() {
		return mapFilmType;
	}

	public void setMapFilmType(Map<Integer, Object> mapFilmType) {
		this.mapFilmType = mapFilmType;
	}

	public FilmService getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
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

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public File getFilmImg() {
		return filmImg;
	}

	public void setFilmImg(File filmImg) {
		this.filmImg = filmImg;
	}

	public String getFilmImgFileName() {
		return filmImgFileName;
	}

	public void setFilmImgFileName(String filmImgFileName) {
		this.filmImgFileName = filmImgFileName;
	}

	public ArrayList<Map<String, Object>> getMapCollectFilm() {
		return mapCollectFilm;
	}

	public void setMapCollectFilm(ArrayList<Map<String, Object>> mapCollectFilm) {
		this.mapCollectFilm = mapCollectFilm;
	}

	public ArrayList<Map<String, Object>> getMapReplyFilm() {
		return mapReplyFilm;
	}

	public void setMapReplyFilm(ArrayList<Map<String, Object>> mapReplyFilm) {
		this.mapReplyFilm = mapReplyFilm;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllFilm() {
		arrayListFilm = filmService.getAllFilm();
		mapFilmType=new HashMap<>();
		for (Iterator iterator = arrayListFilm.iterator(); iterator.hasNext();) {
			FilmBean filmBean = (FilmBean) iterator.next();
			mapFilmType.put(filmBean.getFilm_id(), filmService.getFilmType(filmBean.getFilm_id()));
		}
		System.out.println(mapFilmType);
		return this.SUCCESS;
	}

	public String getFilm() {
		request = ServletActionContext.getRequest();
		setFilmBean(filmService.findFilmById(filmBean.getFilm_id()));
		if (filmBean.getFilm_img() != null) {
			String fName = filmBean.getFilm_img();
			String name = request.getContextPath() + "/Filmpic/" + fName.substring(fName.lastIndexOf("\\") + 1);
			request.setAttribute("filmImg", name);
			System.out.println(name);
		}
		mapFilmType=new HashMap<>();
		mapFilmType.put(filmBean.getFilm_id(), filmService.getFilmType(filmBean.getFilm_id()));
		System.out.println(mapFilmType);
		return this.SUCCESS;
	}

	public String findFilmByName() {
		request = ServletActionContext.getRequest();
		mapFilmType=new HashMap<>();
		String film_name = request.getParameter("film_name");
		arrayListFilm=filmService.findFilmByName(film_name);
		if(filmBean!=null){
			mapFilmType.put(filmBean.getFilm_id(), filmService.getFilmType(filmBean.getFilm_id()));
			
		}
		
		return this.SUCCESS;
	}

	public String deleteFilm() {

		filmService.deleteFilm(filmBean.getFilm_id());
		return this.SUCCESS;
	}

	public String updateFilm() {
		String fileName = uploadPic(filmImg, filmImgFileName);
		filmBean.setFilm_img(fileName);
		filmService.updateFilm(filmBean);
		return this.SUCCESS;
	}

	public String insertFilm() {
		request=ServletActionContext.getRequest();
		arrayListFilmType=new ArrayList<>();
		String fileName="";
		if(filmImg!=null){
			fileName = uploadPic(filmImg, filmImgFileName);
		}
		filmBean.setFilm_img(fileName);
		filmService.insertFilm(filmBean);
		for (Iterator iterator = filmType.iterator(); iterator.hasNext();) {
			String typename = (String) iterator.next();
			FilmTypeBean bean=new FilmTypeBean();
			bean.setFilm_id(filmBean.getFilm_id());
			bean.setType_name(typename);
			arrayListFilmType.add(bean);
		}
		filmService.insertFilmType(arrayListFilmType);
		return this.SUCCESS;
	}

	public String getCollectFilm() {
		mapCollectFilm = new ArrayList<>();
		mapCollectFilm=filmService.getCollect();
		return this.SUCCESS;
	}

	public String getReplyFilm() {
		mapReplyFilm = new ArrayList<>();
		mapReplyFilm = filmService.getReply();
		return this.SUCCESS;
	}
	
	public String getAllFilmForPic(){
		arrayListFilm=filmService.getAllFilm();
		return this.SUCCESS;
	}
	
	public String insertFilmPic(){
		if(filmPic!=null){
			for(int i=0;i<filmPic.length;i++){
				String fileName=uploadPic(filmPic[i], filmPicFileName[i]);
				filmPicBean.setFilm_pic_url(fileName);
				filmService.insertPic(filmPicBean);
			}
		}
		return this.SUCCESS;
	}
	
	public static String getTime() {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date = formater.format(new Date(System.currentTimeMillis()));
		return date;
	}

	public static String uploadPic(File pic, String picName) {
		String realPath = ServletActionContext.getServletContext().getRealPath("/Filmpic");
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
