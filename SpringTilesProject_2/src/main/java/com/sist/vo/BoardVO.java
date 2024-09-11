package com.sist.vo;
import java.util.*;

import lombok.Data;
// 데이터베이스 : CRUD
@Data
public class BoardVO {

	private int no,hit;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
}
