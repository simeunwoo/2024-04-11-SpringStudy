package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.ReserveMapper;
import com.sist.mapper.TicketMapper;
import com.sist.vo.GameReserveVO;
import com.sist.vo.GameVO;
import com.sist.vo.ReserveVO;

@Repository
public class TicketDAO {
	@Autowired
	private TicketMapper mapper;
	@Autowired
	private ReserveMapper rmapper;
	
	public List<GameVO> gameListData(){
		return mapper.gameListData();
	}
	public void gamereserveInsert(GameReserveVO vo) {
		rmapper.gamereserveInsert(vo);
	}
	public void gamereserveOk(int rno) {
		rmapper.gamereserveOk(rno);
	}
	
	  public ReserveVO gamereserveInfoData(int rno) {
		  return rmapper.gamereserveInfoData(rno);
	  }
	
}
