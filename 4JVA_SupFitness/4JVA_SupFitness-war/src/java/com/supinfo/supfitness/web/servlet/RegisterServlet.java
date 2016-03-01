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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Servlet ayant pour fonctionnalité de gérer les inscription
 */
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserBusiness userBusiness;
    
    /**
     * Affiche la page d'inscription
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO register page
        //response.getWriter().print("register test");
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
    }

    /**
     * Récupération du formulaire d'inscription
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creation de l'entité
        UserEntity user = new UserEntity();
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String postalCode = request.getParameter("postalcode");
        String password = request.getParameter("password");
        
        user.setEmail(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPassword(DigestUtils.sha256Hex(password));
        user.setUserName(username);
        try 
        {
        user.setPostalCode(postalCode);
        }
        catch(Exception e)
        {
             response.sendRedirect("register?registerFailed=true"
                    + "&username=" + username
                    + "&firstname=" + firstname
                    + "&lastname=" + lastname
                    + "&email=" + email
                    + "&password=" + password
                    + "&errorMessage=" + "Le code postal est incorrect."
            );
        }
        
        if(userBusiness.findByUsername(username) != null){
            
            
            response.sendRedirect("register?registerFailed=true"
                    + "&username=" + username
                    + "&firstname=" + firstname
                    + "&lastname=" + lastname
                    + "&email=" + email
                    + "&postalcode=" + postalCode
                    + "&password=" + password
                    + "&errorMessage=" + "Le nom d'utilisateur existe deja."
            );
            
        }
        //Username n'est pas dans la BDD
        else{
            
                if(username.length() > 0 && email.length() > 0 && firstname.length() > 0 && lastname.length() > 0 && postalCode.length() > 0
                    && password != null  ){

                        userBusiness.addOrUpdateUser(user);
                        RequestDispatcher rd = request.getRequestDispatcher("login");
                        rd.forward(request, response);
                    }
                    
            else{
                System.out.println("Erreur sur les champs");
                
                request.setAttribute("errorMessage", "Il y a des erreurs sur les champs");
                //response.sendRedirect("editProfile");
                this.doGet(request, response);
            }
        }
       
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Add user";
    }
}
