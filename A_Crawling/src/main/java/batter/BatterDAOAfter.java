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
	   
	   public void batterAfterInsert(BatterVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO batter(bno,age,game,h1,h2,h3,homerun,rbi,ball,strikeout,war,name,team,position,steel,tasoo,image,avg) "
			   		+ "VALUES(batter_bno_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, vo.getBno());
			   ps.setInt(2, vo.getGame());
			   ps.setInt(3, vo.getH1());
			   ps.setInt(4, vo.getH2());
			   ps.setInt(5, vo.getH3());
			   ps.setInt(6, vo.getHomerun());
			   ps.setInt(7, vo.getRbi());
			   ps.setInt(8, vo.getBall());
			   ps.setInt(9, vo.getStrikeout());
			   ps.setDouble(10, vo.getWar());
			   ps.setString(11, vo.getName());
			   ps.setString(12, vo.getTeam());
			   ps.setString(13, vo.getPosition());
			   ps.setInt(14, vo.getSteel());
			   ps.setInt(15, vo.getTasoo());
			   ps.setString(16, vo.getImage());
			   ps.setDouble(17, vo.getAvg());
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
	   
	   /*
	   public BatterVO getBatterByBno(int bno) {
		    BatterVO vo = null;
		    try {
		        getConnection();
		        String sql = "SELECT * FROM batter WHERE bno=?";
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, bno);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            vo = new BatterVO();
		            vo.setBno(rs.getInt("bno"));
		            vo.setName(rs.getString("name"));
		            vo.setTeam(rs.getString("team"));
		            // 필요한 다른 필드도 여기에 추가
		        }
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    } finally {
		        disConnection();
		    }
		    return vo;
		}
		*/

	}



