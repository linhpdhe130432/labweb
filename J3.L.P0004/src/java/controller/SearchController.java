/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NewsDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DuongDT
 */
@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

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
        try {
            String keyword = request.getParameter("keyword");
            // Get page number in param. If if is not a number, default page Number = 1
            int pageNumber;
            try {
                pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            } catch (NumberFormatException ne) {
                pageNumber = 1;
            }
            // Get data for view
            NewsDAO news = new NewsDAO();
            // Keyword cannot null or empty
            if (keyword == null || keyword.isEmpty()) {
                request.setAttribute("listSearch", null);
            } else {
                // Set 3 news per 1 page search
                request.setAttribute("listSearch", news.searchByKeyword(keyword, pageNumber, 3));
                // Get total result to calculate total page in view
                int total = (int) Math.ceil(((float) news.getTotalSearch(keyword)) / 3);
                request.setAttribute("total", total);

                // Get keyword to input value
                request.setAttribute("keyword", keyword);
            }

            // Get data for slide bar
            request.setAttribute("top", news.getTop5Newest());
            // Go to view
            RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            // Go to error page
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
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
