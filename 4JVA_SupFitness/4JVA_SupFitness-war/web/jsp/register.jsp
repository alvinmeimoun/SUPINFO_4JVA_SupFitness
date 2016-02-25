<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
            <jsp:include page="../include/header.jsp" />
</header>
  <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Enregistrer vous dès maintenant !</h1>
                <div class="account-wall">
        <form action="register" method="POST" class="form-signin">
            <div>
                <label for="username">Nom d'utilisateur</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="Nom d'utilisateur" oninvalid="this.setCustomValidity('Veuillez entrer votre nom d\'utilisateur')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            <div>
                <label for="firstname">Prénom</label>
                <input type="text" id="firstname" name="firstname" class="form-control" placeholder="Prénom" oninvalid="this.setCustomValidity('Veuillez entrer votre prénom')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            <div>
                <label for="lastname">Nom de famille</label>
                <input type="text" id="lastname" name="lastname" class="form-control" placeholder="Nom de famille" oninvalid="this.setCustomValidity('Veuillez entrer votre nom de famille')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            
            <div>
                <label for="email">Email</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="Email" oninvalid="this.setCustomValidity('Veuillez entrer votre email')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            
            <div>
                <label for="postalcode">Code postal</label>
                <input type="text" id="postalcode" name="postalcode" class="form-control" placeholder="Code postal" maxlength="5" oninvalid="this.setCustomValidity('Veuillez entrer 5 chiffres')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            
            <div>
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" placeholder="Mot de passe" class="form-control" oninvalid="this.setCustomValidity('Veuillez entrer votre mot de passe')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            
            
                
            <div>
                <button type="submit" class="btn btn-lg btn-primary btn-block"  >S'enregistrer</button>
            </div>
        </form>
                    
                    <div class="text-center login-message">
                <% 
                        if(request.getParameter("error") != null) { %>
                        <p> <c:out value="Nom d'utilisateur déjà existant" </c:out>> </p>
                        
                    <% } %>
                </div>
       </div>
                
<footer>
<jsp:include page="../include/footer.jspf" />
</footer>
