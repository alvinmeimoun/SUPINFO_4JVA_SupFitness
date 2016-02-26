/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet;

import com.supinfo.supfitness.ejb.entity.UserEntity;
import com.supinfo.supfitness.ejb.facade.RaceFacade;
import com.supinfo.supfitness.ejb.facade.UserFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Servlet ayant pour fonctionnalité de s'authentifier
 */
public class LoginServlet extends HttpServlet {

    @EJB
    private UserFacade userFacade;
    
    @EJB
    private RaceFacade raceFacade;
    
    /**
     * Récupère la page de login
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.getWriter().println("login get");
        request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
    }

    /**
     * Récupération du formulaire de login
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String passwordCrypted = DigestUtils.sha256Hex(
                request.getParameter("password"));
        
        UserEntity user = userFacade.findByUsername(username);
        if(user != null && user.getPassword().equals(passwordCrypted)){
            response.addCookie(new Cookie("sb_token", DigestUtils.sha256Hex(username)));
            response.addCookie(new Cookie("sb_username", username));
            response.addCookie(new Cookie("sb_id", String.valueOf(user.getId())));
            
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login?authFailed=true");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Login servlet";
    }

}
