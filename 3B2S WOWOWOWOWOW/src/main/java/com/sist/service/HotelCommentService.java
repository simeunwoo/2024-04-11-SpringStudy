package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface HotelCommentService {
	public List<HotelCommentVO> commentListData(Map map);
	public int commentTotalPage(Map map);
	public void commentInsert(HotelCommentVO vo);
	public void commentReplyReplyInsert(int cno,HotelCommentVO vo);
	public HotelCommentVO commentDeleteInfoData(int cno);
	public void commentDelete(Map map);
	public void hotelReplyDecrement(int hno);
	public void commentUpdate(HotelCommentVO vo);
}
