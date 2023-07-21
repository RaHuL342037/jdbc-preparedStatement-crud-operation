package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.*;

/**
 * 
 * @author Rahul
 *
 */

public class ProductUpdateController{
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
		
		String updateQuery = "update product set productcolor = ? where productid = ?";
		
		//Step3 : create statement
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		
		preparedStatement.setString(1,"red");
		preparedStatement.setInt(2,100);
		
		//Step4: execute 
		int a=preparedStatement.executeUpdate();
		if(a==1) {
			System.out.println("Data is updated.");
		}
		else {
			System.out.println("No such productid present");
		}
		
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
