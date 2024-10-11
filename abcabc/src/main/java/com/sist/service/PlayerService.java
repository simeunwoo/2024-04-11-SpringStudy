package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

public interface PlayerService {

	public BatterVO batterDetailData(int bno);
	public PitcherVO pitcherDetailData(int pno);
	public int batterTotalPage();
	public int pitcherTotalPage();
	public List<BatterVO> batterListData(Map map);
	public List<PitcherVO> pitcherListData(int start,int end);
}
