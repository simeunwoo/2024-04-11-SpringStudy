package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataBoardDAO {

	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(int start,int end)
	{
		return mapper.databoardListData(start, end);
	}

	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
}
