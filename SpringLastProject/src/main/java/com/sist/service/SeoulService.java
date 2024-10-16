package com.sist.service;
import java.util.*;
import com.sist.vo.*;

public interface SeoulService {

	public List<SeoulVO> seoulLocationListData(Map map);
	public List<SeoulVO> seoulNatureListData(Map map);
	public List<SeoulVO> seoulShopListData(Map map);
	public int seoulLocationTotalPage();
	public int seoulNatureTotalPage();
	public int seoulShopTotalPage();
}
