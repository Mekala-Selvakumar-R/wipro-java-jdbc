package com.learn.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.learn.model.Employee;
import com.learn.utility.SqlUitlity;

import oracle.jdbc.driver.SQLUtil;

public class JdbcDemo9 {
	public static void main(String[] args) {

		final String QUERY = "SELECT * FROM EMP where  deptno=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Number");
		int dno = sc.nextInt();
//		try (Connection connection = SqlUitlity.createConnection();
		try (Connection connection = new SqlUitlity().createConnection();
				PreparedStatement pstatement = connection.prepareStatement(QUERY);) {
			pstatement.setInt(1, dno);
			System.out.println(pstatement);
			try (ResultSet resultSet = pstatement.executeQuery();) {
//				List<Employee> employeeList = getAllEmployee(resultSet);
//				employeeList.forEach(System.out::println);
				
				ResultSetMetaData  meta = resultSet.getMetaData();
				System.out.println(meta.getColumnCount());
				int count =meta.getColumnCount();
				for(int i=1;i<=count;i++) {
				System.out.println(meta.getColumnName(i) +" -- " + meta.getColumnTypeName(i));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error....." + e.getMessage());
		}

	}

	public static List<Employee> getAllEmployee(ResultSet resultSet) throws SQLException {
		List<Employee> employeeList = new ArrayList<>();
		while (resultSet.next()) {
			int empno = resultSet.getInt("empno");
			String employeeName = resultSet.getString("ename");
			String job = resultSet.getString("job");
			int mgr = resultSet.getInt("mgr");
			float salary = resultSet.getFloat("sal");
			float comm = resultSet.getFloat("comm");
			int deptno = resultSet.getInt("deptno");
			Date doj = resultSet.getDate("hireDate");
			// convert sql date to LocalDate
			LocalDate hireDate = doj.toLocalDate();
			Employee emp = new Employee(empno, employeeName, job, mgr, hireDate, salary, comm, deptno);
			employeeList.add(emp);

		}
		return employeeList;
	}

}
