package com.example.lab2jsp.dao;

import com.example.lab2jsp.entities.Department;
import com.example.lab2jsp.utils.DBUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* @author: QuangNV51
* @since: 16/10/2022 02:07
* @description: Class connect and get, set data
*/

public class DepartmentDao {

    public List<Department> findAllDepartment() throws ClassNotFoundException, IOException, SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement callableStatement = connection.prepareStatement("SELECT * FROM Department");
        ResultSet resultSet = callableStatement.executeQuery();
        List<Department> listOfDepartment = new ArrayList<>();
        while (resultSet.next()) {
            int deptId = resultSet.getInt("departmentId");
            String deptName = resultSet.getString("departmentName");
            Department department = new Department(deptId, deptName);
            listOfDepartment.add(department);
        }
        DBUtil.closeConnection(connection);
        return listOfDepartment;
    }
}
