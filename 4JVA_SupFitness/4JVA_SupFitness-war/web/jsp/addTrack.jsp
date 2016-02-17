<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <jsp:include page="../include/header.jsp" />
</header>

 <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Ajouter une track</h1>
        <form action="AddTrack" method="POST">
            <div>
                <input type="hidden" name="userId" value="${requestScope.userId}"/>
                <input type="hidden" name="userId" value="${requestScope.raceId}"/>
                <label for="latitude">Latitude</label>
                <input type="text" id="latitude" name="latitude" class="form-control" placeholder="Latitude"/>
            </div>
            <div>
                <label for="longitude">Longitude</label>
                <input type="text" id="longitude" name="longitude" class="form-control" placeholder="Longitude"/>
            </div>
            <div>
                <label for="speed">Speed</label>
                <input type="text" id="speed" name="speed" class="form-control" placeholder="Speed"/>
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
              
   </div>
 </div>           
<footer>
        <jsp:include page="../include/footer.jspf" />
</footer>