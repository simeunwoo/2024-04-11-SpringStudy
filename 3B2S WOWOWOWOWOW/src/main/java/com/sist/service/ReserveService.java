package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.GameReserveVO;
import com.sist.vo.GameVO;
import com.sist.vo.ReserveVO;

public interface ReserveService {
	public void reserveInsert(ReserveVO vo);
	public List<ReserveVO> reserveMyPageListData(String id);
	public List<ReserveVO> reserveAdminListData(String id);
	public void reserveOk(int rno);
	public ReserveVO reserveInfoData(int rno);
	public List<GameReserveVO> gameNoSeatList(Map map);
	public int getTno(Map map);
	public void gamereserveInsert(GameReserveVO vo);
}
