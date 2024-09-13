package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// => 경우의 수가 많은 경우 => ID, PWD, OK => 자바스크립트 이용
@RestController
public class MemberRestController {

	@Autowired
	private MemberService mService;
	
	@PostMapping("member/login_ok.do")
	public String member_login_ok(String id,String pwd,HttpSession session)
	{
		String result="";
		MemberVO vo=mService.isLogin(id, pwd);
		
		if(vo.getMsg().equals("NOID"))
		{
			result="<script>"
					+ "alert(\"없는 아이디입니다\");"
					+ "history.back();"
					+ "</script>";
		}
		else if(vo.getMsg().equals("NOPWD"))
		{
			result="<script>"
					+ "alert(\"비밀 번호가 잘못됐습니다\");"
					+ "history.back();"
					+ "</script>";
		}
		else
		{
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin", vo.getAdmin());
			
			result="<script>"
					+ "location.href=\"../main/main.do\";"
					+ "</script>";
			/*
			 * 	스프링을 통하여 내장 객체를 매개 변수로 받는다
			 * 		HttpSession
			 * 		HttpServletRequest => Cookie
			 * 		HttpServletResponse => Cookie, 업로드
			 * 		Model => 데이터 전송 : forward => request를 JSP로 전송
			 * 		RedirectAttributes : sendRedirect()
			 * 		security
			 */
		}
		
		return result;
	}
}
