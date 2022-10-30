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
import java.util.List;

@WebServlet("/viewContent")
public class ViewContentServlet extends HttpServlet {
    ContentDao contentDao = new ContentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        req.setAttribute("userLogin", user.getUserName());
        List<Content> contentList = contentDao.getAllContent();
        if (contentList.size()>0){
            req.setAttribute("listContent", contentList);
            System.out.println(contentList.get(0).toString());
            req.getRequestDispatcher("/views/viewContent.jsp").forward(req, resp);
            resp.sendRedirect("/views/viewContent.jsp");
        }else {
            req.getRequestDispatcher("/views/viewContent.jsp").forward(req, resp);
            resp.sendRedirect("/views/viewContent.jsp");
        }
    }
}
