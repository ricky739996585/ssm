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
import com.ricky.bean.ActyReplyBean;
import com.ricky.bean.UserBean;
import com.ricky.service.ActyService;
import com.ricky.service.UserService;

public class TopicAction implements Action{
	
	private ActyBean actyBean;
	private UserBean userBean;
	private ArrayList<ActyBean> arrayListActy;
	private ArrayList<Map<String, Object>> arrayListMapActy;
	private ArrayList<Map<String, Object>> arrayListActyReply;
	private ArrayList<ActyBean> arrayListHotActy;
	private ArrayList<ActyBean> arrayListLatestActy;
	private ActyService actyService;
	private UserService userService;
	private Map<Integer, Object> mapActyPic;
	private Map<Integer, Object> mapUserHead;
	private HttpServletRequest request;
	private File actyImg;
	private String actyImgFileName;
	private ActyReplyBean actyReplyBean;
	private int acty_id;
	
	private int start;
	private int end;
	private final int row=8;
	
	
	

	
	public int getActy_id() {
		return acty_id;
	}


	public void setActy_id(int acty_id) {
		this.acty_id = acty_id;
	}


	public ActyReplyBean getActyReplyBean() {
		return actyReplyBean;
	}


	public void setActyReplyBean(ActyReplyBean actyReplyBean) {
		this.actyReplyBean = actyReplyBean;
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


	public ArrayList<Map<String, Object>> getArrayListActyReply() {
		return arrayListActyReply;
	}


	public void setArrayListActyReply(ArrayList<Map<String, Object>> arrayListActyReply) {
		this.arrayListActyReply = arrayListActyReply;
	}


	public ArrayList<Map<String, Object>> getArrayListMapActy() {
		return arrayListMapActy;
	}


	public void setArrayListMapActy(ArrayList<Map<String, Object>> arrayListMapActy) {
		this.arrayListMapActy = arrayListMapActy;
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


	public ActyService getActyService() {
		return actyService;
	}


	public void setActyService(ActyService actyService) {
		this.actyService = actyService;
	}


	public Map<Integer, Object> getMapActyPic() {
		return mapActyPic;
	}


	public void setMapActyPic(Map<Integer, Object> mapActyPic) {
		this.mapActyPic = mapActyPic;
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


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public String topic(){
		request=ServletActionContext.getRequest();
		mapActyPic=new HashMap<>();
		if(request.getParameter("page")!=null){
			int page=Integer.parseInt(request.getParameter("page"));
			arrayListMapActy=actyService.getSortActy(start, row, page);
			request.setAttribute("page", page);
		}else {
			int page=1;
			request.setAttribute("page", page);
			arrayListMapActy=actyService.getSortActy(start, row, page);
		}
		for (Iterator iterator = arrayListMapActy.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("acty_img").toString(), "/Actypic/", mapActyPic, request, Integer.parseInt(map.get("acty_id").toString()));
		}
		int sum=actyService.getCount();
		if(sum%row==0){
			end=sum/row;
		}else {
			end=sum/row+1;
		}
		request.setAttribute("end", end);
		arrayListHotActy=actyService.getHotActy();
		arrayListLatestActy=actyService.getLatestActy();
		return this.SUCCESS;
	}
	public String topicType(){
		request=ServletActionContext.getRequest();
		String type=request.getParameter("actyType");
		mapActyPic=new HashMap<>();
		arrayListMapActy=new ArrayList<>();
		if(request.getParameter("page")!=null){
			int page=Integer.parseInt(request.getParameter("page"));
			arrayListMapActy=actyService.getByType(type, start, row, page);
			request.setAttribute("page", page);
		}else{
			int page=1;
			request.setAttribute("page", page);
			arrayListMapActy=actyService.getByType(type, start, row, page);
		}
		for (Iterator iterator = arrayListMapActy.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("acty_img").toString(), "/Actypic/", mapActyPic, request, Integer.parseInt(map.get("acty_id").toString()));
		}
		int sum=actyService.getCount();
		if(sum%row==0){
			end=sum/row;
		}else {
			end=sum/row+1;
		}
		request.setAttribute("end", end);
		arrayListHotActy=actyService.getHotActy();
		arrayListLatestActy=actyService.getLatestActy();
		return this.SUCCESS;
	}
	public String topicInstruct(){
		request=ServletActionContext.getRequest();
		mapUserHead=new HashMap<>();
		if(actyBean.getActy_id()==null){
			actyBean.setActy_id(1);
		}
		setActyBean(actyService.findActyById(actyBean.getActy_id()));
		arrayListActyReply=actyService.getReplyById(actyBean.getActy_id());
		for (Iterator iterator = arrayListActyReply.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			getImgName(map.get("user_head").toString(), "/Headpic/", mapUserHead, request, Integer.parseInt(map.get("user_id").toString()));
		}
		setUserBean(userService.findUserById(actyBean.getUser_id()));
		System.out.println(userBean);
		String img=actyBean.getActy_img();
		String name=request.getContextPath()+"/Actypic/"+img.substring(img.lastIndexOf("\\")+1);
		request.setAttribute("actyPic", name);
		return this.SUCCESS;
	}
	public String insertTopic(){
		request=ServletActionContext.getRequest();
		String login="login";
		String msg="发表成功！等待审核";
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null){
			UserBean user=(UserBean) session.getAttribute("user");
			String time=getTime();
			if(actyImg!=null){
				String fileName=uploadPic(actyImg, actyImgFileName);
				actyBean.setActy_img(fileName);
			}
			actyBean.setUser_id(user.getUser_id());
			actyBean.setActy_time(time);
			actyBean.setActy_status("审核");
			actyBean.setActy_people(0);
			request.setAttribute("msg", msg);
			actyService.insertActyByUser(actyBean);
			System.out.println(actyBean);
			return this.SUCCESS;
		}else{
			request.setAttribute("login", login);
			return "login";
		}
	}
	public String replyTopic(){
		request=ServletActionContext.getRequest();
		String login="login";
		String nice="nice";
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null){
			UserBean user=(UserBean) session.getAttribute("user");
			String time=getTime();
			actyReplyBean.setReply_time(time);
			actyReplyBean.setUser_id(user.getUser_id());
			System.out.println(actyReplyBean);
			setActy_id(actyReplyBean.getActy_id());
			if(actyService.insertReplyByUser(actyReplyBean)){
				request.setAttribute("nice",nice);
			}
			return this.SUCCESS;
		}else{
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
	public static String uploadPic(File pic,String picName){
		String realPath=ServletActionContext.getServletContext().getRealPath("/Actypic");
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
