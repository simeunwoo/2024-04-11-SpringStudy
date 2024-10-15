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

	@Override
	public void goodsCartAccountUpdate(CartVO vo) {
		// TODO Auto-generated method stub
		gDao.goodsCartAccountUpdate(vo);
	}

	@Override
	public int goodsCartGnoCount(int gno) {
		// TODO Auto-generated method stub
		return gDao.goodsCartGnoCount(gno);
	}

	@Override
	public List<CartVO> goodsCartListData(String id) {
		// TODO Auto-generated method stub
		return gDao.goodsCartListData(id);
	}

	@Override
	public void goodsCartCancel(int cno) {
		// TODO Auto-generated method stub
		gDao.goodsCartCancel(cno);
	}

	@Override
	public void goodsBuy(int cno) {
		// TODO Auto-generated method stub
		gDao.goodsBuy(cno);
	}

	@Override
	public List<CartVO> goodsBuyListData(String id) {
		// TODO Auto-generated method stub
		return gDao.goodsBuyListData(id);
	}
	
	
}
