<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <jsp:include page="../include/header.jsp" />
</header>
<div class="row bs-docs-header" style="height:100px;">
    <p><h2 class="" style="font-size:20px; margin: 10px; color:white;">Mes checkpoints</h2></p></br>
</div>
<div class="container">

<table class="table table-bordered table-hover">
    <thead>
        <tr>
            <td><strong>Id</strong></td>
            <td><strong>Latitude</strong></td>
            <td><strong>Longitude</strong></td>
            <td><strong>Speed</strong></td>
            <td><strong>Date</strong></td>
            <td><strong>Actions</strong></td>
        </tr>
    </thead>
    <tbody>

            <c:forEach items="${listTracks}" var="track">
                <tr>
                    <td><c:out value="${track.getId()}" /></td>
                    <td><c:out value="${track.getLatitude()}" /></td>
                    <td><c:out value="${track.getLongitude()}" /></td>
                    <td><c:out value="${track.getSpeed()}" /></td>
                    <td><c:out value="${track.getStartDate()}" /></td>
                    <td><a href="DeleteTrack?trackId=<c:out value="${track.getId()}" />">Supprimer</a></td>
                </tr>
            </c:forEach>
    </tbody>
</table>
<p style="text-align:right;" >
<a class="btn btn-info" href="AddTrack?raceId=<c:out value="${raceId}" />">Ajouter un checkpoint</a>
</p>
</div>
<footer>
            <jsp:include page="../include/footer.jspf" />
</footer>