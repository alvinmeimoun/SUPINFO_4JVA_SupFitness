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

public class RegisterServlet extends HttpServlet {

    @EJB
    private UserBusiness userBusiness;
    
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
        //TODO register page
        //response.getWriter().print("register test");
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
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
        user.setPassword(DigestUtils.sha256Hex(
                password));
        user.setUserName(username);
        user.setPostalCode(postalCode);
        
        /*userBusiness.addOrUpdateUser(user);
        
        RequestDispatcher rd = request.getRequestDispatcher("login");
        rd.forward(request, response);
        */
        
        
        
        if(userBusiness.findByUsername(username) != null){
            System.out.println("Existant");
            
            request.setAttribute("error", "Nom d'utilisateur déjà existant");
            response.sendRedirect("register");
            
        }
        //Username n'est pas dans la BDD
        else{
            
                if(username.length() > 0 && email.length() > 0 && firstname.length() > 0 && lastname.length() > 0 
                    && postalCode.length() == 5 && password != null  ){

                     userBusiness.addOrUpdateUser(user);
                     RequestDispatcher rd = request.getRequestDispatcher("login");
                     rd.forward(request, response);

                }

            else{
                System.out.println("Erreur sur les champs");
                response.sendRedirect("register");
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
