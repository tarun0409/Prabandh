package upyog;

import java.sql.Connection;
import java.sql.ResultSet;
import database.Connect;

public class Data {
	
	Connection connection;
	public Data()
	{
		if(connection==null)
		{
			connection = Connect.getConnection();
		}
	}
	public ResultSet getDataFromDB(String table, String condition, String ...columns)
	{
		String query = "SELECT";
		for(int i=0; i<columns.length; i++)
		{
			String column = columns[i];
			query+=" "+column;
			if(i!=columns.length-1)
			{
				query=query+",";
			}
		}
		query=query+" WHERE ";
		
		return null;
		
	}

}
