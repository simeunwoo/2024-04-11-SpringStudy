package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

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
	
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	
	public RecipeDetailVO recipeDetailData(int no)
	{
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
	
	public List<RecipeVO> recipeFindData(Map map)
	{
		return mapper.recipeFindData(map); // 동적 쿼리
	}
	
	public int recipeFindTotalPage(Map map)
	{
		return mapper.recipeFindTotalPage(map);
	}
	
	public List<ChefVO> chefListData(Map map)
	{
		return mapper.chefListData(map);
	}
	
	public int chefTotalPage()
	{
		return mapper.chefTotalPage();
	}
	
	public List<RecipeVO> chefMakeData(Map map)
	{
		return mapper.chefMakeData(map);
	}
	
	public int chefMakeTotalPage(Map map)
	{
		return mapper.chefMakeTotalPage(map);
	}
}
