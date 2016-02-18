/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet;

import com.supinfo.supfitness.ejb.business.RaceBusiness;
import com.supinfo.supfitness.ejb.business.TrackBusiness;
import com.supinfo.supfitness.ejb.business.UserBusiness;
import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import com.supinfo.supfitness.ejb.entity.UserEntity;
import com.supinfo.supfitness.web.util.ConverterUtil;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

    @EJB
    TrackBusiness trackBusiness;
    
    @EJB
    RaceBusiness raceBusiness;
    
    @EJB
    UserBusiness userBusiness;
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
        
        if(request.getAttribute("isAuthenticated").equals("false"))
        {
            List<RaceEntity> listRaces = raceBusiness.findAll();
            List<TrackEntity> listTracks = trackBusiness.findAll();
            List<UserEntity> listUsers = userBusiness.findAll();
            int nbRaces = listRaces.size();
            int nbTracks = listTracks.size();
            int nbUsers = listUsers.size();
            request.setAttribute("racesNumber",nbRaces);
            request.setAttribute("tracksNumber",nbTracks);
            request.setAttribute("usersNumber",nbUsers);
        }
        else 
        {
            UserEntity user = userBusiness.find(ConverterUtil.ConvertRequestParameterToLong(request.getAttribute("userId")));
            RaceEntity race = raceBusiness.getLastRaceByUser(user);
            request.setAttribute("raceDetails", race);
            request.setAttribute("tracksCount", race.getTracks().size());
        }
        
        
        request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
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
        return "Home page";
    }

}
