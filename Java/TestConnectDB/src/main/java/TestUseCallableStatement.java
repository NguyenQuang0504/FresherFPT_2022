import java.sql.*;

public class TestUseCallableStatement {
    public static void main(String[] args) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=TestConnectSQL;encrypt=true;trustServerCertificate=true";
            String userName = "sa";
            String password = "123456aA@$";
            Connection connection = DriverManager.getConnection(url, userName, password);
            String procedures = "{call TestProcedures(?)}";
            CallableStatement cstm = connection.prepareCall(procedures);
            cstm.setInt(1,1);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()){
                System.out.print(rs.getInt("id" + " : "));
                System.out.println(rs.getString("nameTable"));
            }
            rs.close();
            cstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
