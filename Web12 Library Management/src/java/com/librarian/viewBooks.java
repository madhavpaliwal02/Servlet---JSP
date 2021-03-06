package com.librarian;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class viewBooks extends HttpServlet {

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
            out.println("<title>Servlet viewBooks</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("This is view Books Page");
            
            ArrayList<Book> book = SqlQuery.selectAllBook();
            
            out.println("<table border='1' width='100%'>");

            out.print("<tr>"
                    + "<th>Name</th>"
                    + "<th>Description</th>"
                    + "<th>Author Name</th>"
                    + "<th>Edition</th>"
                    + "</tr>");
            
            for(Book b : book){
                out.print("<tr>"
                        + "<td>"+ b.getName() +"</td>"
                        + "<td>"+ b.getDesc() +"</td>"
                        + "<td>"+ b.getAuth() +"</td>"
                        + "<td>"+ b.getEdition() +"</td>"
                        + "</tr>");
            }
            
            out.println("</table>");
            
            out.println("<br>");
            out.println("<br>");
                        
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
