<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <jsp:include page="../include/header.jsp" />
</header>

 <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Ajouter une race</h1>
        <form action="AddRace" method="POST">
            <div>
                <input type="hidden" name="userId" value="${requestScope.userId}"/>
                <label for="name">Nom de la race</label>
                <input type="text" id="name" name="name" class="form-control" placeholder="Nom de la race"/>
            </div>
            <div>
                <label for="date">Date</label>
                <input type="date" id="startDate" name="startDate" class="form-control" />
            </div>
            <div>
                <button type="submit" class="btn btn-success"  >Enregistrer</button>
            </div>
        </form>
       </div>
            
<footer>
            <jsp:include page="../include/footer.jspf" />
</footer>