package busResvDB;

import java.sql.*;

public class DBConnection {
	private static final String url="jdbc:mysql://localhost:3306/busresv";
	private static final String username="root";
	private static final String password="Jey1137";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
}
