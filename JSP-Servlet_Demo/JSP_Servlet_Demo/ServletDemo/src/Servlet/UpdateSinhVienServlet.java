package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateSinhVienServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     String svId = request.getParameter("svId");
	     if (svId == null || "".equals(svId)) {
	         throw new RuntimeException();
	     }
	     
		 //Xu ly database
	     //O day khong dung database, ma chi tao data dummy
	     String name = "Sinh Vien Name";
	     int age = 0;
		 
		 SinhVien sv = new SinhVien(svId, name, age);
		 
		 request.setAttribute("sinhvien", sv);
		 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/update.jsp");
		 dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    String svId = request.getParameter("svId");
        if (svId == null || "".equals(svId)) {
            throw new DataInvalidException("Id khong hop le");
        }
        
        //Xu ly update sinh vien vao database
        
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/danh_sach_sinh_vien");
	}

}
