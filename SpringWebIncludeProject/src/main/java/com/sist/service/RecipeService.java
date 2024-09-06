package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

// 인터페이스는 메모리 할당이 불가능
public interface RecipeService {

	public List<RecipeVO> recipeListData(Map map);
	public int recipeRowCount();
	public RecipeDetailVO recipeDetailData(int no);
	public List<ChefVO> chefListData(Map map);
	public int chefTotalPage();
	public List<RecipeVO> chefMakeRecipeData(Map map);
	public int chefMakeRecipeTotalPage(String chef);
	public RecipeVO recipeCookieInfoData(int no);
	public List<RecipeVO> recipeFindData(Map map);
	public int recipeFindTotalPage(Map map);
}
