<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.usuario_data"%>
<%@ include file="/html/init.jsp"%>

<portlet:renderURL var="home" >
	<portlet:param name="mvcPath" value="/html/formulario_publico/funcionario.jsp"/>
</portlet:renderURL>
<%
	editores editor = null;
	try{
		editor = editoresLocalServiceUtil.getPorUserid(String.valueOf(user.getUserId()));
	} catch (PortalException e) {}
	if(editor!=null){
		//String usuarioId = (String) renderRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		double porcentaje = 0.0;
		porcentaje+=usuario.getPorcentaje_dp();
		porcentaje+=usuario.getPorcentaje_fa();
		porcentaje+=usuario.getPorcentaje_el();
		porcentaje+=usuario.getPorcentaje_te();
		porcentaje+=usuario.getPorcentaje_br();
		porcentaje+=usuario.getPorcentaje_ic();
		porcentaje+=usuario.getPorcentaje_ci();
		porcentaje = porcentaje * Math.pow(10, 2);
		porcentaje = Math.round(porcentaje);
		porcentaje = porcentaje/Math.pow(10, 2);
		String p = String.valueOf(porcentaje);
%>

<portlet:actionURL var="guardarArchivoDR" name="guardarArchivoDR"></portlet:actionURL>

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
	<div style="display: inline-block; vertical-align: top; width: 17%; min-height: 430px">
		<jsp:include page="/html/formulario_publico/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 82%;">
		<form action="<%=guardarArchivoDR %>" method="post"  enctype="multipart/form-data">
			<div class="content-fliud">
				<div class="row">
					<div class="col-md-offset-6 col-md-6">
						<div class="form-group">
							<label for="barra">Porcentaje de hoja de vida completado</label>
							<div id="barra">
								<div class="progress" style="margin-bottom: auto;">
									<div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:<%=p%>%">
								    	<%=p%>% Completado
									</div>
								</div>
							</div>
							<label style="font-size: 12px;">No necesariamente debe completar el 100% para generar su hoja de vida</label>
						</div>
					</div>				
				</div>
				<div class="row text-center">
					<h2>Declaraci�n de Renta</h2>
				</div>
				<% if(!usuario.getArchivo_declaracion_renta().equals("")){
				%>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group text-center col-md-offset-2 col-md-8">
							<label for="archivoDR">ARCHIVO ACTUAL DE DECLARACI�N DE RENTA</label>
							<portlet:resourceURL var="ver">
								<portlet:param name="pagina" value="declaracionRenta"/>
								<portlet:param name="ruta" value="<%=usuario.getArchivo_declaracion_renta()%>"/>
							</portlet:resourceURL>
							<a target="_blank" href="<%=ver %>">
								Descargar Archivo
							</a>
						</div>
					</div>
				</div>
				<% } %>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group text-center col-md-offset-2 col-md-8">
							<label for="archivoDR">SELECIONE SU ARCHIVO DE DECLARACI�N DE RENTA EN FORMATO PDF</label>
							<input type="file" accept="application/pdf" class="anchoCompleto" style="max-width: 100% !important" id="archivoDR" name="archivoDR">
						</div>
					</div>
				</div>
				<% if(!usuario.getArchivo_declaracion_renta().equals("")){
				%>
					<br>
					<div class="row text-center">
						<button class="btn" value="Guardar" type="submit">Actualizar</button>
					</div>
				<% }else{ %>
					<br>
					<div class="row text-center">
						<button class="btn" value="Guardar" type="submit">Guardar</button>
					</div>
				<% } %>
			</div>
		</form>
	</div>
</div>
<script>
$('#archivoDeclaRenta').addClass("active");

</script>
<% }else{ %>
<script type="text/javascript">
$(document).ready( function(){
	window.location.href = '<%=home%>';
});
</script>
<% } %>