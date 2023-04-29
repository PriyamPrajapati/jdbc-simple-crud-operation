package com.jsp.jdbc_simple_project_crud.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class StudentInsertController {
	
	static Connection connection;
	
	public static void main(String[] args) {
		
			try {
				
				//step-1 load/Register Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//step-2 Create the Connection
				String url = "jdbc:mysql://localhost:3306/jdbc-simple";
				String user = "root";
				String pass = "Priyam";
				
				connection = DriverManager.getConnection(url,user,pass);
				
	            //Step-3 create statement
				Statement statement = connection.createStatement();
				
				//step-4 execute Query
				String insertQuery = "insert into student values(101,'Priyam','Priyam@gmail.com')";
				
				statement.execute(insertQuery);
				
				System.out.println("Data Added Succesfully");
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
				
		   }finally {
			   
			//step-5 close the connection
			try {
				connection.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}

}
