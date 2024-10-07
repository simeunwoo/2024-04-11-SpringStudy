package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

	@Autowired
	private MemberService mService;
	
	@GetMapping(value="member/idcheck_vue.do",produces="text/plain;charset=UTF-8")
	public String member_idcheck(String userId)
	{
		int count=mService.idCheck(userId);
		
		return String.valueOf(count);
	}
}