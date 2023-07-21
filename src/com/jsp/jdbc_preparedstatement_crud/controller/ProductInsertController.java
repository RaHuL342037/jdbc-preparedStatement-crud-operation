package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.*;

/**
 * 
 * @author Rahul
 *
 */

public class ProductInsertController{
	/*
	 * about method
	 */
	public static void main(String[] args){
	Connection connection = null;
	try {
		
		/*
		 * about variable
		 */
		
		//Step1 : load/register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step2 : create connection
		String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
		String user = "root";
		String pass = "Rahul342037@";
		
		connection = DriverManager.getConnection(url,user,pass);
		
		String insertQuery = "insert into product values(?,?,?,?)";
		
		//Step3 : create statement
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		
		preparedStatement.setInt(1,100);
		preparedStatement.setString(2,"pen");
		preparedStatement.setDouble(3, 14.5);
		preparedStatement.setString(4, "Blue");
		
		//Step4: execute 
		preparedStatement.execute();
		
	}
	catch(ClassNotFoundException | SQLException e){
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
