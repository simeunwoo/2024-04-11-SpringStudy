package com.sist.web;
import java.util.*;
import com.sist.vo.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * 	화면 변경
 * 		request 전송 => forward => "경로명/파일명"
 * 		request를 초기화 후에 화면 변경 => redirect => .do
 * 			=> _ok.do : INSERT/UPDATE/DELETE
 * 				=> 서버에서 직접 지정
 */

@Controller
public class FreeBoardController {

	@GetMapping("freeboard/list.do")
	public String freeboard_list()
	{
		return "freeboard/list";
	}

	@GetMapping("freeboard/insert.do")
	public String freeboard_insert()
	{
		return "freeboard/insert";
	}
}
