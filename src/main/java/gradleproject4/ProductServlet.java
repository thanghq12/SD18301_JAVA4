/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package gradleproject4;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangquangthang
 */
@WebServlet(name="ProductServlet", urlPatterns={"/ProductServlet"})
public class ProductServlet extends HttpServlet {
    // khởi tạo List
    public List<Product> dataList = new ArrayList<>();
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // viết hàm khởi tạo 
    
    @Override
    public void init()
    throws ServletException {
//        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        // Khởi tạo sản phẩm 
        Product p1 = new Product(1, "Mạnh", 2000);
        dataList.add(p1);
         Product p2 = new Product(2, "ABC", 3000);
         dataList.add(p2);
         // fake data cho list 
    } 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath () + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
      request.setAttribute("dataList", dataList);
      if(request.getParameter("id") != null ) {
          //
          int id = Integer.parseInt(request.getParameter("id"));
          // lấy theo ví đối tượng trong list
          String name = dataList.get(id - 1).getName();
          int price = dataList.get(id - 1).getPrice();
           request.setAttribute("name", name);
       request.setAttribute("price",price);
        request.getRequestDispatcher("/views/product.jsp").forward(request, response); 
      }
      request.setAttribute("name", "");
       request.setAttribute("price", "");
      request.getRequestDispatcher("/views/product.jsp").forward(request, response); 
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
//        processRequest(request, response);
           //action trong khu vực post
           String name = request.getParameter("name");
           int price = Integer.parseInt(request.getParameter("price"));
           //khi ấn vào nút thêm tạo ra 1 đối tượng product nhét vào list
           int i = 3 ; // id tăng tự động 
           Product  product = new Product(i,name,price);
           dataList.add(product);
           // nhảy về màn hình GET  (load lại trang )
           response.sendRedirect("/gradleproject4/ProductServlet");
           
                  
          
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
