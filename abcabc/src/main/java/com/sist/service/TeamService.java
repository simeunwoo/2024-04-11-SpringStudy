package com.sist.service;
import java.util.*;
import com.sist.vo.*;

public interface TeamService {

	public List<TeamDetailVO> teamListData();
	public TeamDetailVO teamDetailData(String name);
	public List<TeamVO> teamRankingData();
}
