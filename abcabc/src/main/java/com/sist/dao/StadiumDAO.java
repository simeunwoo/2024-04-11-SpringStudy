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

    public List<StadiumVO> stadiumListData(int start,int end)
	{
		return mapper.stadiumListData(start, end);
	}
	public int stadiumTotalPage()
	{
		return mapper.stadiumTotalPage();
	}
	public StadiumVO stadiumDetailData(int no)
	{
	    return mapper.stadiumDetailData(no);
	}
}
