package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DanhSachSinhVienServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Gia su query duoi DB duoc danh sach sinh vien sau
        List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
        sinhVienList.add(new SinhVien("SV0001", "Nguyen Van A", 18));
        sinhVienList.add(new SinhVien("SV0002", "Nguyen Van A1", 19));
        sinhVienList.add(new SinhVien("SV0003", "Nguyen Van A2", 20));
        sinhVienList.add(new SinhVien("SV0004", "Nguyen Van A3", 21));
        sinhVienList.add(new SinhVien("SV0005", "Nguyen Van A4", 22));
        
        String userName = request.getParameter("username");
        
        Date sysdate = (Date) request.getAttribute("sysdate");
        
        String displayInfo = userName + " - " + String.valueOf(sysdate);
        
        //showSinhVienList(response, sinhVienList, displayInfo);

        
        request.setAttribute("listSinhVien", sinhVienList);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DanhSachSinhVien.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /*
    private void showSinhVienList(HttpServletResponse response, List<SinhVien> sinhVienList, String userName) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write("\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("<!DOCTYPE html>\r\n");
        out.write("<html>\t\r\n");
        out.write("<head>\r\n");
        out.write("<meta charset=\"ISO-8859-1\">\r\n");
        out.write("<title>Insert title here</title>\r\n");
        out.write("\r\n");
        out.write("<style>\r\n");
        out.write("table {\r\n");
        out.write("  font-family: arial, sans-serif;\r\n");
        out.write("  border-collapse: collapse;\r\n");
        out.write("  width: 100%;\r\n");
        out.write("}\r\n");
        out.write("\r\n");
        out.write("td, th {\r\n");
        out.write("  border: 1px solid #dddddd;\r\n");
        out.write("  text-align: left;\r\n");
        out.write("  padding: 8px;\r\n");
        out.write("}\r\n");
        out.write("\r\n");
        out.write("tr:nth-child(even) {\r\n");
        out.write("  background-color: #dddddd;\r\n");
        out.write("}\r\n");
        out.write("</style>\r\n");
        out.write("</head>\r\n");
        out.write("<body>\r\n");
        out.write("<h2>"+ userName + "</h2>\r\n");
        out.write("<h2>Danh sach sinh vien</h2>\r\n");
        out.write("<table>\r\n");
        out.write("  <tr>\r\n");
        out.write("    <th>Name</th>\r\n");
        out.write("    <th>Age</th>\r\n");
        out.write("    <th>Link</th>\r\n");
        out.write("  </tr>\r\n");
        out.write("  ");

        for (int i = 0; i < sinhVienList.size(); i++) {

            out.write("\r\n");
            out.write("  \t\t<tr>\r\n");
            out.write("\t\t    <td>");
            out.print(sinhVienList.get(i).getName());
            out.write("</td>\r\n");
            out.write("\t\t    <td>");
            out.print(sinhVienList.get(i).getAge());
            out.write("</td>\r\n");
            out.write("\t\t    <td> <a href=\"/ServletDemo/update_sinh_vien?svId=");
            out.print(sinhVienList.get(i).getSvId());
            out.write("\">Link</a> </td>\r\n");
            out.write("  \t\t</tr>\r\n");
            out.write("  ");

        }

        out.write("\r\n");
        out.write("  \r\n");
        out.write("</table>\r\n");
        out.write("</body>\r\n");
        out.write("</html>");
    }
    */
}
