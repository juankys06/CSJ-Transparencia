<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.List"%>
<%@ include file="/html/init.jsp"%>

<%
	//List<modeloBasico> tipoDocumento = consultas.getTipoDocumento();
	List<Role> roles = user.getRoles();
	boolean acceso = false;
	for(Role r : roles){
		if(r.getName().equalsIgnoreCase("ley de transparencia"))
			acceso=true;
	}
	if(acceso){
%>

<portlet:actionURL var="acceder" name="acceder"></portlet:actionURL>

<liferay-ui:error key="datosInvalidos" message="Los datos suministrados no coinciden con los guardados en nuestra base de datos"></liferay-ui:error>
<liferay-ui:error key="noRegistroEditor" message="El usuario en sesión no posee ningún registro en la aplicación"></liferay-ui:error>
<liferay-ui:error key="datosInvalidosUsuario" message="Los datos suministrados no coinciden con los datos del usuario en sesión"></liferay-ui:error>
<liferay-ui:error key="noRegistro" message="Ocurrió un problema durante el registro favor intentar nuevamente"></liferay-ui:error>
<liferay-ui:success key="registro" message="El correo electrónico se registró correctamente en breve recibirá un email con la información para el acceso al aplicativo"></liferay-ui:success>

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
	<div class="row">
		<div class="col-md-12 text-center">
			<h4 class="textCuston">Datos del Funcionario</h4>
		</div>
	</div>
	<br>
	<div class="container">
		<form class="form-horizontal" action="<%=acceder %>" method="post" >
			<div class="form-group">
	    		<label for="tipoDocumento" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">Tipo Documento</label>
	    		<div class="col-md-4">
	      			<select class="select-option anchoCompleto" name="tipoDocumento" id="tipoDocumento" required="required">
	      				<option value="">Seleccione un tipo de documento</option>
	      				<option value="1">Cédula de Ciudadanía</option>
	      				<option value="2">Cédula de Extranjería</option>
	      				<option value="3">Pasaporte</option>
	      			</select>
	    		</div>
	  		</div>	
	  		<div class="form-group">
	    		<label for="numeroDocumento" class="col-md-3 col-md-offset-2 control-label textCuston labelCuston">Número de Documento</label>
	    		<div class="col-md-4">
	      			<input type="text" class="select-option anchoCompleto" name="numeroDocumento" id="numeroDocumento" pattern="\d*" placeholder="123456789" style="max-width: 100% !important;" required="required">
	    		</div>
	  		</div>
	  		<div class="form-group">
		    	<div class="col-md-offset-5 col-md-2 text-center">
		      		<button type="submit" class="btn">Entrar</button>
		    	</div>
		  	</div>
		</form>
	</div>
</div>
<% }else{ %>
<liferay-ui:error key="noRegistro" message="Ocurrió un problema durante el registro favor intentar nuevamente"></liferay-ui:error>
<liferay-ui:success key="registro" message="El correo electrónico se registró correctamente en breve recibirá un email con la información para el acceso al aplicativo"></liferay-ui:success>

<portlet:renderURL var="registro">
	<portlet:param name="mvcPath" value="/html/formulario_publico/registrar.jsp"/>
</portlet:renderURL>
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
	<% if(!user.getDefaultUser()){ %>
		<div class="row">
			<div class="col-md-12 text-center">
				<h4 class="textCuston">El usuario que esta utilizando no posee permisos para el aplicativo<br>Favor inicie sesión en el portal con su usuario para tener acceso al aplicativo<br>o<br>hacer clic en registrar correo</h4>
			</div>
		</div>
		<br>
		<br>
		<div class="container">
			<div class="form-group">
		    	<div class="col-md-offset-5 col-md-2 text-center">
		      		<a class="btn" style="background: #19325b; color: white; border-radius: 0;" href="<%= registro%>">Registrar Correo</a>
		    	</div>
		  	</div>
		</div>
	<% }else{ %>
		<div class="row">
			<div class="col-md-12 text-center">
				<h4 class="textCuston">Favor inicie sesión en el portal con su usuario para acceder al aplicativo<br>de no poseer un usuario por favor hacer clic en registrar correo</h4>
			</div>
		</div>
		<br>
		<br>
		<div class="container">
			<div class="form-group">
		    	<div class="col-md-offset-5 col-md-2 text-center">
		      		<a class="btn" style="background: #19325b; color: white; border-radius: 0;" href="https://www.ramajudicial.gov.co/c/portal/login">Iniciar Sesión</a>
		    	</div>
		  	</div>
		  	<br>
		  	<br>
			<div class="form-group">
		    	<div class="col-md-offset-5 col-md-2 text-center">
		      		<a class="btn" style="background: #19325b; color: white; border-radius: 0;" href="<%= registro%>">Registrar Correo</a>
		    	</div>
		  	</div>
		</div>
	<% } %>
</div>
<% } %>