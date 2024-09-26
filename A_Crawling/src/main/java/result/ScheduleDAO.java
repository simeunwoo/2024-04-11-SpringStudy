package result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScheduleDAO {

    private Connection conn;

    public ScheduleDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertSchedule(ScheduleVO vo) {
        String sql = "INSERT INTO schedule(sno,game_date,game_time,home,away,stadium,homescore,awayscore) "
                   + "VALUES(schedule_sno_seq.nextval,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vo.getGame_date());
            pstmt.setString(2, vo.getGame_time());
            pstmt.setString(3, vo.getHome());
            pstmt.setString(4, vo.getAway());
            pstmt.setString(5, vo.getStadium());
            pstmt.setInt(6, vo.getHomescore()); // null 처리
            pstmt.setInt(7, vo.getAwayscore()); // null 처리

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
