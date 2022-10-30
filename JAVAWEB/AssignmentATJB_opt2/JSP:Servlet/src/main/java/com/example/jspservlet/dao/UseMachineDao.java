package com.example.jspservlet.dao;


import com.example.jspservlet.model.UseMachine;
import com.example.jspservlet.utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UseMachineDao {
    public boolean saveUseMachine(UseMachine useMachine){
        Connection connection = null;
        String SQL = "INSERT INTO SuDungMay VALUES(?,?,?,?,?)";
        Integer count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, useMachine.getMaKH());
            preparedStatement.setString(2, useMachine.getMaMay());
            preparedStatement.setString(3, useMachine.getNgayBD());
            preparedStatement.setString(4, useMachine.getGioBD());
            preparedStatement.setInt(5, useMachine.getThoigianSD());
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
