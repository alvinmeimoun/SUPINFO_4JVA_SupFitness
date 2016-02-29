<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <jsp:include page="../include/header.jsp" />
</header>
<div class="row bs-docs-header" style="height:100px;">
    <p><h2 class="" style="font-size:20px; margin: 10px; color:white;">Ajouter un checkpoint</h2></p></br>
</div>
 <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
        <form action="AddTrack" method="POST">
            <div>
                <input type="hidden" name="userId" value="${requestScope.userId}"/>
                <input type="hidden" name="raceId" value="${requestScope.raceId}"/>
                <label for="latitude">Latitude</label>
                <input type="text" pattern="[0-9]+([\.,][0-9]+)?" id="latitude" name="latitude" class="form-control" placeholder="Latitude" required="true"/>
            </div>
            <div>
                <label for="longitude">Longitude</label>
                <input type="text" pattern="[0-9]+([\.,][0-9]+)?" id="longitude" name="longitude" class="form-control" placeholder="Longitude" required="true"/>
            </div>
            <div>
                <label for="speed">Speed</label>
                <input type="text"  pattern="[0-9]+([\.,][0-9]+)?" id="speed" name="speed" class="form-control" placeholder="Speed" required="true"/>
            </div>
            <div>
                <label for="startDate">Date</label>
                <input type="datetime-local" id="startDate" name="startDate" class="form-control" required="true"/>
            </div>
                <br>
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