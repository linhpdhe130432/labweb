/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DuongDT
 */
public class manageQuizController extends HttpServlet {

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
        try  {
            int pageNumber;
            // Get page number parameter. If pageNumber isn't number, default pageNumber = 1
            try {
                pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            } catch (NumberFormatException e) {
                pageNumber=1;
            }
            // Get data from DB
            QuestionsDAO question = new QuestionsDAO();
            // Each page have 3 question, page size = 3
            request.setAttribute("questions", question.getAllQuestions(pageNumber, 3));
            // Get total page for pagging
            // If pageNumber more than size of page. Calculate total page size with Pagging
            int total = (int) Math.ceil(((float)question.getTotalQuestions()) / 3) ;
            request.setAttribute("totalPage", total);
            // Get total question in DB
            request.setAttribute("total", question.getTotalQuestions());
            RequestDispatcher rd = request.getRequestDispatcher("manageQuiz.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            // Go to error page
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            request.setAttribute("error", "The link you followed may be broken, or the page may have been removed.");
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
