package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.sql.Librarian;
import com.sql.SqlQuery;

public class ViewLibrarian extends HttpServlet {

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
            out.println("<title>Servlet ViewLibrarain</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>This is View Librarain page</h1>");
            
            // Creating a list of librarian to fetch multiple records
            ArrayList<Librarian> al = SqlQuery.selectAllLib();
            
            out.println("<table border='1' width='100%'>");

            out.print("<tr>"
                    + "<th>Name</th>"
                    + "<th>Username</th>"
                    + "<th>Password</th>"
                    + "</tr>");
            
            for(Librarian lib : al){
                out.print("<tr>"
                        + "<td>"+ lib.getName() +"</td>"
                        + "<td>"+ lib.getUname() +"</td>"
                        + "<td>"+ lib.getPass() +"</td>"
                        + "</tr>");
            }
            
            out.println("</table>");
            
            out.println("<br>");
            out.println("<br>");
            RequestDispatcher rd1 = request.getRequestDispatcher("adminLoginView");
            rd1.include(request, response);
            
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
