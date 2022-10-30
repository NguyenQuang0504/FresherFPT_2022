package com.example.assignmentjwe101.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter
public class LoginFilter implements Filter {
    List<String> listUrlPass;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        listUrlPass = new ArrayList<>();
        listUrlPass.add(new String("/"));
        listUrlPass.add(new String("/login"));
        listUrlPass.add(new String("/register"));
        listUrlPass.add(new String(".css"));
        listUrlPass.add(new String(".js"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        boolean check  = session != null && session.getAttribute("user") != null;
        String url = httpServletRequest.getRequestURI();
        if (check || checkRequest(url)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            httpServletRequest.setAttribute("loginFail", "Login Fail");
            httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);
        }
    }

    public boolean checkRequest(String request){
        for (String requestCheck: listUrlPass){
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
