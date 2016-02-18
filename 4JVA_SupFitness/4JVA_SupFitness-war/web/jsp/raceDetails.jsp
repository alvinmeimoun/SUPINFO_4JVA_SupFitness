<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.supinfo.supfitness.ejb.entity.TrackEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.supinfo.supfitness.ejb.entity.RaceEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<% RaceEntity raceModel = (RaceEntity) request.getAttribute("raceDetails");
   int trackCounts = (Integer)request.getAttribute("tracksCount");
%>


        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDEfDi5eg8sWA5DumJtUKdqFA1ITz1wH8E&callback=initMap" type="text/javascript"></script>



        <!-- Facebook SDK -->
        <div id="fb-root"></div>
        <script>(function(d, s, id) {
          var js, fjs = d.getElementsByTagName(s)[0];
          if (d.getElementById(id)) return;
          js = d.createElement(s); js.id = id;
          js.src = "//connect.facebook.net/fr_FR/sdk.js#xfbml=1&version=v2.5&appId=1703651573245872";
          fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>
        <% 
            String currentUrl = request.getRequestURL().toString();
            String baseURL = currentUrl.substring(0, currentUrl.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
        %>
        
        <header>
            <jsp:include page="../include/header.jsp" />
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <p><h1 style="margin: 10px"><%= raceModel.getName() %></h1></p></br>
                </div>
                <div class="col-md-6">
                    <% String fbShareUrl = "http://www.supinfo.com/supfitness/detailsRace?raceId=" + raceModel.getId(); %>
                    <div class="fb-share-button right" data-href='<%= fbShareUrl %>'  data-layout="button"
                        style="margin-top: 10px;"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5">
                    <p>
                        <% DateFormat dateFormatMain = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault()); %>
                        <%= dateFormatMain.format(raceModel.getStartDate()) %>
                    </p></br>
                    </br>
                    <% if(request.getAttribute("isAuthenticated") != null
                            && ((String) request.getAttribute("isAuthenticated")).equals("true")) {%>
                        <a href="AddTrack?raceId=<%= raceModel.getId() %>">Ajouter une track</a>
                    <% } %>
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
                <div class="col-md-6">
                    <div id="map"></div>
                </div>
            </div>
        </div>
        <footer>
            <jsp:include page="../include/footer.jspf" />
        </footer>

    
    <!-- Google Map API -->
    <style type="text/css">
        #map {
            height: 100%; width: 100%; min-height: 400px;
            margin-bottom: 10px;
        }
    </style>
    <script>
        var points;
        var map;
        function initMap() {
            <% if(raceModel.getTracks().size() > 0) { %>
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: <%= raceModel.getTracks().get(0).getLatitude() %>, 
                        lng: <%= raceModel.getTracks().get(0).getLongitude() %>},
                    zoom: 8
                });
                
                var directionsDisplay = new google.maps.DirectionsRenderer();
                directionsDisplay.setMap(map);
                
                points = new Array();
                waypoints = new Array();
                var pointsIncrementer = 0;
                //All Tracks positions
                    <% for(TrackEntity trackModel : raceModel.getTracks()) { %>
                        var pt = {lat: <%= trackModel.getLatitude() %>,
                                lng : <%= trackModel.getLongitude() %>
                            };
                        var waypt = {"location" : "<%= trackModel.getLatitude() %>,<%= trackModel.getLongitude() %>"};
                        points.push(pt);
                        
                        if(pointsIncrementer > 0 && pointsIncrementer < <%= trackCounts-1 %>){
                            waypoints.push(waypt);
                        }
                        
                        pointsIncrementer++;
                    <% } %>
                    
                var mapRequest = {
                    origin: points[0],
                    destination: points[points.length - 1],
                    waypoints: waypoints, //an array of waypoints
                    optimizeWaypoints: true, //set to true if you want google to determine the shortest route or false to use the order specified.
                    travelMode: google.maps.DirectionsTravelMode.WALKING
                };
                var reqStatus;
                var directionsService = new google.maps.DirectionsService();
                directionsService.route(mapRequest, function(_response, _status) {
                    reqStatus = _status;
                    if (reqStatus == google.maps.DirectionsStatus.OK) {
                        directionsDisplay.setDirections(_response);
                    }
                });
                
            <% } %>
        }
    </script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDEfDi5eg8sWA5DumJtUKdqFA1ITz1wH8E&callback=initMap" type="text/javascript"></script>
    
    <!-- Facebook -->
    <script>
    function facebook_share(link){
        var left = (screen.width/2)-(520/2);
        var top = (screen.height/2)-(430/2);
        window.open("https://www.facebook.com/sharer/sharer.php?u=="+link, "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top="+top+", left="+left+", width=520, height=430");
    }
    </script>
    
</html>