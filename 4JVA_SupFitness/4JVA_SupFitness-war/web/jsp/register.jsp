<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupFitness - Register</title>
    </head>
    <body>
        <form method="POST">
            <div>
                <label for="username">Username</label>
                <input type="text" id="username" name="username" />
            </div>
            <div>
                <label for="firstname">Firstname</label>
                <input type="text" id="firstname" name="firstname" />
            </div>
            <div>
                <label for="lastname">Lastname</label>
                <input type="text" id="lastname" name="lastname" />
            </div>
            
            <div>
                <label for="email">Email</label>
                <input type="text" id="email" name="email" />
            </div>
            
            <div>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" />
            </div>
            
            <div>
                <input type="submit" value="Add" />
            </div>
        </form>
    </body>
</html>
