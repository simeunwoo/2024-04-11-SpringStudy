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
}
