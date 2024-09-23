package batter;
import java.util.*;
import java.sql.*;

public class BatterDAO {
	
	private Connection conn;
	   private PreparedStatement ps;
	   private static BatterDAO dao;
	   private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
	   
	   // 드라이버 등록 
	   public BatterDAO()
	   {
		   try
		   {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }catch(Exception ex) {}
	   }
	   
	   // 연결 
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,"hr2","happy");
		   }catch(Exception ex) {}
	   }
	   // 해제 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   // 싱글턴
	   public static BatterDAO newInstance()
	   {
		   if(dao==null)
			   dao=new BatterDAO();
		   return dao;
	   }
	   // 기능 
	   
	   public void batterInsert(BatterVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="UPDATE batter SET game=?,rbi=?,ball=?,strikeout=?,war=?,run=?,tasoo=? "
			   		+ "WHERE bno=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, vo.getGame());
			   ps.setInt(2, vo.getRbi());
			   ps.setInt(3, vo.getBall());
			   ps.setInt(4, vo.getStrikeout());
			   ps.setDouble(5, vo.getWar());
			   ps.setInt(6, vo.getRun());
			   ps.setInt(7, vo.getTasoo());
			   ps.setInt(8, vo.getBno());
			   ps.executeUpdate();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
	   }
	}



