package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class NewsCommentDAO {
   @Autowired
   private NewsCommentMapper mapper;
   
   public List<NewsCommentVO> newsCommentListData(Map map)
   {
 	  return mapper.newsCommentListData(map);
   }
   public int newsCommentTotalPage(Map map)
   {
 	  return mapper.newsCommentTotalPage(map);
   }
   public void newsCommentInsert(NewsCommentVO vo)
   {
 	  mapper.newsReplyIncrement(vo.getNno());
 	  mapper.newsCommentInsert(vo);
   }
   @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
   public void newsCommentReplyReplyInsert(int cno,NewsCommentVO vo)
   {
 	  mapper.newsReplyIncrement(vo.getCno());
 	  NewsCommentVO pvo=mapper.newsCommentParentInfoData(cno);
 	  vo.setGroup_id(pvo.getGroup_id());
 	  vo.setGroup_step(pvo.getGroup_step()+1);
 	  vo.setGroup_tab(pvo.getGroup_tab()+1);
 	  
 	  mapper.newsCommentGroupStepIncrement(pvo);
 	  mapper.newsCommentReplyReplyInsert(vo);
 	  mapper.newsCommentDepthIncrement(cno); 
   }
   public NewsCommentVO newsCommentDeleteInfoData(int cno)
   {
 	  return mapper.newsCommentDeleteInfoData(cno);
   }
   public void newsCommentDelete(Map map)
   {
 	   mapper.newsCommentDelete(map);    
   }
   public void newsReplyDecrement(int nno)
   {
 	  mapper.newsReplyDecrement(nno);
   }
   public void newsCommentUpdate(NewsCommentVO vo)
   {
 	  mapper.newsCommentUpdate(vo);
   }
   
}
