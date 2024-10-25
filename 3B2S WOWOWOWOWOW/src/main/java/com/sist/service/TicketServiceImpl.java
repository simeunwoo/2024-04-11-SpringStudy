package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.TicketDAO;
import com.sist.vo.GameReserveVO;
import com.sist.vo.GameVO;
import com.sist.vo.ReserveVO;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketDAO tDAO;

	@Override
	public List<GameVO> gameListData() {
		// TODO Auto-generated method stub
		return tDAO.gameListData();
	}

	@Override
	public void gamereserveInsert(GameReserveVO vo) {
		// TODO Auto-generated method stub
		tDAO.gamereserveInsert(vo);
	}

	@Override
	public void gamereserveOk(int rno) {
		// TODO Auto-generated method stub
		tDAO.gamereserveOk(rno);
	}

	@Override
	public ReserveVO gamereserveInfoData(int rno) {
		// TODO Auto-generated method stub
		return tDAO.gamereserveInfoData(rno);
	}
}
