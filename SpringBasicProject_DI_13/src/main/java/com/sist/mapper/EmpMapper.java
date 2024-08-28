package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.*;

import com.sist.vo.*;

public interface EmpMapper {
	/*
	 * 	@Results
	 * 	=
	 * 	<resultMap>
	 * 		<result property="dvo.name" column="dname"/>
	 * 	</resultMap>
	 */
	// ¡∂¿Œ
	@Results({
		@Result(property="dvo.dname",column="dname"),
		@Result(property="dvo.loc",column="loc"),
		@Result(property="svo.grade",column="grade")
	})
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc,grade "
			+ "FROM emp,dept,salgrade "
			+ "WHERE emp.deptno=dept.deptno "
			+ "AND sal BETWEEN losal AND hisal")
	public List<EmpVO> empListData();
}
