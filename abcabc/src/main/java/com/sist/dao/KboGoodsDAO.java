package com.sist.dao;

import java.util.*;

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
}
