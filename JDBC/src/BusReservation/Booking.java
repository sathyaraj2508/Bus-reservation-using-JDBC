package BusReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
     String name;
     int busNo;
     Date date;
    Booking() throws ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name = ");
        name=sc.next();
        System.out.println("Enter your Busno = ");
        busNo=sc.nextInt();
        System.out.println("Enter your Date in this format(dd/mm/yyyy) = ");
        String dateformat=sc.next();
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        try {
            date=formatter1.parse(dateformat);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean isAvailable() throws SQLException {
        BusDAO busdao=new BusDAO();
        BookingDAO bookdao=new BookingDAO();

        int capacity=busdao.getCapacity(busNo);
        int booked=bookdao.getBookCount(busNo,date);
        return booked<capacity;
    }
}
