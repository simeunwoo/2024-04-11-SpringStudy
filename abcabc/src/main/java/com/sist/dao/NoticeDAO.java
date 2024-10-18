package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 형식동일 => 마이페이지,관리자페이지에서 여러개를 동시에 삭제  
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class NoticeDAO {
   @Autowired
   private NoticeMapper mapper;
   
   public List<NoticeVO> noticeListData(int start,int end)
   {
	   return mapper.noticeListData(start, end);
   }
   public int noticeRowCount()
   {
	   return mapper.noticeRowCount();
   }
   public void noticeInsert(NoticeVO vo)
   {
	   mapper.noticeInsert(vo);
   }
  
   public NoticeVO noticeDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.noticeDetailData(no);
   }
   
   public void noticeDelete(int no)
   {
	   mapper.noticeDelete(no);
   }
   
   public NoticeVO noticeUpdateData(int no)
   {
	   return mapper.noticeUpdateData(no);
   }
   public void noticeUpdate(NoticeVO vo)
   {
	   mapper.noticeUpdate(vo);
   }
}