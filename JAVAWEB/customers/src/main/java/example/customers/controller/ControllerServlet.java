package example.customers.controller;

import example.customers.dao.CustomerDao;
import example.customers.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "/customer")
public class ControllerServlet extends HttpServlet {

    CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create": {
                createPage(req, resp);
                break;
            }
            case "update":
                System.out.println("Update");
                break;
            case "findById":
                System.out.println("FindById");
                break;
            default:
                System.out.println("Default");
                homePage(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    submitPage(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Default");
        }
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerDao.getAllCustomer();
        request.setAttribute("listCustomer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/home.jsp");
        dispatcher.forward(request, response);
    }
    private void createPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/create.jsp");
        dispatcher.forward(request, response);
    }

    private void submitPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Customer customer = new Customer();
        customer.setCustomerName(request.getParameter("name"));
        customer.setCustomerBirthDay(request.getParameter("date"));
        customer.setCustomerEmail(request.getParameter("email"));
        boolean check = false;
        check = customerDao.addCustomer(customer);
        if (check){
            request.setAttribute("message", "Thêm mới thành công !!!");
        }
        List<Customer> customerList = customerDao.getAllCustomer();
        request.setAttribute("listCustomer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/home.jsp");
        dispatcher.forward(request, response);
    }
}
