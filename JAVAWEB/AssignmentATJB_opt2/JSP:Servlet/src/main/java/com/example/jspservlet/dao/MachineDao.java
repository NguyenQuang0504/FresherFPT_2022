package com.example.jspservlet.dao;

import com.example.jspservlet.model.Machine;
import com.example.jspservlet.utils.DBUtil;

import javax.crypto.Mac;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineDao {

    /*
    * @author: QuangNV51
    * @since: 24/10/2022 00:24
    * @description:
    */
    public List<Machine> getAllMachine() throws SQLException {
        List<Machine> machineList = new ArrayList<>();
        Connection connection = null;
        String SQL = "SELECT * FROM May";
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Machine machine = new Machine();
                machine.setMaMay(rs.getString("MaMay"));
                machine.setTrangThai(rs.getString("TrangThai"));
                machine.setViTri(rs.getString("ViTri"));
                machineList.add(machine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
        return machineList;
    }

    /*
    * @author: QuangNV51
    * @since: 24/10/2022 00:28
    * @description:
    */
    public boolean addMachine(Machine machine) throws SQLException {
        Connection connection = null;
        int count = 0;
        String SQL = "INSERT INTO May VALUES(?,?,?)";
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, machine.getMaMay());
            preparedStatement.setString(2, machine.getViTri());
            preparedStatement.setString(3, machine.getTrangThai());
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
        }
        return false;
    }

    /*
    * @author: QuangNV51
    * @since: 24/10/2022 00:28
    * @description:
    */
    public boolean deleteService(String maMay) throws SQLException {
        Connection connection = null;
        String SQL = "DELETE FROM May WHERE MaMay = ?";
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,maMay);
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
