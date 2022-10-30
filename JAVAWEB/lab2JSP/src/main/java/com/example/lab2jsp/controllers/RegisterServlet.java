package com.example.lab2jsp.controllers;
import com.example.lab2jsp.dao.UserDao;
import com.example.lab2jsp.entities.User;
import com.example.lab2jsp.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register", description = "This is RegisterServlet")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static UserDao userDao = new UserDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get data from input with request.getParameter()
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// set data for user
		User user = new User(firstName, lastName, email, userName, password);
		// call method registerUser to insert user into DB
		try {
			if (userDao.registerUser(user)) {
				// send a attribute name as "userRegister" to register-user-process.jsp page
				request.setAttribute("userRegister", user);
				//forward to register-user-process.jsp page
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			} else {
				// send a attribute name as "message" to register-user.jsp page
				request.setAttribute("message", Constants.REGISTER_FAIL_MESSAGE);
				//forward to register-user.jsp page
				request.getRequestDispatcher("/views/register-user.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("views/register-user.jsp").forward(request, response);
  }
	
}
