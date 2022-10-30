package com.example.lab2jsp.controllers;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class handle request log out
 * 
 * @author FA
 *
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // remove session userLogin
        request.getSession().removeAttribute("userLogin");
        // redirect to /login
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
