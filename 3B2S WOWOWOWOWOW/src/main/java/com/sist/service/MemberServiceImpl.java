package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO mDao;
	
	
	@Override
	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return mDao.idCheck(userId);
	}

	@Override
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		mDao.memberInsert(vo);
	}

	@Override
	public void memberAuthorityInsert(String userId) {
		// TODO Auto-generated method stub
		mDao.memberAuthorityInsert(userId);
	}

	@Override
	public MemberVO memberInfoData(String userId) {
		// TODO Auto-generated method stub
		return mDao.memberInfoData(userId);
	}

	@Override
	public MemberVO memberSessionData(String userId) {
		// TODO Auto-generated method stub
		return mDao.memberSessionData(userId);
	}


	@Override
	public void mypageDelete(String userId) {
		// TODO Auto-generated method stub
		mDao.mypageDelete(userId);   
	}

	@Override
	public MemberVO mypageUpdateData(String userId) {
		// TODO Auto-generated method stub
		return mDao.mypageUpdateData(userId);
	}

	@Override
	public void mypageUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		mDao.mypageUpdate(vo);
	}

	@Override
	public int mypageBuyCount(String id) {
		// TODO Auto-generated method stub
		return mDao.mypageBuyCount(id);
	}

	@Override
	public int mypageCartCount(String id) {
		// TODO Auto-generated method stub
		return mDao.mypageCartCount(id);
	}

	@Override
	public int mypageTicketCount(String id) {
		// TODO Auto-generated method stub
		return mDao.mypageTicketCount(id);
	}

	@Override
	public int mypageHotelCount(String id) {
		// TODO Auto-generated method stub
		return mDao.mypageHotelCount(id);
	}

	@Override
	public int mypageBoardCount(String id) {
		// TODO Auto-generated method stub
		return mDao.mypageBoardCount(id);
	}

	@Override
	public int mypageReplyCount(String id) {
		// TODO Auto-generated method stub
		return 0;
	} 

}
