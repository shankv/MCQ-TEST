package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myconnection {
	static Connection c;
	public static Connection connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/shashank","root","shank");
			System.out.println("connected");
		} catch (ClassNotFoundException|SQLException e) {
	
			e.printStackTrace();
		}
		
	return c;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connect();

	}

}
