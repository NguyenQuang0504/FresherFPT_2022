package pkg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.model.bean.UserBean;
import pkg.model.bo.LoginBO;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    UserBean user = new UserBean();
        user.setUserName("");
        user.setPassword("");
	    request.setAttribute("loginInfo", user);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserBean user = new UserBean();
		user.setUserName(userName);
		user.setPassword(password);
		
		LoginBO loginBo = new LoginBO();
		boolean isLoginSuccess = loginBo.checkLoginInfo(user);
		
		if (isLoginSuccess) {
		    //Set cookie
            Cookie cookieUserName = new Cookie("loginUserName", userName);
            Cookie cookiePassword = new Cookie("loginPassword", password);
            response.addCookie(cookieUserName);
            response.addCookie(cookiePassword);
            
            //Set session
            HttpSession session = request.getSession(true);
            session.setAttribute("loginUserName", userName);
            session.setAttribute("passwordUserName", password);
            //session.setAttribute("userInfo", user);
            //session.removeAttribute("userInfo");
            //session.invalidate();
            
            List<String> strList = new ArrayList<>();
            //Xu ly lay thong tin cho strList
            session.setAttribute("stringList", strList);
            
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/danh_sach_sinh_vien");
		} else {
		    request.setAttribute("loginMessage", "Dang nhap khong thanh cong");
		    request.setAttribute("loginInfo", user);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
		}
	}

}
