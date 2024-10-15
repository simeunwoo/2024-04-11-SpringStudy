package com.sist.service;
import java.util.*;
import com.sist.vo.*;

public interface GoodsService {

	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage();
	public void goodsHitIncrement(int no);
	public GoodsVO goodsDetailData(int no);
	public MemberVO memberinfoData(String userId);
}
