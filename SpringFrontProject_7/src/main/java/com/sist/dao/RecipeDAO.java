package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 * 	~VO : 데이터형 => class : 관련된 데이터를 모아서 관리 (다른 데이터형을 모아서 처리)
 * 	~Mapper
 * 	~Service
 * 	--------- 메모리 할당에서 제외
 * 
 * 	class 종류
 * 	= 데이터형 클래스
 * 	= 액션 클래스 (기능 => 메소드)
 * 		~DAO / ~Manager / ~Service / ~Controller / ~RestController
 * 		===> 스프링에서 관리 => 반드시 등록 (생성 ~ 소멸)
 * 		~DAO : @Repository
 * 		~Manager : @Component, AOP
 * 		~Service : @Service, DAO 여러개를 통합하여 사용 (BI)
 * 		~Controller : @Controller
 * 		~RestController : @RestController
 */
@Repository
public class RecipeDAO {

	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(Map map)
	{
		return mapper.recipeListData(map);
	}

	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}

	public RecipeDetailVO recipeDetailData(int no)
	{
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
}
