package com.ricky.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysql.fabric.xmlrpc.base.Array;
import com.ricky.bean.FilmReplyBean;
import com.ricky.bean.MusicBean;
import com.ricky.bean.MusicReplyBean;
import com.ricky.bean.UserBean;

public interface MusicDao {
	
	
	@Select("select * from tb_music")
	public ArrayList<MusicBean> getAllMusic();
	
	@Select("select * from tb_music where music_id=#{music_id}")
	public MusicBean selectById(Integer music_id);
	
	@Select("select * from tb_music where music_name=#{music_name}")
	public ArrayList<MusicBean> selectByName(String music_name);
	
	@Select("select music_collect,tb_user.user_id,user_name,tb_music.music_id,music_name "
			+ "from tb_user,tb_music_collect,tb_music "
			+ "where tb_user.user_id=tb_music_collect.user_id "
			+ "and tb_music.music_id=tb_music_collect.music_id")
	public ArrayList<Map<String, Object>> getCollect();
	
	@Select("select music_reply_id,user_name,music_name,music_reply_content,music_reply_score,music_reply_time "
			+ "from tb_user,tb_music,tb_music_reply "
			+ "where tb_music.music_id=tb_music_reply.music_id "
			+ "and tb_user.user_id=tb_music_reply.user_id")
	public ArrayList<Map<String, Object>> getReply();
	
	@Delete("delete from tb_music where music_id=#{music_id}")
	public boolean deleteById(Integer music_id);
	
	@Update("update tb_music set music_name=#{music_name},music_type=#{music_type},music_singer=#{music_singer},music_img=#{music_img},"
			+ "music_lyric=#{music_lyric},music_play=#{music_play} where music_id=#{music_id}")
	public boolean updateById(MusicBean musicBean);
	
	@Insert("insert into tb_music(music_name,music_time,music_type,music_singer,music_img,music_lyric,music_play)"
			+ " values(#{music_name},#{music_time},#{music_type},#{music_singer},#{music_img},#{music_lyric},#{music_play})")
	public boolean insert(MusicBean musicBean);
	
	@Select("select music_name,tb_music.music_id,count(tb_music_collect.music_id) sum from tb_music_collect,tb_music "
			+ "where tb_music_collect.music_id=tb_music.music_id group by "
			+ "tb_music_collect.music_id order by count('tb_music_collect.music_id') desc")
	public ArrayList<Map<String, Object>> orderByCollect();
	
	@Select("select music_id,music_name,music_singer from tb_music order by music_time desc")
	public ArrayList<Map<String, Object>> orderByTime();
	
	@Select("select * from tb_music LIMIT #{start},#{row} ")
	public ArrayList<MusicBean> selectSort(@Param("start") int start,@Param("row") int row);
	
	@Select("select count(*) from tb_music")
	public Integer getCount();
	
	@Select("select music_id,sum(music_reply_score) score,count(music_id) num "
			+ "from tb_music_reply group by music_id")
	public ArrayList<Map<String, Object>> getScore();
	
	@Select("select * from tb_music where music_type=#{type} LIMIT #{start},#{row}")
	public ArrayList<MusicBean> selectByType(@Param("type")String type,@Param("start") int start,@Param("row") int row);
	
	@Select("select tb_user.user_id,user_nick,user_head,music_reply_content,music_reply_time "
			+ "from tb_user,tb_music_reply where tb_music_reply.user_id=tb_user.user_id"
			+ " and music_id=#{id}")
	public ArrayList<Map<String, Object>> getReplyById(@Param("id")int id);
	
	@Select("select * from tb_music where music_name like #{key}")
	public ArrayList<MusicBean> searchByKey(@Param("key")String key);
	
	@Select("select distinct tb_music.music_id,music_name,music_img,music_play,music_singer "
			+ "from tb_music_collect,tb_music where tb_music_collect.user_id=#{id} and"
			+ " tb_music.music_id=tb_music_collect.music_id")
	public ArrayList<Map<String, Object>> getCollectByUser(@Param("id")int id);
	
	@Insert("insert into tb_music_collect(user_id,music_id) values(#{user_id},#{music_id})")
	public Boolean insertCollectMusic(@Param("user_id")int user_id,@Param("music_id")int music_id);
	
	@Insert("insert into tb_music_reply(music_id,user_id,music_reply_content,music_reply_score,music_reply_time) "
			+ "values(#{music_id},#{user_id},#{music_reply_content},#{music_reply_score},#{music_reply_time})")
	public Boolean insertReplyByUser(MusicReplyBean musicReplyBean);
}
