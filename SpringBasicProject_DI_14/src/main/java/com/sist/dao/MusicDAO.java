package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
// 메모리 할당 : => 1) DAO, 2) Service, 3) Model
// VO : 메모리 할당이 아니다 (일반 데이터형)
@Repository("dao")
public class MusicDAO {
	// Spring 안에 MyBatis에서 자동 구현 => 자동으로 주소를 읽어 온다
	@Autowired
	private MusicMapper mapper;
	
	/*
	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music ORDER BY mno ASC")
	 */
	public List<MusicVO> musicListData()
	{
		return mapper.musicListData();
	}
	
	/*
	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music "
			+ "WHERE title=#{title}")

	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music "
			+ "WHERE singer=#{singer}")

	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music "
			+ "WHERE album=#{album}")
	 */
	public List<MusicVO> musicTitleFindData(String title)
	{
		return mapper.musicTitleFindData(title);
	}
	public List<MusicVO> musicSingerFindData(String singer)
	{
		return mapper.musicSingerFindData(singer);
	}
	public List<MusicVO> musicAlbumFindData(String album)
	{
		return mapper.musicAlbumFindData(album);
	}
	
	/*
	통합 검색 => 동적 쿼리
		<foreach> : IN
		<trim> : 제거 / 추가 => OR / AND
		<if> : 조건문
		--------------------------
		<choose>
			<when></when>
		</choose>
		-------------------------- 다중 조건문
		<resultMap> : 조인
		<parameterMap> : 프로시저
	 */
	public List<MusicVO> musicFindData(int type,String fd)
	{
		return mapper.musicFindData(type, fd);
	}
}
