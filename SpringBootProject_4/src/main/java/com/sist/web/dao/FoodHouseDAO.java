package com.sist.web.dao;
import java.util.*;
import com.sist.web.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodHouseDAO extends JpaRepository<FoodHouseEntity, Integer>{

	// 9개의 데이터 => Main에 출력
	@Query(value="SELECT fno,name,poster,score,hit,jjimcount,type "
			+ "FROM project_food_house ORDER BY hit DESC "
			+ "LIMIT 0,9",nativeQuery=true)
	public List<FoodHouseVO> foodHitTop9();
	
	public FoodHouseEntity findByFno(int fno);
	// SELECT * FROM project_food_house WHERE fno=? => 자동 SQL 문장 이용
}
