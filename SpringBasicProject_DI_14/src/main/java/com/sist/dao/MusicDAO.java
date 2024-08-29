package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
// �޸� �Ҵ� : => 1) DAO, 2) Service, 3) Model
// VO : �޸� �Ҵ��� �ƴϴ� (�Ϲ� ��������)
@Repository("dao")
public class MusicDAO {
	// Spring �ȿ� MyBatis���� �ڵ� ���� => �ڵ����� �ּҸ� �о� �´�
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
}
