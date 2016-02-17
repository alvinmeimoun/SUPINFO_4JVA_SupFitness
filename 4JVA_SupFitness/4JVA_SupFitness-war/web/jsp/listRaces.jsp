<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <jsp:include page="../include/header.jsp" />
</header>
<div class="container">
<a href="AddRace">Ajouter une foot race</a>
<table class="table table-bordered table-hover">
    <thead>
        <tr>
            <td><strong>Id</strong></td>
            <td><strong>Nom</strong></td>
            <td><strong>Date</strong></td>
            <td><strong>Action</strong></td>
        </tr>
    </thead>
    <tbody>
            <c:forEach items="${listRaces}" var="race">
                <tr>
                    <td><c:out value="${race.getId()}" /></td>
                    <td><c:out value="${race.getName()}" /></td>
                    <td><c:out value="${race.getStartDate()}" /></td>
                    <td><a href="#">Ajouter une track</a></td>
                </tr>
            </c:forEach>
    </tbody>
</table>   
</div>
<footer>
            <jsp:include page="../include/footer.jspf" />
</footer>