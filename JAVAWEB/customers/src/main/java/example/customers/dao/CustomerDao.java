package example.customers.dao;

import example.customers.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements CustomerDaoImpl{
    private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Customer;encrypt=true;trustServerCertificate=true";
    private String user = "sa";
    private String password = "123456aA@$";
    private final String GET_ALL = "SELECT * FROM CUSTOMER";
    private final String ADD_CUSTOMER = "INSERT INTO Customer VALUES(?,?,?)";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customerId"));
                customer.setCustomerName(resultSet.getString("customerName"));
                customer.setCustomerEmail(resultSet.getString("customerEmail"));
                customer.setCustomerBirthDay(resultSet.getString("customerBirthDay"));
                customerList.add(customer);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public Customer findCustomerById(int id) {
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }

    @Override
    public boolean addCustomer(Customer customer) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
            preparedStatement.setString(1,customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthDay());
            preparedStatement.setString(3, customer.getCustomerEmail());
            int check = preparedStatement.executeUpdate();
            if (check!=0){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }
}
