package com.jsp.jdbc_simple_project_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdateController {
	
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
			//Step-3 create the statement
			Statement statement = connection.createStatement();
			
			String updateStudentQuery = "update student set name ='Govind' where id = 101";
			
			//step-4 execute Query
			int id = statement.executeUpdate(updateStudentQuery);
			
			if(id!=0)
			{
				System.out.println("Data Updated");
			}
			else
			{
				System.out.println("Giiven id Not Found");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			//step-5 close the connection
			try {
				connection.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}

}
