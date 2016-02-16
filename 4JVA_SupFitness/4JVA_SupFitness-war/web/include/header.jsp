<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>    
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupFitness</title>

        <link rel="stylesheet" href="css/libs/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/libs/bootstrap-theme.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/login.css" type="text/css"/>
        <script src="js/libs/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home">SupFitness</a>
    </div>
<%
        if(request.getAttribute("isAuthenticated") == "true") {
        %>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        
        <li><a href="AddRace">Ajouter une foot race</a></li>
        <li><a href="ListRaces">Voir mes foot races</a></li>
      </ul>
       
        <ul class="nav navbar-nav navbar-right">
            <li><a>Bonjour <%= request.getAttribute("username") %> ! </a></li>
          <li><a href="logout">Se déconnecter</a></li>

        </ul>
        <% }else 
             {%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login">Se connecter</a></li>
                <li><a href="register">S'enregistrer</a></li>
            </ul>
        <% } %>
       
       
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>