package com.example.lab2jsp.controllers;

import com.example.lab2jsp.dao.EmployeeDao;
import com.example.lab2jsp.entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet {
    EmployeeDao employeeDao = new EmployeeDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int action = Integer.parseInt(req.getParameter("action"));
        Employee employee = new Employee();
        int count = 0;
        try {
            employee = employeeDao.findEmployeeById(action);
            count = employeeDao.deleteEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count != 0){
            req.setAttribute("message", "Delete success: " +employee.getEmployeeName());
            req.getRequestDispatcher("/list-employees").forward(req, resp);
        }
        else {
            req.setAttribute("message", "Delete fail:  " +employee.getEmployeeName());
            req.getRequestDispatcher("/list-employees").forward(req, resp);
        }
    }
}
