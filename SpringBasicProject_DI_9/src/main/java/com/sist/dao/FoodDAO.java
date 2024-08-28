package com.sist.dao;
import java.util.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;

// �޸� �Ҵ�
// @Repository("dao")
@Repository // => ("dao")�� ���� id�� ���� �������� ���� ��� => id�� �ڵ����� foodDAO�� ���� �ȴ�
public class FoodDAO {
	@Autowired // ���������� ����� ��ü �ּҸ� ã�Ƽ� ���� => �ڵ� ����
	private FoodMapper mapper;
	
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
}
