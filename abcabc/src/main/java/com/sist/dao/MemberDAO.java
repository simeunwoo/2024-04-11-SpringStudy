package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public int idCheck(String userId) {
		return mapper.idCheck(userId);
	}
	
	public void memberInsert(MemberVO vo) {
		mapper.memberInsert(vo);
	}
	
	public void memberAuthorityInsert(String userId) {
		mapper.memberAuthorityInsert(userId);
	}
	
	public MemberVO memberInfoData(String userId) {
		return mapper.memberInfoData(userId);
	}
	
	public MemberVO memberSessionData(String userId) {
		return mapper.memberSessionData(userId);
	}
}
