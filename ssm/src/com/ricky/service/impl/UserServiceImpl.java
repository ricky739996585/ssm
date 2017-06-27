package com.ricky.service.impl;

import java.util.ArrayList;
import java.util.Map;

import com.ricky.bean.AdminBean;
import com.ricky.bean.UserBean;
import com.ricky.dao.UserDao;
import com.ricky.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean admin(AdminBean adminBean) {
		if(userDao.admin(adminBean)==null){
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public boolean login(UserBean userBean) {
		if(userDao.login(userBean)==null){
			return false;
		}else {
			return true;
		}
	}

	@Override
	public ArrayList<UserBean> getAllUser() {
		
		return userDao.getAllUser();
	}

	@Override
	public UserBean findUserByName(String user_name) {
		
		return userDao.selectByName(user_name);
	}

	@Override
	public UserBean findUserById(Integer user_id) {
		return userDao.selectById(user_id);
	}

	@Override
	public boolean deleteUser(Integer user_id) {
		return userDao.deleteById(user_id);
	}

	@Override
	public boolean updateUser(UserBean userBean) {
		
		return userDao.updateById(userBean);
	}

	@Override
	public boolean insertUser(UserBean userBean) {
		return userDao.insert(userBean);
	}

	@Override
	public boolean modifyUser(UserBean userBean) {
		// TODO Auto-generated method stub
		return userDao.modifyById(userBean);
	}

	

}
