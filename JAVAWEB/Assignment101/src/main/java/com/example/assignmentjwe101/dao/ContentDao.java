package com.example.assignmentjwe101.dao;

import com.example.assignmentjwe101.entities.Content;
import com.example.assignmentjwe101.utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContentDao {

    public List<Content> getAllContent(){
        String SQL = "SElECT * FROM Content";
        Connection connection = null;
        List<Content> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Content content =  new Content();
                content.setId(resultSet.getInt("id"));
                content.setTitle(resultSet.getString("title"));
                content.setContent(resultSet.getString("content"));
                content.setBrief(resultSet.getString("brief"));
                content.setCreateDate(resultSet.getString("createDate"));
                content.setUpdateDate(resultSet.getString("updateDate"));
                list.add(content);
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
        return list;
    }

    public boolean deleteContent(int id){
        Connection connection = null;
        String SQL = "DELETE FROM Content WHERE id = ?";
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
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
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean createContent(Content content){
        Connection connection = null;
        String SQL = "INSERT INTO Content(title, brief, content, createDate) VALUES(?,?,?,?)";
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, content.getTitle());
            preparedStatement.setString(2, content.getBrief());
            preparedStatement.setString(3, content.getContent());
            preparedStatement.setString(4, content.getCreateDate());
            count = preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
            if (count > 0) {
                return  true;
            }else {
                return  false;
            }
        }
    }

    public List<Content> search(String search){
        String SQL = "SELECT * FROM Content WHERE content LIKE ? ";
        Connection connection = null;
        List<Content> contentList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, '%' +search +'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Content content = new Content();
                content.setId(resultSet.getInt("id"));
                content.setTitle(resultSet.getString("title"));
                content.setContent(resultSet.getString("content"));
                content.setBrief(resultSet.getString("brief"));
                content.setCreateDate(resultSet.getString("createDate"));
                content.setUpdateDate(resultSet.getString("updateDate"));
                contentList.add(content);
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
        return contentList;
    }
}
