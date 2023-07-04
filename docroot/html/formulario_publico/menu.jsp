<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%-- <portlet:renderURL var="datosPersonales">
	<portlet:param name="mvcPath" value="/html/formulario_publico/datosPersonales.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="declaracionRenta">
	<portlet:param name="mvcPath" value="/html/formulario_publico/declaracionRenta.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="formularioBienes">
	<portlet:param name="mvcPath" value="/html/formulario_publico/formularioBienes.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="despachoAsignado">
	<portlet:param name="mvcPath" value="/html/formulario_publico/despachoAsignado.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="tiempoExperiencia">
	<portlet:param name="mvcPath" value="/html/formulario_publico/tiempoExperiencia.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="firmaServidorPublico">
	<portlet:param name="mvcPath" value="/html/formulario_publico/firmaServidorPublico.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="formacionAcademica">
	<portlet:param name="mvcPath" value="/html/formulario_publico/formacionAcademica.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="experienciaLaboral">
	<portlet:param name="mvcPath" value="/html/formulario_publico/experienciaLaboral.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="generarHojaVida">
	<portlet:param name="mvcPath" value="/html/formulario_publico/generarHojaVida.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="solicitarPublicacion">
	<portlet:param name="mvcPath" value="/html/formulario_publico/solicitarPublicacion.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="inicio">
	<portlet:param name="mvcPath" value="/html/formulario_publico/principal.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="bienesYRentas">
	<portlet:param name="mvcPath" value="/html/formulario_publico/bienesYRentas.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="InformacionComplementaria">
	<portlet:param name="mvcPath" value="/html/formulario_publico/InformacionComplementaria.jsp"/>
</portlet:renderURL> --%>

<portlet:actionURL var="datosPersonales" name="irDatosPersonales" />

<portlet:actionURL var="declaracionRenta" name="irDeclaracionRenta" />

<portlet:actionURL var="formularioBienes" name="irFormularioBienes" />

<portlet:actionURL var="despachoAsignado" name="irDespachoAsignado" />

<portlet:actionURL var="tiempoExperiencia" name="irTiempoExperiencia" />

<portlet:actionURL var="formacionAcademica" name="irFormacionAcademica" />

<portlet:actionURL var="experienciaLaboral" name="irExperienciaLaboral" />

<portlet:actionURL var="generarHojaVida" name="irGenerarHojaVida" />

<portlet:actionURL var="solicitarPublicacion" name="irSolicitarPublicacion" />

<portlet:actionURL var="inicio" name="irInicio" />

<portlet:actionURL var="bienesYRentas" name="irBienesYRentas" />

<portlet:actionURL var="InformacionComplementaria" name="irInformacionComplementaria" />

<portlet:renderURL var="conflictoIntereses">
	<portlet:param name="mvcPath" value="/html/formulario_publico/ConflictosIntereses.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="salir" name="salir"></portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="panel-group">
			<div class="panel panel-default" style="border-radius : 0;">
		    	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a href="<%=inicio %>" >Inicio</a>
		        	</h4>
		      	</div>
		    	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse0" >Funcionario</a>
		        	</h4>
		      	</div>
		      	<div id="collapse0" class="panel-collapse collapse in">
		        	<ul class="list-group" style="margin: 0">
		        		<li id="datosPersonales" class="list-group-item"><a href="<%=datosPersonales %>">Datos Personales</a></li>
						<li id="despachoAsignado" class="list-group-item"><a href="<%= despachoAsignado %>">Despacho Asignado y Cargo</a></li>
						<%-- <li id="solicitarPublicacion" class="list-group-item"><a href="<%= solicitarPublicacion %>">Publicar Información</a></li> --%>
		        	</ul>
		      	</div>
		    	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse1" >Hoja de vida</a>
		        	</h4>
		      	</div>
		      	<div id="collapse1" class="panel-collapse collapse in">
		        	<ul class="list-group" style="margin: 0">
						<li id="formacionAcademica" class="list-group-item"><a href="<%=formacionAcademica %>">Formación Académica</a></li>
						<li id="experienciaLaboral" class="list-group-item"><a href="<%=experienciaLaboral %>">Experiencia Laboral</a></li>
						<li id="tiempoExperiencia" class="list-group-item"><a href="<%= tiempoExperiencia%>">Tiempo Total de Experiencia</a></li>
						<li id="bienesYRentas" class="list-group-item"><a href="<%= bienesYRentas%>">Bienes y Rentas</a></li>
						<li id="informacionComplementaria" class="list-group-item"><a href="<%= InformacionComplementaria%>">Información Complementaria</a></li>
						<li id="conflictoIntereses" class="list-group-item"><a href="<%= conflictoIntereses%>">Conflicto de intereses</a></li>
						<li id="generarHojaVida" class="list-group-item"><a href="<%= generarHojaVida%>">Generar Hoja de Vida</a></li>
		        	</ul>
		      	</div>
		      	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse2">Declaración de renta</a>
		        	</h4>
		      	</div>
		      	<div id="collapse2" class="panel-collapse collapse in">
		        	<ul class="list-group" style="margin: 0">
		        		<li id="archivoDeclaRenta" class="list-group-item"><a href="<%=declaracionRenta %>">Cargar Archivo</a></li>
		        	</ul>
		      	</div>
		      	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse3">Formulario de bienes</a>
		        	</h4>
		      	</div>
		      	<div id="collapse3" class="panel-collapse collapse in">
		        	<ul class="list-group" style="margin: 0">
		        		<li  id="archivoFormuBienes" class="list-group-item"><a href="<%=formularioBienes %>">Cargar Archivo</a></li>
		        	</ul>
		      	</div>
		      	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a data-toggle="collapse" href="#collapse4">Publicar Información</a>
		        	</h4>
		      	</div>
		      	<div id="collapse4" class="panel-collapse collapse in">
		        	<ul class="list-group" style="margin: 0">
		        		<li id="solicitarPublicacion" class="list-group-item"><a href="<%= solicitarPublicacion %>">Solicitar publicación</a></li>
		        	</ul>
		      	</div>
		      	<div class="panel-heading">
		        	<h4 class="panel-title">
		          		<a href="<%= salir%>">Salir</a>
		        	</h4>
		      	</div>
		 	</div>
		</div>
	</div>
</div>