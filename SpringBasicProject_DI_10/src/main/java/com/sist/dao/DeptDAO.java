package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository // id�� : deptDAO
public class DeptDAO {

	@Autowired // mapper�� �ּ� ���� ���� ("SELECT ~")
	private DeptMapper mapper;
	
	public List<DeptVO> deptListData() {
		return mapper.deptListData();
	}
}
