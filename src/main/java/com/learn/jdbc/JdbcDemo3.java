package com.learn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo3 {
	public static void main(String[] args) {
		final String USER = "system";
		final String PASSWORD = "India12345";
 		final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
 	final String QUERY="SELECT empno,ename,sal,deptno FROM EMP";

 		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(QUERY);

			) {
				while (resultSet.next()) {
				int empno=	 resultSet.getInt(1);
				String employeeName =resultSet.getString(2);
 				double salary = resultSet.getDouble(3);
				int deptno =resultSet.getInt(4);
				System.out.printf("%-10s%-15s%-10s%-10s\n",empno,employeeName,salary,deptno);
				
 				}
			} 
 		catch(SQLException e) {
 			System.out.println("Error....." +e.getMessage());
 		}
	
	}
	
}



//select * from emp   ---> all 8 columns and all rows retrived
//empno   ename   job mgr  hiredate  sal  comm deptno
//1         2      3   4     5        6     7    8
//select empno,ename,sal,deptno from emp ;     -->only  4 columns all rows
//1 2 3 4
//select * from emp where deptno=10; -- >all columns but only limited rows
