<%-- 
    Document   : welcome
    Created on : 06-Dec-2021, 3:12:23 pm
    Author     : Nayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <!--Scriptlet tag-->
        <%
            String name = request.getParameter("name");
            out.println("Welcome   " + name );
        %>
    </body>
</html>
