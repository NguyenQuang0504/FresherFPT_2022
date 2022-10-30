package com.example.jspservlet.dao;

import com.example.jspservlet.model.Service;
import com.example.jspservlet.utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao {
    /*
    * @author: QuangNV51
    * @since: 23/10/2022 23:47
    * @description:
    */
    public List<Service> getAllService() throws SQLException {
        Connection connection = null;
        String SQL = "SELECT * FROM DichVu";
        List<Service> serviceList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Service service = new Service();
                service.setMaDV(rs.getString("MaDV"));
                service.setTenDV(rs.getString("TenDV"));
                service.setDonGia(rs.getInt("DonGia"));
                service.setDonVi(rs.getString("DonViTinh"));
                serviceList.add(service);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }return serviceList;
    }

    /*
    * @author: QuangNV51
    * @since: 23/10/2022 23:51
    * @description:
    */
    public boolean addService(Service service) throws SQLException {
        Connection connection = null;
        String SQL = "INSERT INTO DichVu VALUES(?,?,?,?)";
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, service.getMaDV());
            preparedStatement.setString(2, service.getTenDV());
            preparedStatement.setString(3, service.getDonVi());
            preparedStatement.setInt(4, service.getDonGia());
            count = preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
        if (count != 0){
            return true;
        }return false;
    }

    public boolean deleteService(String maDV) throws SQLException {
        Connection connection = null;
        String SQL = "DELETE FROM DichVu WHERE MaDV = ?";
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,maDV);
            count = preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
        if (count != 0){
            return  true;
        }return false;
    }
}
