<%-- 
    Document   : process
    Created on : 24-Jun-2022, 10:26:05 am
    Author     : Nayan
--%>

<%@page import="com.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.RegisterDao"%>
<%@page import="com.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="style.css">
        <style>
            body{
                height: 100vh;
                width: 100vw;
            }
            #showBal{
                font-size: 2rem;
                color: white;
                /*margin: 5rem 0 0 0;*/
                text-align: center;
            }
            a{
                text-decoration: none;
            }
            #transaction{
                margin: 3rem;
                color:white;
            }
            #transaction table{
                margin: 0 auto;
                width: -webkit-fill-available;
                text-align: center;
            }

            table, th, td{
                border:2px solid gray;
            }
        </style>
    </head>
    <body>
        <%
            // Getting parameters from home.jsp
            String button = request.getParameter("button");
            int bal = Integer.parseInt(request.getParameter("amount"));

            // Getting Session
            User u = (User) session.getAttribute("user");

            // For Transaction - switch
            switch (button) {
                
                // 1. Viewing balance
                case "view": {
        %> 
        <div id="showBal"> 
            <%  out.println("Dear " + u.getUname());
                out.println("<br>Your current Balance is:" + RegisterDao.viewBal(u.getEmail()));  %>
        </div>
        <%
                break;
            }
            // 2. Deposit Balance
            case "deposit": {
                // Checking whether the deposited amount is greater than 0 or not
                if (bal > 0) {
                    if (RegisterDao.deposit(u, bal)) {
        %>
        <!-- If deposit true-->
        <script>
            alert("Successfull Deposited!");
        </script>
        <%
            }
        } else {
        %>
        <!--If deposit false-->
        <script>
            alert("Deposit Unsuccessfull ! Please enter a valid amount");
        </script>
        <%
                }
                break;
            }
            // 3. Withdraw Balance
            case "withdraw": {
                // Checking whether the withdrawal_amount <= current_amount or not
                if (bal <= RegisterDao.viewBal(u.getEmail())) {
                    if (RegisterDao.withdraw(u, bal)) {
        %>
        <!--If Withdrawal true-->
        <script>
            alert("Successfull Withdraw !");
        </script>
        <%
            }
            break;
        } else {
        %>
        <!--If Withdrawal false-->
        <script>
            alert("Withdraw Unsuccessfull ! Please enter a valid amount");
        </script>
        <%
                    break;
                }
            }
            // 4. Show transaction
            case "trans": {
                ArrayList<Transaction> trans = RegisterDao.getTrans(u);
        %>
        <!--Table format-->
        <div id="transaction">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>Balance</th>
                        <th>Date-Time</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Transaction t : trans) {
                    %>
                    <tr>
                        <td> <%= t.getId()%> </td>
                        <td> <%= t.getUname()%> </td>
                        <td> <%= t.getAmount()%> </td>
                        <td> <%= t.getStatus()%> </td>
                        <td> <%= t.getBalance()%> </td>
                        <td> <%= t.getTime()%> </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <%
                break;
            }
            // Default in switch
            default: {
        %>
        <!--If all cases fails-->
        <script>
            alert("Transaction Unsuccessfull!");
        </script>
        <%
                    break;
                }
            }
        %>

        <!-- Navigation Button-->
        <div><a href="home.jsp"><button class="flex" type="submit">Back</button></a></div>
        <div><a href="index.jsp"><button class="flex" type="submit">Go to Home Page</button></a></div>

    </body>
</html>