package com.tcs.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static String URL = "jdbc:postgresql://localhost:5432/railway";
	static String USER = "postgres";
	static String PASS = "root";
	static Connection c = null;
	public static Connection start(){
		try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager.getConnection(URL, USER, PASS);
		     } 
		catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
		 System.out.println("Opened database successfully");
		 return c;
	}
		public static void Close() {
			try {
			c.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

}
