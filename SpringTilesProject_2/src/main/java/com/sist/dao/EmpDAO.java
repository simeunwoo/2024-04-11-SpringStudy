package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {

	@Autowired
	private EmpMapper m;
	
	public List<EmpVO> empListData()
	{
		return m.empListData();
	}
	
	public EmpVO empDetailData(int empno)
	{
		return m.empDetailData(empno);
	}
}
