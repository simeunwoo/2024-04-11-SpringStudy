package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {

	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
			+"FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
}
