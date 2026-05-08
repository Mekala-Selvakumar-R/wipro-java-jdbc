package com.learn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo8{
	public static void main(String[] args) {
		final String USER = "system";
		final String PASSWORD = "India12345";
		final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
		final String QUERY = "delete  from  dept where deptno=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Number to  delete");
		int dno = sc.nextInt();
 
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstatement = connection.prepareStatement(QUERY);) {
 			pstatement.setInt(1, dno);
            //Oracle JDBC driver doesn't override the toString() method of a Object class
			System.out.println(pstatement);
			int n = pstatement.executeUpdate();
			System.out.println(n);
			if (n>0) {
				System.out.println(n+ "row(s) deleted");
			}
 
		} catch (SQLException e) {
			System.out.println("Error....." + e.getMessage());
		}

	}

}

 