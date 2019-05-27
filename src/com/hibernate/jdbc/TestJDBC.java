package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String uName = "hbstudent";
		String pass = "hbstudent";

		try {
			Connection connection = DriverManager.getConnection(jdbcURL, uName, pass);
			System.out.println("connection successfully");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
