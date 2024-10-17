package com.sist.vo;

import lombok.Data;
/*
NO      NOT NULL NUMBER         
TITLE   NOT NULL VARCHAR2(200)  
POSTER  NOT NULL VARCHAR2(500)  
MSG     NOT NULL VARCHAR2(4000) 
ADDRESS NOT NULL VARCHAR2(300)  
 */
/*
 * 	스프링 : 객체 생성 ~ 소멸
 * 		=> 기본적으로 모든 클래스를 관리
 * 			VO : 데이터형 (사용자)
 * 			===========
 * 			Mapper
 * 			Service
 * 			=========== 인터페이스 => 연결용
 * 		=> 재사용 기법 : 싱글턴
 * 		=> @Autowired => 스프링에서 메모리가 할당된 클래스 안에서만 찾아서 주소를 대입
 * 			=> 오라클 : 자바를 유료화
 * 					  ========== 자바 => 코틀린
 * 
 * 	@Component => 싱글턴
 * 	@Scope("prototype") => 요청 시마다 새롭게 메모리 할당
 * 	class A
 * 
 * 	VO, DTO : 데이터를 모아서 전송
 * 	ENTITY : 데이터베이스 컬럼과 연동 => JPA
 * 
 * 	Spring => VO => MyBatis 중심
 * 	Spring-Boot => Entity => JPA 중심 (***)
 */
@Data
public class SeoulVO {

	private int no;
	private String title,poster,msg,address,addr;
}
