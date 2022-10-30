package com.example.assignmentjwe101.controllers;

import com.example.assignmentjwe101.dao.UserDao;
import com.example.assignmentjwe101.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        boolean check;
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        check = userDao.login(user);
        if (check){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/home");
        }else {
            req.setAttribute("loginFail", "LoginFail");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
