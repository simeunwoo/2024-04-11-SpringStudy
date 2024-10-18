package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM member_2s3b "
			+ "WHERE userId=#{userId}")
	public int idCheck(String userId);
	
	@Insert("INSERT INTO member_2s3b(userId, userName, userPwd, enabled, sex, birthday, email, post, addr1, addr2, phone) "
			+"VALUES(#{userId},#{userName},#{userPwd},1,#{sex},#{birthday},#{email},#{post},#{addr1},#{addr2},#{phone})")
	public void memberInsert(MemberVO vo);
	
	// role_admin / role_user
	@Insert("INSERT INTO authority VALUES(#{userId},'ROLE_USER') ")
	public void memberAuthorityInsert(String userId);
	
	//로그인 처리
	//ID여부 확인(idcheck)
	
	//비밀번호 검사
	@Select("SELECT userId,userName,userPwd,enabled, authority "
			+ "FROM member_2s3b sm, authority au "
			+ "WHERE sm.userId=au.userId "
			+ "AND pm.userId=#{userId}")
	public MemberVO memberInfoData(String userId);
	
	@Select("SELECT userId,userName,userPwd, sex, email "
			+ "FROM member_2s3b "
			+ "WHERE userId=#{userId}")
	public MemberVO memberSessionData(String userId);
}
