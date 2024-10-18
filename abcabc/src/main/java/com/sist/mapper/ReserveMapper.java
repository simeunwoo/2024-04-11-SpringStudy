package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.ReserveVO;

public interface ReserveMapper {
	
	/////////////////////////////// HOTEL ////////////////////////////////////////
	@Insert("INSERT INTO reserve_hotel(rno,hno,id,rday,rroom,rprice) "
			+ "  VALUES(hr_rno_seq.nextval,#{hno},#{id},#{rday},#{rroom},#{rprice})")
	public void reserveInsert(ReserveVO vo);
	
	@Results({
		@Result(property="hvo.poster",column="poster"),
		@Result(property="hvo.name",column="name")
	})
	@Select("SELECT rno,rh.hno,poster,name,rday,rroom,rprice,"
			+ "		TO_CHAR(regdate,'YYYY-MM-DD') as dbday , isReserve "
			+ "  FROM reserve_hotel rh,hotel ht "
			+ "  WHERE rh.hno=ht.hno AND id=#{id} ORDER BY hno DESC")
	public List<ReserveVO> reserveMyPageListData(String id);
	@Select("SELECT rno,rh.hno,poster,name,rday,rroom,rprice,"
			+ "		TO_CHAR(regdate,'YYYY-MM-DD') as dbday , isReserve "
			+ "  FROM reserve_hotel rh,hotel ht "
			+ "  WHERE rh.hno=ht.hno ORDER BY hno DESC")
	public List<ReserveVO> reserveAdminListData(String id);
	
	@Update("UPDATE reserve_hotel SET "
			 +"isReserve=1 "
			 +"WHERE rno=#{rno}")
	  public void reserveOk(int rno);
	// 호텔예약 정보 
	  @Results({
		  @Result(property = "hvo.name",column = "name"),
		  @Result(property = "hvo.poster",column = "poster"),
		  @Result(property = "hvo.location",column = "location"),
		  @Result(property = "hvo.address",column = "address"),
		  @Result(property = "hvo.checkin",column = "checkin"),
		  @Result(property = "hvo.checkout",column = "checkout"),
		  @Result(property = "hvo.score",column = "score"),
		  @Result(property = "hvo.price",column = "price"),
	  })
	  @Select("SELECT rno,rday,rtime,rinwon,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
			 +"name,poster,location,address,checkin,checkout,score,price "
			 +"FROM reserve_hotel rh,hotel ht "
			 +"WHERE rh.hno=ht.hno "
			 +"AND rno=#{rno}")
	  public ReserveVO reserveInfoData(int rno);
	  /////////////////////////////////////////////////////////////////////////////////////////////
	
}
