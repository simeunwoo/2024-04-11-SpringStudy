package com.sist.vo;
import java.util.*;

import lombok.Data;
// �޸� �Ҵ� ����� �ƴϴ� => Annotation�� ������� �ʴ´�
@Data
public class EmpVO {

	private int empno,sal;
	private String ename,job,dbday;
	private Date hiredate;
}
