package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.ReserveMapper;
import com.sist.vo.GameReserveVO;
import com.sist.vo.GameVO;
import com.sist.vo.ReserveVO;

@Repository
public class ReserveDAO {
	@Autowired
	private ReserveMapper mapper;

	public void reserveInsert(ReserveVO vo) {
		mapper.reserveInsert(vo);
	}

	public List<ReserveVO> reserveMyPageListData(String id){
		return mapper.reserveMyPageListData(id);
	}

	public List<ReserveVO> reserveAdminListData(String id){
		return mapper.reserveAdminListData(id);
	}

	public void reserveOk(int rno) {
		mapper.reserveOk(rno);
	}

	public ReserveVO reserveInfoData(int rno) {
		return mapper.reserveInfoData(rno);
	}
	
	public List<GameReserveVO> gameNoSeatList(Map map) {
		return mapper.gameNoSeatList(map);
	}
	public int getTno(Map map) {
		return mapper.getTno(map);
	}
	public void gamereserveInsert(GameReserveVO vo) {
		mapper.gamereserveInsert(vo);
	}
}
