<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
            <jsp:include page="../include/header.jsp" />
</header>
  <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Modification de votre profil</h1>
                <div class="account-wall">
        <form action="editProfile" method="POST" class="form-signin">
            <div>
                <label for="username">Nom d'utilisateur</label>
                <input type="text" id="username" name="username" value="<c:out value="${user.userName}"> </c:out>" class="form-control" placeholder="Nom d'utilisateur"/>
            </div>
            <div>
                <label for="firstname">Prénom</label>
                <input type="text" id="firstname" name="firstname" value="<c:out value="${user.firstName}"> </c:out>" class="form-control" placeholder="Nom"/>
            </div>
            <div>
                <label for="lastname">Nom de famille</label>
                <input type="text" id="lastname" name="lastname" value="<c:out value="${user.lastName}"> </c:out>" class="form-control" placeholder="Prénom"/>
            </div>
            
            <div>
                <label for="email">Email</label>
                <input type="text" id="email" name="email" value="<c:out value="${user.email}"> </c:out>" class="form-control" placeholder="Email" />
            </div>
            
            <div>
                <label for="oldPassword">Ancien mot de passe</label>
                <input type="password" id="oldPassword" name="oldPassword" placeholder="Ancien mot de passe" class="form-control" />
            </div>
            
            <div>
                <label for="newPassword">Nouveau mot de passe</label>
                <input type="password" id="newPassword" name="newPassword" placeholder="Nouveau mot de passe" class="form-control" />
            </div>
            
            <div>
                <label for="confirmNewPassword">Confirmation du mot de passe</label>
                <input type="password" id="confirmNewPassword" name="confirmNewPassword" placeholder="Confirmation du mot de passe" class="form-control" />
            </div>
            
            <div>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Modifier</button>
            </div>
        </form>
       </div>
<footer>
<jsp:include page="../include/footer.jspf" />
</footer>
