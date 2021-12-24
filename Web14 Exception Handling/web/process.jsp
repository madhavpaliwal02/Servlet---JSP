<%-- 
    Document   : process
    Created on : 06-Dec-2021, 10:41:54 pm
    Author     : Nayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process</title>
    </head>
    <body>
        <!--<h1>Hello World!</h1>-->
        
        <%
            int a = Integer.parseInt(request.getParameter("num1"));
            int b = Integer.parseInt(request.getParameter("num2"));
            int div = a/b;
            
            out.println("Divide : " + div);
        %>
        
    </body>
</html>
