/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet;

import com.supinfo.supfitness.ejb.business.RaceBusiness;
import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailsRaceServlet extends HttpServlet {

    @EJB
    RaceBusiness raceBusiness;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raceIdStr = req.getParameter("raceId");
        if(raceIdStr == null || raceIdStr.length() == 0){
            resp.sendRedirect("ListRaces");
            return;
        }
        
        RaceEntity race = raceBusiness.findOne(Long.parseLong(raceIdStr));
        
        req.setAttribute("raceDetails", race);
        req.setAttribute("tracksCount", race.getTracks().size()); //Force load a lazy collection
        
        req.getRequestDispatcher("jsp/raceDetails.jsp").forward(req, resp);
    }
    
    
    
}
