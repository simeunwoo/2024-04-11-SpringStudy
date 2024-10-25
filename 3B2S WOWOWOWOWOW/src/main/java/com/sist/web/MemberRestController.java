package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.MemberService;
import com.sist.vo.BoardVO;
import com.sist.vo.MemberVO;

@RestController
public class MemberRestController {
	@Autowired
	private MemberService mService;
	
	@GetMapping(value="member/idcheck_vue.do", produces="text/plain;charset=UTF-8")
	public String member_idcheck(String userId) {
		int count=mService.idCheck(userId);
		return String.valueOf(count);
	}
	
	  @GetMapping(value = "mypage/mypage_update_vue.do", produces = "text/plain;charset=UTF-8")
	  public String mypage_update(String userId) throws Exception {
		  MemberVO vo = mService.mypageUpdateData(userId);
		  ObjectMapper mapper = new ObjectMapper();
		  String json = mapper.writeValueAsString(vo);
		  return json;
	  }
	  
	  
	  @PostMapping(value = "mypage/mypage_update_ok_vue.do", produces = "text/plain;charset=UTF-8")
	  public String mypage_update_ok(MemberVO vo) {
		  String result="";
		  try {
			  mService.mypageUpdate(vo);
			  result="yes";
		  }catch(Exception ex) {
			  result = ex.getMessage();
		  }
		  
		  return result;
	  }
	  
	  @GetMapping(value = "mypage/mypage_delete_vue.do", produces = "text/plain;charset=UTF-8")
	  public String mypage_delete(String userId) throws Exception {
		  String result="";
		  try {
			  mService.mypageDelete(userId);
			  result="yes";
		  }catch(Exception ex) {
			  result=ex.getMessage();
		  }
		  return result;
	  }
}
