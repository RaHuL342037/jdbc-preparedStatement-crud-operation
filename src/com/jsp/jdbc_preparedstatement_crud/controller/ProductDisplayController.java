package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDisplayController {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			//step1 - load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 - create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "Rahul342037@";
			
			connection = DriverManager.getConnection(url,user,pass);
			
			//step3 - create Statement 
			String displayQuery = "Select * from product";
			
			PreparedStatement preparedStatement = connection.prepareStatement(displayQuery);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("productid");
				String name = resultSet.getString("productname");
				double price = resultSet.getDouble("productprice");
				String color = resultSet.getString("productcolor");
				
				System.out.println("ProductId : " + id);
				System.out.println("ProductName : " + name);
				System.out.println("ProductPrice : " + price);
				System.out.println("ProductColor : " + color);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
