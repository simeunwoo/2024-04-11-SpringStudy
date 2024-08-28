package com.sist.vo;
import java.util.*;

import lombok.Data;
// 메모리 할당 대상이 아니다 => Annotation을 사용하지 않는다
@Data
public class EmpVO {

	private int empno,sal;
	private String ename,job,dbday;
	private Date hiredate;
}
