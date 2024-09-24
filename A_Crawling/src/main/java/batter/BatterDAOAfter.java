package batter;
import java.util.*;
import java.sql.*;

public class BatterDAOAfter {
	
	private Connection conn;
	   private PreparedStatement ps;
	   private static BatterDAOAfter dao;
	   private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
	   
	   // 드라이버 등록 
	   public BatterDAOAfter()
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
	   public static BatterDAOAfter newInstance()
	   {
		   if(dao==null)
			   dao=new BatterDAOAfter();
		   return dao;
	   }
	   // 기능 
	   
	   public void batterafterInsert(BatterVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="UPDATE batter SET "
			   		+ "image=? "
			   		+ "WHERE bno=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getImage());
			   ps.setInt(2, vo.getBno());
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



