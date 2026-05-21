package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.learn.model.Employee;
import com.learn.utility.SqlUitlity;

public class JdbcDemo10 {
	public static void main(String[] args) {
		final String QUERY = "SELECT * FROM EMP";
		try (Connection connection = new SqlUitlity().createConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QUERY);) {
 			DatabaseMetaData dmeta = connection.getMetaData();
			System.out.println(dmeta.getDatabaseProductName());
			System.out.println(dmeta.getDatabaseProductVersion());
			System.out.println(dmeta.getDatabaseMajorVersion());
			System.out.println(dmeta.getDriverName());
			System.out.println(dmeta.getDriverMajorVersion());

			ResultSetMetaData meta = resultSet.getMetaData();
			System.out.println(meta.getColumnCount());
			int count = meta.getColumnCount();
			for (int i = 1; i <= count; i++) {
				System.out.println(meta.getColumnName(i) + " -- " + meta.getColumnTypeName(i));
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
