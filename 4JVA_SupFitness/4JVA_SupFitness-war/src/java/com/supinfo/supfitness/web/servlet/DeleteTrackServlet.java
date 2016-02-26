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
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ayant pour fonctionnalité de supprimer un Track
 */
public class DeleteTrackServlet extends HttpServlet {

    @EJB
    private TrackBusiness trackBusiness;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Supprime un track
     * Prends en paramètre trackId
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Long trackId = ConverterUtil.ConvertRequestParameterToLong(request.getParameter("trackId"));
            TrackEntity track = trackBusiness.find(trackId);
            String raceId = String.valueOf(track.getRace().getId());
            trackBusiness.deleteTrack(track);
            RequestDispatcher rd = request.getRequestDispatcher("ListTracks?raceId=" + raceId);
            rd.forward(request, response);

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
