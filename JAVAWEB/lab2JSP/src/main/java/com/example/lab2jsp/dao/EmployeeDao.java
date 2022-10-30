package com.example.lab2jsp.dao;

import com.example.lab2jsp.entities.Employee;
import com.example.lab2jsp.utils.DBUtil;
import com.example.lab2jsp.utils.DateUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDao {
    public boolean addEmployee(Employee employee) throws ClassNotFoundException, IOException, SQLException {
        Connection connection = DBUtil.getConnection();
        CallableStatement callableStatement = connection.prepareCall("INSERT INTO Employee VALUES(?,?,?,?)");
        int param = 0;
        callableStatement.setString(++param, employee.getEmployeeName());
        callableStatement.setByte(++param, employee.getGender());
        callableStatement.setDate(++param, DateUtils.convertJavaDateToSqlDate(employee.getDateOfBirth()));
        callableStatement.setInt(++param, employee.getDepartmentId());
        int result = callableStatement.executeUpdate();
        DBUtil.closeConnection(connection);
        if (result > 0) {
            return true;
        }
        return false;
    }

    public List<Employee> findAllEmployee() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = DBUtil.getConnection();
        CallableStatement callableStatement = connection.prepareCall("SELECT * FROM Employee");
        ResultSet resultSet = callableStatement.executeQuery();
        List<Employee> listOfEmployee = new ArrayList<>();
        while (resultSet.next()) {
            int empId = resultSet.getInt(1);
            String empName = resultSet.getString(2);
            byte gender = resultSet.getByte(3);
            Date birthDate = resultSet.getDate(4);
            int deptId = resultSet.getInt(5);

            Employee employee = new Employee(empId, empName, gender, birthDate, deptId);
            listOfEmployee.add(employee);
        }
        DBUtil.closeConnection(connection);
        return listOfEmployee;
    }
    public Employee findEmployeeById(int id) throws SQLException {
        Connection connection = null;
        Employee employee = new Employee();
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employee WHERE employeeId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int empId = resultSet.getInt(1);
                String empName = resultSet.getString(2);
                byte gender = resultSet.getByte(3);
                Date birthDate = resultSet.getDate(4);
                int deptId = resultSet.getInt(5);
                employee.setEmployeeId(empId);
                employee.setEmployeeName(empName);
                employee.setGender(gender);
                employee.setDateOfBirth(birthDate);
                employee.setDepartmentId(deptId);
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
        return employee;
    }


    public int updateEmployee(Employee employee) throws SQLException {
        Connection connection = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Employee SET employeeName = ?, employeeGender = ? , employeeDateOfBirth = ?, departmentId = ? WHERE employeeId = ?");
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setByte(2, employee.getGender());
            preparedStatement.setDate(3, DateUtils.convertJavaDateToSqlDate(employee.getDateOfBirth()));
            preparedStatement.setInt(4, employee.getDepartmentId());
            preparedStatement.setInt(5, employee.getEmployeeId());
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
        return count;
    }

    public int deleteEmployee(Employee employee) throws SQLException {
        Connection connection = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement("DELETE FROM Employee WHERE employeeId = ?");
            preparedStatement.setInt(1, employee.getEmployeeId());
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return count;
    }
}
