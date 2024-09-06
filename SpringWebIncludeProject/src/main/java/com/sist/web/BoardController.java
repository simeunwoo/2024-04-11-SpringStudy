package com.sist.web;
import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.vo.*;
import com.sist.commons.CommonsPage;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 조립기 => Service + VO + DAO => 결과값 추출 => JSP로 전송
// DispatcherServlet과 연결
public class BoardController {
	// 객체를 이용하여 @Autowired를 사용하여 주소값을 받으면 => 속도가 늦다
	// 가급적이면 생성자를 이용한다 (객체보다는 생성자 선호)
	private BoardService bService;
	
	@Autowired // 생성자 활용 가능
	public BoardController(BoardService bService)
	{
		this.bService=bService;
	}
	
	@GetMapping("board/list.do") // 사용자가 게시판에 목록을 요청했다면 => 조건문
	// 어노테이션 1개는 if문 한개를 추가하는 것이다
	// 찾기 => 스프링에서 찾아서 처리
	public String board_list(String page,Model model)
	{
		// Map map=CommonsPage.pageConfig(page, 10);
			// => CommonsPage 참고 => pageConfig(String page,int rowSize) => pageConfig(page,10)
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=10;
		// CommonsPage 설정 시 => rowSize 개수 설정은 X => 언제든지 바뀔 수 있으므로
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		List<ReplyBoardVO> list=bService.boardListData(start, end);
		int count=bService.boardRowCount();
		int totalpage=(int)(Math.ceil(count/(double)rowSize));
		count=count-((curpage*rowSize)-rowSize);
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		model.addAttribute("main_jsp", "../board/list.jsp");
		return "main/main";
	}
	
	@GetMapping("board/insert.do")
	public String board_insert(Model model)
	{
		model.addAttribute("main_jsp", "../board/insert.jsp");
		return "main/main";
	}
	
	@PostMapping("board/insert_ok.do")
	public String board_insert_ok(ReplyBoardVO vo)
	{
		bService.boardInsert(vo);
		
		return "redirect:./board/list.do";
	}
	
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model)
	{
		model.addAttribute("main_jsp", "../board/detail.jsp");
		return "main/main";
	}
}
