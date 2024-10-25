package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
    private NewsDAO nDao;

	@Override
	public List<NewsVO> newsListData(Map map) {
		// TODO Auto-generated method stub
		return nDao.newsListData(map);
	}

	@Override
	public int newsTotalPage(Map map) {
		// TODO Auto-generated method stub
		return nDao.newsTotalPage(map);
	}
	
	@Override
	public NewsVO newsDetailData(int nno) {
		// TODO Auto-generated method stub
		return nDao.newsDetailData(nno);
	}

	@Override
	public List<NewsVO> newsHitTop8() {
		// TODO Auto-generated method stub
		return nDao.newsHitTop8();
	}
}
