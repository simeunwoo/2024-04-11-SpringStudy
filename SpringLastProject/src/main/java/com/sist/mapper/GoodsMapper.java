package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Select;

public interface GoodsMapper {

	@Select("SELECT no,goods_price,goods_poster,goods_name,hit,num "
			+ "FROM (SELECT no,goods_price,goods_poster,goods_name,hit,rownum as num "
			+ "FROM (SELECT no,goods_price,goods_poster,goods_name,hit "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
}
