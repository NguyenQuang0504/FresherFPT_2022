package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
		 dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    String svId = request.getParameter("svId");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("Name: " + name + " - Age: " + age);
		
		response.sendRedirect("/ServletDemo" + "/danh_sach_sinh_vien");
	}

}
