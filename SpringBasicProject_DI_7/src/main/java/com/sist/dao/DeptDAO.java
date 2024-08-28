package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
// XML, Annotation => 동시 설정
// XML : 라이브러리 사용 / Annotation : 사용자 정의
@Repository
public class DeptDAO {
	@Autowired // 자동 메모리 주소 설정 (자동 구현)
	private DeptMapper mapper;
	public List<DeptVO> deptListData()
	{
		return mapper.deptListData();
	}
}
