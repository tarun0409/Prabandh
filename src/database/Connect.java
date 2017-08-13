package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private static Connection prabandh;
	public static Connection getConnection()
	{
		if(prabandh==null)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prabandh","root","******");
				prabandh = con;
			}
			catch(SQLException s)
			{
				System.out.println("Unable to establish SQL connection");
				prabandh = null;
			}
		}
		return prabandh;
	}

}
