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
	
	/*
		매개 변수 : 순서와 상관 없다
			사용자 요청값
				=> String / int / String[] / VO
			라이브러리 클래스 (내장 객체)
				=> HttpServletRequest : Cookie 읽기
				=> HttpServletResponse : Cookie 저장, 다운로드
				=> HttpSession
				=> 데이터 전송 : Model
				=> sendRedirect로 데이터 전송 : RedirectAttributes
				=> 보안 : 보안 클래스 (여러개 있음)
		
		리턴형 : String / void
			String
				request를 전송 => forward => "경로명/JSP명"
				이전(기존) 화면 이동 => sendRedirect => "redirect:~.do" => request를 전송하지 X
			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 화면 변경
			void : Ajax / 다운로드 / 스케줄러=>task
			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 화면 변경 X
			
		메소드명 : 개발자가 설정 => @GetMapping => URL 주소
		
		=> detail.do?no=10 => 모든 데이터는 String으로 받을 수 있다
		   ---------------
		   (String no) -> Integer.parseInt(no)
		   (int no)
		=> 데이터가 많은 경우
			VO (*******)
			List (*******) : File 멀티 업로드
			String[] : checkbox
		=> 에러 종류
			404 : 파일이 없는 경우 => 경로명, 파일 여부
			500 : 소스 오류 => SQL 문장, null일 때 String 메소드 이용
			400 : Bad Request => 매개 변수의 데이터형이 다른 경우
			405 : GET/POST 관련 오류 => (GET => @Getmapping / POST => @PostMapping)
				<form>, ajax, axios.post
			403 : 접근 거부 => 권한 부여 => security
			412 : UTF-8 => 한글 변환 코드가 틀린 경우
		   
	 */
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model)
	{
		// 데이터베이스 연동
		ReplyBoardVO vo=bService.boardDetailData(no);
		
		// 결과값 전송
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../board/detail.jsp");
		// request.setAttribute() => model.addAttribute()
		/*
		 * 	request/response를 사용하면 안되는 이유
		 * 	----------------
		 * 	사용자 정보를 가지고 있다 => IP, 컴퓨터에 대한 정보가 노출 가능
		 * 	스프링 5 => 보안 강조
		 * 		request/response 사용 빈도가 거의 없어짐
		 * 		XML을 사용하지 않는다 => 자바 설정 파일이 생성
		 */
		return "main/main"; // forward => request 전송 => class화 시킨 것이 Model
	}
	
	@GetMapping("board/update.do")
	public String board_update(int no,Model model)
	{
		ReplyBoardVO vo=bService.boardUpdateData(no);
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_jsp", "../board/update.jsp");
		return "main/main";
	}
	
	@GetMapping("board/reply.do")
	public String board_reply(int no,Model model)
	{
		model.addAttribute("no", no);
		
		model.addAttribute("main_jsp", "../board/reply.jsp");
		return "main/main";
	}
}
