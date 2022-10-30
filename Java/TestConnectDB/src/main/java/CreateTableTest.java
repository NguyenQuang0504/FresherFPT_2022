import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableTest {
    public static void main(String[] args) {
        String sql = "CREATE TABLE TestTable1(\n" +
                " id int IDENTITY,\n" +
                " nameTable NVARCHAR(30) \n" +
                ");";
        try{
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=TestConnectSQL;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement stm = connection.createStatement();
            stm.executeQuery(sql);
            stm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
