/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.servlet;

import com.supinfo.supfitness.ejb.business.UserBusiness;
import com.supinfo.supfitness.ejb.entity.UserEntity;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Servmet ayant pour fonctionnalité d'éfiter un profil utilisateur
 */
//@WebServlet(name = "EditProfileServlet", urlPatterns = {"/editProfile"})
public class EditProfileServlet extends HttpServlet {
    
    @EJB
    UserBusiness userBusiness;
    
    /**
     * Récupère la page d'édition d'un profil utilisateur
     * Le nom d'utilisateur est obtenu depuis les Cookies d'authentification
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
     * Sauvegarde le formulaire d'édition d'un profil utilisateur
     * Attribut username requis
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
        
        try 
        {
        user.setPostalCode(postalCode);
        }
        catch(Exception e)
        {
             response.sendRedirect("editProfile?profileFailed=true"
                    + "&firstname=" + firstname
                    + "&lastname=" + lastname
                    + "&email=" + email
                    + "&oldPassword=" + oldPassword
                    + "&newPassword=" + newPassword
                    + "&confirmNewPassword=" + confirmNewPassword
                    + "&errorMessage=" + "Le code postal est incorrect."
            );
        }
        
        if(oldPassword != null && newPassword != null && confirmNewPassword != null &&
                email.length() > 0 && firstname.length() > 0 && lastname.length() > 0 && postalCode.length() > 0 ){
            //Changement de mot de passe
            System.out.println("Password");
                
                //Check si ancien password est valide
                if(user.getPassword().equals(DigestUtils.sha256Hex(oldPassword))){
               
                    //Check si le new password equals la confirmation
                    if(newPassword.equals(confirmNewPassword)){
                        //Confirmation du nouveua mot de passe valide
                        user.setPassword(DigestUtils.sha256Hex(newPassword));
                        System.out.println("New Password");

                        userBusiness.addOrUpdateUser(user);
                        response.sendRedirect("home");
                    } 
                    //Renvoie un message d'erreur si le new password ne correspond pas avec la confirmation
                    else {
                    request.setAttribute("errorMessage", "Le mot de passe ne correspond pas");
                    //response.sendRedirect("editProfile");
                    this.doGet(request, response);

                    }
                
                }
                //Renvoie un message d'erreur si l'ancien password n'est pas correcte
                else {
                    System.out.println("Bad Old Password");

                    System.out.println("Mot de passe incorrect");
                    request.setAttribute("errorMessage", "Mot de passe incorrect");
                    //response.sendRedirect("editProfile");
                    this.doGet(request, response);

                }
           }
           
        //Renvoie un message d'erreur s'il y a des champs incomplets
        else {
            System.out.println("Erreur sur les champs");
            //response.sendRedirect("editProfile");           
            
            request.setAttribute("errorMessage", "Il y a des erreurs sur les champs");
                //response.sendRedirect("editProfile");
            this.doGet(request, response);
                
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
