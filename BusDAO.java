package busResvDB;

import java.sql.*;

public class BusDAO {
	public void displayBusInfo() throws SQLException {
		String query="select * from bus";
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus No: "+rs.getInt(1));
			if(rs.getInt(2)==0)
				System.out.println("AC : NO ");
			else
				System.out.println("AC : YES ");
			System.out.println("Capacity: "+rs.getInt(3));
			System.out.println("Starting Point : "+rs.getString(4));
			System.out.println("Stoping Point : "+rs.getString(5));
			System.out.println("Duration : "+rs.getString(6));
			System.out.println(" ");
			
		}
		System.out.println("------------------------------------");
	}
	
	public int getCapacity(int id) throws SQLException {
		String query="select capacity from bus where id1="+id;
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		
		return rs.getInt(1);
		
	}
	
	
}
