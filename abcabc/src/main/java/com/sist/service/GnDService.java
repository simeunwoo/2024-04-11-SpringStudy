package com.sist.service;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface GnDService {
   
   public List<GnDVO> gndListData(Map map);
   public int gndTotalPage();
   public List<GnDVO> gndTeamListData(Map map);
   public int gndTeamTotalPage(String team);
}