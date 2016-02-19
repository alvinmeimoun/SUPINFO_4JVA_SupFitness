<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <jsp:include page="../include/header.jsp" />
</header>
<div class="row bs-docs-header" style="height:100px;">
    <p><h2 class="" style="font-size:20px; margin: 10px; color:white;">Mes courses</h2></p></br>
</div>
<div class="container">
<table class="table table-bordered table-hover">
    <thead>
        <tr>
            <td><strong>ID</strong></td>
            <td><strong>Nom</strong></td>
            <td><strong>Date</strong></td>
            <td><strong>Action</strong></td>
        </tr>
    </thead>
    <tbody>
            <c:forEach items="${listRaces}" var="race">
                <tr>
                    <td><c:out value="${race.getId()}" /></td>
                    <td><a href="detailsRace?raceId=${race.getId()}"><c:out value="${race.getName()}" /></a></td>
                    <td><c:out value="${race.getStartDate()}" /></td>
                    <td><a href="AddTrack?raceId=<c:out value="${race.getId()}" />">Ajouter un checkpoint</a> | <a href="ListTracks?raceId=<c:out value="${race.getId()}" />">Mes tracks</a></td>
                </tr>
            </c:forEach>
    </tbody>
</table>   
 <p style="text-align:right;">
    <a class="btn btn-info" href="AddRace">Ajouter une course</a>
</p>
</div>
<footer>
            <jsp:include page="../include/footer.jspf" />
</footer>