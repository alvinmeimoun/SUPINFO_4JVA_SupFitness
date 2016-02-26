/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet;

import com.supinfo.supfitness.ejb.business.RaceBusiness;
import com.supinfo.supfitness.ejb.business.TrackBusiness;
import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import com.supinfo.supfitness.web.util.ConverterUtil;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ayant pour fonctionnalité d'ajouter un Track
 */
@WebServlet(name = "AddTrackServlet", urlPatterns = {"/AddTrack"})
public class AddTrackServlet extends HttpServlet {

    @EJB
    private RaceBusiness raceBusiness;
    
    @EJB
    private TrackBusiness trackBusiness;


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Récupère la page d'ajout de Track
     * Prends en paramètre raceId
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raceId = request.getParameter("raceId");
        if(raceId != null)
        {
        request.setAttribute("raceId", raceId);
        
        request.getRequestDispatcher("jsp/addTrack.jsp").forward(request, response);
        }
        else 
        {
           request.getRequestDispatcher("home").forward(request, response); 
        }
    }

    /**
     * Ajoute un Track
     * Prends en paramètre raceId
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long raceId = ConverterUtil.ConvertRequestParameterToLong(request.getParameter("raceId"));
        RaceEntity race = raceBusiness.findOne(raceId);
        
        if(race != null)
        {
            Double latitude = Double.valueOf(request.getParameter("latitude"));
            Double longitude = Double.valueOf(request.getParameter("longitude"));
            Double speed = Double.valueOf(request.getParameter("speed"));
            String startDateStr = request.getParameter("startDate");
            // On parse la date rentrée
            startDateStr = String.valueOf(startDateStr.replace('T', ' '));
            startDateStr = String.valueOf(startDateStr.replace('-', '/'));
            SimpleDateFormat sdf0 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            TrackEntity track = new TrackEntity();
            track.setLatitude(latitude).setLongitude(longitude).setSpeed(speed).setRace(race);
            
            try {
                //surround below line with try catch block as below code throws checked exception
                Date startDate = sdf0.parse(startDateStr);
                track.setStartDate(startDate);
            } catch (ParseException ex) {
                Logger.getLogger(AddRaceServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            trackBusiness.addOrUpdateTrack(track);
            //request.setAttribute("raceId", request.getParameter("raceId"));
            //getServletContext().getRequestDispatcher("/ListTracks").forward(request, response);
            response.sendRedirect("ListTracks?raceId="+raceId);
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
