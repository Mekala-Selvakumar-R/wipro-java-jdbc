package com.learn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {

	public static void main(String[] args) {
		final String USER = "system";
		final String PASSWORD = "India12345";
//	  final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

		// LOAD AND REGISTER THE DRIVER
		Driver driver = new oracle.jdbc.OracleDriver();
// TRY WITH RESOURCES
		try {
			DriverManager.registerDriver(driver);
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM EMP");

			) {
				while (resultSet.next()) {
				int empno=	 resultSet.getInt("empno");
				String employeeName =resultSet.getString("ename");
				String  job =resultSet.getString("job");
				double salary = resultSet.getDouble("sal");
				int deptno =resultSet.getInt("deptno");
				System.out.printf("%-10s%-15s%-15s%-10s%-10s\n",empno,employeeName,job,salary,deptno);
				
 				}
			} catch (SQLException e) {
				System.out.println("Error ... " + e.getMessage());

 			}

		} catch (SQLException e) {
			System.out.println("Error ... " + e.getMessage());
		}

	}

}


//select * from emp   ---> all 8 columns and all rows retrived
//empno   ename   job mgr  hiredate  sal  comm deptno
//select empno,ename,sal,deptno from emp ;     -->only  4 columns all rows
//select * from emp where deptno=10; -- >all columns but only limited rows
