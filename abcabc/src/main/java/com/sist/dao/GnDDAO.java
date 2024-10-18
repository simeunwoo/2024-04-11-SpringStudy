package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class GnDDAO {
   @Autowired
   private GnDMapper mapper;
  
   
   public int gndTotalPage() {
      return mapper.gndTotalPage();
   }
   
   public List<GnDVO> gndListData(Map map){
	   mapper.gndListData(map);
	   return (List<GnDVO>)map.get("pResult");
   }
   
   
   public List<GnDVO> gndTeamListData(Map map){
	   mapper.gndTeamListData(map);
	   return (List<GnDVO>)map.get("pResult");
   }
   public int gndTeamTotalPage(String team) {
	   return mapper.gndTeamTotalPage(team);
   }
   
}
