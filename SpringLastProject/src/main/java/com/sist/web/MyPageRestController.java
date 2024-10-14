package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPageRestController {

	@Autowired
	private ReserveService rService;
	
	@GetMapping(value="mypage/reserve_info_vue.do",produces="text/plain;charset=UTF-8")
	public String reserve_info(int fno,int rno) throws Exception
	{
		ReserveVO vo=rService.reserveInfoData(rno);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
}
