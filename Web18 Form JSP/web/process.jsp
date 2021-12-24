<%@page import="bean.RegisterDao" %>
<jsp:useBean id="obj" class="bean.User" />

<jsp:setProperty property="*" name="obj" />


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
            int status = RegisterDao.register(obj);
            if (status > 0)
                out.println("You are Successfully registered...");
        %>

    </body>
</html>
