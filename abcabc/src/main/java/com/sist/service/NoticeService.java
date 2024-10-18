package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface NoticeService {
	public List<NoticeVO> noticeListData(int start,int end);
	public int noticeRowCount();
	public void noticeInsert(NoticeVO vo);
	public NoticeVO noticeDetailData(int no);
	public void noticeDelete(int no);
	public NoticeVO noticeUpdateData(int no);
	public void noticeUpdate(NoticeVO vo);
	
}