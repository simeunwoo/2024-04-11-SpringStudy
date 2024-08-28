package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@Service("eds")
public class EmpDeptServiceImpl {

	@Autowired
	private EmpDAO edao;
	@Autowired
	private DeptDAO ddao;
	
	@Override
	public List<EmpVO> empListData() {
		return edao.empListData();
	}
	@Override
	public List<DeptVO> deptListData() {
		return ddao.deptListData();
	}
	
}
