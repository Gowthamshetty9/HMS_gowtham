package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDatafronMysql_DB {

	public static void main(String[] args) throws SQLException {
		//Connection con=null;
		
	//Register/load the sql data base
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	//Get connected to database
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema","root","root");
	
	//Create sql statement/query
	Statement statement = con.createStatement();
	String query="select * from engines";
	
	//Execute a query/statement
	ResultSet result = statement.executeQuery(query);
	while(result.next()) {
		System.out.println(result.getString(1));
	}
		con.close();
	}
	}

