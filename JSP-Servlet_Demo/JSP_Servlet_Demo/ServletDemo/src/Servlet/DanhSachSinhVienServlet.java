package Servlet;

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

public class DanhSachSinhVienServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
	    //Validate login information
	    boolean isLogined = validateLogin(request);
	    if(!isLogined) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
	    }
	    
	    
		List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
		sinhVienList.add(new SinhVien("SV0001", "Nguyen Van A", 18));
		sinhVienList.add(new SinhVien("SV0002", "Nguyen Van A1", 19));
		sinhVienList.add(new SinhVien("SV0003", "Nguyen Van A2", 20));
		sinhVienList.add(new SinhVien("SV0004", "Nguyen Van A3", 21));
		sinhVienList.add(new SinhVien("SV0005", "Nguyen Van A4", 22));
		
		request.setAttribute("listSinhVien", sinhVienList);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DanhSachSinhVien.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	public boolean validateLogin (HttpServletRequest request) {
	    HttpSession currentSession = request.getSession(false);
	    String userName = (String)currentSession.getAttribute("loginUserName");
	    String password = "";
	    
	    //Check exist session
	    if (userName != null && !"".equals(userName) ) {
	        return true;
	    }
	    
	    //Get exist cookie
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (int i = 0; i < cookies.length; i++) {
	            Cookie cookie= cookies[i];
	            if ("loginUserName".equals(cookie.getName())) {
	                userName = cookie.getValue();
	            }
	            if ("loginPassword".equals(cookie.getName())) {
	                password = cookie.getValue();
                }
	            
	            //Break loop khi da lay duoc cookie can thiet
	            if (userName != null && !"".equals(userName)
	                    && password != null && !"".equals(password)) {
	                return true;
	            }
	        }
	    }
	    
	    //Check login information get from cookie mapping Database
	    //Goi database de kiem tra thong tin login 
	    if ("hieuvt8".equals(userName) && "hieuvt8".equals(password)) {
            
            //Set session again
	        currentSession.setAttribute("loginUserName", userName);
            
            return true;
        }
	    
	    return false;
	}
}
