package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface TeamMapper {

	@Select("SELECT name,syear,home,logo "
			+ "FROM teamdetail "
			+ "ORDER BY name ASC")
	public List<TeamDetailVO> teamListData();
}
