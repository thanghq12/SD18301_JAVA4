/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package gradleproject4;

import entity.HinhChuNhat;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hoangquangthang
 */
@WebServlet(name="HcnServlet", urlPatterns={"/hcn/list","/hcn/add"})
public class HcnServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HcnServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HcnServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
//        super.service(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        String uri = req.getRequestURI();
        // đây là nơi nhận tất cả 
        if (uri.contains("list")) {
         req.getRequestDispatcher("/views/addhcn.jsp").forward(req, resp);
        } else if(uri.contains("add")) {
        req.getRequestDispatcher("/views/hcn.jsp").forward(req, resp);
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        processRequest(request, response);
        String uri = request.getRequestURI(); // lấy được toàn bộ route
        if(uri.contains("list")) {
            request.getRequestDispatcher("/views/hcn.jsp").forward(request, response);
        } else if (uri.contains("add")) {
            request.getRequestDispatcher("/views/addhcn.jsp").forward(request, response);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//       processRequest(request, response);
        int chieudai = Integer.parseInt(request.getParameter("chieu_dai"));
        int chieurong =  Integer.parseInt(request.getParameter("chieu_rong"));
        //khởi tạo đối tượng hình chữ nhật 
        HinhChuNhat hcn = new HinhChuNhat(chieudai, chieurong);
        int option = Integer.parseInt(request.getParameter("chon"));
        switch(option) {
            case 1 : // tính chu vi 
                int chuvi = hcn.tinhChuVi();
                request.setAttribute("thongtin","Chu vi là" + chuvi );
                break;
            case 2 : // tính diện tích
                int dientich = hcn.tinhDienTich();
                request.setAttribute("thongtin","Diện tích là" + dientich );
                break;    
        }
        request.getRequestDispatcher("/views/hcn.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
