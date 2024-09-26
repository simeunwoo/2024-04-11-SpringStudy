package result;

import java.sql.*;

public class GameScheduleDAO {
    private Connection conn;
    private PreparedStatement ps;
    private static GameScheduleDAO dao;
    private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";

    // 드라이버 등록
    public GameScheduleDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 연결
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(URL, "hr2", "happy");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 해제
    public void disConnection() {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 싱글턴
    public static GameScheduleDAO newInstance() {
        if (dao == null)
            dao = new GameScheduleDAO();
        return dao;
    }

    // 기능
    public void insertGameSchedule(GameScheduleVO vo) {
        try {
            getConnection();
            String sql = "INSERT INTO schedule(sno,gamedate,home,away,homescore,awayscore) "
                       + "VALUES(schedule_sno_seq.nextval,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getGamedate());
            ps.setString(2, vo.getHome());
            ps.setString(3, vo.getAway());
            ps.setInt(4, vo.getHomescore());
            ps.setInt(5, vo.getAwayscore());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disConnection();
        }
    }
}

