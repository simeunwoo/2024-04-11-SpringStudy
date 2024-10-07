package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.*;
import com.sist.service.*;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("member/join.do")
	public String member_join()
	{
		return "member/join";
	}
	
	@PostMapping("member/join_ok.do")
	public String member_join_ok(MemberVO vo)
	{
		System.out.println(vo);
		
		vo.setPhone(vo.getPhone()+"-"+vo.getPhone2());
		// 비밀 번호 암호화
		String enPwd=encoder.encode(vo.getUserPwd());
		vo.setUserPwd(enPwd);
		
		mService.memberInsert(vo);
		mService.memberAuthorityInsert(vo.getUserId());
		
		// insert / insert
		
		return "redirect:../main/main.do";
	}
}
