package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Form extends HttpServlet{
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        
        PrintWriter out = res.getWriter();
        out.println("This is my Form");
        
        String name = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String email = req.getParameter("user_email");
        String gender = req.getParameter("user_gender");
        String course = req.getParameter("user_course");
        String cond = req.getParameter("condition");
//        out.println(cond);
   
        
        if(cond !=null){
           if(cond.equals("checked")) {
            out.println("<h2>Name : " + name + "</h2>");
            out.println("<h2>Password : " + password + "</h2>");
            out.println("<h2>E-mail : " + email + "</h2>");
            out.println("<h2>Gender : " + gender + "</h2>");
            out.println("<h2>Course : " + course + "</h2>");
            
         
            // JDBC Connector
        try{
            // Loading the Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Connection Establish
            String url = "jdbc:mysql://localhost/db1";
            Connection con = DriverManager.getConnection(url, "root", "123456");
            
            // Preparing statement / query
            String q = "insert into t2 values (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, gender);
            pstmt.setString(5, course);
            
            // Execute query
            pstmt.executeUpdate();
            out.println("Stored in the Database....");
            
            RequestDispatcher rd = req.getRequestDispatcher("success");
            rd.forward(req, res);
            
            // Disconnect
            con.close();
        } catch(Exception e){ e.printStackTrace(); }
          } else{
            out.println("You have not accepted the terms and condition");
          }
        } else{
            out.println("You have not accepted the terms and condition");
            
            // Including the index.html
            
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, res);
        }
        
    }
}
