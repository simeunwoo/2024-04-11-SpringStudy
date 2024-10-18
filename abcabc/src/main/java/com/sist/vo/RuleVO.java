package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class RuleVO {
  private int no,hit;
  private String id,name,subject,content, dbday;
  private Date regdate;

}