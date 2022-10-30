package com.example.jspservlet.dao;

import com.example.jspservlet.model.Service;
import com.example.jspservlet.model.UseMachine;
import com.example.jspservlet.model.UseService;
import com.example.jspservlet.utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UseServiceDao {
    public List<UseService> getAllService() throws SQLException {
        Connection connection = null;
        String SQL = "SELECT * FROM SuDungDV";
        List<UseService> useServiceList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                UseService useService = new UseService();
                useService.setMaKH(rs.getString("MakH"));
                useService.setMaDV(rs.getString("MaDV"));
                useService.setNgaySD(rs.getString("NgaySD"));
                useService.setGioSD(rs.getString("GioSD"));
                useService.setSoLuong(rs.getInt("SoLuong"));
                useServiceList.add(useService);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(connection);
        }
        return useServiceList;
    }

    public boolean saveUseService(UseService useService){
        Connection connection = null;
        String SQL = "INSERT INTO SuDungDV VALUES(?,?,?,?,?)";
        Integer count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, useService.getMaKH());
            preparedStatement.setString(2, useService.getMaDV());
            preparedStatement.setString(3, useService.getNgaySD());
            preparedStatement.setString(4, useService.getGioSD());
            preparedStatement.setInt(5, useService.getSoLuong());
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
}
