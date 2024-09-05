package com.sist.service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.GoodsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDAO dao;

	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return dao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage() {
		// TODO Auto-generated method stub
		return dao.goodsTotalPage();
	}

	@Override
	public void goodsHitIncrement(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GoodsVO goodsDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.goodsDetailData(no);
	}

	@Override
	public GoodsVO goodsCookieData(int no) {
		// TODO Auto-generated method stub
		return dao.goodsCookieData(no);
	}
	
	
}
