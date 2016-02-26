/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.api.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.supinfo.supfitness.ejb.business.TrackBusiness;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet composante de l'API REST permettant de récupérer la liste des track
 * @author alvin
 */
public class ListTrackRestServlet extends HttpServlet {

    @EJB
    TrackBusiness trackBusiness;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Récupère la liste des Track
     * API REST
     * L'API REST commuique en JSON
     * 
     * Prends en paramètre raceId pour obtenir la liste des Tracks d'un Race
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrackEntity> entities = trackBusiness.findAllTrack(
                req.getParameter("raceId") == null ? null : Long.parseLong(req.getParameter("raceId")));
        
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String jsonString = gson.toJson(entities);
        
        resp.addHeader("Content-Type", "application.json");
        
        resp.getWriter().print(jsonString);
    }
    
    
    
}
