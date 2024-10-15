package com.sist.web;
import com.sist.vo.*;
import com.sist.service.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // => Router
public class GoodsController {

	@GetMapping("goods/list.do")
	public String goods_list()
	{
		return "goods/list";
	}
}
