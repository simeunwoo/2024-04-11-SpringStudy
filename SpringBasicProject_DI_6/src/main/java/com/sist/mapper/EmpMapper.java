package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface EmpMapper {

	@Select("SELECT empno,ename,job,hriedate,sal "
			+"FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData(); // �ڵ� ������ �ȴ� => ��ȯ�� �ڵ�ȭ�� �ȴ�
	//       resultType           id        parameterType
	// <select id="empListData" resultType="EmpVO" parameterType="">
}
