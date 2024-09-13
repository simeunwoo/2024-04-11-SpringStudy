package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface RecipeMapper {

	@Select("SELECT no,title,chef,poster,num "
			+ "FROM (SELECT no,title,chef,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,title,chef,poster "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	// rownum => Top-N : 중간의 데이터를 읽을 수 없다
	public List<RecipeVO> recipeListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)")
	public int recipeTotalPage();
	/*
	 * 	INTERSECT : 교집합
	 * 	UNION : 합집합 (중복 데이터 제거)
	 * 	MINUS : 차집합
	 * 	UNION ALL : 합집합 (중복 데이터 포함)
	 */
}