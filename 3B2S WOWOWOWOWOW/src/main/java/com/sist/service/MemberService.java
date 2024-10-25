package com.sist.service;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberService {
public int idCheck(String userId);
	
	public void memberInsert(MemberVO vo);
	
	public void memberAuthorityInsert(String userId);

	public MemberVO memberInfoData(String userId);
	
	public MemberVO memberSessionData(String userId);	
	

	public MemberVO mypageUpdateData(String userId);
	
	public void mypageUpdate(MemberVO vo);
	
	public void mypageDelete(String userId);
	
	
	
	  public int mypageBuyCount(String id);
	  
	  public int mypageCartCount(String id);
	  
	  public int mypageTicketCount(String id);
	  
	  public int mypageHotelCount(String id);
	  
	  public int mypageBoardCount(String id);
	  
	  public int mypageReplyCount(String id);
}
