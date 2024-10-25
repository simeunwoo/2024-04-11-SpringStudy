package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

public interface PlayerService {

	public BatterVO batterDetailData(int bno);
	public PitcherVO pitcherDetailData(int pno);
	public int batterTotalPage(String fd);
	public int pitcherTotalPage(String fd);
	public List<BatterVO> batterListData(Map map);
	public List<PitcherVO> pitcherListData(Map map);
	public List<BatterVO> batterChartData();
	public List<PitcherVO> pitcherChartData();
	public List<BatterVO> batterListMainData();
}
