package com.sist.web;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// 브라우저와 연결 => JSP (DAO에서 데이터를 얻어서 JSP로 전송)
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BoardController {

	@Autowired
	private BoardDAO bDao;
	
	@GetMapping("board/list.do")
	public String board_list()
	{
		return "board/list";
	}
}
