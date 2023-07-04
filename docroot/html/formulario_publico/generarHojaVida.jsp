<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactory"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
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
		JSONObject datos_personales = JSONFactoryUtil.createJSONObject();
		JSONObject tiempo_experiencia = JSONFactoryUtil.createJSONObject();
		JSONObject conflicto_intereces = JSONFactoryUtil.createJSONObject();
		if( !usuario.getDatos_personales().isEmpty() )
			datos_personales = JSONFactoryUtil.createJSONObject(usuario.getDatos_personales());
		if( !usuario.getTiempo_experiencia().isEmpty() )
			tiempo_experiencia = JSONFactoryUtil.createJSONObject(usuario.getTiempo_experiencia());
		if( !usuario.getConflicto_intereses().isEmpty() )
			conflicto_intereces = JSONFactoryUtil.createJSONObject(usuario.getConflicto_intereses());
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
%>

<portlet:actionURL var="generarHojaVida" name="generarHojaVida"></portlet:actionURL>

<liferay-ui:success key="generoHojaVida" message="Su hoja de vida se ha generado exitosamente"></liferay-ui:success>
<liferay-ui:error key="noGeneroHojaVida" message="Error generando su hoja de vida"></liferay-ui:error>

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
	<div style="display: inline-block; vertical-align: top; width: 17%; min-height: 430px">
		<jsp:include page="/html/formulario_publico/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 82%;">
		<form action="<%= generarHojaVida %>" method="post"  enctype="multipart/form-data">
			<div class="content-fliud">
				<div class="row text-center">
					<h2>Generar Hoja de Vida</h2>
				</div>
				<br>
				<div class="col-md-offset-2 col-md-8 text-center">
					<h4>Porcentaje de hoja de vida completado</h4>
				</div>
				<% String p = String.valueOf(porcentaje); %>
				<div class="col-md-offset-2 col-md-8">
					<div class="progress">
						<div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:<%=p%>%">
					    	<%=p%>% Completado
						</div>
					</div>
				</div>
				<br>
				<br>
				<div class="col-md-offset-2 col-md-8">
					<%
						if(!usuario.getArchivo_hoja_vida().isEmpty()){
					%>
					<div class="row">
						<div class="form-group text-center col-md-offset-2 col-md-8">
							<label for="archivoHV">ARCHIVO ACTUAL DE HOJA DE VIDA</label>
							<portlet:resourceURL var="ver">
								<portlet:param name="pagina" value="verificarArchivo"/>
								<portlet:param name="ruta" value="<%=usuario.getArchivo_hoja_vida()%>"/>
							</portlet:resourceURL>
							<a target="_blank" href="<%=ver %>">
								Descargar Archivo
							</a>
						</div>
					</div>
					<br>
					<% } %>
					<div class="row">
						<% if(!datos_personales.getString("sexo").isEmpty() && !conflicto_intereces.getString("respuesta").isEmpty() && (tiempo_experiencia.getInt("anosTotales")>0 || tiempo_experiencia.getInt("mesesTotales")>0)){ %>
							<div class="col-md-12 text-center">
								<button class="btn" type="submit">Generar Hoja de Vida</button>
							</div>
						<% }else{ %>
							<div class="col-md-12">
								<% if(datos_personales.getString("sexo").isEmpty()){ %>
									<strong style="color: red;">- Debe diligenciar la sección de datos personales (Por lo menos el sexo y la nacionalidad)</strong><br>
								<% } if(tiempo_experiencia.getInt("anosTotales") + tiempo_experiencia.getInt("mesesTotales")==0){ %>
									<strong style="color: red;">- Debe diligenciar la sección de tiempo total de experiencia</strong><br>
								<% } if(conflicto_intereces.getString("respuesta").isEmpty()){ %>
									<strong style="color: red;">- Debe diligenciar la información de cónyuge y/o compañero(a) permanente en la sección de conflicto de intereses</strong>
								<% } %>
							</div>
						<% } %>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script>
$('#generarHojaVida').addClass("active");

</script>
<% }else{ %>
<script type="text/javascript">
$(document).ready( function(){
	window.location.href = '<%=home%>';
});
</script>
<% } %>