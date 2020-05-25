/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;
import model.Test;
import model.Users;

/**
 *
 * @author DuongDT
 */
public class CreateTestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
            RequestDispatcher rd = request.getRequestDispatcher("takeQuiz.jsp");
            
            // In this serverlet, if no have params in request or invalid parameters 
            // Go to view page. If have params -> create session for quiz with amount question
            // and start counting time for quiz
            
            String numberParam = request.getParameter("number");

            // Get session user info
            HttpSession session = request.getSession(true);
            Users user = (Users) session.getAttribute("user");
            request.setAttribute("name", user.getUserName());

            QuestionsDAO questionDao = new QuestionsDAO();

            // When input of user invalid
            if (numberParam != null && numberParam.matches("\\d+")) {
                // If amount over integer number, set it equal max question in DB
                int amount;
                try {
                    amount = Integer.parseInt(numberParam);
                } catch (NumberFormatException ne) {
                    amount = questionDao.getTotalQuestions();
                }

                // If number question in request equal or less than 0, back to take page with error noti
                if (amount <= 0) {
                    request.setAttribute("error", "The number of question must greater than 0");
                } else {
                    // When the number of questions in request is invalid, Create new test for user
                    // Before create new test, remove all test having in session of this user
                    session.removeAttribute("test");

                    // Create random list Question for this request.
                    // If the number of ques in request bigger than total question have in
                    // database, get list with largest number of questions 
                    List<Question> listQuestions = questionDao.getRandomQuestionList(amount);

                    // Get time now to set begin time
                    long beginTime = new Date().getTime(); // Get time at the moment to milisecond
                    // Each question have 1 minutes -> total time is ( 1 minute x  total amount question )
                    // 1 minute = 60 second.
                    // 1 second = 1000 milisecond
                    // Calculate end time in milisecond
                    long endTime = beginTime + (listQuestions.size() * 60 * 1000);
                    //Create new test
                    Test test = new Test(user, endTime, listQuestions);
                    // Write in session

                    session.setAttribute("test", test);
                    // Send to serverlet get question
                    response.sendRedirect("test?question=1");
                    return;
                }
            // When input of user not null but not invalid (must be a number >0)
            // back to view page with error message
            } else if (numberParam != null&&!numberParam.matches("\\d+")) {
                request.setAttribute("error", "The number of question must be a number and greater than 0");
            }
            // In the remaining cases (without parameters input), go to view page
            rd.forward(request, response);
        } catch (Exception e) {
            // Go to error page
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            request.setAttribute("error", "The link you followed may be broken, or the page may have been removed.");
            rd.forward(request, response);
        }
    }

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
