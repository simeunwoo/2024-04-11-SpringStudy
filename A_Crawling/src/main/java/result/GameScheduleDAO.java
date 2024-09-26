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
            String sql = "INSERT INTO game_schedule(sno, game_date, game_time, home, away, stadium, home_score, away_score) "
                       + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, vo.getSno());
            ps.setString(2, vo.getGameDate());
            ps.setString(3, vo.getGameTime());
            ps.setString(4, vo.getHome());
            ps.setString(5, vo.getAway());
            ps.setString(6, vo.getStadium());
            ps.setInt(7, vo.getHomeScore());
            ps.setInt(8, vo.getAwayScore());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disConnection();
        }
    }
}

