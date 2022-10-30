import java.sql.*;

public class Main{

    public static void main(String[] args) {
        String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=TestConnectSQL;encrypt=true;trustServerCertificate=true"; //defind connect URL
        String userName = "sa"; // defind userName
        String password = "123456aA@$"; // defind password
        String sql = "SELECT * FROM TestTable"; //create query
        try(
                Connection connection = DriverManager.getConnection(connectionUrl, userName, password); // create connect
                Statement stmt = connection.createStatement();
//            String sql1 = "DROP TABLE TestTable";
//            stmt.execute(sql1);
                ResultSet rs = stmt.executeQuery(sql); // use executeQuery with query select, with query update, insert, delete use executeUpdate, with query create or drop table use execute
        ){

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            // Get information Database
            DatabaseMetaData databaseMetaData = connection.getMetaData(); //get information Database
            String info = connection.getMetaData().getDatabaseProductName(); // get Name Database
            String version = databaseMetaData.getDatabaseProductVersion(); // get version Database
            System.out.println("Database Meta Data: " +databaseMetaData);
            System.out.println("Name Database: " +info);
            System.out.println("Version:" +version);

            // Create Statement
            System.out.println("Data on TestTable: ");
            // Xu ly ket qua tra ve
            while (rs.next()){
                System.out.print("Row" +rs.getRow() +": ");
                System.out.print("Id: " +rs.getString("id"));
                System.out.println(" Name: " +rs.getString("nameTable"));
            }
            rs.close();
            stmt.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}