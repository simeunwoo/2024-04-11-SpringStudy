package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {

	@Select("SELECT empno,ename,job,hiredate,sal FROM emp") // @Select(������̼�) = <select></select>
	public List<EmpVO> empListData();
	//     =========== =========== ==
	//     resultType  id          parameterType
	// @Insert, @Update, @Delete�� ����
	// @Results = <resultMap></resultMap>
}
