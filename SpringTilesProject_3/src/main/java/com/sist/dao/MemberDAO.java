package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 * 	스프링에 관리 (클래스)
 * 		= DAO : @Repository
 * 		= Service : @Service
 * 		= Manager : @Component ===> 일반 클래스
 * 		= Controller : @Controller
 * 		= Interceptor : xml => <bean>
 * 		= AOP : @Component ===> 일반 클래스
 * 		~~~~~~~~~~~~~~~~~~~~~ 스프링에 의하여 관리
 * 
 * 	(제외)
 *	 	= interface : 메모리 할당이 불가능
 * 		= ~VO : 클래스 => 데이터형
 * 
 * 	클래스
 * 	1) 데이터형 클래스 => 변수로 구성
 * 		= 사용자 정의 데이터형 => ~VO, ~DTO, ~Bean
 * 		= 데이터 여러개를 묶어서 한번에 관리할 목적
 * 	2) 액션 클래스 => 기능을 가지고 있는 클래스 => 메소드로 구성 => 스프링 관리
 */
@Repository // 메모리 할당 요청 => 스프링이 관리
public class MemberDAO {

	@Autowired // 스프링에서 메모리 할당이 된 경우에만 사용 가능
	private MemberMapper mapper;
	
	public int memberIdCount(String id)
	{
		return mapper.memberIdCount(id);
	}
		
	public MemberVO memberGetPassword(String id)
	{
		return mapper.memberGetPassword(id);
	}
}
