package com.learn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo7{
	public static void main(String[] args) {
		final String USER = "system";
		final String PASSWORD = "India12345";
		final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
		final String QUERY = "update   dept  set dname=? , loc=? where deptno=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Number to modify");
		int dno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Department Name");
		String dname =sc.nextLine();
		System.out.println("Enter Location");
		String location =sc.nextLine();
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstatement = connection.prepareStatement(QUERY);) {
			pstatement.setString(1,dname);
			pstatement.setString(2, location);
			pstatement.setInt(3, dno);
            //Oracle JDBC driver doesn't override the toString() method of a Object class
			System.out.println(pstatement);
			int n = pstatement.executeUpdate();
			if (n>0) {
				System.out.println(n+ "row(s) updated");
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
