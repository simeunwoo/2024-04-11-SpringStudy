package pitcher;
import java.util.*;
import java.sql.*;

public class PitcherDAO {
	
	private Connection conn;
	   private PreparedStatement ps;
	   private static PitcherDAO dao;
	   private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
	   
	   // 드라이버 등록 
	   public PitcherDAO()
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
	   public static PitcherDAO newInstance()
	   {
		   if(dao==null)
			   dao=new PitcherDAO();
		   return dao;
	   }
	   // 기능 
	   
	   public void pitcherInsert(PitcherVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO pitcher(pno,name,game,win,lose,hit,strikeout,ball,era,war,team,age,inning,save,hold) "
					     +"VALUES(pitcher_pno_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getName());
			   ps.setInt(2, vo.getGame());
			   ps.setInt(3, vo.getWin());
			   ps.setInt(4, vo.getLose());
			   ps.setInt(5, vo.getHit());
			   ps.setInt(6, vo.getStrikeout());
			   ps.setInt(7, vo.getBall());
			   ps.setDouble(8, vo.getEra());
			   ps.setDouble(9, vo.getWar());
			   ps.setString(10, vo.getTeam());
			   ps.setInt(11, vo.getAge());
			   ps.setDouble(12, vo.getInning());
			   ps.setInt(13, vo.getSave());
			   ps.setInt(14, vo.getHold());
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



