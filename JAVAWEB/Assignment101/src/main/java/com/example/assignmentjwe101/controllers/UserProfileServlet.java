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

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        req.setAttribute("userLogin", user.getUserName());
        User user1 = userDao.getUser(user);
        System.out.println(user1.toString());
        req.setAttribute("user", user1);
        req.getRequestDispatcher("/views/editProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        boolean check = false;
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        user.setDescription(req.getParameter("description"));
        user.setPhone(req.getParameter("phone"));
        user.setUpdateDate(String.valueOf(java.time.LocalDate.now()));
        check = userDao.updateUser(user);
        if (check){
            req.setAttribute("message", "Update user success!!!");
            resp.sendRedirect("/home");
        }else {
            req.setAttribute("message", "Update user fail!!!");
            resp.sendRedirect("/userProfile");
        }
    }
}
