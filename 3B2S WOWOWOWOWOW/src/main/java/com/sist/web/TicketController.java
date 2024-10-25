package com.sist.web;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.mapper.ReserveMapper;
import com.sist.service.ReserveService;
import com.sist.vo.GameReserveVO;
import com.sist.vo.GameVO;


@Controller
public class TicketController {
   @Autowired
   private ReserveService rService; 
	@GetMapping("ticket/ticket_main.do")
   public String ticket_main(Model model , HttpSession session,HttpServletRequest request)
   {
	   String num = request.getParameter("num");
	   System.out.println(num);
	   String price = request.getParameter("price");
	   String type = request.getParameter("type");
	   String day = request.getParameter("day");
	   Map map = new HashMap();
	   String rseat="";
	   map.put("rseat", rseat);
	   map.put("day", day);
	   map.put("type", type);
	   int rprice = Integer.parseInt(price);
	   List<GameReserveVO> list = rService.gameNoSeatList(map);
	   for (GameReserveVO vo : list) {
		System.out.println(vo.getGvo().getSeat());
	}
	   model.addAttribute("list", list);
	   model.addAttribute("price", rprice);
		model.addAttribute("type", type);
		model.addAttribute("day", day);
		model.addAttribute("num", num);
	   String id=(String)session.getAttribute("userId");
	   model.addAttribute("sessionId",id);
	   return "ticket/ticket_main";
   }
   @GetMapping("ticket/ticketchoice.do")
   public String ticketchoice(HttpSession session,Model model)
   {
	   String id=(String)session.getAttribute("userId");
	   model.addAttribute("id", id);
	   System.out.println(id);
	   return "ticket/ticketchoice";
   }
   
   
}