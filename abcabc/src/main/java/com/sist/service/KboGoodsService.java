package com.sist.service;

import java.util.*;

import com.sist.vo.*;

public interface KboGoodsService {
	//굿즈 리스트
	
	public List<KboGoodsVO> kboGoodsListData(int start, int end);
	public List<KboGoodsVO> kboGoodsFindListData(Map map);
	
	//상세보기
	public KboGoodsVO kboGoodsDetailData(int gno);
	
	//총 페이지
	public int kboGoodsTotalPage();
	public int kboGoodsFindTotalPage(Map map);
	
}
