<%-- 
    Document   : login
    Created on : 24-Jun-2022, 10:25:32 am
    Author     : Nayan
--%>

<%@page import="com.User"%>
<%@page import="com.RegisterDao"%>

<!DOCTYPE html>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="style.css">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                height: 96.8vh;
                width: 90vw;
            }
            a{
                text-decoration: none;
            }
        </style>
    </head>

    <body>
        <div><a href="index.jsp"><button class="flex" type="submit">Go to Home Page</button></a></div>
        <%
            response.setContentType("text/html");

            // Fetching values from form (index.jsp)
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");

            // Validating the user
            if (RegisterDao.validate(email, pass)) {
                // If matches then

                // Creating new Session
                User u = new User(email, pass);
                u.setUname((RegisterDao.getUser(email, pass)).getUname());

                session.setAttribute("user", u);
                response.sendRedirect("home.jsp");
        } else {
            // If not matches
        %>
        <script>
            alert("Login Unsuccessfull ! Invalid Credentials");
        </script>
        <%
            }
        %>

    </body>
</html>


