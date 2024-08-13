package busResvDB;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
	String passengerName;
	int busNo;
	Date date;
	int id;
	
	Booking(){
		Scanner scan=new Scanner(System.in);
		
		System.out.print("\nEnter your Name: ");
		passengerName=scan.next();
		
		System.out.print("\nEnter Bus Number: ");
		busNo=scan.nextInt();
		
		System.out.print("\nEnter Travel Date(dd-mm-yyyy): ");
		String DateIP=scan.next();
		
		SimpleDateFormat dateFormate=new SimpleDateFormat("dd-MM-yyyy");
	
		try {
			date=dateFormate.parse(DateIP);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	public boolean isAvailable() throws SQLException {
		
		BusDAO busdao=new BusDAO();
		BookingDAO bookingdao=new BookingDAO();
		int capacity=busdao.getCapacity(busNo);
		
		int booked=bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
	}
	
}
