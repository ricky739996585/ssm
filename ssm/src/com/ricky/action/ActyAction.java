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
import com.ricky.bean.ActyBean;
import com.ricky.bean.BookBean;
import com.ricky.bean.MusicBean;
import com.ricky.service.ActyService;
import com.ricky.service.BookService;
import com.ricky.service.MusicService;

public class ActyAction implements Action {
	private ActyService actyService;
	private ActyBean actyBean;
	private ArrayList<ActyBean> arrayListActy;
	private Map<String, Object> mapActy;
	private HttpServletRequest request;
	private File actyImg;
	private String actyImgFileName;
	private ArrayList<Map<String, Object>> mapReplyActy;

	public ActyAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Map<String, Object> getMapActy() {
		return mapActy;
	}

	public void setMapActy(Map<String, Object> mapActy) {
		this.mapActy = mapActy;
	}

	public ActyService getActyService() {
		return actyService;
	}

	public void setActyService(ActyService actyService) {
		this.actyService = actyService;
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

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public File getActyImg() {
		return actyImg;
	}

	public void setActyImg(File actyImg) {
		this.actyImg = actyImg;
	}

	public String getActyImgFileName() {
		return actyImgFileName;
	}

	public void setActyImgFileName(String actyImgFileName) {
		this.actyImgFileName = actyImgFileName;
	}

	public ArrayList<Map<String, Object>> getMapReplyActy() {
		return mapReplyActy;
	}

	public void setMapReplyActy(ArrayList<Map<String, Object>> mapReplyActy) {
		this.mapReplyActy = mapReplyActy;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllActy() {
		arrayListActy=actyService.getAllActy();
		return this.SUCCESS;
	}

	public String getActy() {
		request = ServletActionContext.getRequest();
		mapActy=new HashMap<>();
		mapActy=actyService.getActy(actyBean.getActy_id());
		if (mapActy.get("acty_img") != null) {
			String fName = (String)mapActy.get("acty_img");
			String name = request.getContextPath() + "/Actypic/" + fName.substring(fName.lastIndexOf("\\") + 1);
			request.setAttribute("actyImg", name);
		}
		return this.SUCCESS;
	}
	public String searchActy() {
		request = ServletActionContext.getRequest();
		mapActy=new HashMap<>();
		mapActy=actyService.getActy(actyBean.getActy_id());
		if (mapActy.get("acty_img") != null) {
			String fName = (String)mapActy.get("acty_img");
			String name = request.getContextPath() + "/Actypic/" + fName.substring(fName.lastIndexOf("\\") + 1);
			request.setAttribute("actyImg", name);
		}
		return this.SUCCESS;
	}

	public String findActyByTitle() {
		request = ServletActionContext.getRequest();
		String acty_title = request.getParameter("acty_title");
		setActyBean(actyService.findActyByTitle(acty_title));
		return this.SUCCESS;
	}

	public String deleteActy() {

		actyService.deleteActy(actyBean.getActy_id());
		return this.SUCCESS;
	}

	public String updateActy() {
		String fileName="";
		if(actyImg!=null){
			 fileName = uploadPic(actyImg, actyImgFileName);
		}
		actyBean.setActy_img(fileName);
		actyService.updateActy(actyBean);
		return this.SUCCESS;
	}

	public String insertActy() {
		String fileName="";
		if(actyImg!=null){
			 fileName = uploadPic(actyImg, actyImgFileName);
		}
		actyBean.setActy_img(fileName);
		actyBean.setActy_time(getTime());
		System.out.println(actyBean);
		actyService.insertActy(actyBean);
		return this.SUCCESS;
	}
	public String getStatus(){
		arrayListActy=actyService.getStatus("审核");
		return this.SUCCESS;
	}
	
	public String updateStatus(){
		actyBean.setActy_status("活跃");
		System.out.println(actyBean);
		actyService.updateStatus(actyBean);
		return this.SUCCESS;
	}
	public String getReply() {
		mapReplyActy = new ArrayList<>();
		mapReplyActy=actyService.getReply();
		return this.SUCCESS;
	}

	public static String getTime() {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date = formater.format(new Date(System.currentTimeMillis()));
		return date;
	}

	public static String uploadPic(File pic, String picName) {
		String realPath = ServletActionContext.getServletContext().getRealPath("/Actypic");
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
