package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class StadiumDAO {
    @Autowired
    private StadiumMapper mapper;

    public List<StadiumVO> stadiumListData()
	{
		return mapper.stadiumListData();
	}
	public StadiumVO stadiumDetailData(int no)
	{
	    return mapper.stadiumDetailData(no);
	}
	public List<HotelVO> stadiumHotelListData(String hd)
	{
		return mapper.stadiumHotelListData(hd);
	}
	public List<FoodVO> stadiumFoodListData(String fd)
	{
		return mapper.stadiumFoodListData(fd);
	}
	public HotelVO stadiumHotelDetailData(int hno)
	{
		return mapper.stadiumHotelDetailData(hno);
	}
	public FoodVO stadiumFoodDetailData(int fno)
	{
		return mapper.stadiumFoodDetailData(fno);
	}
}
