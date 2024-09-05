package com.sist.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// HandlerMapping => @Controller만 찾는다 : DispatcherServlet과 연결
// 요청을 받아서 => 데이터베이스 연동 => JSP로 결과값(Model) 전송
// 전체 프로그램의 조립기 (main)
/*
	요청
	-----------------------------------------
	=> 요청 분리 (구분)
		@RequestMapping => GET/POST 동시에 처리
		= @GetMapping
		= @PostMapping
	-----------------------------------------
	=> 요청하는 데이터
		사용자가 보내준 데이터
		예) 상세 보기 => (번호)
			로그인 => id, pwd
			검색 => 검색어
			목록 => 페이지
			================ getParameter() => 매개 변수
	-----------------------------------------
	=> 요청 결과 전송 : Model (전송 객체를 이용)
	
	검색 (PostMapping) => <form>
	|
	페이지 나누기 (GetMapping) => <a>
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	RequestMapping은 Spring 6에서 제거됨 (라이브러리 자체 삭제)
	그러나 GetMapping, PostMapping은 여전히 존재
	
	### 동작 순서 ###
		JSP
			=> 요청 => <a>, <form> => .do
		Controller
			=> @GetMapping(".do")
		Mapper
			=> SQL 문장
		DAO
			=> SQL 구현
		-----------------------------------
		Controller
			=> DAO 호출
			=> Model에 담기
		JSP
			=> 출력
 */
@Controller
public class MainController {

	@GetMapping("main/main.do")
	public String main_main()
	{
		// include할 JSP를 지정
		return "main/main";
	}
}