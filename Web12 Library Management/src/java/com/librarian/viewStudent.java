package com.librarian;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import com.sql.*;

public class viewStudent extends HttpServlet {

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
            out.println("<title>Servlet viewStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("This is View Student Page");
            ArrayList<Student> stu = SqlQuery.selectAllStu();
            
            out.println("<table border='1' width='100%'>");

            out.print("<tr>"
                    + "<th>Name</th>"
                    + "<th>Roll NO</th>"
                    + "<th>Email</th>"
                    + "<th>Password</th>"
                    + "<th>Course</th>"
                    + "</tr>");
            
            for(Student s : stu){
                out.print("<tr>"
                        + "<td>"+ s.getName() +"</td>"
                        + "<td>"+ s.getRollno() +"</td>"
                        + "<td>"+ s.getEmail() +"</td>"
                        + "<td>"+ s.getPass() +"</td>"
                        + "<td>"+ s.getCourse() +"</td>"
                        + "</tr>");
            }
            
            out.println("</table>");
            
            RequestDispatcher rd = request.getRequestDispatcher("librarianLoginView");
            rd.include(request, response);
            
            
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
