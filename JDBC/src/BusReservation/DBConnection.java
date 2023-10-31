package BusReservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url="jdbc:mysql://127.0.0.1:3306/busrev";
    private static final String username="root";
    private static final String pass="1432";

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url,username,pass);
    }
}
