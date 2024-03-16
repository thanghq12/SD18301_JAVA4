<%-- 
    Document   : hcn
    Created on : Mar 12, 2024, 1:28:38 PM
    Author     : hoangquangthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hhhihihihiihi!</h1>
        <form action="/gradleproject4/hcn" method="POST">
            Chiều dài <input type="text" name="chieu_dai" />
            Chiều rộng <input type="text" name="chieu_rong" />
            Chọn <select name="chon">
                <option value="1"> Chu vi</option>
                <option value="2">Diện tích</option>
                
            </select>
            <h2>Thông tin  ${thongtin}</h2>
            <button>Tính</button>
        </form>
    </body>
</html>
