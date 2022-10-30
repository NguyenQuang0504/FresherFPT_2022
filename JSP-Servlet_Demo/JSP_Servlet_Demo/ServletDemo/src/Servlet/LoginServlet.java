package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
		 dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Goi database kiem tra co ton tai username password khong
		if ("hieuvt8".equals(userName) && "hieuvt8".equals(password)) {
		    
		    //Set cookie
		    Cookie cookieUserName = new Cookie("loginUserName", userName);
		    Cookie cookiePassword = new Cookie("loginPassword", password);
		    response.addCookie(cookieUserName);
		    response.addCookie(cookiePassword);
		    
		    //Set session
		    HttpSession session = request.getSession(true);
		    session.setAttribute("loginUserName", userName);
		    
			String contextPath = request.getContextPath();
			System.out.println(contextPath);
			response.sendRedirect(contextPath + "/danh_sach_sinh_vien");
		} else {
			request.setAttribute("loginMessage", "Dang nhap khong thanh cong");
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
