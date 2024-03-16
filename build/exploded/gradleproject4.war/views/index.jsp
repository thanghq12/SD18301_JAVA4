<%-- 
    Document   : index
    Created on : Mar 9, 2024, 12:39:42 PM
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
        <h1>Lêu lêu ${name} !</h1>
        <form action="/gradleproject4/NewServlet" method="POST">
            <input name="email" />
            <button>Submit</button>
        </form>
    </body>
</html>
