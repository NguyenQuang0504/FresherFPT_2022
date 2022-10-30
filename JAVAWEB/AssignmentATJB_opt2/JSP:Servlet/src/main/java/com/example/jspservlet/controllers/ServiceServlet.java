package com.example.jspservlet.controllers;

import com.example.jspservlet.dao.ServiceDao;
import com.example.jspservlet.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/service")
public class ServiceServlet extends HttpServlet {
    ServiceDao serviceDao = new ServiceDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "add":
                Service service = new Service();
                service.setMaDV(req.getParameter("maDV"));
                service.setTenDV(req.getParameter("tenDV"));
                service.setDonVi(req.getParameter("donViTinh"));
                service.setDonGia(Integer.valueOf(req.getParameter("donGia")));
                if (saveService(service)){
                    resp.sendRedirect("/service?action=list");
                }else {
                    req.setAttribute("message", "Create Fail!!!");
                    addService(req, resp);
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "list":
                showListService(req, resp);
                break;
            case "add":
                addService(req, resp);
                break;
            case "delete":
                String id = req.getParameter("id");
                try {
                    if (serviceDao.deleteService(id)){
                        resp.sendRedirect("/service?action=list");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void showListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Service> serviceList = serviceDao.getAllService();
            request.setAttribute("services", serviceList);
            request.getRequestDispatcher("/WEB-INF/views/list_service.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/create_service.jsp").forward(request,response);
    }

    public boolean saveService(Service service){
        boolean check = false;
        try {
            if (serviceDao.addService(service)){
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
