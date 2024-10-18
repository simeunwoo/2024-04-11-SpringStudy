package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;
@Controller
public class NewsController {
    @Autowired
    private NewsService nService;
    
    @GetMapping("news/list.do")
    public String news_list(Model model)
    {
 	    List<NewsVO> nList=nService.newsHitTop8();
    	
 	    model.addAttribute("nList", nList);
    	return "news/list";
    }
    @GetMapping("news/detail.do")
    public String news_detail(int nno,Model model)
    {
 	    model.addAttribute("nno", nno);
 	    return "news/detail";
    }
}
