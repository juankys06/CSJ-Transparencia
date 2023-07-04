<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:renderURL var="solicitudesPendientes">
	<portlet:param name="mvcPath" value="/html/administracion/solicitudesPendientes.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="solicitudesAprobadas">
	<portlet:param name="mvcPath" value="/html/administracion/solicitudesAprobadas.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="solicitudesDenegadas">
	<portlet:param name="mvcPath" value="/html/administracion/solicitudesDenegadas.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="planificacion">
	<portlet:param name="mvcPath" value="/html/administracion/anoVigencia.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="auditoria">
	<portlet:param name="mvcPath" value="/html/administracion/auditoria.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="reporteDespachoSF">
	<portlet:param name="mvcPath" value="/html/administracion/reporteDespachoSF.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="reportePublicaciones">
	<portlet:param name="mvcPath" value="/html/administracion/reportePublicaciones.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="funcionarios">
	<portlet:param name="mvcPath" value="/html/administracion/funcionarios.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="funcionariosR">
	<portlet:param name="mvcPath" value="/html/administracion/funcionariosRegistrados.jsp"/>
</portlet:renderURL>


<div class="row">
	<div class="col-md-12">
		<div class="panel-group">
			<div class="panel panel-default" style="border-radius : 0;">
		    	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse0" >Funcionario</a>
		        	</h4>
		      	</div>
		      	<div id="collapse0" class="panel-collapse collapse">
		        	<ul class="list-group" style="margin: 0">
		        		<li id="funcionarios" class="list-group-item"><a href="<%= funcionarios%>">Funcionarios sin registar</a></li>
		        		<li id="funcionariosR" class="list-group-item"><a href="<%= funcionariosR%>">Funcionarios registardos</a></li>
		        	</ul>
		      	</div>
		      	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse1" >Publicaciones</a>
		        	</h4>
		      	</div>
		      	<div id="collapse1" class="panel-collapse collapse">
		        	<ul class="list-group" style="margin: 0">
		        		<li id="solicitudesAprobadas" class="list-group-item"><a href="<%= solicitudesAprobadas %>">Publicaciones Activas</a></li>
						<%-- <li id="solicitudesPendientes" class="list-group-item"><a href="<%= solicitudesPendientes %>">Solicitudes Pendientes</a></li>
						<li id="solicitudesDenegadas" class="list-group-item"><a href="<%= solicitudesDenegadas %>">Solicitudes Negadas</a></li> --%>
		        	</ul>
		      	</div>
		      	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse2" >Planificación</a>
		        	</h4>
		      	</div>
		      	<div id="collapse2" class="panel-collapse collapse">
		        	<ul class="list-group" style="margin: 0">
		        		<li id="anoVigencia" class="list-group-item"><a href="<%= planificacion %>">Año de Vigencia</a></li>
		        	</ul>
		      	</div>
		    	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse3" >Reportes</a>
		        	</h4>
		      	</div>
		      	<div id="collapse3" class="panel-collapse collapse">
		        	<ul class="list-group" style="margin: 0">
		        		<li id="reporteDespachoSF" class="list-group-item"><a href="<%= reporteDespachoSF %>" >Despachos sin Funcionarios</a></li>
		        		<li id="reportePublicacionesA" class="list-group-item"><a href="<%= reportePublicaciones %>" >Publicaciones Activas</a></li>
		        	</ul>
		      	</div>
		      	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse4" >Auditoria</a>
		        	</h4>
		      	</div>
		      	<div id="collapse4" class="panel-collapse collapse">
		        	<ul class="list-group" style="margin: 0">
		        		<li id="auditoria" class="list-group-item"><a href="<%= auditoria %>" >Auditoria</a></li>
		        	</ul>
		      	</div>
		 	</div>
		</div>
	</div>
</div>