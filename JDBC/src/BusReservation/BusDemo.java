package BusReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) throws SQLException, ParseException {

        BusDAO busdao=new BusDAO();
        busdao.displayBusInfo();

        int i=1;
        Scanner sc=new Scanner(System.in);
        while(i==1){
            System.out.println("Enter 1 to book and 2 to exit");
            i=sc.nextInt();
            if(i==1){
                Booking booking=new Booking();
                if(booking.isAvailable()){
                    BookingDAO bookingdao=new BookingDAO();
                    bookingdao.addBooking(booking);
                    System.out.println("Booking success");
                }else{
                    System.out.println("Sorry seat is full. Try another date or bus");
                }
            }
        }
    }
}
