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
	
/*	@Select({"<script>"
			+ "SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD DY') as dbday,sal,deptno "
			+ "FROM emp "
			+ "<trim prefix=\"WHERE ename IN(\" suffix=\")\" suffixOverrides\")\" "
			+ "prefixOverrides\"(\">"
			+ "<foreach collection=\"names\" item=\"name\" open=\"(\" close=\")\" separator=\",\">"
			+ "#{name}"
			+ "</foreach>"
			+ "</trim>"
			+ "</script>"}) */
	public List<EmpVO> empNameFindData(Map map);
	/*
	 * 	trim : 추가, 삭제
	 * 		prefix : 접두어
	 * 		suffix : 접미어
	 * 		================== 추가
	 * 		prefixOverrides
	 * 		suffixOverrides
	 * 		================== 삭제
	 * 
	 		+ "<trim prefix=\"WHERE ename IN(\" suffix=\")\" suffixOverrides\")\" "
			+ "prefixOverrides\"(\">"
			
			===> WHERE ename IN
	 */
	
	@Select({"<script>"
			+ "SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,deptno "
			+ "FROM emp "
			+ "<if test=\"fd!='all'\">"
			+ "WHERE ${fd} LIKE '%'||#{ss}||'%'"
			+ "</if>"
			+ "</script>"})
	/*
	 * 	fd = ename, ss = king
	 * 	${fd} => ename (컬럼명/테이블명 => ''을 붙이지 않는다)
	 * 	#{ss} => 'king'
	 * 
	 * 	${} => table_name, column_name
	 * 	#{} => 나머지 경우 ...
	 */
	public List<EmpVO> empFindData(Map map);
	
	// 다중 조건 => HRD, 시청, 잡포털 ...
	/*
	 * 	동적 쿼리
	 * 
	 * 		<foreach> => IN
	 * 
	 * 		<trim> => 제거, 추가
	 * 
	 * 		<if> => 단일 조건문
	 * 
	 * 		<choose> => 다중 조건문
	 * 			<when>
	 * 			<otherwise>
	 * 		</choose>
	 */
}
