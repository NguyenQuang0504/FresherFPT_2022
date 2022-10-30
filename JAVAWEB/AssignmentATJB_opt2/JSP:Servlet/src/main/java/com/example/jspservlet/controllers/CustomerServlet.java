package com.example.jspservlet.controllers;


import com.example.jspservlet.dao.CustomerDao;
import com.example.jspservlet.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerDao customerDao = new CustomerDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = "";
        action = req.getParameter("action");
        switch (action){
            case "add":
                addCustomer(req, resp);
                break;
            case "list":
                showListCustomer(req, resp);
                break;
            case "delete":
                if (deleteCustomer(req.getParameter("id"))){
                    resp.sendRedirect("/customer?action=list");
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = "";
        action = req.getParameter("action");
        switch (action){
            case "add":
                Customer customer = new Customer();
                customer.setMaKH(req.getParameter("maKH"));
                customer.setTenKH(req.getParameter("tenKH"));
                customer.setDiaChi(req.getParameter("diaChi"));
                customer.setEmail(req.getParameter("email"));
                customer.setSdt(req.getParameter("sdt"));
                if (saveCustomer(customer)){
                    resp.sendRedirect("/customer?action=list");
                }else {
                    req.setAttribute("message", "Create Fail!!!");
                    req.getRequestDispatcher("/WEB-INF/views/create_customer.jsp").forward(req, resp);
                }
                break;
        }
    }

    public void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerDao.getAllCustomer();
        request.setAttribute("customers", customerList);
        request.getRequestDispatcher("/WEB-INF/views/list_customer.jsp").forward(request, response);
    }

    public void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/create_customer.jsp").forward(request, response);
    }
    public boolean saveCustomer(Customer customer){
        boolean check = false;
        if (customerDao.addCustomer(customer)){
            return true;
        }
        return false;
    }
    public boolean deleteCustomer(String maKH){
        if (customerDao.deleteCustomer(maKH)){
            return true;
        }return false;
    }
}
