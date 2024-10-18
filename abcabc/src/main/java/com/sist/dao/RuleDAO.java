package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class RuleDAO {
   @Autowired
   private RuleMapper mapper;

   public List<RuleVO> ruleListData(int start,int end)
   {
	   return mapper.ruleListData(start, end);
   }
   public int ruleCount()
   {
	   return mapper.ruleCount();
   }
   
   public List<RuleVO> ruleFind(Map map){
	   return mapper.ruleFind(map);
   }
   
   public RuleVO ruleDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.ruleDetailData(no);
   }
   /*
   public void ruleDelete(int no)
   {
	   mapper.ruleDelete(no);
   }
   
   public void ruleInsert(RuleVO vo)
   {
	   mapper.ruleInsert(vo);
   }
   
   public ruleVO ruleUpdateData(int no)
   {
	   return mapper.ruleUpdateData(no);
   }
   public void ruleUpdate(BoardVO vo)
   {
	   mapper.ruleUpdate(vo);
   }
   */
   
   
}