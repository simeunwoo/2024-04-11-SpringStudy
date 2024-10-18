package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class BoardVO {
  private int no,hit,filecount;
  private String id,name,subject,content,pwd,filename,filesize,dbday;
  private Date regdate;

  private List<MultipartFile> files;
}