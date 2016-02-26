/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet;

import com.supinfo.supfitness.ejb.business.TrackBusiness;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import com.supinfo.supfitness.web.util.ConverterUtil;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ayant pour fonctionnalité d'afficher la liste des Tracks
 */
@WebServlet(name = "ListTracksServlet", urlPatterns = {"/ListTracks"})
public class ListTracksServlet extends HttpServlet {

    
    @EJB
    private TrackBusiness trackBusiness;


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Récupère la page de liste des Tracks
     * Prends en paramètre raceId
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      Long raceId = ConverterUtil.ConvertRequestParameterToLong(request.getParameter("raceId"));
      request.setAttribute("raceId",raceId);
        
      List<TrackEntity> listTracks = trackBusiness.findAllTrack(raceId);
      request.setAttribute("listTracks",listTracks);
        
      request.getRequestDispatcher("jsp/listTracks.jsp").forward(request, response);
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
