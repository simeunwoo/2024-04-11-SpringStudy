package com.sist.mapper;

import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StadiumMapper {
	  @Select("SELECT no,name,poster,location,hometeam "
			 +"FROM stadium ORDER BY no ASC")
	  public List<StadiumVO> stadiumListData();

	  @Select("SELECT * FROM stadium "
			  +"WHERE no=#{no}")
	  public StadiumVO stadiumDetailData(int no);
	  
	  @Select("SELECT hno,name,poster "
	  		 +"FROM hotel "
	  		 +"WHERE address LIKE '%'||#{hd}||'%' "
	  		 +"ORDER BY hno ASC")
	  public List<HotelVO> stadiumHotelListData(String hd);
	  
	  @Select("SELECT fno,name,poster "
		  		 +"FROM food_blue "
		  		 +"WHERE address LIKE '%'||#{fd}||'%' "
		  		 +"ORDER BY fno ASC")
	  public List<FoodVO> stadiumFoodListData(String fd);
	  
	  @Select("SELECT * FROM hotel "
			 +"WHERE hno=#{hno}")
	  public HotelVO stadiumHotelDetailData(int hno);
	  
	  @Select("SELECT * FROM food_blue "
			 +"WHERE fno=#{fno}")
	  public FoodVO stadiumFoodDetailData(int fno);
}
