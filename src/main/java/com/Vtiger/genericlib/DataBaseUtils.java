package com.Vtiger.genericlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author zubairahmed
 *
 */
public class DataBaseUtils {
	 Connection con = null;
	 ResultSet result = null;
	/**
	 * This method is used to execute select Database query & return the table in
	 * the form of ResultSet
	 * 
	 * @param query
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet executeDbSelectQuery(String query) throws SQLException {
		Connection con = null;
		ResultSet result = null;
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			Statement statement = con.createStatement();

			result = statement.executeQuery(query);

			while (result.next()) {
				System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4) + "\t" + result.getString(5) + "\t" + result.getInt(6));
			}
		} catch (Exception e) {
			System.err.println("Invalid Query");
		} finally {
			con.close();
			System.out.println("Database Connection Closed");
		}
		return result;
	}



	public int executeDbNonSelectQuery(String query) throws SQLException {
		Connection con=null;
		int result = 0;
		try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement state = con.createStatement();
		
		result = state.executeUpdate(query);
		if(result==1) {
			System.out.println("Valide Query");
		}
		}
		catch (Exception e) {
			System.out.println("Invalid Query");
		
		}
		finally {
			con.close();
		}
		return result;
	}
	public void connectToDB() {
		Driver driverRef;
		try {
			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	public ResultSet execyteQuery(String query) throws Throwable {
		

		try {
			// executing the query
			 result = con.createStatement().executeQuery(query);
			 return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 
				
			
		}
		return result;
		
	}
	public   String executeQueryAndGetData(String query ,int columnName , String expectedData) throws Throwable{
        boolean flag = false;
			result = con.createStatement().executeQuery(query);
			
		while (result.next()) {
			  		if(result.getString(columnName).equals(expectedData)) {
			  			flag= true;
			  			break;
			  		}
		}
			
		
		if(flag) {
			System.out.println(expectedData + "===> data verified in data base table");
			return expectedData;
		}else {
			System.out.println(columnName + "===> data not verified in data base table");
			return expectedData;
		}
		
		
	}
	
	public void closeDb() throws SQLException {
		con.close();
	}
}
