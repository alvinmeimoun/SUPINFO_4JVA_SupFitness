<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.supinfo.supfitness.ejb.entity.TrackEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.supinfo.supfitness.ejb.entity.RaceEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<% RaceEntity raceModel = (RaceEntity) request.getAttribute("raceDetails");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupFitness</title>
    </head>
    <body>
        <header>
            <jsp:include page="../include/header.jsp" />
        </header>
        <div class="container">
            <div class="row">
                <p><h1><%= raceModel.getName() %></h1></p></br>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <p>
                        <% DateFormat dateFormatMain = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, Locale.getDefault()); %>
                        <%= dateFormatMain.format(raceModel.getStartDate()) %>
                    </p></br>
                    <table id="table_tracks" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Date</th>
                                <th>Vitesse</th>
                                <th>Latitude</th>
                                <th>Longitude</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(TrackEntity trackModel : raceModel.getTracks()) { %>
                                <tr>
                                    <td><%= dateFormatMain.format(trackModel.getStartDate()) %></td>
                                    <td><%= trackModel.getSpeed() %></td>
                                    <td><%= trackModel.getLatitude() %></td>
                                    <td><%= trackModel.getLongitude() %></td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-4">
                    google maps
                </div>
            </div>
        </div>
        <footer>
            <jsp:include page="../include/footer.jspf" />
        </footer>
    </body>
</html>
