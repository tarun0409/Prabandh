package sample;
import java.sql.*;
public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sample_database","root","TatTvamAsi123!");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from sample_table");
			ResultSetMetaData rsmt = rs.getMetaData();
			int cnt = rsmt.getColumnCount();

			for(int i=1; i<=cnt; i++)
			{
				String columnLabel = rsmt.getColumnLabel(i);
				String columnType = rsmt.getColumnTypeName(i);
				System.out.println(columnLabel+":::::::::::::::"+columnType);
			}
			while(rs.next())  
			System.out.println(rs.getString("column1")+"  "+rs.getString("column2"));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  

	}

