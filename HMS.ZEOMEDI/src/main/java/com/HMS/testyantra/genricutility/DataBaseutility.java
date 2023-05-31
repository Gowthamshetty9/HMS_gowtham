package com.HMS.testyantra.genricutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


public class DataBaseutility {
	Connection con;
	
public void open_DB() throws Throwable {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema","root","root");
}

public  ResultSet Executequery(String sql) throws Throwable {
	ResultSet result = con.createStatement().executeQuery(sql);
	return result;
	}

public  int Executeupdate(String sql) throws Throwable {
	int result = con.createStatement().executeUpdate(sql);
	return result;
}

public void close_DB() throws SQLException {
	con.close();
}
}
