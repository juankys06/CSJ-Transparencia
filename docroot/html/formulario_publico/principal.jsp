<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.co.csj.service.service.publicacionesLocalServiceUtil"%>
<%@page import="com.co.csj.service.service.planificacionLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.publicaciones"%>
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
		String p = String.valueOf(porcentaje);
		
		
%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12 text-center">
			<h1 class="textCuston">Ley de Transparencia</h1>
			<label style="display: none;"><%=usuario.getNumeroDocumento() %></label>
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
		
		<liferay-ui:error key="noGuardoDatosPersonales" message="Error guardando los datos personales" />
		<liferay-ui:success key="guardoDatosPersonales" message="Se guardaron o actualizaron los datos personales" />
		<liferay-ui:error key="noGuardoDespacho" message="Error guardando el despacho y/o cargo del usuario" />
		<liferay-ui:success key="guardoDespacho" message="Se guardo o actualizo el despacho y/o cargo del usuario" />
		<liferay-ui:error key="noGuardoFormacionAcademica" message="Error guardando la formación académica" />
		<liferay-ui:success key="guardoFormacionAcademica" message="Se guardo o actualizo la formación académica" />
		<liferay-ui:error key="noGuardoExperienciaLaboral" message="Error guardando la experiencia laboral" />
		<liferay-ui:success key="guardoExperienciaLaboral" message="Se guardo o actualizo la experiencia laboral" />
		<liferay-ui:error key="noGuardoTiempoExperiencia" message="Error guardando el tiempo experiencia laboral" />
		<liferay-ui:success key="guardoTiempoExperiencia" message="Se guardo o actualizo el tiempo experiencia laboral" />
		<liferay-ui:error key="noGuardoDeclaracionRenta" message="Error guardando el archivo de declaración de renta" />
		<liferay-ui:success key="guardoDeclaracionRenta" message="Se guardo o actualizo el archivo de declaración de renta" />
		<liferay-ui:error key="noGuardoFormularioBienes" message="Error guardando el archivo de formulario de bienes" />
		<liferay-ui:success key="guardoFormularioBienes" message="Se guardo o actualizo el archivo de formulario de bienes" />
		<liferay-ui:success key="generoSolicitud" message="Se publicó exitosamente la información" />
		<liferay-ui:success key="guardoBienesRentas" message="Se guardaron o actualizaron los datos de bienes y rentas" />
		<liferay-ui:error key="noGuardoBienesRentas" message="Error guardando los datos de bienes y rentas" />
		<liferay-ui:success key="guardoInformacionComplementaria" message="Se guardo o actualizo los datos de información complementaria" />
		<liferay-ui:error key="noGuardoInformacionComplementaria" message="Error guardando los datos de información complementaria" />
		<liferay-ui:success key="guardoConflicto" message="Se guardo o actualizo los datos de conflicto de intereses" />
		<liferay-ui:error key="noGuardoConflicto" message="Error guardando los datos de conflicto de intereses" />
		
		<div class="row">
			<div class="col-md-12">
				<fieldset class="scheduler-border">
				   	<legend  class="scheduler-border">Tu publicación activa para el año <%=ano.getAnhio() %></legend>
				   	<div class="row">
				   		<%
				   			if(publicacion!=null){
				   		%>
						   		<div class="col-md-12">
						   			<%
						   				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");						   				
						   			%>
						   			Usted posee información publicada en el despacho: <strong><%= consultas.getNombreDespacho(publicacion.getDespacho_usuario()) %></strong> la misma fue publicada el <strong><%=formato.format(publicacion.getFecha_publicacion()) %></strong>  
						   		</div>
						<%
				   			}else{
						%>
								<div class="col-md-12 text-center">
									No posee publicación de información
								</div>
						<%
				   			}
						%>
				   	</div>
				</fieldset>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<fieldset class="scheduler-border">
				   	<legend  class="scheduler-border">Información de interés</legend>
				   	<div class="row">
				   		<div class="col-md-12">
							<ul>
								<li>
									Si no ha realizado la publicación de información: 
								</li>
								<ol>
									<li>
										Diligenciar sus datos personales en el apartado (Datos personales)
									</li>
									<li>
										Verificar el despacho al que pertenece y el cargo que desempeña en el apartado (Despacho asignado y cargo)
									</li>
									<li>
										Diligenciar los datos de su hoja de vida en los siguientes apartados (Formación académica. Experiencia laboral, Tiempo total de experiencia, Bienes y rentas, Información complementaria y conflicto de intereses)
									</li>
									<li>
										Generar la hoja de vida
									</li>
									<li>
										Cargar el archivo de declaración de renta
									</li>
									<li>
										Cargar el archivo de formulario de bienes
									</li>
									<li>
										Solicitar la publicación de la información 
									</li>
								</ol>
								<li>
									Si posee información publicada y desea realizar una actualización de su información:
								</li>
								<ol>
									<li>
										En caso de realizar un cambio en su hoja de vida
									</li>
									<ul>
										<li>
											Realizar el cambio deseado en la sección de la hoja de vida
										</li>
										<li>
											Generar la hoja de vida nuevamente
										</li>
										<li>
											Solicitar la publicación de la información nuevamente
										</li>
									</ul>
									<li>
										En caso de actualizar el archivo de declaración de renta
									</li>
									<ul>
										<li>
											Subir el archivo que desea actualizar en la sección de declaración de renta
										</li>
										<li>
											Solicitar la publicación de la información nuevamente
										</li>
									</ul>
									<li>
										En caso de actualizar el archivo de formulario de bienes
									</li>
									<ul>
										<li>
											Subir el archivo que desea actualizar en la sección de formulario de bienes
										</li>
										<li>
											Solicitar la publicación de la información nuevamente
										</li>
									</ul>
									<li>
										En caso de actualizar el despacho judicial al que pertenece o el cargo que desempeña en el mismo
									</li>
									<ul>
										<li>
											Ingresar al apartado de (Despacho asignado y cargo) y actualizar el despacho o el cargo según lo necesite
										</li>
										<li>
											Solicitar la publicación de la información nuevamente
										</li>
									</ul>
								</ol>
								<li>
									En caso de retiro de la corporación:
								</li>
								<ol>
									<li>
										Realizar la actualización de la información que desee realizar
									</li>
									<li>
										Solicitar la publicación de la información, pero esta vez marcando el check list de retiro de la corporación 
									</li>
								</ol>
						   	</ul>	
						</div>
				   	</div>
				</fieldset>
			</div>
		</div>
		
	</div>
</div>
<% }else{ %>
<script type="text/javascript">
$(document).ready( function(){
	window.location.href = '<%=home%>';
});
</script>
<% } %>