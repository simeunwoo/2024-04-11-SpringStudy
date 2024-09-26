package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDAO dao;

	@Override
	public RecipeVO recipeMaxHitData() {
		// TODO Auto-generated method stub
		return dao.recipeMaxHitData();
	}

	@Override
	public List<RecipeVO> recipeHitTop8() {
		// TODO Auto-generated method stub
		return dao.recipeHitTop8();
	}
}
