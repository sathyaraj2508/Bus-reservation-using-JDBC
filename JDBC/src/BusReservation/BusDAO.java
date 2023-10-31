package BusReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {
    // DAO means bus data access object

    public void displayBusInfo() throws SQLException {
        String query = "select * from bus;";

        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("Bus number = " + rs.getInt(1));
            if (rs.getInt(2) == 0) {
                System.out.println("AC = No");
            } else {
                System.out.println("AC = Yes");

            }
            System.out.println("Bus capacity = " + rs.getInt(3));
        }
        System.out.println("---------------------------------------------------------------");
        con.close();
    }
    public int getCapacity(int busno) throws SQLException {
        String query ="select cap from bus where bus_no="+busno;
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
