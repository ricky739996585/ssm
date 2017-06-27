package com.ricky.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.ActionMessage;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.ricky.bean.AdminBean;
import com.ricky.bean.UserBean;
import com.ricky.service.UserService;
import com.ricky.service.impl.UserServiceImpl;
import com.sun.glass.ui.Pixels.Format;

public class UserAction implements Action {
	private UserService userService;
	private UserBean userBean;
	private AdminBean adminBean;
	private ArrayList<UserBean> arrayListUser;
	private Map<String, Object> mapUserActy;
	private HttpServletRequest request;
	private File headImg;
	private String headImgFileName;
	
	

	public AdminBean getAdminBean() {
		return adminBean;
	}

	public void setAdminBean(AdminBean adminBean) {
		this.adminBean = adminBean;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	

	public Map<String, Object> getMapUserActy() {
		return mapUserActy;
	}

	public void setMapUserActy(Map<String, Object> mapUserActy) {
		this.mapUserActy = mapUserActy;
	}

	public ArrayList<UserBean> getArrayListUser() {
		return arrayListUser;
	}

	public void setArrayListUser(ArrayList<UserBean> arrayListUser) {
		this.arrayListUser = arrayListUser;
	}

	public UserAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String admin(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		if(userService.admin(adminBean)){
			session.setAttribute("admin", adminBean);
			return this.SUCCESS;
		}else {
			return "login";
		}
	}

	public String getAllUser() {
		arrayListUser = userService.getAllUser();
		System.out.println(ServletActionContext.getRequest().getSession().getAttribute("admin"+"--->getAllUser()"));
		return this.SUCCESS;
	}
	public String getUser() {
		request=ServletActionContext.getRequest();
		setUserBean(userService.findUserById(userBean.getUser_id()));
		if(userBean.getUser_head()!=null){
			String fName=userBean.getUser_head();
			String name=request.getContextPath()+"/Headpic/"+fName.substring(fName.lastIndexOf("\\")+1);
			request.setAttribute("headImg",name);
		}
		return this.SUCCESS;
	}

	public String findUserByName() {
		request=ServletActionContext.getRequest();
		String user_name = request.getParameter("user_name");
		setUserBean(userService.findUserByName(user_name));
		return this.SUCCESS;
	}

	public String findUserById() {
		Integer user_id = new Integer(3);
		setUserBean(userService.findUserById(user_id));
		return this.SUCCESS;
	}

	public String deleteUser() {
		
		userService.deleteUser(userBean.getUser_id());
		return this.SUCCESS;
	}

	public String updateUser() {
		String fileName=uploadPic(headImg, headImgFileName);
		userBean.setUser_head(fileName);
		userService.updateUser(userBean);
		return this.SUCCESS;
	}

	public String insertUser() {
		String time=getTime();
		String fileName=uploadPic(headImg, headImgFileName);
		userBean.setUser_head(fileName);
		userBean.setUser_time(time);
		userService.insertUser(userBean);
		return this.SUCCESS;
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
