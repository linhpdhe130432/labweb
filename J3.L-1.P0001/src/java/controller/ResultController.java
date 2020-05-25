/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TestDAO;
import java.io.IOException;
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
public class ResultController extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            
            // Get test in session
            Test testSession = (Test) session.getAttribute("test");
            
            // Get total question is session to calculate score and get another quiz with 
            // the same number of questions
            int totalQuestion = testSession.getListQuestion().size();
            
            // Check time allow. If it over time the result is not recorded 
            long now = new Date().getTime();
            long takeTime = now - testSession.getEndTime();
            
            // Set time delay is 5 second. 5 second = 5*1000 milisecond
            // Users will not be recorded results after timeup 5 seconds
            if (takeTime > 5*1000) {
                request.setAttribute("score", "Not recorded! Overtime");
            } else {
                // If user submit in time allowed
                // Calculate score
                int trueAnswer = 0;
                List<Question> listQuestion = testSession.getListQuestion();
                for (Question question : listQuestion ) {
                    // If list true answers equal list option user chosen -> True
                    // total true answer + 1
                    // otherwise -> False
                    if (question.getAnswersList().equals(question.getUserChoice())) {
                        trueAnswer = trueAnswer+1;
                    }
                }
                
                float score =(float) Math.round(((float)trueAnswer/totalQuestion) * 100) / 10;
                //Write in database
                TestDAO test = new TestDAO();
                test.recordResultTest(testSession.getUser().getUserName(), score);

                // Classify
                if (score>=5) {
                    request.setAttribute("score", ""+score+" ("+(int)(score*10)+"%) - Passed");
                    request.setAttribute("pass", true);
                } else {
                    request.setAttribute("score", ""+score+" ("+(int)(score*10)+"%) - Not Pass");
                }
                
                
            }
            // Send total question to view to user retake another quizz
            request.setAttribute("total", totalQuestion);
            // Go to view
            RequestDispatcher rd = request.getRequestDispatcher("score.jsp");
            rd.forward(request, response);
            // Delete session of quiz to block back to question after finish
            session.removeAttribute("test");
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
