package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class EmpDAO {
	@Autowired // 자동 메모리 주소 설정 (자동 구현)
	private EmpMapper mapper;
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
}
