package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/*
 *   화면 변경 : request전송  => forward => "경로/파일명"
 *             request를 초기화후 화면 변경 => redirect => .do 
 *              ==> _ok.do : Insert/Update/Delete
 *                           => 서버에서 지정 
 */

public class NoticeController {
   @GetMapping("notice/list.do")
   public String notice_list()
   {
	   return "notice/list";
   }
   @GetMapping("notice/insert.do")
   public String notice_insert()
   {
	   return "notice/insert";
   }
   @GetMapping("notice/detail.do")
   public String notice_detail(int no,Model model,HttpSession session)
   {
	   String sessionId=(String)session.getAttribute("userId");
	   model.addAttribute("no", no);
	   model.addAttribute("sessionId", sessionId);
	   return "notice/detail";
   }
   @GetMapping("notice/update.do")
   public String notice_update(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "notice/update";
   }
}

