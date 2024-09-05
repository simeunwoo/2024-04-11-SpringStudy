package com.sist.service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
	JSP => Controller => Service => Repository => Oracle
	Oracle => Repository => Service => Controller => JSP
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDAO dao;
	
	@Override
	public List<RecipeVO> recipeListData(Map map) {
		return dao.recipeListData(map);
	}
	
	@Override
	public int recipeRowCount() {
		return dao.recipeRowCount();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.recipeDetailData(no);
	}
	
	
}
