package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface EmpMapper {

	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD DY') as dbday,sal,deptno "
			+ "FROM emp")
	public List<EmpVO> empListData();
	
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD DY') as dbday,sal,deptno "
			+ "FROM emp "
			+ "WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
	
	@Select("SELECT DISTINCT ename FROM emp")
	public List<String> empEnameList();
}
