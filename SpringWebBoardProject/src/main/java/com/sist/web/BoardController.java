package com.sist.web;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 모델 클래스 => HandlerMapping에서 처리
public class BoardController {

	// 필요한 객체를 스프링에서 얻어 온다
	@Autowired
	private BoardDAO dao; // new를 사용하면 안된다 => 스프링에서 가져오는 것이므로 (새로 생성 X)
	
	// 가급적이면 @RequestMapping 사용하지 않기
	// @RequestMapping => GET + POST => 나눠서 사용을 권장
	@GetMapping("board/list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		List<BoardVO> list=dao.boardListData(start, end);
		
		// 총 페이지
		int count=dao.boardRowCount();
		int totalpage=(int)(Math.ceil(count/(double)rowSize));
		count=count-((rowSize*curpage)-rowSize);
		
		// 사용자로부터 받는 값 => Model : 결과값 전송 객체
		// 출력에 필요한 데이터를 list.jsp로 전송
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("count", count);
		/*
		 * 	public void addAttribute(String key,Object obj)
		 * 	{
		 * 		request.setAttribute(key,obj);
		 * 	}
		 */
		
		return "board/list"; // .jsp를 붙이면 404 오류 발생
	}
	/*
	 * 	메소드 규칙
	 * 	========
	 * 	리턴형
	 * 		= String : 파일 지정 / redirect
	 * 		= void : 파일 다운로드, (Ajax, VueJS => JSON 전송)
	 * 	매개 변수 : getParameter() => 변수, VO 단위, List 단위, 배열 단위
	 * 		내장 객체
	 * 			=> HttpServletRequset, HttpServletResponse
	 * 			=> HttpSession, Model model
	 * 			=> RedirectAttributes
	 * 			=> 순서는 상관 없다
	 * 	메소드명 : 개발자가 원하는 메소드명 ...
	 * 	=> 한글 => web.xml에 등록 => setCharacterEncoding을 사용하지 않는다
	 */
	
	// 게시판 입력창을 요청
	@GetMapping("board/insert.do") // 412, 매개 변수 => 400
	public String board_insert()
	{
		return "board/insert";
	}
	@PostMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo) // 커맨드 객체 => VO 단위로 값을 받는 경우
	{
		// dao 연동
		dao.boardInsert(vo);
		
		// 비밀 번호 암호화
		
		return "redirect:list.do";
	}
	
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model) // 여기서는 request는 model에 해당
	{
		// 데이터 읽기 상세 보기
		BoardVO vo=dao.boardDetailData(no);
		
		model.addAttribute("vo", vo);
		
		return "board/detail";
	}
	
	@GetMapping("board/update.do")
	public String board_update(int no,Model model)
	{
		// 데이터베이스 연동
		BoardVO vo=dao.boardUpdateData(no);
		
		// 결과값 전송
		model.addAttribute("vo", vo);
		
		return "board/update";
	}
	
	@PostMapping("board/update_ok.do")
	@ResponseBody // 자바스크립트나 JSON을 전송 시에 사용 => 진화 : @RestController
	public String board_update_ok(BoardVO vo,Model model)
	{
		// 데이터베이스 연동
		boolean bCheck=dao.boardUpdate(vo);
		
		// 결과값 전송 => @ResponseBody를 사용하면 따로 보낼 필요 없음
	//	model.addAttribute("bCheck", bCheck);
	//	model.addAttribute("no", vo.getNo());
		
		// 이동 화면이 2가지 => 이전 (자바스크립트), 상세 보기
		// @Controller => 무조건 => return은 파일명이나 .do
		// 자바스크립트를 전송 => 실행 @ResponseBody, @RestController
		// @ResponseBody는 한글이 깨진다 => 영문으로 전송
		
		if(bCheck==true)
		{
			js="<script>"
					+ "location.href=\"detail.do?no="+vo.getNo()+"\";"
							+ "</script>";
		}
		else
		{
			js="<script>"
					+ "alert(\"비밀 번호가 잘못됐습니다\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return js;
	}
}
