package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
 USERID                                    NOT NULL VARCHAR2(20)
 USERNAME                                  NOT NULL VARCHAR2(50)
 USERPWD                                   NOT NULL VARCHAR2(20)
 ENABLED                                            NUMBER(1)
 SEX                                                VARCHAR2(6)
 BIRTHDAY                                  NOT NULL VARCHAR2(20)
 EMAIL                                              VARCHAR2(100)
 POST                                      NOT NULL VARCHAR2(10)
 ADDR1                                     NOT NULL VARCHAR2(500)
 ADDR2                                              VARCHAR2(500)
 PHONE                                     NOT NULL VARCHAR2(20)
 CONTENT                                            CLOB
 REGDATE                                            DATE
 MODIFYDATE                                         DATE
 LASTLOGIN                                          DATE
 */
@Data
public class MemberVO {

	private String userId,userName,userPwd,sex,birthday,email,post,addr1,addr2,phone,content;
	private int enabled;
	private Date regdate,modifydate,lastlogin;
	
	private String msg,authority; // msg : 로그인 확인 변수, authority : 권한 변수
	/*
	 * 	보안 : userName, userPwd
	 * 	     =========
	 *        id
	 */
}
