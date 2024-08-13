package busResvDB;
import java.util.Date;
import java.sql.*;

public class BookingDAO {
	public int getBookedCount(int busNo,Date date) throws SQLException{
		String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		
		Connection con=DBConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqldate);
		ResultSet rs=pst.executeQuery();
		rs.next();
		
		return rs.getInt(1);
	}
	
	public int addBooking(Booking booking) throws SQLException{
		String query ="Insert into booking (passenger_name,bus_no,travel_date) values(?,?,?)";
		
		Connection con=DBConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqldate);
		pst.executeUpdate();
		
		int id=getId(booking.passengerName);
		return id;
	}
	
	public int getId(String passengerName) throws SQLException{
		
		String query="select id from booking where passenger_name = '" + passengerName + "'";
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		int id=rs.getInt(1);
		return id;
	}
	
	public void deleteBooking(int id)throws SQLException{
		
		String query="delete from booking where id="+id;
		
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		int rows=st.executeUpdate(query);
		
		System.out.println("Your Booking is Cancelled.....");
		
	}
}
