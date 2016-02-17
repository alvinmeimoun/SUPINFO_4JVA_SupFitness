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
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonin
 */
@WebServlet(name = "AddRaceServlet", urlPatterns = {"/AddRace"})
public class AddRaceServlet extends HttpServlet {

    @EJB
    private RaceBusiness raceBusiness;
    
    @EJB
    private UserBusiness userBusiness;
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
        
        UserEntity user = userBusiness.find(ConverterUtil.ConvertRequestParameterToLong(request.getAttribute("userId")));
        
        RaceEntity race = new RaceEntity();
        race.setUser(user);
        raceBusiness.addOrUpdateRace(race);
        
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
