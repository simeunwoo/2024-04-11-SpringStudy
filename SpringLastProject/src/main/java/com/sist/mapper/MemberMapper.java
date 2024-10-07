package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

	// ID 중복 체크
	@Select("SELECT COUNT(*) FROM spring_member "
			+ "WHERE userId=#{userId}")
	public int idCheck(String userId);
	
	// 회원 가입
	@Insert("INSERT INTO spring_member(userId,userName,userPwd,enabled,sex,birthday,"
			+ "email,post,addr1,addr2,phone,content) "
			+ "VALUES(#{userId},#{userName},#{userPwd},1,#{sex},#{birthday},"
			+ "#{email},#{post},#{addr1},#{addr2},#{phone},#{content})")
	public void memberInsert(MemberVO vo);
	
	@Insert("INSERT INTO authority "
			+ "VALUES(#{userId},'ROLE_USER')")
	public void memberAuthorityInsert(String userId);
	// role_admin은 동시에 role_user가 될 수 있다 ex) admin도 마이 페이지 방문, 상품 구매 가능
}
