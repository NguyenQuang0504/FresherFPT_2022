package com.example.jspservlet.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
* @author: QuangNV51
* @since: 23/10/2022 20:11
* @description:
*/

public class DBUtil {
	private static String DRIVER, SERVER_NAME, DB_NAME, USER_NAME, PASSWORD;
	static final String FILE_NAME = "/properties/DBConfig.properties";


	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties properties = new Properties();
		properties.load(DBUtil.class.getResourceAsStream(FILE_NAME));

		DRIVER = properties.getProperty("driver");
		SERVER_NAME = properties.getProperty("server");
		DB_NAME = properties.getProperty("dbname");
		USER_NAME = properties.getProperty("username");
		PASSWORD = properties.getProperty("password");
		Class.forName(DRIVER);

		return DriverManager.getConnection(SERVER_NAME + ";databaseName=" + DB_NAME +";encrypt=true;trustServerCertificate=true", USER_NAME, PASSWORD);
	}


	public static void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

}
