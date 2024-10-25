package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerCommentRestController {

	@Autowired
	private PlayerCommentService pService;
	
	// 자주 호출이 필요하므로 만든 메소드
	public String batterCommonsListData(int page,int rno,int type) throws Exception
	{
		Map map=new HashMap();
		
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		map.put("start", start);
		map.put("end", end);
		map.put("rno", rno);
		map.put("type", type);
		
		List<BatterCommentVO> list=pService.batterCommentListData(map);
		int totalpage=pService.batterCommentTotalPage(map);
		
		final int BLOCK=5;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value="comment/batter_list_vue.do",produces="text/plain;charset=UTF-8")
	public String batterComment_list(int page,int rno,int type) throws Exception
	{
		return batterCommonsListData(page, rno, type);
	}
	
	@PostMapping(value="comment/batter_insert_vue.do",produces="text/plain;charset=UTF-8")
	public String batterComment_insert(BatterCommentVO vo,HttpSession session) throws Exception
	{
		String id=(String)session.getAttribute("userId");
		String name=(String)session.getAttribute("userName");
		String sex=(String)session.getAttribute("sex");
		vo.setId(id);
		vo.setName(name);
		vo.setSex(sex);
		pService.batterCommentInsert(vo);
		
		// INSERT INTO spring_comment(cno,rno,id,name,sex,msg,group_id,type)
		// id, name => 저장
		return batterCommonsListData(1, vo.getRno(), vo.getType());
	}
	
	@PostMapping(value="comment/batter_reply_insert_vue.do",produces="text/plain;charset=UTF-8")
	public String batterComment_reply_insert(int cno,BatterCommentVO vo,HttpSession session) throws Exception
	{
		String id=(String)session.getAttribute("userId");
		String name=(String)session.getAttribute("userName");
		String sex=(String)session.getAttribute("sex");
		vo.setId(id);
		vo.setName(name);
		vo.setSex(sex);
		pService.batterCommentReplyReplyInsert(cno, vo);
		
		return batterCommonsListData(1, vo.getRno(), vo.getType());
	}
	
	@GetMapping(value="comment/batter_delete_vue.do",produces="text/plain;charset=UTF-8")
	public String batterComment_delete(int cno,int rno,int type) throws Exception
	{
		// 데이터베이스 연동
		BatterCommentVO vo=pService.batterCommentDeleteInfoData(cno);
		
		Map map=new HashMap();
		map.put("cno", cno);
		map.put("group_id", vo.getGroup_id());
		map.put("group_step", vo.getGroup_step());
		pService.batterCommentDelete(map);
		pService.batterReplyDecrement(rno);
		
		return batterCommonsListData(1, rno, type);
	}
	
	@GetMapping(value="comment/batter_update_vue.do",produces="text/plain;charset=UTF-8")
	public String batterComment_update(BatterCommentVO vo) throws Exception
	{
		pService.batterCommentUpdate(vo);
		return batterCommonsListData(1, vo.getRno(), vo.getType());
	}
	
	////////////////////////////////////////////////////////////////////
	
	// 자주 호출이 필요하므로 만든 메소드
	public String pitcherCommonsListData(int page,int rno,int type) throws Exception
	{
		Map map=new HashMap();
		
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		map.put("start", start);
		map.put("end", end);
		map.put("rno", rno);
		map.put("type", type);
		
		List<PitcherCommentVO> list=pService.pitcherCommentListData(map);
		int totalpage=pService.pitcherCommentTotalPage(map);
		
		final int BLOCK=5;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value="comment/pitcher_list_vue.do",produces="text/plain;charset=UTF-8")
	public String pitcherComment_list(int page,int rno,int type) throws Exception
	{
		return pitcherCommonsListData(page, rno, type);
	}
	
	@PostMapping(value="comment/pitcher_insert_vue.do",produces="text/plain;charset=UTF-8")
	public String pitcherComment_insert(PitcherCommentVO vo,HttpSession session) throws Exception
	{
		String id=(String)session.getAttribute("userId");
		String name=(String)session.getAttribute("userName");
		String sex=(String)session.getAttribute("sex");
		vo.setId(id);
		vo.setName(name);
		vo.setSex(sex);
		pService.pitcherCommentInsert(vo);
		
		// INSERT INTO spring_comment(cno,rno,id,name,sex,msg,group_id,type)
		// id, name => 저장
		return pitcherCommonsListData(1, vo.getRno(), vo.getType());
	}
	
	@PostMapping(value="comment/pitcher_reply_insert_vue.do",produces="text/plain;charset=UTF-8")
	public String pitcherComment_reply_insert(int cno,PitcherCommentVO vo,HttpSession session) throws Exception
	{
		String id=(String)session.getAttribute("userId");
		String name=(String)session.getAttribute("userName");
		String sex=(String)session.getAttribute("sex");
		vo.setId(id);
		vo.setName(name);
		vo.setSex(sex);
		pService.pitcherCommentReplyReplyInsert(cno, vo);
		
		return pitcherCommonsListData(1, vo.getRno(), vo.getType());
	}
	
	@GetMapping(value="comment/pitcher_delete_vue.do",produces="text/plain;charset=UTF-8")
	public String pitcherComment_delete(int cno,int rno,int type) throws Exception
	{
		// 데이터베이스 연동
		PitcherCommentVO vo=pService.pitcherCommentDeleteInfoData(cno);
		
		Map map=new HashMap();
		map.put("cno", cno);
		map.put("group_id", vo.getGroup_id());
		map.put("group_step", vo.getGroup_step());
		pService.pitcherCommentDelete(map);
		pService.pitcherReplyDecrement(rno);
		
		return pitcherCommonsListData(1, rno, type);
	}
	
	@GetMapping(value="comment/pitcher_update_vue.do",produces="text/plain;charset=UTF-8")
	public String pitcherComment_update(PitcherCommentVO vo) throws Exception
	{
		pService.pitcherCommentUpdate(vo);
		return pitcherCommonsListData(1, vo.getRno(), vo.getType());
	}
}
