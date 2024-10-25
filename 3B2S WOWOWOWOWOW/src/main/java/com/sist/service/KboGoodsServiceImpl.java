package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class KboGoodsServiceImpl implements KboGoodsService{
	@Autowired
	private KboGoodsDAO kgDao;

	@Override
	public List<KboGoodsVO> kboGoodsListData(int start, int end) {
		// TODO Auto-generated method stub
		return kgDao.kboGoodsListData(start, end);
	}
	@Override
	public List<KboGoodsVO> kboGoodsFindListData(Map map) {
		// TODO Auto-generated method stub
		return kgDao.kboGoodsFindListData(map);
	}

	@Override
	public KboGoodsVO kboGoodsDetailData(int gno) {
		// TODO Auto-generated method stub
		return kgDao.kboGoodsDetailData(gno);
	}

	@Override
	public int kboGoodsTotalPage() {
		// TODO Auto-generated method stub
		return kgDao.kboGoodsTotalPage();
	}
	@Override
	public int kboGoodsFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return kgDao.kboGoodsFindTotalPage(map);
	}
	@Override
	public void GoodsCartInsert(KboGoodsCartVO vo) {
		// TODO Auto-generated method stub
		kgDao.GoodsCartInsert(vo);
	}
	@Override
	public void goodsCartAccountUpdate(KboGoodsCartVO vo) {
		// TODO Auto-generated method stub
		kgDao.goodsCartAccountUpdate(vo);
	}
	@Override
	public int goodsCartGnoCount(int gno) {
		// TODO Auto-generated method stub
		return kgDao.goodsCartGnoCount(gno);
	}
	@Override
	public List<KboGoodsCartVO> goodsCartListData(String id) {
		// TODO Auto-generated method stub
		return kgDao.goodsCartListData(id);
	}
	@Override
	public void goodsCartCancel(int cno) {
		// TODO Auto-generated method stub
		kgDao.goodsCartCancel(cno);
	}
	@Override
	public void goodsBuy(int cno) {
		// TODO Auto-generated method stub
		kgDao.goodsBuy(cno);
	}
	@Override
	public List<KboGoodsCartVO> goodsBuyListData(String id) {
		// TODO Auto-generated method stub
		return kgDao.goodsBuyListData(id);
	}
		
}
