package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

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
	
	@GetMapping("recipe/detail_before.do")
	public String recipe_detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
	{
		// Cookie 제작 => 저장 => 브라우저 전송 (반드시 매개 변수는 HttpServletResponse response로 받아야 한다)
		
		// 전송 객체 => Model : forward 방식
		// 전송 객체 => RedirectAttributes : sendRedirect 방식
		ra.addAttribute("no", no);
	//	ra.addFlashAttribute("no", no);
		return "redirect:../recipe/detail.do";
	}
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model) // Model(결과값)은 JSP로 전송 시에 사용 : forward
	{
		// 데이터베이스 연결 => 데이터를 읽기
		RecipeDetailVO vo=rService.recipeDetailData(no);
		
		String data=vo.getData();
		data=data.replace("구매", "");
		vo.setData(data.trim());
		
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
	
	@GetMapping("recipe/chef_list.do")
	public String recipe_chef_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=50;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<ChefVO> list=rService.chefListData(map);
		int totalpage=rService.chefTotalPage();

		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		model.addAttribute("main_jsp", "../recipe/chef_list.jsp");
		return "main/main";
	}
	/*
		반복 코딩
		=> 메소드 처리
			메소드 : 반복 제거 기능, 단점은 반드시 호출을 해야 한다
		=> AOP 이용
			AOP : 자동 호출이 가능 => 호출 위치 지정 : JoinPoint
		
		public void display()
		{
			=== 자동 호출 가능 => (before)
			try
			{
				=== 핵심 모듈
			}catch(Exception ex)
			{
				=== 자동 호출 가능 => (after-throwing)
			}
			finally
			{
				=== 자동 호출 가능 => (after)
			}
			return === 자동 호출 가능 => (after-returning)
		}
		
	*/
	
	// 셰프 상세
	@GetMapping("recipe/chef_detail.do")
	public String recipe_chef_detail(String page,String chef,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("chef", chef);
		map.put("start", start);
		map.put("end", end);
		
		List<RecipeVO> list=rService.chefMakeRecipeData(map);
		int totalpage=rService.chefMakeRecipeTotalPage(chef);
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("chef", chef);
		
		model.addAttribute("main_jsp", "../recipe/chef_detail.jsp");
		return "main/main";
	}
}
