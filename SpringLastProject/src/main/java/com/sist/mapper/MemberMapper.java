package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

	@Select("SELECT COUNT(*) FROM spring_member "
			+ "WHERE userId=#{userId}")
	public int idCheck(String userId);
}
