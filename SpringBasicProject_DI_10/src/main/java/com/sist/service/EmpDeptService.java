package com.sist.service;

import java.util.List;

import com.sist.vo.*;
// �̷��� �ϴ� ���� => ���ռ��� ���� ���α׷��� ����� ���Ͽ� => ���� ���� �ÿ� ������ ��ġ�� �ʴ´� (�� ���)
public interface EmpDeptService {

	public List<EmpVO> empListData();
	public List<DeptVO> deptListData();
}
