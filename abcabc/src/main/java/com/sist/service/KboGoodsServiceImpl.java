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
	

	
	
	
}
