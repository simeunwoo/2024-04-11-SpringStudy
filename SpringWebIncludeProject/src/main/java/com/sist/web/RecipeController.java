package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;

@Controller
public class RecipeController {

/*	@Autowired // 생성자 활용 / 이런 경우 객체 생성 가능성 있음
	public RecipeController(RecipeService rService)
	{
		this.rService=rService;
	} */
	
	@Autowired
	private RecipeService rService;
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model) // Model(결과값)은 JSP로 전송 시에 사용 : forward
	{
		// 데이터베이스 연결 => 데이터를 읽기
		RecipeDetailVO vo=rService.recipeDetailData(no);
		
		// detail.jsp로 출력할 데이터 보내주기
		model.addAttribute("vo", vo);
		
		List<String> mList=new ArrayList<String>();
		List<String> iList=new ArrayList<String>();
		
		String[] make=vo.getFoodmake().split("\n");
		for(String m:make)
		{
			StringTokenizer st=new StringTokenizer(m,"^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		
		model.addAttribute("mList", mList); // 레시피 방식
		model.addAttribute("iList", iList); // 이미지
		
		model.addAttribute("main_jsp", "../recipe/detail.jsp");
		return "main/main"; 
	}
}
