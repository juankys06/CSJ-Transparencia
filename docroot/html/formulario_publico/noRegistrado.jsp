<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.List"%>
<%@ include file="/html/init.jsp"%>

<portlet:actionURL var="registrarUsuarioNoRegistrado" name="registrarUsuarioNoRegistrado"></portlet:actionURL>

<portlet:renderURL var="inicio">
	<portlet:param name="mvcPath" value="/html/formulario_publico/funcionario.jsp"/>
</portlet:renderURL>

<%
	String correo = (String) renderRequest.getAttribute("correo");
	String numeroDocumento = (String) renderRequest.getAttribute("numeroDocumento");
	String tipoDocumentor = (String) renderRequest.getAttribute("tipoDocumento");
	
	if(correo==null)
		correo="";
	if(numeroDocumento==null)
		numeroDocumento="";
	
 	List<modeloBasico> tipoDocumento = consultas.getTipoDocumento();
%>

<liferay-ui:error key="numeroDocumentoInvalido" message="El numero de documento no puede ser editado por el correo electr�nico suministrado"></liferay-ui:error>

<liferay-ui:error key="noCorreo" message="El correo suministrado no se encuentra almacenado en nuestra base de datos"></liferay-ui:error>
<liferay-ui:error key="noCorreo" message="Complete los datos solicitados para porder registrar el correo electr�nico"></liferay-ui:error>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12 text-center">
			<h1 class="textCuston">Ley de Transparencia</h1>
			<h2 class="textCuston">Formulario P�blico</h2>
			<p>Dando cumplimiento a lo establecido en la Ley 1581 de 2012 y el Decreto 1377 de 2013, la Rama Judicial garantiza la seguridad y confidencialidad de la informaci�n suministrada con la finalidad de analizar y generar datos de car�cter estad�stico y promoci�n de la participaci�n ciudadana. Al diligenciar este formulario se entiende que acepta los t�rminos y condiciones de la Pol�tica de Privacidad y T�rminos de Uso y autoriza el uso de sus datos personales</p>
			<br>
			<p>Los Magistrados titulares, Magistrados Auxiliares, Jueces de la Rep�blica, Director Ejecutivo, Directores Seccionales y Unidades T�cnicas deben diligenciar y publicar la informaci�n de la declaraci�n de bienes y rentas, registro de conflicto de intereses y declaraci�n del impuesto sobre la renta y complementarios en el portal web de la Rama Judicial www.ramajudicial.gov.co</p>
		</div>
	</div>
	<br>
	<br>
	<div class="container">
		<form class="form-horizontal" action="<%=registrarUsuarioNoRegistrado %>" method="post" >
			<div class="form-group">
	    		<label for="correo" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">Correo Electr�nico</label>
	    		<div class="col-md-4">
	    			<input class="select-option anchoCompleto" name="correo" id="correo" type="email" required="required" placeholder="ejemplo@cendoj.ramajudicial.gov.co" pattern=".+@cendoj.ramajudicial.gov.co|.+@consejodeestado.gov.co|.+@consejosuperior.ramajudicial.gov.co|.+@corteconstitucional.gov.co|.+@cortesuprema.gov.co|.+@deaj.ramajudicial.gov.co|.+@notificacionesrj.gov.co|.+@ramajudicial.gov.co|.+@cortesuprema.ramajudicial.gov.co|.+@comisiondedisciplina.ramajudicial.gov.co"  style="max-width: 100% !important;" value="<%=correo %>" >
	      			<!-- <input type="email" class="select-option anchoCompleto" name="correo" id="correo" placeholder="ejemplo@cendoj.ramajudicial.gov.co" style="max-width: 100% !important;" required="required"> -->
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="tipoDocumento" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">Tipo Documento</label>
	    		<div class="col-md-4">
	      			<select class="select-option anchoCompleto" name="tipoDocumento" id="tipoDocumento" required="required">
	      				<option value="">Seleccione un tipo de documento</option>
	      				<% for(modeloBasico td : tipoDocumento){ %>
	      					<% if(td.getCodigo().equalsIgnoreCase(tipoDocumentor)){ %>
	      						<option value="<%=td.getCodigo() %>" selected="selected"><%=td.getNombre() %></option>
	      					<% }else{ %>
	      						<option value="<%=td.getCodigo() %>"><%=td.getNombre() %></option>
	      					<% } %>
	      				<%} %>
	      			</select>
	    		</div>
	  		</div>	
	  		<div class="form-group">
	    		<label for="numeroDocumento" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">N�mero Documento</label>
	    		<div class="col-md-4">
	      			<input type="text" class="select-option anchoCompleto" name="numeroDocumento" id="numeroDocumento" pattern="\d*" placeholder="123456789" style="max-width: 100% !important;" required="required" value="<%=numeroDocumento %>">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="nombres" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">Nombres</label>
	    		<div class="col-md-4">
	      			<input type="text" class="select-option anchoCompleto" name="nombres" id="nombres" placeholder="Pedro Pablo" style="max-width: 100% !important;" required="required"">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="apellidos" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">Apellidos</label>
	    		<div class="col-md-4">
	      			<input type="text" class="select-option anchoCompleto" name="apellidos" id="apellidos" placeholder="Perez Perez" style="max-width: 100% !important;" required="required">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="cargo" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">Cargo</label>
	    		<div class="col-md-4">
	      			<input type="text" class="select-option anchoCompleto" name="cargo" id="cargo" placeholder="Juez" style="max-width: 100% !important;" required="required">
	    		</div>
	  		</div>
	  		<br>
	  		<div class="form-group">
		    	<div class="col-md-offset-5 col-md-2 text-center">
		      		<button type="submit" class="btn">Registrar</button>
		    	</div>
		  	</div>
		  	<br>
		  	<br>
		  	<div class="row text-center">
		  		<div class="col-md-offset-5 col-md-2">
		  			<a href="<%=inicio %>">Volver al inicio</a>
		  		</div>
		  	</div>
		</form>
	</div>
</div>