<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bs-docs-header">
                <div class="container">
                <h1 style="color:white;">Bienvenue sur SupFitness</h1>
                <p><a href="login" class="btn btn-info">Connectez-vous !</a>&nbsp;<a href="register" class="btn btn-warning">Enregistrez-vous !</a></p>
                </div>
            </div>  
        <div class="container">

        <div class="row">
            <div class="col-md-3 div-home" style="margin-left:7.5%">
                <div style="height:55px;">
                <h2 class="login-title" style="font-size: 25px;">Nombre de courses actuelles</h2>
                </div>
                <div class="circle">
                    <div class="inner-circle">
                    <c:out value="${racesNumber}"></c:out>
                    </div>
                </div>
                <h2 class="login-title" style="font-size: 25px; margin-top: 10%; color: steelblue;">races</h2>
            </div>
              <div class="col-md-3 div-home-green" style="margin-left:5%">
                <div style="height:55px;">
                <h2 class="login-title" style="font-size: 25px;">Nombre de checkpoints actuels</h2>
                </div>
                <div class="circle-green">
                    <div class="inner-circle">
                    <c:out value="${tracksNumber}"></c:out>
                    </div>
                </div>
                <h2 class="login-title" style="font-size: 25px; margin-top: 10%; color: #5cb85c;">tracks</h2>
            </div>
            <div class="col-md-3 div-home-orange" style="margin-left:5%">
                <div style="height:55px; ">
                <h2 class="login-title" style="font-size: 25px;">Nombre d'utilisateurs</h2>
                </div>
                <div class="circle-orange">
                    <div class="inner-circle">
                    <c:out value="${usersNumber}"></c:out>
                    </div>
                </div>
                <h2 class="login-title" style="font-size: 25px; margin-top: 10%; color: orange;">utilisateurs</h2>
            </div>
        
        </div>
 </div>
