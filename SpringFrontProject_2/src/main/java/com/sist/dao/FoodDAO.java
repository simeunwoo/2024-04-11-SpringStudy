package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
/*
 *	스프링 어노테이션
 *		= 메모리 할당 => 스프링에 클래스 관리 요청
 *	                        ======== 생성 ~ 소멸 => 필요 시에는 주소값을 얻어서 사용
 *		구분
 *		===
 *		DAO =========> @Repository : 저장소, 데이터베이스 연결
 *		SERVICE =====> @Service : BI (DAO 여러개를 통합)
 *		MODEL =======> @Controller : 화면 제어
 *		               @RestController : 자바스크립트/코틀린과 같이 다른 언어와 연결
 *		EXCEPTION ===> 공통 예외 처리 => 모든 모델 클래스의 예외 처리를 한번에 처리
 *		               @ControllerAdvice / @RestControllerAdvice
 *		일반 클래스 : OpenAPI => @Component
 *
 *		= 모든 클래스를 메모리 할당 요청하지는 않는다
 *			~VO : 사용자 정의 데이터형
 *			인터페이스는 메모리 할당을 하지 않는다
 *		= 공통으로 사용되는 기능을 모아서 관리 => 공통 모듈
 *			@Aspect => AOP
 *		= 자바로 환경 설정 => @Bean
 *		= React 연결 : 포트가 다르다 (서버 연결을 할 수 없다 => 포트 허용)
 *		= 보안 / 스케쥴러
 */
@Repository
public class FoodDAO {

	@Autowired
	private FoodMapper mapper; // 스프링에서 구현된 객체 주소를 받는다 => 자동 주입
	
	public List<FoodVO> foodListData(int start,int end)
	{
		return mapper.foodListData(start, end); 
	}
	// 여러개의 매개 변수 => @Param, Map, VO
	
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
}
