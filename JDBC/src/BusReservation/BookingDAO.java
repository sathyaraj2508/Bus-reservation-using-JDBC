package BusReservation;

import java.sql.*;
import java.util.Date;

public class BookingDAO {
    public int getBookCount(int busno, Date date) throws SQLException {
        String query="select count(passenger_name) from booking where bus_no="+busno+" and travel_date=? ;";
        java.sql.Date sqldate=new java.sql.Date(date.getTime());

        Connection con = DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);

        pst.setDate(1,sqldate);

        ResultSet rs=pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void addBooking(Booking booking) throws SQLException {
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());

        String query="insert into booking values(?,?,?);";
        Connection con = DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1,booking.name);
        pst.setInt(2,booking.busNo);
        pst.setDate(3,sqldate);

        pst.executeUpdate();

        /*PreparedStatement pst=con.prepareStatement(query);
        pst.setDate(1,sqldate);
        ResultSet rs=pst.executeQuery();
         */
    }

}
