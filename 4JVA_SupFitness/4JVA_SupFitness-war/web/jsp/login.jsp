<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupFitness - Login</title>

        <link rel="stylesheet" href="css/libs/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/libs/bootstrap-theme.min.css" type="text/css"/>
        <script src="js/libs/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="css/login.css" type="text/css"/>
    </head>
    <body>
         <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Identifiez-vous pour continuer</h1>
                <div class="account-wall">
                    <img class="profile-img" src="img/supinfo_logo.png"
                         alt=""/>
                    <form method="post" class="form-signin">
                        <input type="text" class="form-control" placeholder="Nom d'utilisateur" name="username"/>
                        <input type="password" class="form-control" placeholder="Mot de passe" name="password"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
                    </form>
                </div>

                <div class="text-center login-message">
<!--                    <div th:if="param.error">
                        <p th:text="login.bad_credentials">Bad credentials</p>
                    </div>
                    <div th:if="param.logout">
                        <p th:text="login.has_logout">You have been logged out</p>
                    </div>-->
                </div>
            </div>
        </div>
    </div>
        
        
<!--        <form method="POST" class="form-signin">
                            <div>
                                <input class="form-control" type="text" name="username" placeholder="Nom d'utilisateur" />
                            </div>
                            <div>
                                <input class="form-control" type="password" name="password" placeholder="Mot de passe" />
                            </div>
                            <div>
                                <button class="btn btn-lg btn-primary btn-block" type="submit"><p>Connexion</p></button>
                            </div>
                        </form>-->
    </body>
</html>
