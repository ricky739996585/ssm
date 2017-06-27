package com.ricky.service;

import java.util.ArrayList;
import java.util.Map;

import com.ricky.bean.AdminBean;
import com.ricky.bean.UserBean;

public interface UserService {
	//管理员登录
	public boolean admin(AdminBean adminBean);
	
	//用户登录操作
	public boolean login(UserBean userBean);
	
	//获取所有用户
	public ArrayList<UserBean> getAllUser();
	
	//查询用户
	public UserBean findUserByName(String user_name);
	
	//根据ID获取用户
	public UserBean findUserById(Integer user_id);
	
	//根据用户ID删除
	public boolean deleteUser(Integer user_id);
	
	//更新用户根据用户ID
	public boolean updateUser(UserBean userBean);
	
	//插入新用户
	public boolean insertUser(UserBean userBean);
	
	//用户修改自身信息
	public boolean modifyUser(UserBean userBean);
}
