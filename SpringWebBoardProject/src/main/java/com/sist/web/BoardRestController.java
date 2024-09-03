package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController // 자바스크립트나 다른 언어를 연결할 때 사용 => 파일을 제어하지 않는다 => 문자열, JSON, 자바스크립트 전송이 가능
public class BoardRestController {

	@Autowired // 싱글턴 => BoardController에도 똑같이 있음 => 별개 (객체이므로)
	private BoardDAO dao;
	
	@PostMapping(value="board/update_ok.do",produces="text/html;charset=UTF-8")
	public String board_update_ok(BoardVO vo)
	{
		String js="";
		
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
					+ "alert(\"비밀 번호가 잘못됐습니다\n다시 쓰세요\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return js;
	}
	
	@PostMapping(value="board/delete_ok.do",produces="text/html;charset=UTF-8")
	public String board_delete_ok(int no,String pwd) // no, pwd => 매개 변수이지만 getParameter()에도 해당
	// getParameter() => 스프링 (DispatcherServlet)
	{
		String js="";
		
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==false)
		{
			js="<script>"
					+ "alert(\"비밀 번호가 잘못됐습니다\");"
					+ "history.back();"
					+ "</script>";
		}
		else
		{
			js="<script>"
					+ "location.href=\"list.do\";"
					+ "</script>";
		}
		
		return js;
	}
	
}
