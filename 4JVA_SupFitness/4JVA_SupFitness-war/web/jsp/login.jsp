<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
            <jsp:include page="../include/header.jsp" />
</header>
        <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Identifiez-vous pour continuer</h1>
                <div class="account-wall">
                    <img class="profile-img" src="img/supinfo_logo.png"
                         alt=""/>
                    <form action="login" method="post" class="form-signin">
                        <input type="text" class="form-control" placeholder="Nom d'utilisateur" name="username"/>
                        <input type="password" class="form-control" placeholder="Mot de passe" name="password"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
                    </form>
                </div>

                <div class="text-center login-message">
                    <% if(request.getParameter("authFailed") != null
                            && request.getParameter("authFailed").equals("true")) { %>
                        <p>Identifiants incorrect</p>
                    <% } %>
                </div>
            </div>
        </div>
    </div>

<footer>
<jsp:include page="../include/footer.jspf" />
</footer>