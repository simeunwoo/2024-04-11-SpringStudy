package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class NewsDAO {
	 @Autowired
     private NewsMapper mapper;
	
	 public List<NewsVO> newsListData(Map map)
	 {
		 return mapper.newsListData(map);
	 }
	 public int newsTotalPage(Map map)
	 {
		 return mapper.newsTotalPage(map);
	 }
	 public NewsVO newsDetailData(int nno)
	 {
		 mapper.hitIncrement(nno);
		 return mapper.newsDetailData(nno);
	  }
	  public List<NewsVO> newsHitTop8()
	  {
		  return mapper.newsHitTop8();
	  }
}
