<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.co.csj.service.service.publicacionesLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.publicaciones"%>
<%@page import="com.co.csj.service.service.planificacionLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.planificacion"%>
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
		planificacion ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		publicaciones publicacion = publicacionesLocalServiceUtil.getPorEstadoUsuario(usuario.getNumeroDocumento(), ano.getAnhio(), "PUBLICADO");
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

<portlet:actionURL var="solicitarPublicacion" name="solicitarPublicacion"></portlet:actionURL>
<liferay-ui:error key="yaTieneSolicitud" message="Ya posee una solicitud de publicación en espera"/>
<liferay-ui:error key="noGeneroSolicitud" message="Error generando la solicitud de publicación"/>
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
		<form action="<%=solicitarPublicacion %>" method="post">
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
					<h2>Publicar Información</h2>
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
					</div>
					<div class="col-md-8 col-md-offset-2">
						<table class="table table-bordered">
					    	<tr>
					        	<th style="text-align: center; vertical-align: middle;" >DESPACHO Y CARGO:</th>
					        	<td style="text-align: center; vertical-align: middle;">
					        		<% if(usuario.getDespacho().isEmpty() && usuario.getCargo().isEmpty()){ %>
					        			<i class="fa fa-ban" style="font-size:48px;color:red;"></i>
					        			<input type="text" style="display: none;" name="validacionDespacho" id="validacionDespacho" required="required" >
					        		<% }else{ %>
					        			<i class="fa fa-check" style="font-size:48px;color:green;"></i>
					        			<input type="text" style="display: none;" name="validacionDespacho" id="validacionDespacho" value="true" required="required">
					        		<% } %>
					        	</td>
					      	</tr>
					      	<tr>
					        	<th style="text-align: center; vertical-align: middle;" >HOJA DE VIDA:</th>
					        	<td style="text-align: center; vertical-align: middle;">
					        		<% if(usuario.getArchivo_hoja_vida().isEmpty()){ %>
					        			<i class="fa fa-ban" style="font-size:48px;color:red;"></i>
					        			<input type="text" style="display: none;" name="validacionHoja" id="validacionHoja" required="required">
					        		<% }else{ %>
					        			<i class="fa fa-check" style="font-size:48px;color:green;"></i>
					        			<input type="text" style="display: none;" name="validacionHoja" id="validacionHoja" value="true" required="required">
					        		<% } %>
					        	</td>
					      	</tr>
					      	<tr>
					        	<th style="text-align: center; vertical-align: middle;" >DECLARACIÓN DE RENTA:</th>
					        	<td style="text-align: center; vertical-align: middle;">
					        		<% if(usuario.getArchivo_declaracion_renta().isEmpty()){ %>
					        			<i class="fa fa-ban" style="font-size:48px;color:red;"></i>
					        			<input type="text" style="display: none;" name="validacionRenta" id="validacionRenta" required="required">
					        		<% }else{ %>
					        			<i class="fa fa-check" style="font-size:48px;color:green;"></i>
					        			<input type="text" style="display: none;" name="validacionRenta" id="validacionRenta" value="true" required="required">
					        		<% } %>
					        	</td>
					      	</tr>
					      	<tr>
					        	<th style="text-align: center; vertical-align: middle;" >FORMULARIO DE BIENES:</th>
					        	<td style="text-align: center; vertical-align: middle;">
					        		<% if(usuario.getArchivo_formulario_bienes().isEmpty()){ %>
					        			<i class="fa fa-ban" style="font-size:48px;color:red;"></i>
					        			<input type="text" style="display: none;" name="validacionBienes" id="validacionBienes" required="required">
					        		<% }else{ %>
					        			<i class="fa fa-check" style="font-size:48px;color:green;"></i>
					        			<input type="text" style="display: none;" name="validacionBienes" id="validacionBienes" value="true" required="required">
					        		<% } %>
					        	</td>
					      	</tr>
						</table>
						<br>
						<div class="row">
							<div class="col-md-12 text-center">
								<label class="switch">
									<% if(usuario.getRetirado().equalsIgnoreCase("true")){ %>
								  		<input type="checkbox" name="retiro" value="true" checked="checked" >
								  	<% }else{ %>
								  		<input type="checkbox" name="retiro" value="true" >
								  	<% } %>
								  	<span class="checkSlider round"></span>
								</label>
								<% if(usuario.getRetirado().equalsIgnoreCase("true")){ %>
								  		<label id="retiro" style="color: red;">Retirado de la coorporación</label>
								  	<% }else{ %>
								  		<label id="retiro" style="color: green;">Retirarme de la coorporación</label>
								  	<% } %>
  								
							</div>
						</div>
						<br>
						<div class="row text-center">
							<% if(publicacion!=null){ %>
								<button class="btn" value="Guardar" type="submit" onclick="validar()">Actualizar información publicada</button>
							<% }else{ %>
								<button class="btn" value="Guardar" type="submit" onclick="validar()">Publicar información</button>
							<% } %>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script>
$('#solicitarPublicacion').addClass("active");

function validar(){
	var validar1 = document.getElementById('validacionDespacho').value;
	var validar2 = document.getElementById('validacionHoja').value;
	var validar3 = document.getElementById('validacionRenta').value;
	var validar4 = document.getElementById('validacionBienes').value;
	
	
	if(validar1!='true'){
		alert('Falta seleccionar el despacho del funcionario');
	}
	if(validar2!='true'){
		alert('Falta generar la hoja de vida del funcionario');
	}
	if(validar3!='true'){
		alert('Falta cargar el archivo de declaración de renta');
	}
	if(validar4!='true'){
		alert('Falta cargar el archivo de formulario de bienes');
	}
}

</script>
<% }else{ %>
<script type="text/javascript">
$(document).ready( function(){
	window.location.href = '<%=home%>';
});
</script>
<% } %>