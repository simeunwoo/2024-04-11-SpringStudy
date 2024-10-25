package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;


public interface TicketMapper {
	@Select("SELECT DISTINCT home,away,game_date,num "
			+ "			 FROM (SELECT DISTINCT home,away,game_date,rownum as num "
			+ "                   FROM (SELECT DISTINCT home,away,game_date "
			+ "						 FROM game "
			+ "						 ORDER BY game_date asc))")
	public List<GameVO> gameListData();
	
}
