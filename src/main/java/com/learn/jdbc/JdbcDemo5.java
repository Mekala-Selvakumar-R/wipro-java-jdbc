package com.learn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo5 {
	public static void main(String[] args) {
		final String USER = "system";
		final String PASSWORD = "India12345";
		final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
		final String QUERY = "SELECT * FROM EMP where  deptno=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Number");
		int dno = sc.nextInt();

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstatement = connection.prepareStatement(QUERY);) {

			pstatement.setInt(1, dno);
			System.out.println(pstatement);
			try (ResultSet resultSet = pstatement.executeQuery();) {
				while (resultSet.next()) {
					int empno = resultSet.getInt("empno");
					String employeeName = resultSet.getString("ename");
					double salary = resultSet.getDouble("sal");
					int deptno = resultSet.getInt("deptno");
					System.out.printf("%-10s%-15s%-10s%-10s\n", empno, employeeName, salary, deptno);

				}
			}
		} catch (SQLException e) {
			System.out.println("Error....." + e.getMessage());
		}

	}

}

//select * from emp   ---> all 8 columns and all rows retrived
//empno   ename   job mgr  hiredate  sal  comm deptno
//1         2      3   4     5        6     7    8
//select empno,ename,sal,deptno from emp ;     -->only  4 columns all rows
//1 2 3 4
//select * from emp where deptno=10; -- >all columns but only limited rows
