/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet;

import com.supinfo.supfitness.ejb.business.RaceBusiness;
import com.supinfo.supfitness.ejb.business.UserBusiness;
import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.entity.UserEntity;
import com.supinfo.supfitness.web.util.ConverterUtil;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ayant pour fonctoin d'ajouter une Race
 */
@WebServlet(name = "AddRaceServlet", urlPatterns = {"/AddRace"})
public class AddRaceServlet extends HttpServlet {

    @EJB
    private RaceBusiness raceBusiness;
    
    @EJB
    private UserBusiness userBusiness;
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Récupère la page d'ajout d'une race
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("jsp/addRace.jsp").forward(request, response);

        
    }

    /**
     * Enregistre l'ajout d'une race
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long id = ConverterUtil.ConvertRequestParameterToLong(request.getParameter("userId"));
        UserEntity user = userBusiness.find(id);
        
        RaceEntity race = new RaceEntity();
        race.setName(String.valueOf(request.getParameter("name")));
        String startDateStr = request.getParameter("startDate");
        SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        

        try {
            //surround below line with try catch block as below code throws checked exception
            Date startDate0 = sdf0.parse(startDateStr);
            //Date startDate = sdf.
            race.setStartDate(startDate0);
        } catch (ParseException ex) {
            Logger.getLogger(AddRaceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        race.setUser(user);
        raceBusiness.addOrUpdateRace(race);
        //RequestDispatcher rd = request.getRequestDispatcher("ListRaces");
        //rd.forward(request, response);
        response.sendRedirect("ListRaces");
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
