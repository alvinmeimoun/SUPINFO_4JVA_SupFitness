<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <jsp:include page="../include/header.jsp" />
</header>
<div class="container">
<a href="AddTrack">Ajouter une track</a>
<table class="table table-bordered table-hover">
    <thead>
        <tr>
            <td><strong>Id</strong></td>
            <td><strong>Latitude</strong></td>
            <td><strong>Longitude</strong></td>
            <td><strong>Speed</strong></td>
            <td><strong>Date</strong></td>
        </tr>
    </thead>
    <tbody>
            <c:forEach items="${listTracks}" var="race">
                <tr>
                    <td><c:out value="${race.getId()}" /></td>
                    <td><c:out value="${race.getLatitude()}" /></td>
                    <td><c:out value="${race.getLongitude()}" /></td>
                    <td><c:out value="${race.getSpeed()}" /></td>
                    <td><c:out value="${race.getDate()}" /></td>
                    <td><a href="#">Supprimer</a></td>
                </tr>
            </c:forEach>
    </tbody>
</table>   
</div>
<footer>
            <jsp:include page="../include/footer.jspf" />
</footer>