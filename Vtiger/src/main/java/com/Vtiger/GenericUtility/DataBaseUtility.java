package com.Vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Kavya
 *
 */
public class DataBaseUtility {

	static Driver driver;
	static Connection connection;
	static ResultSet result;
	
	/**
	 * This method will perform the Mysql Database connection.
	 */
	public void connectDB() {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
				
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3308/projects", "root", "root");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will close the mysql Database connection.
	 * @throws SQLException 
	 */
	public void closeDB() throws SQLException {
		connection.close();
	}
	
	/**
	 * This method will execute the query.
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	
	public ResultSet executeQuery(String query) throws Throwable{
		try {
			result = connection.createStatement().executeQuery(query);	
		return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
