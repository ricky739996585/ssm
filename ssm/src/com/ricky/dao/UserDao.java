package com.ricky.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ricky.bean.AdminBean;
import com.ricky.bean.UserBean;
import com.ricky.interceptor.adminInterceptor;

public interface UserDao {
	
	@Select("select * from tb_admin where admin_name=#{admin_name} and admin_psw=#{admin_psw}")
	public AdminBean admin(AdminBean adminBean);
	
	@Select("select * from tb_user where user_name=#{user_name} and user_psw=#{user_psw}")
	public UserBean login(UserBean userBean);
	
	@Select("select * from tb_user")
	public ArrayList<UserBean> getAllUser();
	
	@Select("select * from tb_user where user_id=#{user_id}")
	public UserBean selectById(Integer user_id);
	
	@Select("select * from tb_user where user_name=#{user_name}")
	public UserBean selectByName(String user_name);
	
	@Delete("delete from tb_user where user_id=#{user_id}")
	public boolean deleteById(Integer user_id);
	
	@Update("update tb_user set user_name=#{user_name},user_psw=#{user_psw},user_sex=#{user_sex},user_nick=#{user_nick},"
			+ "user_status=#{user_status},user_head=#{user_head} where user_id=#{user_id}")
	public boolean updateById(UserBean userBean);
	
	@Insert("insert into tb_user(user_name,user_psw,user_nick,user_sex,user_time,user_status,user_head)"
			+ " values(#{user_name},#{user_psw},#{user_nick},#{user_sex},#{user_time},#{user_status},#{user_head})")
	public boolean insert(UserBean userBean);
	
	@Update("update tb_user set user_psw=#{user_psw},user_sex=#{user_sex},user_nick=#{user_nick},user_head=#{user_head}"
			+ " where user_id=#{user_id}")
	public boolean modifyById(UserBean userBean);
}
