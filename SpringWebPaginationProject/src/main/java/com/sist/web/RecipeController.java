package com.sist.web;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
	JSP => RecipeController와 연결
	오라클 => RecipeDAO와 연결
 */
import org.springframework.web.bind.annotation.RequestMapping;
@Controller // 메모리 할당
// JSP로 값을 전송 => DispatcherServlet과 연결
public class RecipeController {

//	private RecipeDAO dao=new RecipeDAO(); // (X) 이렇게 코딩하면 안된다 => 이렇게 코딩하면 null 값이 나올 수 있다
	
	@Autowired
	private RecipeDAO dao;
	
	// 매칭 => 사용자 전송 URL => 메소드 호출
	@RequestMapping("recipe/list.do")
	/*
		int page=null (X) => int는 null을 받을 수 없으므로
		String page=null => String을 사용하여 null을 받을 수 있게 한다
		
		Vue / React => int page 사용 가능 (Java에서는 불가능)
	 */
	public String recipe_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashedMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		
		List<RecipeVO> list=dao.recipeListData(map);
		int count=dao.recipeRowCount();
		int totalpage=(int)(Math.ceil(count/20.0));
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "recipe/list";
	}
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model)
	{
		// 데이터베이스 연결 => 상세 보기
		
		// 상세 보기에서 출력할 데이터 전송 => Model
		
		return "recipe/detail";
	}
	
}
