import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestUsePrepareStatement {
    public static void main(String[] args) {
        String Url = "jdbc:sqlserver://localhost:1433;DatabaseName=TestConnectSQL;encrypt=true;trustServerCertificate=true";
        String userName = "sa";
        String password = "123456aA@$";
        String sqlPrepareStatement = "SELECT * FROM TestTable WHERE id = ?";
        try( // Su dung try-with-resource
                Connection conection = DriverManager.getConnection(Url, userName, password);
                PreparedStatement pstm = conection.prepareStatement(sqlPrepareStatement);
                ){
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            pstm.setInt(1,1);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                System.out.print(rs.getInt("id") +" : ");
                System.out.println(rs.getString("nameTable"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
