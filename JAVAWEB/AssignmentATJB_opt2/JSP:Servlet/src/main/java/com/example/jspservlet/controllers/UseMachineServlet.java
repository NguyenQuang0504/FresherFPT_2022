package com.example.jspservlet.controllers;

import com.example.jspservlet.dao.CustomerDao;
import com.example.jspservlet.dao.MachineDao;
import com.example.jspservlet.dao.UseMachineDao;
import com.example.jspservlet.model.UseMachine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/useMachine")
public class UseMachineServlet extends HttpServlet {
    private CustomerDao customerDao = new CustomerDao();
    private MachineDao machineDao = new MachineDao();
    private UseMachineDao useMachineDao = new UseMachineDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "add":
                try {
                    req.setAttribute("machines", machineDao.getAllMachine());
                    req.setAttribute("customers", customerDao.getAllCustomer());
                    req.getRequestDispatcher("/WEB-INF/views/use_machine.jsp").forward(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "add":
                UseMachine useMachine = new UseMachine();
                useMachine.setMaKH(req.getParameter("maKH"));
                useMachine.setMaMay(req.getParameter("maMay"));
                useMachine.setNgayBD(req.getParameter("ngayBD"));
                useMachine.setGioBD(req.getParameter("gioBD"));
                useMachine.setThoigianSD(Integer.valueOf(req.getParameter("thoiGianSD")));
                if (useMachineDao.saveUseMachine(useMachine)){
                    resp.sendRedirect("/");
                }else {
                    resp.sendRedirect("/useMachine?action=add");
                }
        }
    }
}
