package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface KboGoodsMapper {
	//굿즈 리스트
	@Select("SELECT gno, name, price, delivery, content, poster, num "
			+ "FROM (SELECT gno, name, price, delivery, content, poster, rownum as num "
			+ "FROM (SELECT gno, name, price, delivery, content, poster "
			+ "FROM kbo_goods "
			+ "ORDER BY gno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<KboGoodsVO> kboGoodsListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT gno, name, price, delivery, content, poster, num "
			+ "FROM (SELECT gno, name, price, delivery, content, poster, rownum as num "
			+ "FROM (SELECT gno, name, price, delivery, content, poster "
			+ "FROM kbo_goods "
			+ "WHERE (name LIKE '%'||#{fd}||'%' AND name LIKE '%'||#{fd2}||'%') "
			+ "ORDER BY gno DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<KboGoodsVO> kboGoodsFindListData(Map map);
		
	//상세보기
	@Select("SELECT * FROM kbo_goods "
			+"WHERE gno=#{gno}")
	public KboGoodsVO kboGoodsDetailData(int gno);
	
	//총 페이지
	@Select("SELECT CEIL(COUNT(*)/15.0) FROM kbo_goods")
	public int kboGoodsTotalPage();
	
	@Select("SELECT CEIL(COUNT(*)/15.0) FROM kbo_goods "
			+"WHERE (name LIKE '%'||#{fd}||'%' AND name LIKE '%'||#{fd2}||'%') ")
	public int kboGoodsFindTotalPage(Map map);
		   
	
	// 장바구니 저장 
	@Insert("INSERT INTO kbo_goods_cart(cno,gno,id,account) VALUES("
			  +"kgc_cno_seq.nextval,#{gno},#{id},#{account})")
	public void GoodsCartInsert(KboGoodsCartVO vo);
	
	@Update("UPDATE kbo_goods_cart SET "
			  +"account=account+#{account} "
			  +"WHERE gno=#{gno}")
	public void goodsCartAccountUpdate(KboGoodsCartVO vo);
	   
	@Select("SELECT COUNT(*) FROM kbo_goods_cart "
			  +"WHERE gno=#{gno}")
	public int goodsCartGnoCount(int gno);
	   
	// 장바구니 보기 
	@Results({
		@Result(property = "gvo.goods_name",column = "goods_name"),
		@Result(property = "gvo.goods_poster",column = "goods_poster"),
		@Result(property = "gvo.goods_price",column = "goods_price")
	})
	@Select("SELECT cno,gno,account,isBuy,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
			  +"name,poster,price "
			  +"FROM kbo_goods_cart sc, kbo_goods ga "
			  +"WHERE sc.gno=ga.no "
			  +"AND id=#{id} AND isBuy=0 "
			  +"ORDER BY cno DESC")
	public List<KboGoodsCartVO> goodsCartListData(String id);
	   
	// 장바구니 삭제 
	@Delete("DELETE FROM kbo_goods_cart "
			  +"WHERE cno=#{cno}")
	public void goodsCartCancel(int cno);
	   
	// 장바구니 구매 
	@Update("UPDATE kbo_goods_cart SET "
			  +"isBuy=1 "
			  +"WHERE cno=#{cno}")
	public void goodsBuy(int cno);
	   
	@Results({
		@Result(property = "gvo.name",column = "name"),
		@Result(property = "gvo.poster",column = "poster"),
		@Result(property = "gvo.price",column = "price")
	})
	@Select("SELECT cno,gno,account,isBuy,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
			  +"name,poster,price "
			  +"FROM kbo_goods_cart sc,kbo_goods ga "
			  +"WHERE sc.gno=ga.no "
			  +"AND id=#{id} AND isBuy=1 "
			  +"ORDER BY cno DESC")
	public List<KboGoodsCartVO> goodsBuyListData(String id);
}
