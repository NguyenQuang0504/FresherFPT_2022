package com.example.assignmentjwe101.controllers;

import com.example.assignmentjwe101.dao.ContentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteContentServlet extends HttpServlet {
    ContentDao contentDao = new ContentDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("action"));
        boolean check = contentDao.deleteContent(id);
        if (check){
            req.setAttribute("message", "Delete content success!!!");
            resp.sendRedirect("/viewContent");
        }else {
            req.setAttribute("message", "Delete content fail!!!");
            resp.sendRedirect("/viewContent");
        }
    }
}
