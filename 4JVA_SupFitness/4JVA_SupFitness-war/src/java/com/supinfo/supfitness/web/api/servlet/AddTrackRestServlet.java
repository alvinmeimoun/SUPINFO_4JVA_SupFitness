/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.api.servlet;

import com.google.gson.Gson;
import com.supinfo.supfitness.ejb.business.RaceBusiness;
import com.supinfo.supfitness.ejb.business.TrackBusiness;
import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import com.supinfo.supfitness.web.api.model.TrackModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet permettant d'ajouter un Track via l'API REST
 * Les service REST communiquent en JSON
 */
public class AddTrackRestServlet extends HttpServlet {

    @EJB
    TrackBusiness trackBusiness;
    
    @EJB
    RaceBusiness raceBusiness;
    
    /**
     * Ajoute un nouveau Track
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder jb = new StringBuilder();
        String line;
        try {
          BufferedReader reader = req.getReader();
          while ((line = reader.readLine()) != null)
            jb.append(line);
        } catch (Exception e) {
            resp.setStatus(400);
            resp.getWriter().print("Error reading request body");
            return;
        }

        TrackModel model;
        try {
          model = new Gson().fromJson(jb.toString(), TrackModel.class);
        } catch (Exception e) {
          resp.setStatus(400);
          resp.getWriter().print("Error parsing JSON data");
          return;
        }
        
        RaceEntity foundRace = raceBusiness.findOne(model.getRaceId());
        if(foundRace == null){
            resp.setStatus(400);
          resp.getWriter().print("Race not found");
          return;
        }
        
        trackBusiness.addOrUpdateTrack(new TrackEntity().setLatitude(model.getLatitude())
            .setLongitude(model.getLongitude()).setSpeed(model.getSpeed())
            .setStartDate(model.getStartDate()).setRace(foundRace));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrackEntity> entities = trackBusiness.findAllTrack(
                req.getParameter("raceId") == null ? null : Long.parseLong(req.getParameter("raceId")));
        String jsonString = new Gson().toJson(entities);
        
        resp.addHeader("Content-Type", "application.json");
        
        resp.getWriter().print(jsonString);
    }
    
    
    
}
