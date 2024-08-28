package com.sist.dao;
import java.util.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;

// 메모리 할당
// @Repository("dao")
@Repository // => ("dao")와 같이 id를 따로 생성하지 않을 경우 => id는 자동으로 foodDAO와 같이 된다
public class FoodDAO {
	@Autowired // 스프링에서 저장된 객체 주소를 찾아서 주입 => 자동 주입
	private FoodMapper mapper;
	
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
}
