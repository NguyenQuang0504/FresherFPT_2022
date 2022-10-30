package com.example.jspservlet.controllers;

import com.example.jspservlet.dao.CustomerDao;
import com.example.jspservlet.dao.ServiceDao;
import com.example.jspservlet.dao.UseServiceDao;
import com.example.jspservlet.model.UseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/useService")
public class UseServiceServlet extends HttpServlet {
    private UseServiceDao  useServiceDao = new UseServiceDao();
    private CustomerDao customerDao = new CustomerDao();
    private ServiceDao serviceDao = new ServiceDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "add":
                System.out.println("Add");
                req.setAttribute("customers", customerDao.getAllCustomer());
                try {
                    req.setAttribute("services", serviceDao.getAllService());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                req.getRequestDispatcher("/WEB-INF/views/use_service.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "add":
                System.out.println("Add");
                UseService useService = new UseService();
                useService.setMaKH(req.getParameter("maKH"));
                useService.setMaDV(req.getParameter("maDV"));
                useService.setNgaySD(req.getParameter("ngaySD"));
                useService.setGioSD(req.getParameter("gioSD"));
                useService.setSoLuong(Integer.valueOf(req.getParameter("soLuong")));
                if (saveUseService(useService)){
                    resp.sendRedirect("/");
                }else {
                    resp.sendRedirect("/useService?action=add");
                }
                break;
        }
    }

    private boolean saveUseService(UseService useService){
        if (useServiceDao.saveUseService(useService)){
            return true;
        }else {
            return false;
        }
    }
}
