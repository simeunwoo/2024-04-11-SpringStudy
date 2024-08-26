package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {

	@Select("SELECT empno,ename,job,hiredate,sal FROM emp") // @Select(어노테이션) = <select></select>
	public List<EmpVO> empListData();
	//     =========== =========== ==
	//     resultType  id          parameterType
	// @Insert, @Update, @Delete도 존재
	// @Results = <resultMap></resultMap>
}
