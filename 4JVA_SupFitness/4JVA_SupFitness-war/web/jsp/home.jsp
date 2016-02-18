<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
        <header>
            <jsp:include page="../include/header.jsp" />
        </header>

<%
        if(request.getAttribute("isAuthenticated") == "false") {
        %>
          <jsp:include page="../include/homeContent_anonymous.jsp" />
        <% }else {%>
        <jsp:include page="../include/homeContent_authenticated.jsp" />
        
          <% } %>
        <footer>
            <jsp:include page="../include/footer.jspf" />
        </footer>