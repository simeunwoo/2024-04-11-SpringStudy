package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@Controller
public class RecipeController {

	@Autowired
	private RecipeDAO rDao;
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model)
	{
		// DB 연동
		RecipeDetailVO vo=rDao.recipeDetailData(no);
		String data=vo.getData();
		data=data.replace("구매", "");
		vo.setData(data.trim());
		
		List<String> mList=new ArrayList<String>();
		List<String> iList=new ArrayList<String>();
		
		String[] foodMake=vo.getFoodmake().split("\n");
		for(String fm:foodMake)
		{
			StringTokenizer st=new StringTokenizer(fm, "^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		
		// JSP에 출력할 데이터 전송
		model.addAttribute("vo", vo);
		model.addAttribute("mList", mList);
		model.addAttribute("iList", iList);
		
		return "recipe/detail";
	}
}
