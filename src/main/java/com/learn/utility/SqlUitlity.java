package com.learn.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUitlity {
//	private static Connection connection;
//	private static final String USER = "system";
//	private static final String PASSWORD = "India12345";
//	private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
//
//	public static Connection createConnection() throws SQLException {
//		if (connection == null) {
//			connection = DriverManager.getConnection(URL, USER, PASSWORD);
//		}
//		return connection;
//
//	}

	private Connection connection;
	private final String USER = "system";
	private final String PASSWORD = "India12345";
	private final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

	public Connection createConnection() throws SQLException {
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		return connection;

	}

}
