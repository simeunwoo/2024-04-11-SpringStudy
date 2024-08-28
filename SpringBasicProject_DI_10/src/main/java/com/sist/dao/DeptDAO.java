package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository // id명 : deptDAO
public class DeptDAO {

	@Autowired // mapper의 주석 갖고 오기 ("SELECT ~")
	private DeptMapper mapper;
	
	public List<DeptVO> deptListData() {
		return mapper.deptListData();
	}
}
