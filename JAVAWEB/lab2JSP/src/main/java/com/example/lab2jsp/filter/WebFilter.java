package com.example.lab2jsp.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* @author: QuangNV51
* @since: 16/10/2022 02:06
* @description: Class authentication use Filter
*/
@javax.servlet.annotation.WebFilter("/*")
public class WebFilter implements Filter {
    private List<String> urlPass;

    // list url always pass
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urlPass = new ArrayList<>();
        urlPass.add(new String("/login"));
        urlPass.add(new String("/"));
        urlPass.add( new String("/register"));
        urlPass.add(new String(".css"));
        urlPass.add(new String(".js"));
    }

    // method check url if have request
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        boolean checkSession = session != null && session.getAttribute("userLogin") != null;
        String requestCheck = request.getRequestURI();
        if (checkSession || checkRequest(requestCheck)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            request.setAttribute("message", "Ban can phai login!!!");
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }

    // method check request 
    public boolean checkRequest(String request){
        for (String requestCheck: urlPass){
            if (request.endsWith(requestCheck)){
                return  true;
            }
        }
        return  false;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
