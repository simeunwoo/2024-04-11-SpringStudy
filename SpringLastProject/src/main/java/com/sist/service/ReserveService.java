package com.sist.service;
import java.util.*;
import com.sist.vo.*;

public interface ReserveService {

	public List<FoodVO> reserveFoodInfoData(Map map);
	public int reserveFoodTotalPage(String type);
	public void reserveInsert(ReserveVO vo);
}
