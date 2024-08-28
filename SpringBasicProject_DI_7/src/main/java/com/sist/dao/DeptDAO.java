package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
// XML, Annotation => ���� ����
// XML : ���̺귯�� ��� / Annotation : ����� ����
@Repository
public class DeptDAO {
	@Autowired // �ڵ� �޸� �ּ� ���� (�ڵ� ����)
	private DeptMapper mapper;
	public List<DeptVO> deptListData()
	{
		return mapper.deptListData();
	}
}
