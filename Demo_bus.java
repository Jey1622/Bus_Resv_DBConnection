package busResvDB;

import java.util.*;

public class Demo_bus {

	public static void main(String[] args) throws Exception {
		BusDAO busdao=new BusDAO();
		
		try {
			busdao.displayBusInfo();
			
			Scanner scan=new Scanner(System.in);
			
			int userop=1;
			while(userop==1) {
				System.out.println("1.Add Booking ");
				System.out.println("2.Delete Booking");
				System.out.println("3.Exit ");
				System.out.println("Enter your Choise");
				userop=scan.nextInt();
				if(userop==1) {
					Booking booking=new Booking();
					if(booking.isAvailable()) {
						BookingDAO bookingdao=new BookingDAO();
						int id=bookingdao.addBooking(booking);
						System.out.println("Your Booking is Conformed...!");
						System.out.println("your id is "+id);					
					}
					else {
						System.out.println("Soory, Bus is Full. try another bus or date. ");
					}
				}
				else if(userop==2) {
					BookingDAO bookingdao=new BookingDAO();
					System.out.println("Enter your booking id : ");
					int id=scan.nextInt();
					bookingdao.deleteBooking(id);
					userop=1;
				}
			}
			scan.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
