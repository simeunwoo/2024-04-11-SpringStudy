package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.commons.CommonsPage;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		Map map=CommonsPage.pageConfig(page, 10);
		// CommonsPage 참고 => pageConfig(String page,int rowSize) => pageConfig(page,10)
		
		model.addAttribute("main_jsp", "../board/list.jsp");
		return "main/main";
	}
}
