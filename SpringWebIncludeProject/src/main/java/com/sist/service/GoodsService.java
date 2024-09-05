package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.GoodsVO;

public interface GoodsService {

	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage();
	public void goodsHitIncrement(int no);
	public GoodsVO goodsDetailData(int no);
}
