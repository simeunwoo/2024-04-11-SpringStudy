package com.sist.service;

import java.util.List;

import com.sist.vo.ReserveVO;

public interface ReserveService {
	public void reserveInsert(ReserveVO vo);
	public List<ReserveVO> reserveMyPageListData(String id);
	public List<ReserveVO> reserveAdminListData(String id);
	public void reserveOk(int rno);
	public ReserveVO reserveInfoData(int rno);
}
