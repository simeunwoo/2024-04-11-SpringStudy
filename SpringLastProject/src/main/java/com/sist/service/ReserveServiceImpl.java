package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	private ReserveDAO rDao;

	@Override
	public List<FoodVO> reserveFoodInfoData(Map map) {
		// TODO Auto-generated method stub
		return rDao.reserveFoodInfoData(map);
	}

	@Override
	public int reserveFoodTotalPage(String type) {
		// TODO Auto-generated method stub
		return rDao.reserveFoodTotalPage(type);
	}

	@Override
	public void reserveInsert(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDao.reserveInsert(vo);
	}

	@Override
	public List<ReserveVO> reserveMyPageListData(String id) {
		// TODO Auto-generated method stub
		return rDao.reserveMyPageListData(id);
	}

	@Override
	public List<ReserveVO> reserveAdminListData() {
		// TODO Auto-generated method stub
		return rDao.reserveAdminListData();
	}

	@Override
	public void reserveOk(int rno) {
		// TODO Auto-generated method stub
		rDao.reserveOk(rno);
	}

	@Override
	public ReserveVO reserveInfoData(int rno) {
		// TODO Auto-generated method stub
		return rDao.reserveInfoData(rno);
	}
}
