/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet.api;

import com.google.gson.Gson;
import com.supinfo.supfitness.ejb.business.TrackBusiness;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import com.supinfo.supfitness.ejb.facade.TrackFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListTrackRestServlet extends HttpServlet {

    @EJB
    TrackBusiness trackBusiness;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
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
