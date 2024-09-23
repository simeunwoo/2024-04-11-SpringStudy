package com.sist.vo;
import java.util.*;

import lombok.Data;

@Data
public class DataBoardVO {

	private int no,hit,filecount;
	private String name,subject,content,pwd,filename,filesize,dbday;
	private Date regdate;
}
