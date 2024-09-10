package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

public interface RecipeMapper {

	/*
	<select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
 		SELECT no,title,poster,chef,num
 		FROM (SELECT no,title,poster,chef,rownum as num
 		FROM (SELECT no,title,poster,chef
 		FROM recipe ORDER BY no ASC))
 		WHERE num BETWEEN #{start} AND #{end}
 	</select>
	 */
	public List<RecipeVO> recipeListData(Map map);
}
