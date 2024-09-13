package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.RecipeVO;
import com.sist.dao.*;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDAO dao;
	
	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return dao.recipeListData(start, end);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return dao.recipeTotalPage();
	}

}
