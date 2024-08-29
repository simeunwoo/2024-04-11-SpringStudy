package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
// �޸� �Ҵ� : => 1) DAO, 2) Service, 3) Model
// VO : �޸� �Ҵ��� �ƴϴ� (�Ϲ� ��������)
@Repository("dao")
public class MusicDAO {
	// Spring �ȿ� MyBatis���� �ڵ� ���� => �ڵ����� �ּҸ� �о� �´�
	@Autowired
	private MusicMapper mapper;
	
	/*
	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music ORDER BY mno ASC")
	 */
	public List<MusicVO> musicListData()
	{
		return mapper.musicListData();
	}
}
