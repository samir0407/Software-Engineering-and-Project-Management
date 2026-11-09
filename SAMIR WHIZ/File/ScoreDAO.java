package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScoreDAO {

    private final String URL =
            "jdbc:mysql://localhost:3306/samir_whiz_db";

    private final String USER = "root";

    private final String PASSWORD = "";

    public void saveScore(
            String playerName,
            int score,
            String difficulty) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            String sql =
                    "INSERT INTO game_scores(player_name, score, difficulty) VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, playerName);
            ps.setInt(2, score);
            ps.setString(3, difficulty);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public ResultSet getTopScores() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            String sql =
                    "SELECT * FROM game_scores "
                    + "ORDER BY score DESC, played_at ASC "
                    + "LIMIT 10";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}