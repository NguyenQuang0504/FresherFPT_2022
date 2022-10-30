package com.example.assignmentjwe101.controllers;

import com.example.assignmentjwe101.dao.UserDao;
import com.example.assignmentjwe101.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        boolean check = false;
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        user.setStartDate(String.valueOf(java.time.LocalDate.now()));
        check = userDao.createUser(user);
        if (check) {
            req.setAttribute("messageRegister", "Register success!!!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Register fail!!!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}
