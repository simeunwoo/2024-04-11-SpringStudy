package com.sist.web;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {
   @GetMapping("board/list.do")
   public String board_list()
   {
	   return "board/list";
   }
   
   @GetMapping("board/insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   @GetMapping("board/detail.do")
   public String board_detail(int no,Model model,HttpSession session)
   {
	   String sessionId=(String)session.getAttribute("userId");
	   model.addAttribute("no", no);
	   model.addAttribute("sessionId", sessionId);
	   return "board/detail";
   }
   @GetMapping("board/update.do")
   public String board_update(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "board/update";
   }
   
   @GetMapping("seoul/weather.do")
   public String seoul_weather(Model model) 
   {
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	   Date date=new Date();
	   StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
	   String today=st.nextToken()+"년도 "+st.nextToken()+"월 "+st.nextToken()+"일";
	   model.addAttribute("today", today);
	   return "seoul/weather";   
   }
   
   
}