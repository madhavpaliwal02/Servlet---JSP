<%-- 
    Document   : home
    Created on : 24-Jun-2022, 10:25:00 am
    Author     : Nayan
--%>

<%@page import="com.RegisterDao"%>
<%@page import="com.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    response.setContentType("text/html");
    // Getting the session
    User u = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="style.css">
        <style>
            body{
                height: 94.8vh;
            }
            a{
                text-decoration: none;
            }
            #head{
                margin: 2rem 0 4rem 0;
                flex-direction: column;
            }
            .heading{
                color:white;
            }
            .section{
                align-items: center;
            }
            .cont input{
                text-align: center;
            }
        </style>
    </head>

    <body>

        <div  id="homePage" class="container-fluid" >
            <div class="flex" id="head">
                <h1 class="heading">Hello ! <b><%= u.getUname()%></b> </h1>
                <h2 class="heading">Welcome To The Dashboard</h2>

            </div>

            <div class="section">
                <form action="process.jsp" >

                    <div class="cont">
                        <button name="button" value="view" type="submit" >View Balance</button>
                    </div>

                    <div class="cont">
                        <input type="number" name="amount" value="0">
                    </div>

                    <div class="cont">
                        <button name="button" value="deposit" type="submit">Deposit Balance</button>
                    </div>

                    <div class="cont">
                        <button name="button" value="withdraw" type="submit">Withdraw Balance</button>
                    </div>
                    
                    <div class="cont">
                        <button name="button" value="trans" type="submit">Show Transaction</button>
                    </div>

                </form>
                <div class="cont">
                    <a href="index.jsp"><button name="button" type="submit">Logout</button></a>
                </div>
            </div>
        </div>
    </body>

</html>
