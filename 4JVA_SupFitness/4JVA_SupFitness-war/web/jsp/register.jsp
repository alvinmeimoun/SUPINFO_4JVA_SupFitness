<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<header>
            <jsp:include page="../include/header.jsp" />
</header>
  <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Enregistrer vous dès maintenant !</h1>
                <div class="account-wall">
                <div class="text-center login-message">
                <% if(request.getParameter("registerFailed") != null
                            && request.getParameter("registerFailed").equals("true")) { 
                            %>
                            <p style="color:red"><%= request.getParameter("errorMessage") %></p>
                        
                    <% }
                            
                %>
                </div>
        <form action="register" method="POST" class="form-signin">
            <div>
                <label for="username">Nom d'utilisateur</label>
                <input type="text" id="username"  name="username"  <% if(request.getParameter("username") != null) { %> value=" <%= request.getParameter("username") %>"  <%}%>  class="form-control" placeholder="Nom d'utilisateur" oninvalid="this.setCustomValidity('Veuillez entrer votre nom d\'utilisateur')" 
onchange="this.setCustomValidity('')" required  />
            </div>
            <div>
                <label for="firstname">Prénom</label>
                <input type="text" id="firstname" name="firstname" <% if(request.getParameter("firstname") != null) { %> value=" <%= request.getParameter("firstname") %>"  <%}%>class="form-control" placeholder="Prénom" oninvalid="this.setCustomValidity('Veuillez entrer votre prénom')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            <div>
                <label for="lastname">Nom de famille</label>
                <input type="text" id="lastname" name="lastname" <% if(request.getParameter("lastname") != null) { %> value=" <%= request.getParameter("lastname") %>"  <%}%>class="form-control" placeholder="Nom de famille" oninvalid="this.setCustomValidity('Veuillez entrer votre nom de famille')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            
            <div>
                <label for="email">Email</label>
                <input type="email" id="email" name="email" <% if(request.getParameter("email") != null) { %> value=" <%= request.getParameter("email") %>"  <%}%> class="form-control" placeholder="Email" oninvalid="this.setCustomValidity('Veuillez entrer votre email')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            
            <div>
                <label for="postalcode">Code postal</label>
                <input type="text" id="postalcode" name="postalcode" <% if(request.getParameter("postalcode") != null) { %> value=" <%= request.getParameter("postalcode") %>"  <%}%> class="form-control" placeholder="Code postal" maxlength="5" oninvalid="this.setCustomValidity('Veuillez entrer 5 chiffres')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            
            <div>
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" <% if(request.getParameter("password") != null) { %> value=" <%= request.getParameter("password") %>"  <%}%> placeholder="Mot de passe" class="form-control" oninvalid="this.setCustomValidity('Veuillez entrer votre mot de passe')" 
onchange="this.setCustomValidity('')" required/>
            </div>
            
            
                
            <div>
                <button type="submit" class="btn btn-lg btn-primary btn-block"  >S'enregistrer</button>
            </div>
        </form>
                    

       </div>
                
<footer>
<jsp:include page="../include/footer.jspf" />
</footer>
