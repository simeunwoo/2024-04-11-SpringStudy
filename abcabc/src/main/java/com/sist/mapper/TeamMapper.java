package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface TeamMapper {

	@Select("SELECT name,syear,home,logo "
			+ "FROM teamdetail "
			+ "ORDER BY name ASC")
	public List<TeamDetailVO> teamListData();
	
	@Select("SELECT * FROM teamdetail "
			+ "WHERE name=#{name}")
	public TeamDetailVO teamDetailData(String name);
	
	@Select("SELECT * FROM team ORDER BY no ASC")
	public List<TeamVO> teamRankingData();
}
