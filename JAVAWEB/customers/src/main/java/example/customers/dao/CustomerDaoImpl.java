package example.customers.dao;

import example.customers.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDaoImpl {
    List<Customer> getAllCustomer();
    Customer findCustomerById(int id);
    boolean deleteCustomer(int id);
    boolean addCustomer(Customer customer) throws SQLException;
    boolean updateCustomer(Customer customer);
}
