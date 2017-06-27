package com.ricky.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ricky.bean.BookBean;
import com.ricky.bean.BookReplyBean;
import com.ricky.bean.MusicBean;
import com.ricky.bean.UserBean;

public interface BookDao {
	
	
	@Select("select * from tb_book")
	public ArrayList<BookBean> getAllBook();
	
	@Select("select * from tb_book where book_id=#{book_id}")
	public BookBean selectById(Integer book_id);
	
	@Select("select * from tb_book where book_name=#{book_name}")
	public ArrayList<BookBean> selectByName(String book_name);
	
	@Select("select book_collect_id,tb_user.user_id,user_name,tb_book.book_id,book_name "
			+ "from tb_user,tb_book_collect,tb_book "
			+ "where tb_user.user_id=tb_book_collect.user_id "
			+ "and tb_book.book_id=tb_book_collect.book_id")
	public ArrayList<Map<String, Object>> getCollect();
	
	@Select("select book_reply_id,user_name,book_name,book_reply_content,book_reply_score,book_reply_time "
			+ "from tb_user,tb_book,tb_book_reply "
			+ "where tb_book.book_id=tb_book_reply.book_id "
			+ "and tb_user.user_id=tb_book_reply.user_id")
	public ArrayList<Map<String, Object>> getReply();
	
	@Delete("delete from tb_book where book_id=#{book_id}")
	public boolean deleteById(Integer book_id);
	
	@Update("update tb_book set book_name=#{book_name},book_author=#{book_author},book_img=#{book_img},"
			+ "book_publish=#{book_publish},book_time=#{book_time},book_url=#{book_url},book_summary=#{book_summary},"
			+ "author_summary=#{author_summary} where book_id=#{book_id}")
	public boolean updateById(BookBean bookBean);
	
	@Insert("insert into tb_book(book_name,book_time,book_type,book_author,book_img,book_publish,book_url,book_summary,author_summary)"
			+ " values(#{book_name},#{book_time},#{book_type},#{book_author},#{book_img},#{book_publish},#{book_url},#{book_summary},author_summary)")
	public boolean insert(BookBean bookBean);
	
	@Select("select book_name,tb_book.book_id,count('tb_book_collect.book_id') sum from tb_book_collect,tb_book "
			+ "where tb_book_collect.book_id=tb_book.book_id group by "
			+ "tb_book_collect.book_id order by count('tb_book_collect.book_id') desc")
	public ArrayList<Map<String, Object>> orderByCollect();
	
	@Select("select book_id,book_name from tb_book order by book_time desc")
	public ArrayList<Map<String, Object>> orderByTime();
	
	@Select("select * from tb_book LIMIT #{start},#{row} ")
	public ArrayList<BookBean> selectSort(@Param("start") int start,@Param("row") int row);
	
	@Select("select count(*) from tb_book")
	public Integer getCount();
	
	@Select("select book_id,sum(book_reply_score) score,count(book_id) num "
			+ "from tb_book_reply group by book_id")
	public ArrayList<Map<String, Object>> getScore();
	
	@Select("select * from tb_book where book_type=#{type} LIMIT #{start},#{row}")
	public ArrayList<BookBean> selectByType(@Param("type")String type,@Param("start") int start,@Param("row") int row);
	
	@Select("select tb_user.user_id,user_nick,user_head,book_reply_content,book_reply_time "
			+ "from tb_user,tb_book_reply where tb_book_reply.user_id=tb_user.user_id"
			+ " and book_id=#{id}")
	public ArrayList<Map<String, Object>> getReplyById(@Param("id")int id);
	
	@Select("select * from tb_book where book_name like #{key}")
	public ArrayList<BookBean> searchByKey(@Param("key")String key);
	
	@Select("select distinct tb_book.book_id,book_name,book_img,book_url from "
			+ "tb_book_collect,tb_book where tb_book_collect.user_id=#{id} and "
			+ "tb_book.book_id=tb_book_collect.book_id")
	public ArrayList<Map<String, Object>> getCollectByUser(@Param("id")int id);
	
	@Insert("insert into tb_book_collect(user_id,book_id) values(#{user_id},#{book_id})")
	public Boolean insertCollectBook(@Param("user_id")int user_id,@Param("book_id")int book_id);
	
	@Insert("insert into tb_book_reply(book_id,user_id,book_reply_content,book_reply_score,book_reply_time) "
			+ "values(#{book_id},#{user_id},#{book_reply_content},#{book_reply_score},#{book_reply_time})")
	public Boolean insertReplyByUser(BookReplyBean bookReplyBean);
}
