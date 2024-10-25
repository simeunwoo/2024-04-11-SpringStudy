package com.sist.web;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.sist.manager.HighlightManager;
import com.sist.vo.*;

@Controller
public class HighlightController {
	@Autowired
	private HighlightManager hManager;
	
	@GetMapping("highlight/list.do")
	public String highlight_list(String pageToken, Model model) throws GoogleJsonResponseException, GeneralSecurityException, IOException {
		List<HighlightVO> hList=hManager.highlightList(pageToken);
		List<HighlightTokenVO> htList=hManager.highlightPageTokener(pageToken);
		
		model.addAttribute("hList", hList);
		model.addAttribute("htList", htList);
		
		return "highlight/list";
	}

	
	@GetMapping("highlight/detail.do")
	public String highlight_detail(String publishedAt ,HttpSession session, Model model) throws GoogleJsonResponseException, GeneralSecurityException, IOException {
		/*
		 * String id=(String)session.getAttribute("userId");
		 * 
		 * 
		 * List<HighlightVO> hList=hManager.highlightList(publishedAt);
		 * model.addAttribute("hList", hList); model.addAttribute("publishedAt",
		 * publishedAt); model.addAttribute("sessionId", id);
		 */

		return "highlight/detail";
	}
	
}
