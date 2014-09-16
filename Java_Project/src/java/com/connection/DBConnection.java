/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;
import java.sql.*;
/**
 *
 * @author Raj
 */
public class DBConnection {
   static Connection connection;
    public static Connection getConnection(){
        if(connection == null){
			try {
	 
				Class.forName("oracle.jdbc.driver.OracleDriver");
	 
			} catch (ClassNotFoundException e) {
	 
				System.out.println("Where is your Oracle JDBC Driver?");
				e.printStackTrace();
				//return;
	 
			}
	 
			System.out.println("Oracle JDBC Driver Registered!");
	 
			
	 
			try {
	 
				connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", "groupb",
						"password");
	 
			} catch (SQLException e) {
	 
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				//return;
	 
			}
	 
			if (connection != null) {
				System.out.println("Connection Successfuly");
				
				}
                        else {
				System.out.println("Failed to make connection!");
			}
        return connection;
        }
        else
        {
            return connection;
        }
			} 
                        
                       
    
}
