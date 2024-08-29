package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Select;

public interface MusicMapper {

	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music ORDER BY mno ASC")
	public List<MusicVO> musicListData();
}
