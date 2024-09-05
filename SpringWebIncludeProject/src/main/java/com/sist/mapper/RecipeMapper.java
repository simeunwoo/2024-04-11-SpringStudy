package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.*;

import com.sist.vo.*;

public interface RecipeMapper {

	// 목록 출력
	@Select("SELECT no,poster,title,chef,num "
			+ "FROM (SELECT no,poster,title,chef,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,poster,title,chef "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT COUNT(*) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
	public int recipeRowCount();
	
	// 상세 보기
	@Update("UPDATE recipe SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void recipeHitIncrement(int no);
	
	@Select("SELECT * FROM recipedetail "
			+ "WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
	// 셰프 목록 출력
	@Select("SELECT chef,poster,men_cont1,men_cont3,men_cont7,men_cont2,num "
			+ "FROM (SELECT chef,poster,men_cont1,men_cont3,men_cont7,men_cont2,rownum as num "
			+ "FROM (SELECT chef,poster,men_cont1,men_cont3,men_cont7,men_cont2 "
			+ "FROM chef)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ChefVO> chefListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/50.0) FROM chef")
	public int chefTotalPage();
	
	// 셰프 상세 보기
	
	// 레시피 찾기
}
