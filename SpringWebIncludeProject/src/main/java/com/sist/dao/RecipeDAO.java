package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDAO {

	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(Map map)
	{
		return mapper.recipeListData(map);
	}
	
	public int recipeRowCount()
	{
		return mapper.recipeRowCount();
	}
	
	/*
	@Update("UPDATE recipe SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void recipeHitIncrement(int no);
	
	@Select("SELECT * FROM recipedetail "
			+ "WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	 */
	public RecipeDetailVO recipeDetailData(int no)
	{
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
	
	/*
	@Select("SELECT chef,poster,men_cont1,men_cont3,men_cont7,men_cont2,num "
			+ "FROM (SELECT chef,poster,men_cont1,men_cont3,men_cont7,men_cont2,rownum as num "
			+ "FROM (SELECT chef,poster,men_cont1,men_cont3,men_cont7,men_cont2 "
			+ "FROM chef)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ChefVO> chefListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/50.0) FROM chef")
	public int chefTotalPage();
	 */
	public List<ChefVO> chefListData(Map map)
	{
		return mapper.chefListData(map);
	}
	public int chefTotalPage()
	{
		return mapper.chefTotalPage();
	}
}
