package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class KboGoodsDAO {
	@Autowired
	private KboGoodsMapper mapper;
	
	//굿즈 리스트
	public List<KboGoodsVO> kboGoodsListData(int start, int end){
		return mapper.kboGoodsListData(start, end); 
	}
	
	public List<KboGoodsVO> kboGoodsFindListData(Map map){
		return mapper.kboGoodsFindListData(map); 
	}
	
	//상세보기
	public KboGoodsVO kboGoodsDetailData(int gno) {
		return mapper.kboGoodsDetailData(gno);
	}
	
	//총 페이지
	public int kboGoodsTotalPage() {
		return mapper.kboGoodsTotalPage();
	}
	public int kboGoodsFindTotalPage(Map map) {
		return mapper.kboGoodsFindTotalPage(map);
	}
	
	//장바구니
	public void GoodsCartInsert(KboGoodsCartVO vo) {
		mapper.GoodsCartInsert(vo);
	}
	   
	public void goodsCartAccountUpdate(KboGoodsCartVO vo) {
		mapper.goodsCartAccountUpdate(vo);
	}

	public int goodsCartGnoCount(int gno) {
		return mapper.goodsCartGnoCount(gno);
	}
	   
	// 장바구니 보기 
	public List<KboGoodsCartVO> goodsCartListData(String id){
		return mapper.goodsCartListData(id);
	}
	   
	// 장바구니 삭제 
	public void goodsCartCancel(int cno) {
		mapper.goodsCartCancel(cno);
	}
	   
	// 장바구니 구매 
	public void goodsBuy(int cno) {
		mapper.goodsBuy(cno);
	}
	   
	public List<KboGoodsCartVO> goodsBuyListData(String id){
		return mapper.goodsBuyListData(id);
	}
}
