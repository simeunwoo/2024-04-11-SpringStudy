package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class EmpDAO {

	@Autowired // 객체의 주소값만 주입이 가능 (일반 변수는 사용이 불가능)
	private EmpMapper mapper; // Spring => MyBatis에서 구현 => 구현한 클래스의 주소를
	
	@Value("홍길동")
	private String name="";
	
	/*
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD DY') as dbday,sal,deptno "
			+ "FROM emp")
	public List<EmpVO> empListData();
	
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD DY') as dbday,sal,deptno "
			+ "FROM emp "
			+ "WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
	
	@Select("SELECT DISTINCT ename FROM emp")
	public List<String> empEnameList();
	 */
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	
	public EmpVO empDetailData(int empno)
	{
		return mapper.empDetailData(empno);
	}

	public List<String> empEnameList()
	{
		return mapper.empEnameList();
		
	}
	
	public List<EmpVO> empNameFindData(Map map)
	{
		return mapper.empNameFindData(map);
	}
}
