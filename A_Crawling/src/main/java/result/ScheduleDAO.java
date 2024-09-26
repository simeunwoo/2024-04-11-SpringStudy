package result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pitcher.PitcherDAOAfter;

public class ScheduleDAO {

	private Connection conn;
	   private PreparedStatement ps;
	   private static ScheduleDAO dao;
	   private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
	   
	   // 드라이버 등록 
	   public ScheduleDAO()
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
	   public static ScheduleDAO newInstance()
	   {
		   if(dao==null)
			   dao=new ScheduleDAO();
		   return dao;
	   }

    public void insertSchedule(ScheduleVO vo) {
     

        try {
        	getConnection();
        	String sql = "INSERT INTO schedule(sno,game_date,game_time,home,away,stadium,homescore,awayscore) "
                    + "VALUES(schedule_sno_seq.nextval,?,?,?,?,?,?,?)";
        	ps=conn.prepareStatement(sql);
        	
            ps.setString(1, vo.getGame_date());
            ps.setString(2, vo.getGame_time());
            ps.setString(3, vo.getHome());
            ps.setString(4, vo.getAway());
            ps.setString(5, vo.getStadium());
            ps.setInt(6, vo.getHomescore()); // null 처리
            ps.setInt(7, vo.getAwayscore()); // null 처리

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
        	disConnection();
        }
    }
}
