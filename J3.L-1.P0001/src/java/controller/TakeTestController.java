/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 *
 * @author DuongDT
 */
public class TakeTestController extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(true);

            //Check time allow before get question for user
            // Get question of test in session for user
            Test testSession = (Test) session.getAttribute("test");

            //Calculate time remaining equal time end - time now
            long now = new Date().getTime();
            long timeRemain = testSession.getEndTime() - now;

            // If time remain less than or equal 0 go to score calculation serverlet
            if (timeRemain <= 0) {
                response.sendRedirect("result");
                return;
            }
            // Get question number in params
            int questionNumber;
            // If question number in params not is a number, default to question number 1
            try {
                questionNumber = Integer.parseInt(request.getParameter("question"));
            } catch (NumberFormatException ne) {
                questionNumber = 1;
            }

            // If question number require bigger than having in session, go to question 1
            int totalQuestionInSession = testSession.getListQuestion().size();
            if (questionNumber > totalQuestionInSession) {
                response.sendRedirect("test?question=1");
                return;
            }
            // Get question with number which request by user 
            Question question = testSession.getListQuestion().get(questionNumber - 1); // index in list start by 0

            // Send time remaing to front end
            request.setAttribute("remain", timeRemain);

            // Get user in session and send name user to view
            request.setAttribute("name", testSession.getUser().getUserName());

            // Send number of question to POST answer with params
            request.setAttribute("number", questionNumber);

            // Send choice of user to show options which chosen before
            request.setAttribute("chosen", question.getUserChoice());

            //Send question content and options for user to view
            request.setAttribute("content", question.getQuestionContent());
            request.setAttribute("options", question.getOptionsList());

            // If question get is a last question in session, add finish option for user to finish all 
            if (questionNumber == totalQuestionInSession) {
                request.setAttribute("isLastQuest", true);
            }

            RequestDispatcher rd = request.getRequestDispatcher("question.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            // Go to error page
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            request.setAttribute("error", "The link you followed may be broken, or the page may have been removed.");
            rd.forward(request, response);
        }
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
        try {
            HttpSession session = request.getSession(true);

            // Check session. If session dont have test, 
            if (session.getAttribute("test") == null) {
                response.sendRedirect("take");
                return;
            }

            //Check time allow before get question for user. 
            // Get question of test in session for user
            Test testSession = (Test) session.getAttribute("test");

            //Calculate time remaining equal time end - time now
            long now = new Date().getTime();
            long timeRemain = testSession.getEndTime() - now;

            // If time remain less than or equal 0 go to score calculation serverlet 
            // and do not record the result of this question
            if (timeRemain <= 0) {
                response.sendRedirect("result");
                return;
            }

            // Get question number in params
            String questionParam = request.getParameter("question");

            // If question number in params not is a number or more than total question in session
            // go to question 1 view
            int totalQuestionInSession = testSession.getListQuestion().size();
            if (questionParam == null || !questionParam.matches("\\d+")
                    || Integer.valueOf(questionParam) > totalQuestionInSession) {
                response.sendRedirect("test?question=1");
                return;
            }

            int questionNumber = Integer.valueOf(questionParam);
            // Get answer from user
            String checkOption1 = request.getParameter("option1");
            String checkOption2 = request.getParameter("option2");
            String checkOption3 = request.getParameter("option3");
            String checkOption4 = request.getParameter("option4");

            // Create a list answers of user for this question
            List<Integer> userChoice = new ArrayList<>();

            // If check box for options is checked, add to answers list
            if (checkOption1 != null && checkOption1.equals("checked")) {
                userChoice.add(1);
            }
            if (checkOption2 != null && checkOption2.equals("checked")) {
                userChoice.add(2);
            }
            if (checkOption3 != null && checkOption3.equals("checked")) {
                userChoice.add(3);
            }
            if (checkOption4 != null && checkOption4.equals("checked")) {
                userChoice.add(4);
            }

            // Write answer of user to session
            // List index start with 0
            testSession.getListQuestion().get(questionNumber - 1).setUserChoice(userChoice);
            // Go to next question
            int nextQuestion = questionNumber + 1;
            response.sendRedirect("test?question=" + nextQuestion);

        } catch (Exception e) {
            // Go to error page
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            request.setAttribute("error", "The link you followed may be broken, or the page may have been removed.");
            rd.forward(request, response);
        }
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
