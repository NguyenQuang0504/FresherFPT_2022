package com.example.jspservlet.controllers;

import com.example.jspservlet.dao.MachineDao;
import com.example.jspservlet.model.Machine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/machine")
public class MachineServlet extends HttpServlet {
    MachineDao machineDao = new MachineDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "list":
                showListMachine(req, resp);
                break;
            case "add":
                req.getRequestDispatcher("/WEB-INF/views/create_machine.jsp").forward(req, resp);
                break;
            case "delete":
                try {
                    if (deleteMachine(req.getParameter("id"))){
                        resp.sendRedirect("/machine?action=list");
                    }
                    break;
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
                Machine machine = new Machine();
                machine.setMaMay(req.getParameter("maMay"));
                machine.setTrangThai(req.getParameter("trangThai"));
                machine.setViTri(req.getParameter("viTri"));
                try {
                    if (saveMachine(machine)){
                        resp.sendRedirect("/machine?action=list");
                    }else {
                        req.setAttribute("message", "Create Fail!!!");
                        req.getRequestDispatcher("/WEB-INF/views/create_machine.jsp").forward(req, resp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void showListMachine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Machine> machineList = machineDao.getAllMachine();
            request.setAttribute("machines", machineList);
            request.getRequestDispatcher("/WEB-INF/views/list_machine.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveMachine(Machine machine) throws SQLException {
        if (machineDao.addMachine(machine)){
            return  true;
        }
        return false;
    }

    public boolean deleteMachine(String maMay) throws SQLException {
        if (machineDao.deleteService(maMay)){
            return  true;
        }
        return false;
    }
}
