<%-- 
    Document   : index
    Created on : 24-Jun-2022, 10:24:07 am
    Author     : Nayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banking Application</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="style.css">
        <style>
            body{
                height: 97.5vh;
                width: 95vw;
            }
        </style>
    </head>
    <body>
        <div><h2 id="success"></h2></div>
        <!-- Login/sign-up -->
        <section id="myforms">
            <div class="main">
                <input type="checkbox" id="chk" aria-hidden="true">

                <div class="signup">
                    <form action="signup.jsp" id="sign-up">
                        <label for="chk" aria-hidden="true">Sign up</label>
                        <input type="text" name="name" placeholder="User name" required="">
                        <input type="email" name="email" placeholder="Email" required="">
                        <input type="password" name="pass" placeholder="Password" required="">
                        <button id="sign_up">Sign up</button>
                    </form>
                </div>

                <div class="login">
                    <form action="login.jsp" id="log-in">
                        <label for="chk" aria-hidden="true">Login</label>
                        <input type="email" name="email" placeholder="Email" required="">
                        <input type="password" name="pass" placeholder="Password" required="">
                        <button id="log_in">Login</button>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>

