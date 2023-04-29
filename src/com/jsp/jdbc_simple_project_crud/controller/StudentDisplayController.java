package com.jsp.jdbc_simple_project_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDisplayController {
	
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
			String displayStudentQuery = "select * FROM student";
			
			//step-4 execute Query
			ResultSet resultSet = statement.executeQuery(displayStudentQuery);
			
			while(resultSet.next())
			{
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				
				System.out.println("Id " + id);
				System.out.println("Name " + name);
				System.out.println("Email " + email);
				System.out.println("========================");
			}
			
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
