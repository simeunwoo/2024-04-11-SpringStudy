package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MusicMapper {

	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music ORDER BY mno ASC")
	public List<MusicVO> musicListData();
	
	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music "
			+ "WHERE title LIKE '%'||#{title}||'%'")
	public List<MusicVO> musicTitleFindData(String title);

	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music "
			+ "WHERE singer LIKE '%'||#{singer}||'%'")
	public List<MusicVO> musicSingerFindData(String singer);

	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music "
			+ "WHERE album LIKE '%'||#{album}||'%'")
	public List<MusicVO> musicAlbumFindData(String album);
	
	@Select("<script>" // 이런 복잡한 코드 해결 방법 => XML로 구사 => 어노테이션 연결
			+ "SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music "
			+ "WHERE "
			+ "<choose>"
			+ "<when test\"type==1\">"
			+ "title LIKE '%'||#{fd}||'%"
			+ "</when>"
			+ "<when test\"type==2\">"
			+ "singer LIKE '%'||#{fd}||'%"
			+ "</when>"
			+ "<when test\"type==3\">"
			+ "album LIKE '%'||#{fd}||'%"
			+ "</when>"
			+ "</choose>"
			+ "</script>")
	public List<MusicVO> musicFindData(@Param("type") int type,@Param("fd") String fd);
}
