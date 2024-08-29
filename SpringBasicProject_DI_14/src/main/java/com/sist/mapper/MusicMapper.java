package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

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
}
