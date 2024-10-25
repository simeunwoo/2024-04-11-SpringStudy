package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.sist.manager.HighlightManager;
import com.sist.vo.*;

@RestController
public class HighlightRestController {
	@Autowired
	private HighlightManager hManager;
	
	/*
	@GetMapping(value="highlight/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String highlight_list_vue(String pageToken, Model model) throws GoogleJsonResponseException, GeneralSecurityException, IOException {
		Map map=new HashMap();
		
		List<HighlightTokenVO> htList=hManager.highlightPageTokener(pageToken);
			
		map=new HashMap();
		map.put("htList", htList);
		map.put("pageToken", pageToken);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json; 
	}
	*/

}
