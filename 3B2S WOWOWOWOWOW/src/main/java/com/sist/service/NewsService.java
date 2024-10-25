package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface NewsService {
	 public List<NewsVO> newsListData(Map map);
	 public int newsTotalPage(Map map);
	 public NewsVO newsDetailData(int nno);
	 public List<NewsVO> newsHitTop8();
}
