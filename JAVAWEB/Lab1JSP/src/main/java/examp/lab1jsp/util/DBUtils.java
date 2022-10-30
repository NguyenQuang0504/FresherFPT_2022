package examp.lab1jsp.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    /**
     * method create connection.
     * @return Connection connection
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
        String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=Lab1JSP;encrypt=true;trustServerCertificate=true"; //defind connect URL
        String userName = "sa"; // defind userName
        String password = "123456aA@$"; // defind password
        return DriverManager.getConnection(connectionUrl, userName, password);
    }

    /**
     * method to close connection
     * @param connection Connection
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
