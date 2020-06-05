/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.GalleryDAO;
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
public class GalleryDetailController extends HttpServlet {

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
            RequestDispatcher rd = request.getRequestDispatcher("gallery.jsp");
            GalleryDAO gallery = new GalleryDAO();
            // send data to header info of gallery
            request.setAttribute("galleryInHeader", gallery.getInfoAllGalleryForHeader());
            String id = request.getParameter("id");
            
            // If id in parameter is not a number or not exist, go to view with no data.
            if (id!=null && id.matches("\\d+")) {
                int pageNumber;
                int idGallery = Integer.valueOf(id); 
                // Check if pageNumber is not a number, default to view with pageNumber = 1
                try {
                    pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
                } catch (NumberFormatException e) {
                    pageNumber = 1;
                }
                // If pageNumber more than size of page. Calculate total page size with Pagging
                int totalPage = (int) Math.ceil(((float)gallery.getTotalImage(idGallery)) / 8);
                // pagging with 8 element in one page
                request.setAttribute("gallery", gallery.getGalleryById(idGallery, pageNumber, 8));
                request.setAttribute("pageSize", totalPage);
            }
            // Go to view
            rd.forward(request, response);

        } catch (Exception e) {
            // Go to page error 
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
