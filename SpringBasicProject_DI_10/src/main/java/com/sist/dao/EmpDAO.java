package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;

@Repository // id�� : empDAO
public class EmpDAO {
	@Autowired // mapper�� �ּ� ���� ���� ("SELECT ~")
	private EmpMapper mapper;
	
	public List<EmpVO> empListData() {
		return mapper.empListData();
	}
	
}
