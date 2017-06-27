package com.ricky.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ricky.bean.BookReplyBean;
import com.ricky.bean.FilmBean;
import com.ricky.bean.FilmPicBean;
import com.ricky.bean.FilmReplyBean;
import com.ricky.bean.FilmTypeBean;
import com.ricky.bean.MusicBean;
import com.ricky.bean.UserBean;

public interface FilmDao {
	
	
	@Select("select * from tb_film")
	public ArrayList<FilmBean> getAllFilm();
	
	@Select("select * from tb_film where film_id=#{film_id}")
	public FilmBean selectById(Integer film_id);
	
	@Select("select * from tb_film where film_name=#{film_name}")
	public ArrayList<FilmBean> selectByName(String film_name);
	
	@Select("select film_collect_id,tb_user.user_id,user_name,tb_film.film_id,film_name "
			+ "from tb_user,tb_film_collect,tb_film "
			+ "where tb_user.user_id=tb_film_collect.user_id "
			+ "and tb_film.film_id=tb_film_collect.film_id")
	public ArrayList<Map<String, Object>> getCollect();
	
	@Select("select film_reply_id,user_name,film_name,film_reply_content,film_reply_score,film_reply_time "
			+ "from tb_user,tb_film,tb_film_reply "
			+ "where tb_film.film_id=tb_film_reply.film_id "
			+ "and tb_user.user_id=tb_film_reply.user_id")
	public ArrayList<Map<String, Object>> getReply();
	
	@Delete("delete from tb_film where film_id=#{film_id}")
	public boolean deleteById(Integer film_id);
	
	@Update("update tb_film set film_name=#{film_name},film_diretor=#{film_diretor},film_actor=#{film_actor},film_summary=#{film_summary},"
			+ "film_detail=#{film_detail},film_url=#{film_url},film_img=#{film_img} where film_id=#{film_id}")
	public boolean updateById(FilmBean filmBean);
	
	@Insert("insert into tb_film(film_name,film_time,film_diretor,film_actor,film_img,film_url,film_summary,film_detail)"
			+ " values(#{film_name},#{film_time},#{film_diretor},#{film_actor},#{film_img},#{film_url},#{film_summary},#{film_detail})")
	@Options(useGeneratedKeys=true,keyProperty="film_id")
	public boolean insert(FilmBean filmBean);
	
	@Insert("insert into tb_film_pic(film_id,film_pic_url) values(#{film_id},#{film_pic_url})")
	@Options(useGeneratedKeys=true,keyProperty="film_pic_id")
	public boolean insertFilmPic(FilmPicBean filmPicBean);
	
	
	@Select("select * from tb_film_type where film_id=#{film_id}")
	public ArrayList<FilmTypeBean> selectFilmType(@Param("film_id")Integer film_id);
	
	@Insert("insert into tb_film_type(film_id,type_name) values(#{film_id},#{type_name})")
	public boolean insertType(FilmTypeBean filmTypeBean);
	
	@Select("select film_name,tb_film.film_id,count(tb_film_collect.film_id) sum from tb_film_collect,tb_film "
			+ "where tb_film_collect.film_id=tb_film.film_id group by "
			+ "tb_film_collect.film_id order by count('tb_film_collect.film_id') desc")
	public ArrayList<Map<String, Object>> orderByCollect();
	
	@Select("select film_id,film_name from tb_film order by film_time desc")
	public ArrayList<Map<String, Object>> orderByTime();
	
	@Select("select * from tb_film LIMIT #{start},#{row} ")
	public ArrayList<FilmBean> selectSort(@Param("start") int start,@Param("row") int row);
	

	@Select("select count(*) from tb_film")
	public Integer getCount();
	
	@Select("select film_id,sum(film_reply_score) score,count(film_id) num "
			+ "from tb_film_reply group by film_id")
	public ArrayList<Map<String, Object>> getScore();
	
	@Select("select tb_film.film_id,film_name,film_url,film_img "
			+ "from tb_film,tb_film_type where tb_film.film_id=tb_film_type.film_id and type_name=#{type}"
			+ " LIMIT #{start},#{row}")
	public ArrayList<Map<String, Object>> selectByType(@Param("type")String type,@Param("start") int start,@Param("row") int row);
	
	@Select("select tb_user.user_id,user_nick,user_head,film_reply_content,film_reply_time "
			+ "from tb_user,tb_film_reply where tb_film_reply.user_id=tb_user.user_id"
			+ " and film_id=#{id}")
	public ArrayList<Map<String, Object>> getReplyById(@Param("id")int id);
	
	@Select("select * from tb_film_pic where film_id=#{id}")
	public ArrayList<FilmPicBean> getFilmStills(@Param("id")int id);
	
	@Select("select * from tb_film where film_name like #{key}")
	public ArrayList<FilmBean> searchByKey(@Param("key")String key);
	
	@Select("select distinct tb_film.film_id,film_name,film_img,film_url "
			+ "from tb_film_collect,tb_film where tb_film_collect.user_id=#{id} "
			+ "and tb_film.film_id=tb_film_collect.film_id;")
	public ArrayList<Map<String, Object>> getCollectById(@Param("id")int id);
	
	@Insert("insert into tb_film_collect(user_id,film_id) values(#{user_id},#{film_id})")
	public Boolean insertCollectFilm(@Param("user_id")int user_id,@Param("film_id")int film_id);
	
	@Insert("insert into tb_film_reply(film_id,user_id,film_reply_content,film_reply_score,film_reply_time) "
			+ "values(#{film_id},#{user_id},#{film_reply_content},#{film_reply_score},#{film_reply_time})")
	public Boolean insertReplyByUser(FilmReplyBean filmReplyBean);
}
