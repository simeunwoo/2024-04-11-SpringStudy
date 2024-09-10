package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface RecipeMapper {

	/*
	<select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
 		SELECT no,title,poster,chef,num
 		FROM (SELECT no,title,poster,chef,rownum as num
 		FROM (SELECT no,title,poster,chef
 		FROM recipe
 		WHERE no IN(SELECT no FROM recipe INTERSECT (SELECT no FROM recipeDetail))
 		ORDER BY no ASC))
 		WHERE num BETWEEN #{start} AND #{end}
 	</select>
	 */
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe")
	public int recipeTotalPage();
	
	@Select("SELECT * FROM recipe "
			+ "WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
	@Update("UPDATE recipe SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void recipeHitIncrement(int no);
}
