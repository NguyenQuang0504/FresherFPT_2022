package com.example.assignmentjwe101.controllers;

import com.example.assignmentjwe101.dao.ContentDao;
import com.example.assignmentjwe101.entities.Content;
import com.example.assignmentjwe101.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/formContent")
public class CreateContentServlet extends HttpServlet {
    ContentDao contentDao = new ContentDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        req.setAttribute("userLogin", user.getUserName());
        req.getRequestDispatcher("/views/addContent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Content content = new Content();
        content.setTitle(req.getParameter("title"));
        content.setContent(req.getParameter("content"));
        content.setBrief(req.getParameter("brief"));
        content.setCreateDate(String.valueOf(java.time.LocalDate.now()));
        boolean check = contentDao.createContent(content);
        if (check){
            req.setAttribute("message", "Create content success!!!");
            resp.sendRedirect("/viewContent");
        }else {
            req.setAttribute("message", "Create content fail!!!");
            resp.sendRedirect("/formContent");
        }
    }
}
