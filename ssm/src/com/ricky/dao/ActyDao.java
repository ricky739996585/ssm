package com.ricky.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ricky.bean.ActyBean;
import com.ricky.bean.ActyReplyBean;
import com.ricky.bean.BookBean;
import com.ricky.bean.MusicBean;
import com.ricky.bean.UserBean;

public interface ActyDao {
	
	
	@Select("select * from tb_acty")
	public ArrayList<ActyBean> getAllActy();
	
	@Select("select * from tb_acty where acty_id=#{acty_id}")
	public ActyBean selectById(Integer acty_id);
	
	@Select("select * from tb_acty where acty_title=#{acty_title}")
	public ActyBean selectByTitle(String acty_title);
	
	@Delete("delete from tb_acty where acty_id=#{acty_id}")
	public boolean deleteById(Integer acty_id);
	
	@Update("update tb_acty set acty_title=#{acty_title},acty_content=#{acty_content},acty_people=#{acty_people},acty_img=#{acty_img},"
			+ "acty_status=#{acty_status} where acty_id=#{acty_id}")
	public boolean updateById(ActyBean actyBean);
	
	@Insert("insert into tb_acty(user_id,acty_title,acty_content,acty_time,acty_people,acty_img,acty_status,acty_type)"
			+ " values(#{user_id},#{acty_title},#{acty_content},#{acty_time},#{acty_people},#{acty_img},#{acty_status},#{acty_type})")
	public boolean insert(ActyBean actyBean);
	
	@Update("update tb_acty set acty_status=#{acty_status} where acty_id=#{acty_id}")
	public boolean updateStatus(ActyBean actyBean);
	
	@Select("select * from tb_acty where acty_status=#{status}")
	public ArrayList<ActyBean> selectByStatus(@Param("status")String status);
	
	
	@Select("select reply_id,acty_title,user_name,reply_content,reply_time "
			+ "from tb_user,tb_acty,tb_acty_reply "
			+ "where tb_user.user_id=tb_acty_reply.user_id "
			+ "and tb_acty.acty_id=tb_acty_reply.acty_id")
	public ArrayList<Map<String, Object>> getReply();
	
	@Select("select acty_id,acty_title,user_name,acty_img,acty_content,acty_time,acty_people,acty_type "
			+ "from tb_user,tb_acty where tb_user.user_id=tb_acty.user_id and acty_id=#{acty_id}")
	public Map<String, Object> getActy(Integer acty_id);
	
	@Select("select * from tb_acty where acty_status=#{status}")
	public ArrayList<ActyBean> getStatus(@Param("status")String status);
	
	@Select("select * from tb_acty where acty_status='活跃' order by acty_people desc")
	public ArrayList<ActyBean> orderByPeople();
	
	@Select("select * from tb_acty where acty_status='活跃' order by acty_time desc")
	public ArrayList<ActyBean> orderByTime();
	
	@Select("select acty_id,tb_user.user_id,acty_title,acty_content,acty_time,acty_people,user_nick,acty_img "
			+ "from tb_acty,tb_user where tb_user.user_id=tb_acty.user_id "
			+ "and acty_status='活跃' LIMIT #{start},#{row} ")
	public ArrayList<Map<String,Object>> selectSort(@Param("start") int start,@Param("row") int row);
	
	@Select("select acty_id,tb_user.user_id,acty_title,acty_content,acty_time,acty_people,user_nick,acty_img"
			+ " from tb_acty,tb_user where tb_user.user_id=tb_acty.user_id and acty_status='活跃' and acty_type=#{type} LIMIT #{start},#{row}")
	public ArrayList<Map<String, Object>> selectByType(@Param("type")String type,@Param("start") int start,@Param("row") int row);
	
	@Select("select count(*) from tb_acty")
	public Integer getCount();
	
	@Select("select acty_id,tb_user.user_id,acty_title,acty_content,acty_time,acty_people,user_nick,acty_img"
			+ " from tb_acty,tb_user where tb_user.user_id=tb_acty.user_id and acty_status='活跃' and acty_title like #{key}")
	public ArrayList<Map<String, Object>> searchByKey(@Param("key")String key);
	
	@Select("select tb_user.user_id,user_nick,user_head,reply_content,reply_time "
			+ "from tb_user,tb_acty_reply where tb_acty_reply.user_id=tb_user.user_id"
			+ " and acty_id=#{id}")
	public ArrayList<Map<String, Object>> getReplyById(@Param("id")int id);
	
	@Insert("insert into tb_acty(user_id,acty_title,acty_content,acty_time,acty_img,acty_status,acty_type)"
			+ " values(#{user_id},#{acty_title},#{acty_content},#{acty_time},#{acty_img},#{acty_status},#{acty_type})")
	public boolean insertActyByUser(ActyBean actyBean);
	
	@Insert("insert into tb_acty_reply(user_id,acty_id,reply_content,reply_time) "
			+ "values(#{user_id},#{acty_id},#{reply_content},#{reply_time})")
	public boolean insertReplyByUser(ActyReplyBean actyReplyBean);
}