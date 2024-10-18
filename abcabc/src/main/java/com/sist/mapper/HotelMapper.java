package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.HotelVO;

public interface HotelMapper {
	@Select("SELECT hno,name,price,address,score,poster,images,num "
			+ "  FROM (SELECT hno,name,price,address,score,poster,images,rownum as num"
			+ "			  FROM (SELECT hno,name,price,address,score,poster,images "
			+ "  						 FROM hotel "
			+ "						 ORDER BY hno asc)) "
			+ "  WHERE num BETWEEN #{start} AND #{end}")
	public List<HotelVO> hotelListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/6) FROM hotel ")
	public int hotelTotalPage();
	@Select("SELECT hno,name,price,address,checkin,checkout,location,poster,images,rdays,jjimcount,likecount,hit,score "
			+ "  FROM hotel "
			+ "  WHERE hno=#{hno}")
	public HotelVO hotelDetailData(int hno);
	
	@Update("UPDATE hotel SET "
			+ "   hit = hit+1 "
			+ "	WHERE hno=#{hno}")
	public void hotelHitIncrement(int hno);
	
	@Select("SELECT hno,name,price,address,location,poster,rdays "
			+ "  FROM hotel "
			+ "  WHERE hno=#{hno}")
	public HotelVO hotelReserveData(int hno);
	
}
