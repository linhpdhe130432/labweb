/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.GalleryDAO;
import DAO.InformationDAO;
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
public class HomeController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            InformationDAO info = new InformationDAO();
            GalleryDAO gallery = new GalleryDAO();
            
            // send data of gallery (name. code) to header
            request.setAttribute("galleryInHeader", gallery.getInfoAllGalleryForHeader());
            
            //get from Database and  set Attribute for all information of Photographer in Home Screen
            request.setAttribute("info", info.getHomeInfo());
            
            int pageNumber;
            // Get page number parameter. If pageNumber isn't number, default pageNumber = 1
            try {
                pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            } catch (NumberFormatException e) {
                pageNumber=1;
            }
            request.setAttribute("gallery", gallery.getInfoGallery(pageNumber, 3));
            // Get total page for pagging
            // If pageNumber more than size of page. Calculate total page size with Pagging
            int total = (int) Math.ceil(((float)gallery.getTotalGallery()) / 3);
            request.setAttribute("total", total);
            
            //show in home.jsp
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            // go to page error 
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
