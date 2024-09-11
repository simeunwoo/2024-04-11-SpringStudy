package com.sist.vo;
import java.util.*;

import lombok.Data;

@Data
// JOIN / 포함 클래스
/*
 * 	SELECT empno,ename,sal,job,TO_CHAR(hiredate,'') as dbday,
 * 		dname,loc,grade
 * 	FROM emp,dept,salgrade
 * 	WHERE emp.deptno=dept.deptno
 * 	AND sal BETWEEN losal AND hisal
 * 	
 *	=> setEmpno(), setEname(), setSal(), setDbday()
 *	=> setDname(), setLoc(), setGrade() ===> (X)
 *		=> dvo.setDname(), dvo.setLoc(), svo.setGrade()
 */
public class EmpVO {

	private int empno,sal;
	private String ename,job,dbday;
	private Date hiredate;
	
	// JOIN / 포함 has-a
	private DeptVO dvo=new DeptVO();
	private SalgradeVO svo=new SalgradeVO();
}
