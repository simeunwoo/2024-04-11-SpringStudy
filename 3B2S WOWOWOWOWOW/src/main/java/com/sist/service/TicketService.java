package com.sist.service;

import java.util.List;

import com.sist.vo.GameReserveVO;
import com.sist.vo.GameVO;
import com.sist.vo.ReserveVO;

public interface TicketService {
	public List<GameVO> gameListData();
	public void gamereserveInsert(GameReserveVO vo) ;;
	public void gamereserveOk(int rno) ;
	  public ReserveVO gamereserveInfoData(int rno) ;
}
