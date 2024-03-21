<%@page import="java.util.List" %>
<%@page import="entity.Product" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Đây là view product</h1>
        <form action="/gradleproject4/ProductServlet" method="POST">
            <input type="text" name="name" value="${name}"/> </br>
            <input type="text" name="price" value="${price}"/> </br>
            <button>Thêm</button>
        </form>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Name</td>
                 <td>Price</td>
                  <td>Action</td>
            </tr>
            <% 
                for(Product product : (List<Product>) request.getAttribute("dataList")) {
            %>
             <tr>
                 <td><%= product.getId() %></td>
                <td><%= product.getName() %></td>
                 <td><%= product.getPrice() %></td>
                 <td><a href="/gradleproject4/ProductServlet?id=<%= product.getId() %>">Sửa</a></td>
            </tr>
            <% 
                }
            %>
        </table>
    </body>
</html>
