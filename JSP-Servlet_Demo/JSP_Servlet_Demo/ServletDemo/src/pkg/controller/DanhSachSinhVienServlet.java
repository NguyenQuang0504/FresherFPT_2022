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

import pkg.model.bean.SinhVien;
import pkg.model.bean.UserBean;
import pkg.model.bo.LoginBO;
import pkg.model.bo.SinhVienBO;

public class DanhSachSinhVienServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
	    //Validate login information
	    boolean isLogined = validateLogin(request, response);
	    if(!isLogined) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
	    }
	    
	    //Call BO de lay danh sach sinh vien
	    SinhVienBO svBo = new SinhVienBO();
	    List<SinhVien> sinhVienList = svBo.getAllSinhVien();
		
		request.setAttribute("listSinhVien", sinhVienList);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DanhSachSinhVien.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    validateLogin(request, response);
	}
	
	public boolean validateLogin (HttpServletRequest request, HttpServletResponse response) {
	    HttpSession currentSession = request.getSession(false);
	    String userName = (String)currentSession.getAttribute("loginUserName");
	    String password = "";
	    
	    List<String> strList = (List) currentSession.getAttribute("stringList");
	    
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
	                break;
	            }
	        }
	    }
	    
	    //Check login information get from cookie mapping Database
	    //Goi database de kiem tra thong tin login
	    UserBean user = new UserBean();
        user.setUserName(userName);
        user.setPassword(password);
        
	    LoginBO loginBo = new LoginBO();
        boolean isLoginSuccess = loginBo.checkLoginInfo(user);
        
        if (isLoginSuccess) {
            //Set session
            currentSession.setAttribute("loginUserName", userName);
            
            return true;
        }
	    
	    return false;
	}
}
