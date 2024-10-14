package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {

	@Autowired
	private ReserveService rService;
	
	@GetMapping(value="admin/admin_reserve_vue.do",produces="text/plain;charset=UTF-8")
	public String admin_reserve() throws Exception
	{
		List<ReserveVO> list=rService.reserveAdminListData();
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		
		return json;
	}
	
	@GetMapping(value="admin/admin_reserve_ok_vue.do",produces="text/plain;charset=UTF-8")
	public String admin_reserve_ok(int rno) throws Exception
	{
		rService.reserveOk(rno);
		
		List<ReserveVO> list=rService.reserveAdminListData();
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		
		return json;
	}
}
