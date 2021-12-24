package com.librarian;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sql.*;
import javax.servlet.RequestDispatcher;

public class addStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            
            // Fetching values from form
            String name = request.getParameter("sname");
            String email = request.getParameter("semail");
            String pass = request.getParameter("spass");
            String rollno = request.getParameter("srollno");
            String course = request.getParameter("scourse");
            
            // Creating student object and passing it as argument
            Student stu = new Student();
            stu.setName(name);
            stu.setEmail(email);
            stu.setPass(pass);
            stu.setRollno(rollno);
            stu.setCourse(course);
            
            // Database 
            int status = SqlQuery.insertStu(stu);
            
            if (status > 0) {
                out.println("<h1>Registered Successfully !!!</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("librarianLoginView");
                rd.include(request, response);
            } else {
                out.println("<h3>Sorry ! unable to save...</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("addStudentForm.html");
                rd.include(request, response);
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
