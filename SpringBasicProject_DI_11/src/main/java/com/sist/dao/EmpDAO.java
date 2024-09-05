package com.sist.dao;
import java.util.*;
import com.sist.vo.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class EmpDAO extends SqlSessionDaoSupport {
	/*
	<select id="empListData" resultType="EmpVO">
		SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal
		FROM emp
		ORDER BY empno ASC
	</select>
	 */
	public List<EmpVO> empListData()
	{
		return getSqlSession().selectList("empListData");
	}
}