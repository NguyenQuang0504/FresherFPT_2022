package com.example.assignmentjwe101.dao;

import com.example.assignmentjwe101.entities.User;
import com.example.assignmentjwe101.utils.DBUtil;

import java.io.IOException;
import java.sql.*;

public class UserDao {

    public boolean createUser(User user) {
        String SQL = "INSERT INTO [User](userName, email, [password], createDate ) VALUES(?,?,?,?)";
        Connection connection = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getStartDate());
            count = preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
            if (count>0){
                return  true;
            }else {
                return false;
            }
        }
    }

    public boolean login(User user){
        String SQL = "SELECT * FROM [User] WHERE userName = ? AND password = ?";
        Connection connection  = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                count = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (count >0){
                return  true;
            }else {
                return  false;
            }
        }
    }

    public User getUser(User user){
        String SQL = "SELECT * FROM [User] WHERE userName = ? AND password = ?";
        Connection connection  = null;
        User user1 = new User();
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user1.setId(resultSet.getInt("id"));
                user1.setUserName(resultSet.getString("userName"));
                user1.setFirstName(resultSet.getString("firstName"));
                user1.setLastName(resultSet.getString("lastName"));
                user1.setEmail(resultSet.getString("email"));
                user1.setPassword(resultSet.getString("password"));
                user1.setDescription(resultSet.getString("description"));
                user1.setPhone(resultSet.getString("phone"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
            return user1;
        }
    }

    public boolean updateUser(User user){
        String SQL = "UPDATE [User] SET firstName = ?, lastName = ?, email = ?, phone = ?, description = ?, updateDate = ? WHERE id = ? ";
        Connection connection = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getDescription());
            preparedStatement.setString(6, user.getUpdateDate());
            preparedStatement.setInt(7, user.getId());
            count = preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
            if (count > 0){
                return  true;
            }
            else {
                return  false;
            }
        }
    }
}
