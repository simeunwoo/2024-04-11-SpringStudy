package com.sist.service;
import com.sist.vo.*;
import java.util.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDAO gDao;

	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.goodsTotalPage();
	}

	@Override
	public void goodsHitIncrement(int no) {
		// TODO Auto-generated method stub
		gDao.goodsHitIncrement(no);
	}

	@Override
	public GoodsVO goodsDetailData(int no) {
		// TODO Auto-generated method stub
		return gDao.goodsDetailData(no);
	}

	@Override
	public MemberVO memberinfoData(String userId) {
		// TODO Auto-generated method stub
		return gDao.memberinfoData(userId);
	}

	@Override
	public void goodsCartInsert(CartVO vo) {
		// TODO Auto-generated method stub
		gDao.goodsCartInsert(vo);
	}
	
	
}
