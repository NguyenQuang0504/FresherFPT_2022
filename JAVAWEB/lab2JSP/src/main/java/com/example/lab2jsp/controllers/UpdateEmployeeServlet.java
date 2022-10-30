package com.example.lab2jsp.controllers;

import com.example.lab2jsp.dao.DepartmentDao;
import com.example.lab2jsp.dao.EmployeeDao;
import com.example.lab2jsp.entities.Department;
import com.example.lab2jsp.entities.Employee;
import com.example.lab2jsp.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
    EmployeeDao employeeDao = new EmployeeDao();
    DepartmentDao departmentDao = new DepartmentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("action"));
        Employee employee = new Employee();
        try {
           employee = employeeDao.findEmployeeById(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Department> departmentList = new ArrayList<>();
        try {
            departmentList = departmentDao.findAllDepartment();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("employee", employee);
        req.setAttribute("departments", departmentList);
        req.getRequestDispatcher("/views/update-employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int emptId = Integer.parseInt(req.getParameter("employeeId"));
        String emptName = req.getParameter("employeeName");
        byte gender = Byte.parseByte(req.getParameter("gender"));
        Date dateOfBirth = null;
        int deptId = Integer.parseInt(req.getParameter("deptId"));
        try {
            dateOfBirth = DateUtils.convertStringToDate(req.getParameter("dateOfBirth"));
        } catch (ParseException e) {
        }
        int count = 0;
        Employee employee = new Employee(emptId, emptName, gender, dateOfBirth, deptId);
        try {
           count = employeeDao.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count ==0){
            req.setAttribute("message", "Update fail!!!");
            req.getRequestDispatcher("/views/update-employee.jsp").forward(req, resp);
        }else {
            req.setAttribute("message", "Update success!!!");
            List<Employee> listOfEmployee = null;
            try {
                listOfEmployee = employeeDao.findAllEmployee();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            List<Department> listOfDepartment = null;
            try {
                listOfDepartment = departmentDao.findAllDepartment();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("listOfEmployee", listOfEmployee);
            req.setAttribute("listOfDepartment", listOfDepartment);
            req.getRequestDispatcher("/views/list-employees.jsp").forward(req, resp);
        }
    }
}
