/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import com.supinfo.supfitness.ejb.business.UserBusiness;
import com.supinfo.supfitness.ejb.entity.UserEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Naruara
 */
//@WebServlet(name = "EditProfileServlet", urlPatterns = {"/editProfile"})
public class EditProfileServlet extends HttpServlet {
    
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
        //response.getWriter().println("edit profile get");
        String cookieUsername = (String) request.getAttribute("username");
        UserEntity user = userBusiness.findByUsername(cookieUsername);
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("jsp/editProfile.jsp").forward(request, response);
       
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
        String cookieUsername = (String) request.getAttribute("username");
        UserEntity user = userBusiness.findByUsername(cookieUsername);
        
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String postalCode = request.getParameter("postalcode");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
       
        //user.setUserName(request.getParameter("username"));
        user.setEmail(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPostalCode(postalCode);
        
        
        if(oldPassword != null && newPassword != null && confirmNewPassword != null
                && oldPassword.length() > 0 && newPassword.length() > 0 &&
                confirmNewPassword.length() > 0){
            //Changement de mot de passe
            System.out.println("Password");
            if(user.getPassword().equals(DigestUtils.sha256Hex(oldPassword))){
                //Ancien mot de passe valide
                System.out.println("Old Password");
                if(newPassword.equals(confirmNewPassword)){
                    //Confirmation du nouveua mot de passe valide
                    user.setPassword(DigestUtils.sha256Hex(newPassword));
                }
            }
            else{
                System.out.println("Bad Old Password");
                
            }
        }
    
        //Voir pour la gestion du nouveau password
        if(email.length() > 0 && firstname.length() > 0 && lastname.length() > 0 
                && postalCode.length() == 5 && oldPassword != null ){
                
            if(user.getPassword().equals(DigestUtils.sha256Hex(oldPassword))){
                userBusiness.addOrUpdateUser(user);
                response.sendRedirect("home");
                
                }
            else{
                System.out.println("Mot de passe incorrect");
                response.sendRedirect("editProfile");
                }
        
        }
        else{
            System.out.println("Erreur sur les champs");
            response.sendRedirect("editProfile");
            //response.sendRedirect("editProfile?listError=true");
            
        }
        
       
        
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Edit my profile";
    }

}
