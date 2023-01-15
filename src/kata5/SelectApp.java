package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:flights.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql ="SELECT * FROM flights";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getInt("DAY_OF_WEEK") + "\t"
                        + rs.getString("DEP_TIME") + "\t"
                        + rs.getString("DEP_DELAY") + "\t"
                        + rs.getString("ARR_TIME") + "\t"
                        + rs.getString("ARR_DELAY") + "\t"
                        + rs.getString("CANCELLED") + "\t"
                        + rs.getString("DIVERTED") + "\t"
                        + rs.getString("AIR_TIME") + "\t"
                        + rs.getString("DISTANCE") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}