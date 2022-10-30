package examp.lab1jsp.servlet;

import examp.lab1jsp.dao.UserDao;
import examp.lab1jsp.entities.User;
import examp.lab1jsp.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // Get data from the request using request.getParameter()
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        // Set data for the user
        User user = new User(firstName, lastName, email, userName, password);
        try {
            UserDao userDao = new UserDao();
            // Call registerUser() method to insert user into DB
            if (userDao.registerUser(user)) {
                // 	Send a attribute name as "userRegister"
//                to register-user-process.jsp page
                request.setAttribute("userRegister", user);
                // Forward to register-user-process.jsp page
                request.getRequestDispatcher("/view/login.jsp").
                        forward(request, response);
            } else {
                // send a attribute name as "message" to register-user.jsp page
                request.setAttribute("message", Constants.REGISTER_FAIL_MESSAGE);
                // forward to register-user.jsp page
                request.getRequestDispatcher("/view/register-user.jsp").
                        forward(request, response);
            }

        } catch (ClassNotFoundException | SQLException e) {
            // log error if exception occurs

        }
    }
}
