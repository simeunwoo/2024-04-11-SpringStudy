package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class NewsCommentVO {
   private int cno,nno,likecount,group_id,group_step,group_tab,depth,root,type;
   private String id,name,sex,msg,dbday,mday;
   private Date regdate,modifydate;
}
