package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.ReserveDAO;
import com.sist.vo.ReserveVO;

@Service
public class ReserveServiceImpl implements ReserveService{
	@Autowired
	private ReserveDAO rDao;

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
	public List<ReserveVO> reserveAdminListData(String id) {
		// TODO Auto-generated method stub
		return rDao.reserveAdminListData(id);
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
