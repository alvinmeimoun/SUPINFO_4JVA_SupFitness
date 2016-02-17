<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <jsp:include page="../include/header.jsp" />
</header>
<a href="addRace">Ajouter une foot race</a>
<ul>
            <c:forEach items="${listRaces}" var="race">
                <li><c:out value="${race.id}" /></li>
            </c:forEach>
</ul>
            
<footer>
            <jsp:include page="../include/footer.jspf" />
</footer>