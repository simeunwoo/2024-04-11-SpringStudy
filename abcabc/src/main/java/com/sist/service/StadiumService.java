package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface StadiumService {
	public List<StadiumVO> stadiumListData(int start,int end);
	public int stadiumTotalPage();
	public StadiumVO stadiumDetailData(int no);
}
