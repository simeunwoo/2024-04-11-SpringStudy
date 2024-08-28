package com.sist.service;

import java.util.List;

import com.sist.vo.*;
// 이렇게 하는 이유 => 결합성이 낮은 프로그램을 만들기 위하여 => 유지 보수 시에 영향을 미치지 않는다 (편리 기능)
public interface EmpDeptService {

	public List<EmpVO> empListData();
	public List<DeptVO> deptListData();
}
