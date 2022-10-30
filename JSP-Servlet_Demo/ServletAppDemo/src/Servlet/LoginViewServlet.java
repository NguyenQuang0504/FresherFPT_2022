package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginViewServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //displayViewLogin(response, null);
        UserBean user = new UserBean();
        user.setUserName("");
        user.setPassword("");
        //request.setAttribute("loginInfo", user);
        //RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
        //dispatcher.forward(request, response);
        
        displayViewLogin(response, null);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Kiem tra thong tin login
        // Co the goi 1 phuong thuc khac de query duoi database va lay thong tin nguoi
        // dung
        if ("hieuvt8".equals(userName) && "hieuvt8".equals(password)) {
            response.sendRedirect("/ServletAppDemo/danh_sach_sinh_vien");
            /*
            request.setAttribute("sysdate", new Date());
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/danh_sach_sinh_vien");
            dispatcher.forward(request, response);
            */
        } else {
            
            UserBean user = new UserBean();
            user.setUserName(userName);
            user.setPassword(password);
            request.setAttribute("loginInfo", user);
            
            String message = "Thong tin dang nhap chua dung";
            request.setAttribute("loginMessage", message);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            //displayViewLogin(response, message);
        }
    }

    
    private void displayViewLogin(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write("\r\n");
        out.write("\r\n");
        out.write("<!DOCTYPE html>\r\n");
        out.write("<html>\r\n");
        out.write("<head>\r\n");
        out.write("<meta charset=\"ISO-8859-1\">\r\n");
        out.write("<title>Insert title here</title>\r\n");
        out.write("</head>\r\n");
        out.write("<body>\r\n");
        out.write("<h2>Login</h2>\r\n");

        out.write("\r\n");
        out.write("<form action=\"/ServletAppDemo/login\" method=\"post\">\r\n");
        out.write("  <div class=\"container\">\r\n");
        out.write("    <label for=\"username\"><b>Username</b></label>\r\n");
        out.write("    <input type=\"text\" placeholder=\"Enter Username\" name=\"username\" required value=\"");
        out.write("\">\r\n");
        out.write("\r\n");
        out.write("    <label for=\"username\"><b>Password</b></label>\r\n");
        out.write("    <input type=\"password\" placeholder=\"Enter Password\" name=\"password\" required  value=\"");
        out.write("\">\r\n");
        out.write("    \r\n");
        out.write("    ");

        if (message != null && !"".equals(message)) {

            out.write("\r\n");
            out.write("    \t<label>");
            out.print(message);
            out.write("</label>\r\n");
            out.write("    ");

        }

        out.write("\r\n");
        out.write("    \r\n");
        out.write("    \r\n");
        out.write("\r\n");
        out.write("    <button type=\"submit\">Login</button>\r\n");
        out.write("  </div>\r\n");
        out.write("</form>\r\n");
        out.write("</body>\r\n");
        out.write("</html>");
    }
    

}
