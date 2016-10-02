package com.Ricardo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {


		private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
		private static final String USER = "root";
		private static final String PASSWORD = "";
		
		private static Connection con = null;
		
		
		static {
			try {
			Class.forName("com.sql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

}
