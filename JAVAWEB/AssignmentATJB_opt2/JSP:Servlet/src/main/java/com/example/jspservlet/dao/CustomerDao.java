package com.example.jspservlet.dao;

import com.example.jspservlet.model.Customer;
import com.example.jspservlet.utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    /*
    * @author: QuangNV51
    * @since: 23/10/2022 20:20
    * @description: GetAllCustomer
    */
    public List<Customer> getAllCustomer(){
        Connection connection = null;
        String SQL = "SELECT * FROM KhachHang";
        List<Customer> customerList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setMaKH(rs.getString("MaKH"));
                customer.setTenKH(rs.getString("TenKH"));
                customer.setDiaChi(rs.getString("DiaChi"));
                customer.setSdt(rs.getString("SDT"));
                customer.setEmail(rs.getString("Email"));
                customerList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    /*
    * @author: QuangNV51
    * @since: 23/10/2022 20:24
    * @description: method addCustomer
    */
    public boolean addCustomer(Customer customer){
        Connection connection = null;
        String SQL = "INSERT INTO KhachHang VALUES(?,?,?,?,?)";
        Integer count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, customer.getMaKH());
            preparedStatement.setString(2, customer.getTenKH());
            preparedStatement.setString(3, customer.getDiaChi());
            preparedStatement.setString(4, customer.getSdt());
            preparedStatement.setString(5, customer.getEmail());
            count = preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count != 0){
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(String maKH){
        Connection connection = null;
        String SQL = "DELETE FROM KhachHang WHERE MaKH = ?";
        int count = 0;
        try {
            connection =DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, maKH);
            count = preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count != 0){
            return  true;
        }
        return  false;
    }
}
