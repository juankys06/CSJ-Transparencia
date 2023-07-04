<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.List"%>
<%@ include file="/html/init.jsp"%>

<portlet:actionURL var="restablecerUsuario" name="restablecerUsuario"></portlet:actionURL>

<portlet:renderURL var="inicio">
	<portlet:param name="mvcPath" value="/html/formulario_publico/view.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="registro">
	<portlet:param name="mvcPath" value="/html/formulario_publico/registrar.jsp"/>
</portlet:renderURL>

<liferay-ui:error key="noRegistrado" message="El correo suministrado no se encuentra registrado"></liferay-ui:error>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12 text-center">
			<h1 class="textCuston">Ley de Transparencia</h1>
			<h2 class="textCuston">Formulario Público</h2>
			<p>Dando cumplimiento a lo establecido en la Ley 1581 de 2012 y el Decreto 1377 de 2013, la Rama Judicial garantiza la seguridad y confidencialidad de la información suministrada con la finalidad de analizar y generar datos de carácter estadístico y promoción de la participación ciudadana. Al diligenciar este formulario se entiende que acepta los términos y condiciones de la Política de Privacidad y Términos de Uso y autoriza el uso de sus datos personales</p>
			<br>
			<p>Los Magistrados titulares, Magistrados Auxiliares, Jueces de la República, Director Ejecutivo, Directores Seccionales y Unidades Técnicas deben diligenciar y publicar la información de la declaración de bienes y rentas, registro de conflicto de intereses y declaración del impuesto sobre la renta y complementarios en el portal web de la Rama Judicial www.ramajudicial.gov.co</p>
		</div>
	</div>
	<br>
	<br>
	<div class="container">
		<form class="form-horizontal" action="<%=restablecerUsuario %>" method="post" >
			<div class="form-group">
	    		<label for="correo" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">Correo Electrónico</label>
	    		<div class="col-md-4">
	    			<input class="select-option anchoCompleto" name="correo" id="correo" type="email" required="required" placeholder="ejemplo@cendoj.ramajudicial.gov.co" pattern=".+@cendoj.ramajudicial.gov.co|.+@consejodeestado.gov.co|.+@consejosuperior.ramajudicial.gov.co|.+@corteconstitucional.gov.co|.+@cortesuprema.gov.co|.+@cortesuprema.ramajudicial.gov.co|.+@deaj.ramajudicial.gov.co|.+@notificacionesrj.gov.co|.+@ramajudicial.gov.co"  style="max-width: 100% !important;" >
	      			<!-- <input type="email" class="select-option anchoCompleto" name="correo" id="correo" placeholder="ejemplo@cendoj.ramajudicial.gov.co" style="max-width: 100% !important;" required="required"> -->
	    		</div>
	  		</div>
	  		<br>
	  		<div class="form-group">
		    	<div class="col-md-offset-5 col-md-2 text-center">
		      		<button type="submit" class="btn">Restablecer</button>
		    	</div>
		  	</div>
		  	<br>
		  	<br>
		  	<div class="row text-center">
		  		<div class="col-md-offset-3 col-md-3">
		  			<a href="<%=inicio %>">Iniciar Sesión.</a>
		  		</div>
		  		<div class="col-md-3">
		  			<a href="<%=registro %>">Registrar Correo.</a>
		  		</div>
		  	</div>
		</form>
	</div>
</div>