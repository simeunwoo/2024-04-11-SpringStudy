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
	
	//장바구니
	public void GoodsCartInsert(KboGoodsCartVO vo);
	   
	public void goodsCartAccountUpdate(KboGoodsCartVO vo);

	public int goodsCartGnoCount(int gno);
	   
	// 장바구니 보기 
	public List<KboGoodsCartVO> goodsCartListData(String id);
	   
	// 장바구니 삭제 
	public void goodsCartCancel(int cno);
	   
	// 장바구니 구매 
	public void goodsBuy(int cno);
	   
	public List<KboGoodsCartVO> goodsBuyListData(String id);
}
