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
import java.util.Date;
import java.util.List;

/**
 * class handle add employee
 * 
 * @author nduong
 *
 */
@WebServlet("/add-emp")
public class AddEmployeeServlet extends HttpServlet {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;

    private DepartmentDao departmentDao = new DepartmentDao();
    private EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get all of departments from DB and display on selected-box in
            // add-employee.jsp page
            List<Department> listOfDepartment = departmentDao.findAllDepartment();
            request.setAttribute("listOfDepartment", listOfDepartment);

            // This method doGet(): trả về response là trang add-employee.jsp cho ajax để
            // hiển
            // thị trên trang home-page
            request.getRequestDispatcher("/views/add-employee.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int deptId = Integer.parseInt(request.getParameter("deptId"));
        String employeeName = request.getParameter("employeeName");
        byte gender = Byte.parseByte(request.getParameter("gender"));
        Date dateOfBirth = null;
        try {
            dateOfBirth = DateUtils.convertStringToDate(request.getParameter("dateOfBirth"));
        } catch (ParseException e) {
        }

        Employee employee = new Employee(employeeName, gender, dateOfBirth, deptId);
        try {
            employeeDao.addEmployee(employee);
            List<Employee> employeeList = employeeDao.findAllEmployee();
            List<Department> departmentList = departmentDao.findAllDepartment();
            request.setAttribute("listOfDepartment", departmentList);
            request.setAttribute("listOfEmployee", employeeList);
            request.setAttribute("message", "Add new employee successfully");

            //When click button add Employee redirect from list-employees page
            request.getRequestDispatcher("/views/list-employees.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

}
