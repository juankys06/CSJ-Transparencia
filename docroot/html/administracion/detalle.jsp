<%@page import="com.co.csj.service.service.publicacionesLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.usuario_dataClp"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.usuario_data"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.service.service.auditoriaLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.auditoria"%>
<%@page import="com.co.csj.service.model.publicaciones"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/init-panel-control.jsp"%>

<portlet:renderURL var="volver">
	<portlet:param name="mvcPath" value="/html/administracion/auditoria.jsp"/>
</portlet:renderURL>

<%	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
	String id = (String) renderRequest.getAttribute("id");
	auditoria audi = auditoriaLocalServiceUtil.getauditoria(Long.parseLong(id));
	if( audi.getCampo_modifico().equals("Año de Vigencia") ){
%>
<div class="row text-center">
	<h3>Detalle de auditoria</h3>
</div>
<br>
<div class="row">
	<div class="col-md-3">
		<div class="form-group">
			<label>Accion</label>
			<div>
				<%=audi.getAccion() %>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>Campo</label>
			<div>
				<%=audi.getCampo_modifico() %>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>Fecha</label>
			<div>
				<%=formato.format(audi.getFecha()) %>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>Modificado por</label>
			<div>
				<%=audi.getModificado_por() %>
			</div>
		</div>
	</div>
</div>
<br>
<div class="row">
	<div class="col-md-6" style="border-right: 1px solid;">
		<div class="row">
			<div class="col-md-12 text-center">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<%= audi.getLog_anterior() %>
	</div>
	<div class="col-md-6">
		<div class="row">
			<div class="col-md-12 text-center">
				Nuevo
				<br>
				<br>
			</div>
		</div>								
		<%=audi.getLog_nuevo() %>
	</div>
</div>

<% }else{ 
	usuario_data usu = new usuario_dataClp();
	if(!audi.getCedula_funcionario().isEmpty())
		usu = usuario_dataLocalServiceUtil.getusuario_data(audi.getCedula_funcionario());
%>
<div class="row text-center">
	<h3>Detalle de auditoria</h3>
</div>
<br>
<div class="row">
	<div class="col-md-3">
		<div class="form-group">
			<label>Accion</label>
			<div>
				<%=audi.getAccion() %>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>Campo</label>
			<div>
				<%=audi.getCampo_modifico() %>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>Fecha</label>
			<div>
				<%=formato.format(audi.getFecha()) %>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>Modificado por</label>
			<div>
				<%=audi.getModificado_por() %>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-3" >
		<div class="form-group">
			<label>Año de vigencia</label>
			<div>
				<% if(audi.getAno_vigencia() != 0){ %>
					<%=String.valueOf(audi.getAno_vigencia()) %>
				<% } %>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>Cedula de funcionario</label>
			<div>
				<%=audi.getCedula_funcionario() %>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>Nombres de funcionario</label>
			<div>
				<% if(usu.getNombres()!=null){ %>
					<%=usu.getNombres()+" "+usu.getApellidos() %>
				<% } %>
			</div>
		</div>
	</div>
	<% if( audi.getAccion().equals("Registro de Correo Electrónico") ){ %>
		<div class="col-md-3">
		<div class="form-group">
			<label>Correo registrado</label>
			<div>
				<%=audi.getLog_anterior() %>
			</div>
		</div>
	</div>
	<% } %>
	<% if( audi.getAccion().equals("Reestablecer Correo Electrónico") ){ %>
		<div class="col-md-3">
		<div class="form-group">
			<label>Correo reestablecido</label>
			<div>
				<%=audi.getLog_anterior() %>
			</div>
		</div>
	</div>
	<% } %>
</div>
<br>
<br>
<%
	if( audi.getCampo_modifico().equals("Archivo de Declaración de Renta") || audi.getCampo_modifico().equals("Archivo de Formulario de Bienes") || audi.getCampo_modifico().equals("Generar Hoja de Vida") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid;">
		<div class="row">
			<div class="col-md-12 text-center">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% if( !audi.getLog_anterior().isEmpty() ){ %>
		<portlet:resourceURL var="verAnterior">
			<portlet:param name="pagina" value="descargarArchivo"/>
			<% if(audi.getCampo_modifico().equals("Archivo de Declaración de Renta")){ %>
				<portlet:param name="archivo_solicitado" value="declaracion_renta"/>
			<% } %>
			<% if(audi.getCampo_modifico().equals("Archivo de Formulario de Bienes")){ %>
				<portlet:param name="archivo_solicitado" value="formulario_bienes"/>
			<% } %>
			<% if(audi.getCampo_modifico().equals("Generar Hoja de Vida")){ %>
				<portlet:param name="archivo_solicitado" value="hoja_vida"/>
			<% } %>
			<portlet:param name="ruta" value="<%=audi.getLog_anterior()%>"/>
		</portlet:resourceURL>
		<a target="_blank" href="<%=verAnterior %>" >Descargar Archivo</a>
		<% } %>
	</div>
	<div class="col-md-6">
		<div class="row">
			<div class="col-md-12 text-center">
				Nuevo
				<br>
				<br>
			</div>
		</div>								
		<% if( !audi.getLog_nuevo().isEmpty() ){ %>
		<portlet:resourceURL var="verNuevo">
			<portlet:param name="pagina" value="descargarArchivo"/>
			<% if(audi.getCampo_modifico().equals("Archivo de Declaración de Renta")){ %>
				<portlet:param name="archivo_solicitado" value="declaracion_renta"/>
			<% } %>
			<% if(audi.getCampo_modifico().equals("Archivo de Formulario de Bienes")){ %>
				<portlet:param name="archivo_solicitado" value="formulario_bienes"/>
			<% } %>
			<% if(audi.getCampo_modifico().equals("Generar Hoja de Vida")){ %>
				<portlet:param name="archivo_solicitado" value="hoja_vida"/>
			<% } %>
			<portlet:param name="pagina" value="descargarArchivo"/>
			<portlet:param name="ruta" value="<%=audi.getLog_nuevo()%>"/>
		</portlet:resourceURL>
		<a target="_blank" href="<%=verNuevo %>" >Descargar Archivo</a>
		<% } %>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Despacho Asignado") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid;">
		<div class="row">
			<div class="col-md-12 text-center">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<strong>Despacho Asignado</strong>
				<br>
				<%= consultas.getNombreDespacho(audi.getLog_anterior()) %>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="row">
			<div class="col-md-12 text-center">
				Nuevo
				<br>
				<br>
			</div>
		</div>								
		<div class="row">
			<div class="col-md-12">
				<strong>Despacho Asignado</strong>
				<br>
				<%= consultas.getNombreDespacho(audi.getLog_nuevo()) %>
			</div>
		</div>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Cargo") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid;">
		<div class="row">
			<div class="col-md-12 text-center">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<strong>Cargo que Desempeña</strong>
				<br>
				<%= audi.getLog_anterior() %>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="row">
			<div class="col-md-12 text-center">
				Nuevo
				<br>
				<br>
			</div>
		</div>								
		<div class="row">
			<div class="col-md-12">
				<strong>Cargo que Desempeña</strong>
				<br>
				<%= audi.getLog_nuevo() %>
			</div>
		</div>
	</div>
</div>
<% } %>

<%
	if( audi.getAccion().equals("Publicar Información") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid;">
		<div class="row">
			<div class="col-md-12 text-center">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% if( !audi.getLog_anterior().isEmpty() ){
			String retirado = "No";
			publicaciones p = publicacionesLocalServiceUtil.getpublicaciones(Long.parseLong(audi.getLog_anterior()));
			if(p.getRetirado().equals("true"))
				retirado = "Si";
			String archivos = 	"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+audi.getLog_anterior()+"&archivo_solicitado=hoja_vida' target='_blank'>Hoja de Vida</a><br>"+
		    					"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+audi.getLog_anterior()+"&archivo_solicitado=declaracion_renta' target='_blank'>Declaracion de Renta</a><br>"+
		    					"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+audi.getLog_anterior()+"&archivo_solicitado=formulario_bienes' target='_blank'>Formulario de Bienes</a><br>"+
		    					"Solicito el retiro:<strong>"+retirado+"</strong>";
		    %>
		    <%= archivos %>
		<% } %>
	</div>
	<div class="col-md-6">
		<div class="row">
			<div class="col-md-12 text-center">
				Nuevo
				<br>
				<br>
			</div>
		</div>								
		<% if( !audi.getLog_nuevo().isEmpty() ){ 
			String retirado = "No";
			publicaciones p = publicacionesLocalServiceUtil.getpublicaciones(Long.parseLong(audi.getLog_nuevo()));
			if(p.getRetirado().equals("true"))
				retirado = "Si";
			String archivos = 	"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+audi.getLog_nuevo()+"&archivo_solicitado=hoja_vida' target='_blank'>Hoja de Vida</a><br>"+
		    					"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+audi.getLog_nuevo()+"&archivo_solicitado=declaracion_renta' target='_blank'>Declaracion de Renta</a><br>"+
		    					"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+audi.getLog_nuevo()+"&archivo_solicitado=formulario_bienes' target='_blank'>Formulario de Bienes</a><br>"+
				    			"Solicito el retiro:<strong>"+retirado+"</strong>";
		    %>
		    <%= archivos %>
		<% } %>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Datos Personales") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid; font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% 
			String datos_personales = "{'nada' : '-' }";
			if(!audi.getLog_anterior().isEmpty()){
				datos_personales = audi.getLog_anterior();
			}
			JSONObject dp = JSONFactoryUtil.createJSONObject(datos_personales);
			if(dp.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<div class="form-group">
								<label for="apellidos">APELLIDOS</label>
								<div id="apellidos">
									<%= usu.getApellidos() %>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="nombres">NOMBRES</label>
								<div id="nombres">
									<%= usu.getNombres() %>
								</div>
							</div>
						</div>
					</div>	
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-4">
							<div class="form-group">
								<label for="documento">DOCUMENTO DE IDENTIFICACIÓN</label>
								<div id="documento">
									<strong><%=consultas.getTipoDocumentoDiminutivo(usu.getTipoDocumento()) %>:</strong> <%= usu.getNumeroDocumento() %>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label for="sexo">SEXO</label>
								<div id="sexo">
									<%=dp.getString("sexo") %>						
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label for="nacionalidadDiv">NACIONALIDAD</label>
								<div id="nacionalidadDiv">
									<%=dp.getString("nacionalidad") %>						  	
								</div>
							</div>
						</div>
						<div id="nacionalidadPais" class="col-md-4">
							<div class="form-group">
								<label for="pais">PAÍS</label>
								<div>
									<%=dp.getString("pais") %>
								</div>
							</div>
						</div>	
					</div>	
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-12">
							<label for="libretaMilitar">LIBRETA MILITAR</label>
							<div id="libretaMilitar">
								<div class="col-md-4">
									<%=dp.getString("tipoLibretaMilitar") %>
								</div>
								<div class="col-md-4">
									<label for="numero">NÚMERO</label>&nbsp;&nbsp;&nbsp;
									<%=dp.getString("numeroLibretaMilitar")%>						  	
								</div>
								<div class="col-md-4">
									<label for="dm">D.M</label>&nbsp;&nbsp;&nbsp;
									<%=dp.getString("dmLibretaMilitar")%>						  	
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-12">
							<label for="fln">FECHA Y LUGAR DE NACIMIENTO</label>
							<div id="fln">
								<div class="form-group col-md-6">
									<label for="fn">FECHA</label>
									<div>
									<%=dp.getString("fechaNacimiento")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="pn">PAÍS</label>
									<div>
									<%=dp.getString("paisNacimiento")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="dn">DEPARTAMENTO</label>
									<div>
									<%=dp.getString("departamentoNacimiento")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="mn">MUNICIPIO</label>
									<div>
									<%=dp.getString("municipioNacimiento")%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-12">
							<label for="ddc">DIRECCION DE CORRESPONDENCIA</label>
							<div id="ddc">
								<div class="form-group col-md-12">
									<%=dp.getString("direccionCorrespondencia")%>
								</div>
								<div class="form-group col-md-4">
									<label for="paisCorespondencia">PAÍS</label>
									<div>
									<%=dp.getString("paisCorrespondencia")%>
									</div>
								</div>
								<div class="form-group col-md-4">
									<label for="depCorespondencia">DEPARTAMENTO</label>
									<div>
									<%=dp.getString("departamentoCorrespondencia")%>
									</div>
								</div>
								<div class="form-group col-md-4">
									<label for="munCorespondencia">MUNICIPIO</label>
									<div>
									<%=dp.getString("municipioCorrespondencia")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="telCorespondencia">TELÉFONO</label>
									<div>
									<%=dp.getString("telefonoCorrespondencia")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="emailCorespondencia">EMAIL</label>
									<div>
									<%=dp.getString("emailCorrespondencia")%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		<% 	} %>
	</div>
	<div class="col-md-6" style="font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Nuevo
				<br>
				<br>
			</div>
		</div>
		<% 
			datos_personales = "{'nada' : '-' }";
			if(!audi.getLog_nuevo().isEmpty()){
				datos_personales = audi.getLog_nuevo();
			}
			dp = JSONFactoryUtil.createJSONObject(datos_personales);
			if(dp.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<div class="form-group">
								<label for="apellidos">APELLIDOS</label>
								<div id="apellidos">
									<%= usu.getApellidos() %>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="nombres">NOMBRES</label>
								<div id="nombres">
									<%= usu.getNombres() %>
								</div>
							</div>
						</div>
					</div>	
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-4">
							<div class="form-group">
								<label for="documento">DOCUMENTO DE IDENTIFICACIÓN</label>
								<div id="documento">
									<strong><%=consultas.getTipoDocumentoDiminutivo(usu.getTipoDocumento()) %>:</strong> <%= usu.getNumeroDocumento() %>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label for="sexo">SEXO</label>
								<div id="sexo">
									<%=dp.getString("sexo") %>						
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label for="nacionalidadDiv">NACIONALIDAD</label>
								<div id="nacionalidadDiv">
									<%=dp.getString("nacionalidad") %>						  	
								</div>
							</div>
						</div>
						<div id="nacionalidadPais" class="col-md-4">
							<div class="form-group">
								<label for="pais">PAÍS</label>
								<div>
									<%=dp.getString("pais") %>
								</div>
							</div>
						</div>	
					</div>	
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-12">
							<label for="libretaMilitar">LIBRETA MILITAR</label>
							<div id="libretaMilitar">
								<div class="col-md-4">
									<%=dp.getString("tipoLibretaMilitar") %>
								</div>
								<div class="col-md-4">
									<label for="numero">NÚMERO</label>&nbsp;&nbsp;&nbsp;
									<%=dp.getString("numeroLibretaMilitar")%>						  	
								</div>
								<div class="col-md-4">
									<label for="dm">D.M</label>&nbsp;&nbsp;&nbsp;
									<%=dp.getString("dmLibretaMilitar")%>						  	
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-12">
							<label for="fln">FECHA Y LUGAR DE NACIMIENTO</label>
							<div id="fln">
								<div class="form-group col-md-6">
									<label for="fn">FECHA</label>
									<div>
									<%=dp.getString("fechaNacimiento")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="pn">PAÍS</label>
									<div>
									<%=dp.getString("paisNacimiento")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="dn">DEPARTAMENTO</label>
									<div>
									<%=dp.getString("departamentoNacimiento")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="mn">MUNICIPIO</label>
									<div>
									<%=dp.getString("municipioNacimiento")%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-12">
							<label for="ddc">DIRECCION DE CORRESPONDENCIA</label>
							<div id="ddc">
								<div class="form-group col-md-12">
									<%=dp.getString("direccionCorrespondencia")%>
								</div>
								<div class="form-group col-md-4">
									<label for="paisCorespondencia">PAÍS</label>
									<div>
									<%=dp.getString("paisCorrespondencia")%>
									</div>
								</div>
								<div class="form-group col-md-4">
									<label for="depCorespondencia">DEPARTAMENTO</label>
									<div>
									<%=dp.getString("departamentoCorrespondencia")%>
									</div>
								</div>
								<div class="form-group col-md-4">
									<label for="munCorespondencia">MUNICIPIO</label>
									<div>
									<%=dp.getString("municipioCorrespondencia")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="telCorespondencia">TELÉFONO</label>
									<div>
									<%=dp.getString("telefonoCorrespondencia")%>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="emailCorespondencia">EMAIL</label>
									<div>
									<%=dp.getString("emailCorrespondencia")%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		<% 	} %>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Formación Académica") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid; font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% 
			String formacion_academica = "{'nada' : '-' }";
			if(!audi.getLog_anterior().isEmpty()){
				formacion_academica = audi.getLog_anterior();
			}
			JSONObject fa = JSONFactoryUtil.createJSONObject(formacion_academica);
			if(fa.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-12">
						<strong>EDUCACIÓN BÁSICA Y MEDIA</strong>
						<br>
						SELECCIONE EL ÚLTIMO GRADO APROBADO (LOS GRADOS DE 1o. A 6o. DE BACHILLERATO EQUIVALEN A LOS GRADOS 6o. A 11o. DE EDUCACIÓN BÁSICA SECUNDARIA Y MEDIA)
						<br>
						<table class="table table-bordered">
						    <thead>
						    	<tr>
						        	<th style="text-align: center; vertical-align: middle; width: 15%;">EDUCACIÓN BÁSICA</th>
						        	<th style="text-align: center; vertical-align: middle; width: 60%">TÍTULO OBTENIDO</th>
						        	<th style="text-align: center; vertical-align: middle;">FECHA DE GRADO</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<tr>
						    		<td>
						    			<%=fa.getString("educacionMedia") %>
						    		</td>
						    		<td>
						    			<%=fa.getString("tituloEducacionMedia")%>
						    		</td>
						    		<td>
						    			<%=fa.getString("mesEducacionMedia") %>
						    			<%=fa.getString("anhioEducacionMedia") %>
						    		</td>
						    	</tr>
						    </tbody>
					  	</table>
					  	<strong>EDUCACIÓN SUPERIOR (PREGRADO Y POSTGRADO)</strong>
					  	<br>
					  	DILIGENCIE ESTE PUNTO EN ESTRICTO ORDEN CRONOLÓGICO.
					  	<br>
					  	<br>
					  	RELACIONE AL FRENTE EL NÚMERO DE LA TARJETA PROFESIONAL (SI ÉSTA HA SIDO PREVISTA EN UNA LEY).
					  	<br>
					  	<table id="TES" class="table table-bordered">
						    <thead style="font-size: 12px;">
						    	<tr>
						        	<th style="text-align: center; vertical-align: middle; width: 12%">MODALIDAD ACADÉMICA</th>
						        	<th style="text-align: center; vertical-align: middle; width: 10%">No. SEMESTRES APROBADOS</th>
						        	<th style="text-align: center; vertical-align: middle; width: 10%">GRADUADO</th>
						        	<th style="text-align: center; vertical-align: middle; width: 45%">NOMBRE DE LOS ESTUDIOS O TÍTULO OBTENIDO</th>
						        	<th style="text-align: center; vertical-align: middle; width: 15%">TERMINACIÓN</th>
						        	<th style="text-align: center; vertical-align: middle; width: 15%">No. DE TARJETA PROFESIONAL</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray esArray = JSONFactoryUtil.createJSONArray();
						    		if(!fa.getString("formacion").equals("")){
						    			esArray = JSONFactoryUtil.createJSONArray(fa.getString("formacion"));
						    		}
						    		int cuenta = esArray.length();
						    		if(cuenta==0)
						    			cuenta=1;
						    		for(int i=1 ; i<=cuenta ; i++){
						    			JSONObject es = JSONFactoryUtil.createJSONObject();
						    			if(esArray.getJSONObject(i-1)!=null)
						    				es = esArray.getJSONObject(i-1);
						    	%>
								    	<tr>
								    		<td>
								    			<%= es.getString("modalidadEducacionSuperior") %>
								    		</td>
								    		<td>
								    			<%=es.getString("semestresEducacionSuperior")%>
								    		</td>
								    		<td>
								    			<%=es.getString("graduadoEducacionSuperior") %>
								    		</td>
								    		<td>
								    			<%=es.getString("tituloEducacionSuperior")%>
								    		</td>
								    		<td>
								    			<%= es.getString("mesEducacionSuperior") %>
								    			<%= es.getString("anhioEducacionSuperior") %>
								    		</td>
								    		<td>
								    			<%=es.getString("tarjetaEducacionSuperior")%>
								    		</td>
								    	</tr>
								    <% } %>
						    </tbody>
					  	</table>
					  	<br>
					  	<br>
					  	ESPECIFIQUE LOS IDIOMAS DIFERENTES AL ESPAÑOL QUE: HABLA, LEE, ESCRIBE DE FORMA, REGULAR, BIEN O MUY BIEN.
					  	<br>
					  	<table id="IDIOMA" class="table table-bordered">
						    <thead style="font-size: 12px;">
						    	<tr>
						        	<th style="text-align: center; vertical-align: middle; width: 40%">IDIOMA</th>
						        	<th style="text-align: center; vertical-align: middle; width: 20%">LO HABLA</th>
						        	<th style="text-align: center; vertical-align: middle; width: 20%">LO LEE</th>
						        	<th style="text-align: center; vertical-align: middle; width: 20%">LO ESCRIBE</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray iArray = JSONFactoryUtil.createJSONArray();
						    		if(!fa.getString("idiomas").equals("")){
						    			iArray = JSONFactoryUtil.createJSONArray(fa.getString("idiomas"));
						    		}
						    		int cuentai = iArray.length();
						    		if(cuentai==0)
						    			cuentai=1;
						    		for(int i=1 ; i<=cuentai ; i++){
						    			JSONObject es = JSONFactoryUtil.createJSONObject();
						    			if(iArray.getJSONObject(i-1)!=null)
						    				es = iArray.getJSONObject(i-1);
						    	%>
							    	<tr >
							    		<td>
							    			<%=es.getString("idioma") %>
							    		</td>
							    		<td>
							    			<%=es.getString("habla") %>
							    		</td>
							    		<td>
							    			<%= es.getString("lee") %>
							    		</td>
							    		<td>
							    			<%= es.getString("escribe") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
					  	</table>
					</div>
				</div>
		<% 	} %>
	</div>
	<div class="col-md-6" style="font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Nuevo
				<br>
				<br>
			</div>
		</div>
		<% 
		formacion_academica = "{'nada' : '-' }";
			if(!audi.getLog_nuevo().isEmpty()){
				formacion_academica = audi.getLog_nuevo();
			}
			fa = JSONFactoryUtil.createJSONObject(formacion_academica);
			if(fa.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-12">
						<strong>EDUCACIÓN BÁSICA Y MEDIA</strong>
						<br>
						SELECCIONE EL ÚLTIMO GRADO APROBADO (LOS GRADOS DE 1o. A 6o. DE BACHILLERATO EQUIVALEN A LOS GRADOS 6o. A 11o. DE EDUCACIÓN BÁSICA SECUNDARIA Y MEDIA)
						<br>
						<table class="table table-bordered">
						    <thead>
						    	<tr>
						        	<th style="text-align: center; vertical-align: middle; width: 15%;">EDUCACIÓN BÁSICA</th>
						        	<th style="text-align: center; vertical-align: middle; width: 60%">TÍTULO OBTENIDO</th>
						        	<th style="text-align: center; vertical-align: middle;">FECHA DE GRADO</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<tr>
						    		<td>
						    			<%=fa.getString("educacionMedia") %>
						    		</td>
						    		<td>
						    			<%=fa.getString("tituloEducacionMedia")%>
						    		</td>
						    		<td>
						    			<%=fa.getString("mesEducacionMedia") %>
						    			<%=fa.getString("anhioEducacionMedia") %>
						    		</td>
						    	</tr>
						    </tbody>
					  	</table>
					  	<strong>EDUCACIÓN SUPERIOR (PREGRADO Y POSTGRADO)</strong>
					  	<br>
					  	DILIGENCIE ESTE PUNTO EN ESTRICTO ORDEN CRONOLÓGICO.
					  	<br>
					  	<br>
					  	RELACIONE AL FRENTE EL NÚMERO DE LA TARJETA PROFESIONAL (SI ÉSTA HA SIDO PREVISTA EN UNA LEY).
					  	<br>
					  	<table id="TES" class="table table-bordered">
						    <thead style="font-size: 12px;">
						    	<tr>
						        	<th style="text-align: center; vertical-align: middle; width: 12%">MODALIDAD ACADÉMICA</th>
						        	<th style="text-align: center; vertical-align: middle; width: 10%">No. SEMESTRES APROBADOS</th>
						        	<th style="text-align: center; vertical-align: middle; width: 10%">GRADUADO</th>
						        	<th style="text-align: center; vertical-align: middle; width: 45%">NOMBRE DE LOS ESTUDIOS O TÍTULO OBTENIDO</th>
						        	<th style="text-align: center; vertical-align: middle; width: 15%">TERMINACIÓN</th>
						        	<th style="text-align: center; vertical-align: middle; width: 15%">No. DE TARJETA PROFESIONAL</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray esArray = JSONFactoryUtil.createJSONArray();
						    		if(!fa.getString("formacion").equals("")){
						    			esArray = JSONFactoryUtil.createJSONArray(fa.getString("formacion"));
						    		}
						    		int cuenta = esArray.length();
						    		if(cuenta==0)
						    			cuenta=1;
						    		for(int i=1 ; i<=cuenta ; i++){
						    			JSONObject es = JSONFactoryUtil.createJSONObject();
						    			if(esArray.getJSONObject(i-1)!=null)
						    				es = esArray.getJSONObject(i-1);
						    	%>
								    	<tr>
								    		<td>
								    			<%= es.getString("modalidadEducacionSuperior") %>
								    		</td>
								    		<td>
								    			<%=es.getString("semestresEducacionSuperior")%>
								    		</td>
								    		<td>
								    			<%=es.getString("graduadoEducacionSuperior") %>
								    		</td>
								    		<td>
								    			<%=es.getString("tituloEducacionSuperior")%>
								    		</td>
								    		<td>
								    			<%= es.getString("mesEducacionSuperior") %>
								    			<%= es.getString("anhioEducacionSuperior") %>
								    		</td>
								    		<td>
								    			<%=es.getString("tarjetaEducacionSuperior")%>
								    		</td>
								    	</tr>
								    <% } %>
						    </tbody>
					  	</table>
					  	<br>
					  	<br>
					  	ESPECIFIQUE LOS IDIOMAS DIFERENTES AL ESPAÑOL QUE: HABLA, LEE, ESCRIBE DE FORMA, REGULAR, BIEN O MUY BIEN.
					  	<br>
					  	<table id="IDIOMA" class="table table-bordered">
						    <thead style="font-size: 12px;">
						    	<tr>
						        	<th style="text-align: center; vertical-align: middle; width: 40%">IDIOMA</th>
						        	<th style="text-align: center; vertical-align: middle; width: 20%">LO HABLA</th>
						        	<th style="text-align: center; vertical-align: middle; width: 20%">LO LEE</th>
						        	<th style="text-align: center; vertical-align: middle; width: 20%">LO ESCRIBE</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray iArray = JSONFactoryUtil.createJSONArray();
						    		if(!fa.getString("idiomas").equals("")){
						    			iArray = JSONFactoryUtil.createJSONArray(fa.getString("idiomas"));
						    		}
						    		int cuentai = iArray.length();
						    		if(cuentai==0)
						    			cuentai=1;
						    		for(int i=1 ; i<=cuentai ; i++){
						    			JSONObject es = JSONFactoryUtil.createJSONObject();
						    			if(iArray.getJSONObject(i-1)!=null)
						    				es = iArray.getJSONObject(i-1);
						    	%>
							    	<tr >
							    		<td>
							    			<%=es.getString("idioma") %>
							    		</td>
							    		<td>
							    			<%=es.getString("habla") %>
							    		</td>
							    		<td>
							    			<%= es.getString("lee") %>
							    		</td>
							    		<td>
							    			<%= es.getString("escribe") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
					  	</table>
					</div>
				</div>
		<% 	} %>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Experiencia Laboral") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid; font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% 
			String experiencia_laboral = "{'nada' : '-' }";
			if(!audi.getLog_anterior().isEmpty()){
				experiencia_laboral = audi.getLog_anterior();
			}
			JSONObject exl = JSONFactoryUtil.createJSONObject(experiencia_laboral);
			if(exl.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="col-md-12">
				<%
					JSONArray elArray = JSONFactoryUtil.createJSONArray();
					if(!exl.getString("experiencia").equals("")){
						elArray = JSONFactoryUtil.createJSONArray(exl.getString("experiencia"));
					}
					int cuenta = elArray.length();
					if(cuenta==0)
						cuenta=1;
					for(int i=1 ; i<=cuenta ; i++){
						JSONObject el = JSONFactoryUtil.createJSONObject();
						if(elArray.getJSONObject(i-1)!=null)
							el = elArray.getJSONObject(i-1);
				%>
					<table class="table table-bordered">
					    <thead>
					    	<tr>
					        	<%
					        		if(i==1){
					        	%>
					        		<th colspan="3" style="text-align: center; vertical-align: middle;">EMPLEO ACTUAL O CONTRATO VIGENTE</th>
					        	<%	}else{ %>
					        		<th colspan="3" style="text-align: center; vertical-align: middle;">EMPLEO O CONTRATO ANTERIOR</th>
					        	<%	} %>
					      	</tr>
					    </thead>
					    <tbody>
				    	   	<tr>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>EMPRESA O ENTIDAD</label>
										<div>
											<%=el.getString("empresa")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>SECTOR</label>
										<div>
											<%=el.getString("sector") %>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>PAÍS</label>
										<div>
											<%=el.getString("pais") %>
										</div>
									</div>
					    		</td>
					    	</tr>
					    	<tr>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>DEPARTAMENTO</label>
										<div>
											<%=el.getString("departamento")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>MUNICIPIO</label>
										<div>
											<%=el.getString("municipio")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>CORREO ELECTRÓNICO ENTIDAD</label>
										<div>
											<%=el.getString("correo")%>
										</div>
									</div>
					    		</td>
					    	</tr>
					    	<tr>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>TELÉFONOS</label>
										<div>
											<%=el.getString("telefono")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label >FECHA DE INGRESO</label>
										<div>
											<%=el.getString("fechaIngreso")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label >FECHA DE RETIRO</label>
										<div>
											<%=el.getString("fechaRetiro")%>
										</div>
									</div>
					    		</td>
					    	</tr>
					    	<tr>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>CARGO O CONTRATO  ACTUAL</label>
										<div>
											<%=el.getString("cargo")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>DEPENDENCIA</label>
										<div>
											<%=el.getString("dependencia")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label >DIRECCIÓN</label>
										<div>
											<%=el.getString("direccion")%>
										</div>
									</div>
					    		</td>
					    	</tr>
					    	<% } %>
					    </tbody>
					</table>
				</div>
		<% 	} %>
	</div>
	<div class="col-md-6" style="font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Nuevo
				<br>
				<br>
			</div>
		</div>
		<% 
		experiencia_laboral = "{'nada' : '-' }";
			if(!audi.getLog_nuevo().isEmpty()){
				experiencia_laboral = audi.getLog_nuevo();
			}
			exl = JSONFactoryUtil.createJSONObject(experiencia_laboral);
			if(exl.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="col-md-12">
				<%
					JSONArray elArray = JSONFactoryUtil.createJSONArray();
					if(!exl.getString("experiencia").equals("")){
						elArray = JSONFactoryUtil.createJSONArray(exl.getString("experiencia"));
					}
					int cuenta = elArray.length();
					if(cuenta==0)
						cuenta=1;
					for(int i=1 ; i<=cuenta ; i++){
						JSONObject el = JSONFactoryUtil.createJSONObject();
						if(elArray.getJSONObject(i-1)!=null)
							el = elArray.getJSONObject(i-1);
				%>
					<table class="table table-bordered">
					    <thead>
					    	<tr>
					        	<%
					        		if(i==1){
					        	%>
					        		<th colspan="3" style="text-align: center; vertical-align: middle;">EMPLEO ACTUAL O CONTRATO VIGENTE</th>
					        	<%	}else{ %>
					        		<th colspan="3" style="text-align: center; vertical-align: middle;">EMPLEO O CONTRATO ANTERIOR</th>
					        	<%	} %>
					      	</tr>
					    </thead>
					    <tbody>
				    	   	<tr>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>EMPRESA O ENTIDAD</label>
										<div>
											<%=el.getString("empresa")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>SECTOR</label>
										<div>
											<%=el.getString("sector") %>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>PAÍS</label>
										<div>
											<%=el.getString("pais") %>
										</div>
									</div>
					    		</td>
					    	</tr>
					    	<tr>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>DEPARTAMENTO</label>
										<div>
											<%=el.getString("departamento")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>MUNICIPIO</label>
										<div>
											<%=el.getString("municipio")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>CORREO ELECTRÓNICO ENTIDAD</label>
										<div>
											<%=el.getString("correo")%>
										</div>
									</div>
					    		</td>
					    	</tr>
					    	<tr>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>TELÉFONOS</label>
										<div>
											<%=el.getString("telefono")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label >FECHA DE INGRESO</label>
										<div>
											<%=el.getString("fechaIngreso")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label >FECHA DE RETIRO</label>
										<div>
											<%=el.getString("fechaRetiro")%>
										</div>
									</div>
					    		</td>
					    	</tr>
					    	<tr>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>CARGO O CONTRATO  ACTUAL</label>
										<div>
											<%=el.getString("cargo")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label>DEPENDENCIA</label>
										<div>
											<%=el.getString("dependencia")%>
										</div>
									</div>
					    		</td>
					    		<td>
					    			<div class="form-group" style="margin-bottom: 0;">
										<label >DIRECCIÓN</label>
										<div>
											<%=el.getString("direccion")%>
										</div>
									</div>
					    		</td>
					    	</tr>
					    	<% } %>
					    </tbody>
					</table>
				</div>
		<% 	} %>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Tiempo Total de Experiencia") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid; font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% 
			String tiempo_experiencia = "{'nada' : '-' }";
			if(!audi.getLog_anterior().isEmpty()){
				tiempo_experiencia = audi.getLog_anterior();
			}
			JSONObject tx = JSONFactoryUtil.createJSONObject(tiempo_experiencia);
			if(tx.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<table class="table table-bordered">
						    <thead>
						    	<tr>
						        	<th rowspan="2" width="60%" style="text-align: center; vertical-align: middle;" >OCUPACIÓN</th>
						        	<th colspan="2" width="40%" style="text-align: center; vertical-align: middle;">TIEMPO DE EXPERIENCIA</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">AÑOS</th>
						        	<th style="text-align: center; vertical-align: middle;">MESES</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<tr>
							    	<td>SERVIDOR PÚBLICO</td>
							        <td>
							        	<%=tx.getInt("anosServidorPublico") %>
							        </td>
							        <td>
							        	<%=tx.getInt("mesesServidorPublico") %>
							        </td>
						      	</tr>
						      	<tr>
							        <td>EMPLEADO DEL SECTOR PRIVADO</td>
							        <td>
							        	<%=tx.getInt("anosSectorPrivado") %>
							        </td>
							        <td>
							        	<%=tx.getInt("mesesSectorPrivado") %>
							        </td>
						      	</tr>
						      	<tr>
							        <td>TRABAJADOR INDEPENDIENTE</td>
							        <td>
							        	<%=tx.getInt("anosTrabajadorIndependiente") %>
							        </td>
							        <td>
							        	<%=tx.getInt("mesesTrabajadorIndependiente") %>
							        </td>
						      	</tr>
						      	<tr>
							        <td>TOTAL TIEMPO EXPERIENCIA</td>
							        <td>
							        	<%=tx.getInt("anosTotales") %>
							        </td>
							        <td>
							        	<%=tx.getInt("mesesTotales") %>
							        </td>
						      	</tr>
						    </tbody>
					  	</table>
					</div>
				</div>
		<% 	} %>
	</div>
	<div class="col-md-6" style="font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Nuevo
				<br>
				<br>
			</div>
		</div>
		<% 
		tiempo_experiencia = "{'nada' : '-' }";
			if(!audi.getLog_nuevo().isEmpty()){
				tiempo_experiencia = audi.getLog_nuevo();
			}
			tx = JSONFactoryUtil.createJSONObject(tiempo_experiencia);
			if(tx.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<table class="table table-bordered">
						    <thead>
						    	<tr>
						        	<th rowspan="2" width="60%" style="text-align: center; vertical-align: middle;" >OCUPACIÓN</th>
						        	<th colspan="2" width="40%" style="text-align: center; vertical-align: middle;">TIEMPO DE EXPERIENCIA</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">AÑOS</th>
						        	<th style="text-align: center; vertical-align: middle;">MESES</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<tr>
							    	<td>SERVIDOR PÚBLICO</td>
							        <td>
							        	<%=tx.getInt("anosServidorPublico") %>
							        </td>
							        <td>
							        	<%=tx.getInt("mesesServidorPublico") %>
							        </td>
						      	</tr>
						      	<tr>
							        <td>EMPLEADO DEL SECTOR PRIVADO</td>
							        <td>
							        	<%=tx.getInt("anosSectorPrivado") %>
							        </td>
							        <td>
							        	<%=tx.getInt("mesesSectorPrivado") %>
							        </td>
						      	</tr>
						      	<tr>
							        <td>TRABAJADOR INDEPENDIENTE</td>
							        <td>
							        	<%=tx.getInt("anosTrabajadorIndependiente") %>
							        </td>
							        <td>
							        	<%=tx.getInt("mesesTrabajadorIndependiente") %>
							        </td>
						      	</tr>
						      	<tr>
							        <td>TOTAL TIEMPO EXPERIENCIA</td>
							        <td>
							        	<%=tx.getInt("anosTotales") %>
							        </td>
							        <td>
							        	<%=tx.getInt("mesesTotales") %>
							        </td>
						      	</tr>
						    </tbody>
					  	</table>
					</div>
				</div>
		<% 	} %>
	</div>
</div>
<% } %>


<%
	if( audi.getCampo_modifico().equals("Bienes y Rentas") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid; font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% 
			String bienes_rentas = "{'nada' : '-' }";
			if(!audi.getLog_anterior().isEmpty()){
				bienes_rentas = audi.getLog_anterior();
			}
			JSONObject br = JSONFactoryUtil.createJSONObject(bienes_rentas);
			if(br.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<table class="table table-bordered" id="bienPatrimonial">
						    <thead>
						    	<tr>
						        	<th colspan="3" style="text-align: center; vertical-align: middle;">BIENES PATRIMONIALES</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle; width: 15%;">TIPO DE BIEN</th>
						      		<th style="text-align: center; vertical-align: middle; width: 65%;">DESCRIPCION</th>
						      		<th style="text-align: center; vertical-align: middle;">VALOR</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray bArray = JSONFactoryUtil.createJSONArray();
						    		if(!br.getString("bienes").equals("")){
						    			bArray = JSONFactoryUtil.createJSONArray(br.getString("bienes"));
						    		}
						    		int cuentab = bArray.length();
						    		if(cuentab==0)
						    			cuentab=1;
						    		for(int i=1 ; i<=cuentab ; i++){
						    			
						    			JSONObject bp = JSONFactoryUtil.createJSONObject();
						    			if(bArray.getJSONObject(i-1)!=null)
						    				bp = bArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%= bp.getString("tipo_bien") %>
							    		</td>
							    		<td>
							    			<%=bp.getString("descripcionBien") %>
							    		</td>
							    		<td>
							    			<%=bp.getString("valorBien") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<br>
						<table class="table table-bordered" id="Obligaciones">
						    <thead>
						    	<tr>
						        	<th colspan="2" style="text-align: center; vertical-align: middle;">OBLIGACIONES</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle; width: 75%;">TIPO DE OBLIGACIONES</th>
						      		<th style="text-align: center; vertical-align: middle;">VALOR</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray oArray = JSONFactoryUtil.createJSONArray();
						    		if(!br.getString("obligaciones").equals("")){
						    			oArray = JSONFactoryUtil.createJSONArray(br.getString("obligaciones"));
						    		}
						    		int cuentao = oArray.length();
						    		if(cuentao==0)
						    			cuentao=1;
						    		for(int i=1 ; i<=cuentao ; i++){
						    			
						    			JSONObject o = JSONFactoryUtil.createJSONObject();
						    			if(oArray.getJSONObject(i-1)!=null)
						    				o = oArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=o.getString("tipoObligacion") %>
							    		</td>
							    		<td>
							    			<%=o.getString("valorObligacion") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
					</div>
				</div>
		<% 	} %>
	</div>
	<div class="col-md-6" style="font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Nuevo
				<br>
				<br>
			</div>
		</div>
		<% 
		bienes_rentas = "{'nada' : '-' }";
			if(!audi.getLog_nuevo().isEmpty()){
				bienes_rentas = audi.getLog_nuevo();
			}
			br = JSONFactoryUtil.createJSONObject(bienes_rentas);
			if(br.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<table class="table table-bordered" id="bienPatrimonial">
						    <thead>
						    	<tr>
						        	<th colspan="3" style="text-align: center; vertical-align: middle;">BIENES PATRIMONIALES</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle; width: 15%;">TIPO DE BIEN</th>
						      		<th style="text-align: center; vertical-align: middle; width: 65%;">DESCRIPCION</th>
						      		<th style="text-align: center; vertical-align: middle;">VALOR</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray bArray = JSONFactoryUtil.createJSONArray();
						    		if(!br.getString("bienes").equals("")){
						    			bArray = JSONFactoryUtil.createJSONArray(br.getString("bienes"));
						    		}
						    		int cuentab = bArray.length();
						    		if(cuentab==0)
						    			cuentab=1;
						    		for(int i=1 ; i<=cuentab ; i++){
						    			
						    			JSONObject bp = JSONFactoryUtil.createJSONObject();
						    			if(bArray.getJSONObject(i-1)!=null)
						    				bp = bArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%= bp.getString("tipo_bien") %>
							    		</td>
							    		<td>
							    			<%=bp.getString("descripcionBien") %>
							    		</td>
							    		<td>
							    			<%=bp.getString("valorBien") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<br>
						<table class="table table-bordered" id="Obligaciones">
						    <thead>
						    	<tr>
						        	<th colspan="2" style="text-align: center; vertical-align: middle;">OBLIGACIONES</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle; width: 75%;">TIPO DE OBLIGACIONES</th>
						      		<th style="text-align: center; vertical-align: middle;">VALOR</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray oArray = JSONFactoryUtil.createJSONArray();
						    		if(!br.getString("obligaciones").equals("")){
						    			oArray = JSONFactoryUtil.createJSONArray(br.getString("obligaciones"));
						    		}
						    		int cuentao = oArray.length();
						    		if(cuentao==0)
						    			cuentao=1;
						    		for(int i=1 ; i<=cuentao ; i++){
						    			
						    			JSONObject o = JSONFactoryUtil.createJSONObject();
						    			if(oArray.getJSONObject(i-1)!=null)
						    				o = oArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=o.getString("tipoObligacion") %>
							    		</td>
							    		<td>
							    			<%=o.getString("valorObligacion") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
					</div>
				</div>
		<% 	} %>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Información Complementaria") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid; font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% 
			String informacion_complementaria = "{'nada' : '-' }";
			if(!audi.getLog_anterior().isEmpty()){
				informacion_complementaria = audi.getLog_anterior();
			}
			JSONObject inf = JSONFactoryUtil.createJSONObject(informacion_complementaria);
			if(inf.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-12">
						<table class="table table-bordered" id="relacionDeRecusaciones">
						    <thead>
						    	<tr>
						        	<th colspan="5" style="text-align: center; vertical-align: middle;">RELACIÓN DE RECUSACIONES</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">QUIEN RECUSA<br></th>
						      		<th style="text-align: center; vertical-align: middle;">CAUSAL<br></th>
						      		<th style="text-align: center; vertical-align: middle;">RECUSADO<br></th>
						      		<th style="text-align: center; vertical-align: middle;">DECISIÓN TOMADA<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray rrArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("relacion_recusaciones").equals("")){
						    			rrArray = JSONFactoryUtil.createJSONArray(inf.getString("relacion_recusaciones"));
						    		}
						    		int cuentarr = rrArray.length();
						    		if(cuentarr==0)
						    			cuentarr=1;
						    		for(int i=1 ; i<=cuentarr ; i++){
						    			
						    			JSONObject rr = JSONFactoryUtil.createJSONObject();
						    			if(rrArray.getJSONObject(i-1)!=null)
						    				rr = rrArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=rr.getString("quien_recusa") %>
							    		</td>
							    		<td>
							    			<%=rr.getString("causal") %>
							    		</td>
							    		<td>
							    			<%=rr.getString("recusado") %>
							    		</td>
							    		<td>
							    			<%=rr.getString("decision_tomada") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="relacionDeImpedimentos">
						    <thead>
						    	<tr>
						        	<th colspan="5" style="text-align: center; vertical-align: middle;">RELACIÓN DE IMPEDIMENTOS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">QUIEN SE DECLARA IMPEDIDO<br></th>
						      		<th style="text-align: center; vertical-align: middle;">FECHA</th>
						      		<th style="text-align: center; vertical-align: middle;">CAUSAL<br></th>
						      		<th style="text-align: center; vertical-align: middle;">DECISIÓN TOMADA<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray riArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("relacion_impedimentos").equals("")){
						    			riArray = JSONFactoryUtil.createJSONArray(inf.getString("relacion_impedimentos"));
						    		}
						    		int cuentari = riArray.length();
						    		if(cuentari==0)
						    			cuentari=1;
						    		for(int i=1 ; i<=cuentari ; i++){
						    			
						    			JSONObject ri = JSONFactoryUtil.createJSONObject();
						    			if(riArray.getJSONObject(i-1)!=null)
						    				ri = riArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=ri.getString("quien_impedido") %>
							    		</td>
							    		<td>
							    			<%=ri.getString("fecha") %>
							    		</td>
							    		<td>
							    			<%=ri.getString("causal") %>
							    		</td>
							    		<td>
							    			<%=ri.getString("decision_tomada") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="comisionServiciosInteriorPais">
						    <thead>
						    	<tr>
						        	<th colspan="8" style="text-align: center; vertical-align: middle;">COMISIÓN DE SERVICIOS AL INTERIOR DEL PAÍS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">N. RESOLUCIÓN<br></th>
						      		<th style="text-align: center; vertical-align: middle;">DESTINO<br></th>
						      		<th style="text-align: center; vertical-align: middle;">OBJETO DE LA COMISIÓN<br></th>
						      		<th style="text-align: center; vertical-align: middle;">VIÁTICOS</th>
						      		<th style="text-align: center; vertical-align: middle;">N. DÍAS</th>
						      		<th style="text-align: center; vertical-align: middle;">ENTIDAD QUE ASUME COSTOS<br></th>
						      		<th style="text-align: center; vertical-align: middle;">OBSERVACIONES<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray ipArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("comision_interior").equals("")){
						    			ipArray = JSONFactoryUtil.createJSONArray(inf.getString("comision_interior"));
						    		}
						    		int cuentaip = ipArray.length();
						    		if(cuentaip==0)
						    			cuentaip=1;
						    		for(int i=1 ; i<=cuentaip ; i++){
						    			
						    			JSONObject ip = JSONFactoryUtil.createJSONObject();
						    			if(ipArray.getJSONObject(i-1)!=null)
						    				ip = ipArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=ip.getString("numero_resolucion") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("destino") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("objeto_comision") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("viaticos") %>
							    		</td>
							    		<td>
							    			<%=ip.getInt("dias") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("entidad") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("observaciones") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="comisionServiciosExteriorPais">
						    <thead>
						    	<tr>
						        	<th colspan="8" style="text-align: center; vertical-align: middle;">COMISIÓN DE SERVICIOS AL EXTERIOR DEL PAÍS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">N. RESOLUCIÓN<br></th>
						      		<th style="text-align: center; vertical-align: middle;">DESTINO<br></th>
						      		<th style="text-align: center; vertical-align: middle;">OBJETO DE LA COMISIÓN<br></th>
						      		<th style="text-align: center; vertical-align: middle;">VIÁTICOS</th>
						      		<th style="text-align: center; vertical-align: middle;">N. DÍAS</th>
						      		<th style="text-align: center; vertical-align: middle;">ENTIDAD QUE ASUME COSTOS<br></th>
						      		<th style="text-align: center; vertical-align: middle;">OBSERVACIONES<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray epArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("comision_exterior").equals("")){
						    			epArray = JSONFactoryUtil.createJSONArray(inf.getString("comision_exterior"));
						    		}
						    		int cuentaep = epArray.length();
						    		if(cuentaep==0)
						    			cuentaep=1;
						    		for(int i=1 ; i<=cuentaep ; i++){
						    			
						    			JSONObject ep = JSONFactoryUtil.createJSONObject();
						    			if(epArray.getJSONObject(i-1)!=null)
						    				ep = epArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=ep.getString("numero_resolucion") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("destino") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("objeto_comision") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("viaticos") %>
							    		</td>
							    		<td>
							    			<%=ep.getInt("dias") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("entidad") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("observaciones") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="inasistenciaSesion">
						    <thead>
						    	<tr>
						        	<th colspan="3" style="text-align: center; vertical-align: middle;">INASISTENCIA A SESIONES ORDINARIAS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle; width: 60%;">INASISTENCIA<br></th>
						      		<th style="text-align: center; vertical-align: middle;">CAUSA<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray isArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("inasistencia_sesiones_ordinarias").equals("")){
						    			isArray = JSONFactoryUtil.createJSONArray(inf.getString("inasistencia_sesiones_ordinarias"));
						    		}
						    		int cuentais = isArray.length();
						    		if(cuentais==0)
						    			cuentais=1;
						    		for(int i=1 ; i<=cuentais ; i++){
						    			
						    			JSONObject is = JSONFactoryUtil.createJSONObject();
						    			if(isArray.getJSONObject(i-1)!=null)
						    				is = isArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=is.getString("inasistencia") %>
							    		</td>
							    		<td>
							    			<%=is.getString("causa") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="docenciaUniversitaria">
						    <thead>
						    	<tr>
						        	<th colspan="7" style="text-align: center; vertical-align: middle;">DOCENCIA UNIVERSITARIAS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">SEMESTRE O AÑO</th>
						      		<th style="text-align: center; vertical-align: middle;">UNIVERSIDAD<br></th>
						      		<th style="text-align: center; vertical-align: middle;">FACULTAD<br></th>
						      		<th style="text-align: center; vertical-align: middle;">CÁTEDRA<br></th>
						      		<th style="text-align: center; vertical-align: middle;">HORARIO Y DÍA<br></th>
						      		<th style="text-align: center; vertical-align: middle;">HORAS SEMANALES</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray duArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("docencia_universitarias").equals("")){
						    			duArray = JSONFactoryUtil.createJSONArray(inf.getString("docencia_universitarias"));
						    		}
						    		int cuentadu = duArray.length();
						    		if(cuentadu==0)
						    			cuentadu=1;
						    		for(int i=1 ; i<=cuentadu ; i++){
						    			
						    			JSONObject du = JSONFactoryUtil.createJSONObject();
						    			if(duArray.getJSONObject(i-1)!=null)
						    				du = duArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=du.getInt("semestre") %>
							    		</td>
							    		<td>
							    			<%=du.getString("universidad") %>
							    		</td>
							    		<td>
							    			<%=du.getString("facultad") %>
							    		</td>
							    		<td>
							    			<%=du.getString("catedra") %>
							    		</td>
							    		<td>
							    			<%=du.getString("horario") %>
							    		</td>
							    		<td>
							    			<%=du.getInt("horas") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
					</div>
				</div>
		<% 	} %>
	</div>
	<div class="col-md-6" style="font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center" style="font-size: 16px">
				Nuevo
				<br>
				<br>
			</div>
		</div>
		<% 
		informacion_complementaria = "{'nada' : '-' }";
			if(!audi.getLog_nuevo().isEmpty()){
				informacion_complementaria = audi.getLog_nuevo();
			}
			inf = JSONFactoryUtil.createJSONObject(informacion_complementaria);
			if(inf.getString("nada").equals("-")){
		%>
		<% 	}else{ %>
				<div class="row">
					<div class="col-md-12">
						<table class="table table-bordered" id="relacionDeRecusaciones">
						    <thead>
						    	<tr>
						        	<th colspan="5" style="text-align: center; vertical-align: middle;">RELACIÓN DE RECUSACIONES</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">QUIEN RECUSA<br></th>
						      		<th style="text-align: center; vertical-align: middle;">CAUSAL<br></th>
						      		<th style="text-align: center; vertical-align: middle;">RECUSADO<br></th>
						      		<th style="text-align: center; vertical-align: middle;">DECISIÓN TOMADA<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray rrArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("relacion_recusaciones").equals("")){
						    			rrArray = JSONFactoryUtil.createJSONArray(inf.getString("relacion_recusaciones"));
						    		}
						    		int cuentarr = rrArray.length();
						    		if(cuentarr==0)
						    			cuentarr=1;
						    		for(int i=1 ; i<=cuentarr ; i++){
						    			
						    			JSONObject rr = JSONFactoryUtil.createJSONObject();
						    			if(rrArray.getJSONObject(i-1)!=null)
						    				rr = rrArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=rr.getString("quien_recusa") %>
							    		</td>
							    		<td>
							    			<%=rr.getString("causal") %>
							    		</td>
							    		<td>
							    			<%=rr.getString("recusado") %>
							    		</td>
							    		<td>
							    			<%=rr.getString("decision_tomada") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="relacionDeImpedimentos">
						    <thead>
						    	<tr>
						        	<th colspan="5" style="text-align: center; vertical-align: middle;">RELACIÓN DE IMPEDIMENTOS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">QUIEN SE DECLARA IMPEDIDO<br></th>
						      		<th style="text-align: center; vertical-align: middle;">FECHA</th>
						      		<th style="text-align: center; vertical-align: middle;">CAUSAL<br></th>
						      		<th style="text-align: center; vertical-align: middle;">DECISIÓN TOMADA<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray riArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("relacion_impedimentos").equals("")){
						    			riArray = JSONFactoryUtil.createJSONArray(inf.getString("relacion_impedimentos"));
						    		}
						    		int cuentari = riArray.length();
						    		if(cuentari==0)
						    			cuentari=1;
						    		for(int i=1 ; i<=cuentari ; i++){
						    			
						    			JSONObject ri = JSONFactoryUtil.createJSONObject();
						    			if(riArray.getJSONObject(i-1)!=null)
						    				ri = riArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=ri.getString("quien_impedido") %>
							    		</td>
							    		<td>
							    			<%=ri.getString("fecha") %>
							    		</td>
							    		<td>
							    			<%=ri.getString("causal") %>
							    		</td>
							    		<td>
							    			<%=ri.getString("decision_tomada") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="comisionServiciosInteriorPais">
						    <thead>
						    	<tr>
						        	<th colspan="8" style="text-align: center; vertical-align: middle;">COMISIÓN DE SERVICIOS AL INTERIOR DEL PAÍS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">N. RESOLUCIÓN<br></th>
						      		<th style="text-align: center; vertical-align: middle;">DESTINO<br></th>
						      		<th style="text-align: center; vertical-align: middle;">OBJETO DE LA COMISIÓN<br></th>
						      		<th style="text-align: center; vertical-align: middle;">VIÁTICOS</th>
						      		<th style="text-align: center; vertical-align: middle;">N. DÍAS</th>
						      		<th style="text-align: center; vertical-align: middle;">ENTIDAD QUE ASUME COSTOS<br></th>
						      		<th style="text-align: center; vertical-align: middle;">OBSERVACIONES<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray ipArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("comision_interior").equals("")){
						    			ipArray = JSONFactoryUtil.createJSONArray(inf.getString("comision_interior"));
						    		}
						    		int cuentaip = ipArray.length();
						    		if(cuentaip==0)
						    			cuentaip=1;
						    		for(int i=1 ; i<=cuentaip ; i++){
						    			
						    			JSONObject ip = JSONFactoryUtil.createJSONObject();
						    			if(ipArray.getJSONObject(i-1)!=null)
						    				ip = ipArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=ip.getString("numero_resolucion") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("destino") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("objeto_comision") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("viaticos") %>
							    		</td>
							    		<td>
							    			<%=ip.getInt("dias") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("entidad") %>
							    		</td>
							    		<td>
							    			<%=ip.getString("observaciones") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="comisionServiciosExteriorPais">
						    <thead>
						    	<tr>
						        	<th colspan="8" style="text-align: center; vertical-align: middle;">COMISIÓN DE SERVICIOS AL EXTERIOR DEL PAÍS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">N. RESOLUCIÓN<br></th>
						      		<th style="text-align: center; vertical-align: middle;">DESTINO<br></th>
						      		<th style="text-align: center; vertical-align: middle;">OBJETO DE LA COMISIÓN<br></th>
						      		<th style="text-align: center; vertical-align: middle;">VIÁTICOS</th>
						      		<th style="text-align: center; vertical-align: middle;">N. DÍAS</th>
						      		<th style="text-align: center; vertical-align: middle;">ENTIDAD QUE ASUME COSTOS<br></th>
						      		<th style="text-align: center; vertical-align: middle;">OBSERVACIONES<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray epArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("comision_exterior").equals("")){
						    			epArray = JSONFactoryUtil.createJSONArray(inf.getString("comision_exterior"));
						    		}
						    		int cuentaep = epArray.length();
						    		if(cuentaep==0)
						    			cuentaep=1;
						    		for(int i=1 ; i<=cuentaep ; i++){
						    			
						    			JSONObject ep = JSONFactoryUtil.createJSONObject();
						    			if(epArray.getJSONObject(i-1)!=null)
						    				ep = epArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=ep.getString("numero_resolucion") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("destino") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("objeto_comision") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("viaticos") %>
							    		</td>
							    		<td>
							    			<%=ep.getInt("dias") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("entidad") %>
							    		</td>
							    		<td>
							    			<%=ep.getString("observaciones") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="inasistenciaSesion">
						    <thead>
						    	<tr>
						        	<th colspan="3" style="text-align: center; vertical-align: middle;">INASISTENCIA A SESIONES ORDINARIAS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle; width: 60%;">INASISTENCIA<br></th>
						      		<th style="text-align: center; vertical-align: middle;">CAUSA<br></th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray isArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("inasistencia_sesiones_ordinarias").equals("")){
						    			isArray = JSONFactoryUtil.createJSONArray(inf.getString("inasistencia_sesiones_ordinarias"));
						    		}
						    		int cuentais = isArray.length();
						    		if(cuentais==0)
						    			cuentais=1;
						    		for(int i=1 ; i<=cuentais ; i++){
						    			
						    			JSONObject is = JSONFactoryUtil.createJSONObject();
						    			if(isArray.getJSONObject(i-1)!=null)
						    				is = isArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=is.getString("inasistencia") %>
							    		</td>
							    		<td>
							    			<%=is.getString("causa") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<br>
						<table class="table table-bordered" id="docenciaUniversitaria">
						    <thead>
						    	<tr>
						        	<th colspan="7" style="text-align: center; vertical-align: middle;">DOCENCIA UNIVERSITARIAS</th>
						      	</tr>
						      	<tr>
						      		<th style="text-align: center; vertical-align: middle;">SEMESTRE O AÑO</th>
						      		<th style="text-align: center; vertical-align: middle;">UNIVERSIDAD<br></th>
						      		<th style="text-align: center; vertical-align: middle;">FACULTAD<br></th>
						      		<th style="text-align: center; vertical-align: middle;">CÁTEDRA<br></th>
						      		<th style="text-align: center; vertical-align: middle;">HORARIO Y DÍA<br></th>
						      		<th style="text-align: center; vertical-align: middle;">HORAS SEMANALES</th>
						      	</tr>
						    </thead>
						    <tbody>
						    	<%
						    		JSONArray duArray = JSONFactoryUtil.createJSONArray();
						    		if(!inf.getString("docencia_universitarias").equals("")){
						    			duArray = JSONFactoryUtil.createJSONArray(inf.getString("docencia_universitarias"));
						    		}
						    		int cuentadu = duArray.length();
						    		if(cuentadu==0)
						    			cuentadu=1;
						    		for(int i=1 ; i<=cuentadu ; i++){
						    			
						    			JSONObject du = JSONFactoryUtil.createJSONObject();
						    			if(duArray.getJSONObject(i-1)!=null)
						    				du = duArray.getJSONObject(i-1);
						    	%>
							    	<tr>
							    		<td>
							    			<%=du.getInt("semestre") %>
							    		</td>
							    		<td>
							    			<%=du.getString("universidad") %>
							    		</td>
							    		<td>
							    			<%=du.getString("facultad") %>
							    		</td>
							    		<td>
							    			<%=du.getString("catedra") %>
							    		</td>
							    		<td>
							    			<%=du.getString("horario") %>
							    		</td>
							    		<td>
							    			<%=du.getInt("horas") %>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
					</div>
				</div>
		<% 	} %>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Funcionario sin registrar") ){
		
		
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid; font-size: 10px">
		<div class="row">
			<div class="col-md-12 text-center">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% if( !audi.getLog_anterior().isEmpty() ){ JSONObject anterior = JSONFactoryUtil.createJSONObject(audi.getLog_anterior()); %>
			<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Correo</label>
							<div>
								<%=anterior.getString("correo") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Numero Documento</label>
							<div>
								<%=anterior.getString("numero_documento") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Cargo</label>
							<div>
								<%=anterior.getString("cargo") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Nombres</label>
							<div>
								<%=anterior.getString("nombres") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Apellidos</label>
							<div>
								<%=anterior.getString("apellidos") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Código Despacho</label>
							<div>
								<%=anterior.getString("despacho") %>
							</div>
						</div>
					</div>				
				</div>
		<% } %>
	</div>
	<div class="col-md-6" style="font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center">
				Nuevo
				<br>
				<br>
			</div>
		</div>								
		<% if( !audi.getLog_nuevo().isEmpty() ){ JSONObject nuevo = JSONFactoryUtil.createJSONObject(audi.getLog_nuevo()); %>
			<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Correo</label>
							<div>
								<%=nuevo.getString("correo") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Numero Documento</label>
							<div>
								<%=nuevo.getString("numero_documento") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Cargo</label>
							<div>
								<%=nuevo.getString("cargo") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Nombres</label>
							<div>
								<%=nuevo.getString("nombres") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Apellidos</label>
							<div>
								<%=nuevo.getString("apellidos") %>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Código Despacho</label>
							<div>
								<%=nuevo.getString("despacho") %>
							</div>
						</div>
					</div>				
				</div>
		<% } %>
	</div>
</div>
<% } %>

<%
	if( audi.getCampo_modifico().equals("Conflicto de Intereses") ){
%>

<div class="row">
	<div class="col-md-6" style="border-right: 1px solid; font-size: 10px">
		<div class="row">
			<div class="col-md-12 text-center">
				Anterior
				<br>
				<br>
			</div>
		</div>
		<% if( !audi.getLog_anterior().isEmpty() ){
			JSONObject conflicto_intereses = JSONFactoryUtil.createJSONObject(audi.getLog_anterior());
			%>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label for="informacionConyuge">INFORMACIÓN DE CÓNYUGE Y/O COMPAÑERO(A) PERMANENTE</label>
						<div id="informacionConyuge">
							<div class="col-md-12">
								<p>En la actualidad tengo sociedad conyugal o de hecho vigente</p>
								<br>
								<%=conflicto_intereses.getString("respuesta") %>
								<br>
								<br>
								<table class="table table-bordered" id="sociedadConyugalTable">
								    <thead>
								      	<tr>
								      		<th style="text-align: center; vertical-align: middle;">NOMBRE COMPLETO (nombres y apellidos)</th>
								      		<th style="text-align: center; vertical-align: middle;">TIPO DE SOCIEDAD</th>
								      		<th style="text-align: center; vertical-align: middle;">DOCUMENTO DE IDENTIDAD</th>
								      	</tr>
								    </thead>
								    <tbody>
								    	<%
								    		JSONArray conyugeArray = JSONFactoryUtil.createJSONArray();
								    		if(!conflicto_intereses.getString("informacion_coyuge").equals("")){
								    			conyugeArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("informacion_coyuge"));
								    		} 
								    		int cuentaConyuge = conyugeArray.length();
								    		if(cuentaConyuge==0)
								    			cuentaConyuge=1;
								    		for(int i=1 ; i<=cuentaConyuge ; i++){							    			
								    			JSONObject sc = JSONFactoryUtil.createJSONObject();
								    			if(conyugeArray.getJSONObject(i-1)!=null)
								    				sc = conyugeArray.getJSONObject(i-1);
								    	%>
									    	<tr>
									    		<td>
									    			<%=sc.getString("nombreConyuge") %>
									    		</td>
									    		<td>
									    			<%=sc.getString("tipoSociedad") %>
									    		</td>
									    		<td>
									    			<%=sc.getString("numeroDocumento") %>
									    		</td>
									    	</tr>
								    	<% } %>
								    </tbody>
								</table>
								<br>
								<br>						  	
							</div>
						</div>
					</div>
					<div class="form-group col-md-12">
						<label for="informacionParientes">INFORMACIÓN DE PARIENTES DE CONSANGUINIDAD, AFINIDAD Y PRIMERO CIVIL</label>
						<div id="informacionParientes">
							<div class="col-md-12">
								<p>A continuación, se solicitará información de los parientes hasta el cuarto grado de consanguinidad, segundo de afinidad y primero civil que sea susceptible de generar conflicto de interés frente a la labor o actividad que desempeña</p>	
								<br>
								<table class="table table-bordered" id="parientesTable">
								    <thead>
								      	<tr>
								      		<th colspan="6">PARIENTES HASTA EL CUARTO GRADO DE CONSANGUINIDAD, SEGUNDO GRADO DE AFINIDAD Y PRIMERO CIVIL</th>
								      	</tr>
								      	<tr>
								      		<th style="text-align: center; vertical-align: middle;" rowspan="2">PARENTESCO</th>
								      		<th style="text-align: center; vertical-align: middle;" colspan="4">NOMBRE COMPLETO(nombres y apellidos)</th>
								      		<th style="text-align: center; vertical-align: middle;" rowspan="2">DOCUMENTO DE IDENTIDAD</th>
								      	</tr>
								      	<tr>
								      		<th style="text-align: center; vertical-align: middle;">Primer Nombre</th>
								      		<th style="text-align: center; vertical-align: middle;">Segundo Nombre</th>
								      		<th style="text-align: center; vertical-align: middle;">Primer Apellido</th>
								      		<th style="text-align: center; vertical-align: middle;">Segundo Apellido</th>
								      	</tr>
								    </thead>
								    <tbody>
								    	<%
								    		JSONArray parienteArray = JSONFactoryUtil.createJSONArray();
								    		 if(!conflicto_intereses.getString("informacion_parientes").equals("")){
								    			 parienteArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("informacion_parientes"));
								    		} 
								    		int cuentaPariente = parienteArray.length();
								    		if(cuentaPariente==0)
								    			cuentaPariente=1;
								    		for(int i=1 ; i<=cuentaPariente ; i++){
								    			
								    			JSONObject ip = JSONFactoryUtil.createJSONObject();
								    			if(parienteArray.getJSONObject(i-1)!=null)
								    				ip = parienteArray.getJSONObject(i-1);
								    	%>
									    	<tr>
									    		<td>
									    			<%=ip.getString("parentesco") %>
									    		</td>
									    		<td>
									    			<%=ip.getString("primerNombre") %>
									    		</td>
									    		<td>
									    			<%=ip.getString("segundoNombre") %>
									    		</td>
									    		<td>
									    			<%=ip.getString("primerApellido") %>
									    		</td>
									    		<td>
									    			<%=ip.getString("segundoApellido") %>
									    		</td>
									    		<td>
									    			<%=ip.getString("numeroDocumento") %>
									    		</td>
									    	</tr>
								    	<% } %>
								    </tbody>
								</table>
								<br>
								<br>						  	
							</div>
						</div>
					</div>
					<div class="form-group col-md-12">
						<label for="participacionGremios">DE PARTICIPACIÓN EN GREMIOS, SINDICATOS, GRUPOS SOCIALES O ECONÓMICOS U ORGANIZACIONES CON ÁNIMO Y SIN ÁNIMO DE LUCRO</label>
						<div id="participacionGremios">
							<div class="col-md-12">
								<p>Participación en gremios, sindicatos, grupos sociales o económicos u organizaciones con ánimo o sin ánimo de lucro (nacional o extranjera):</p>	
								<br>
								<table class="table table-bordered" id="gremiosTable">
								    <thead>
								      	<tr>
								      		<th style="text-align: center; vertical-align: middle;">GREMIO, SINDICATO, GRUPO SOCIAL O ECONÓMICO U ORGANIZACIÓN</th>
								      		<th style="text-align: center; vertical-align: middle;">CALIDAD DE MIEMBRO</th>
								      		<th style="text-align: center; vertical-align: middle;">PAÍS</th>
								      	</tr>
								    </thead>
								    <tbody>
								    	<%
								    		JSONArray gremiosArray = JSONFactoryUtil.createJSONArray();
								    		 if(!conflicto_intereses.getString("participacion_gremios").equals("")){
								    			 gremiosArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("participacion_gremios"));
								    		} 
								    		int cuentaGremios = gremiosArray.length();
								    		if(cuentaGremios==0)
								    			cuentaGremios=1;
								    		for(int i=1 ; i<=cuentaGremios ; i++){
								    			
								    			JSONObject pg = JSONFactoryUtil.createJSONObject();
								    			if(gremiosArray.getJSONObject(i-1)!=null)
								    				pg = gremiosArray.getJSONObject(i-1);
								    	%>
									    	<tr>
									    		<td>
									    			<%=pg.getString("gremio") %>
									    		</td>
									    		<td>
									    			<%=pg.getString("calidadMiembro") %>
									    		</td>
									    		<td>
									    			<%=pg.getString("pais") %>
									    		</td>
									    	</tr>
								    	<% } %>
								    </tbody>
								</table>
								<br>
								<br>						  	
							</div>
						</div>
					</div>
					<div class="form-group col-md-12">
						<label for="otrasInversiones">OTRAS INVERSIONES</label>
						<div id="otrasInversiones">
							<div class="col-md-12">
								<p>Los fideicomisos y encargos fiduciarios de los cuales soy constituyente o beneficiario en Colombia y en el exterior son</p>	
								<br>
								<table class="table table-bordered" id="fideicomisosTable">
								    <thead>
								      	<tr>
								      		<th style="text-align: center; vertical-align: middle;">NOMBRE DEL FIDEICOMISO O ENCARGO FIDUCIARIO</th>
								      		<th style="text-align: center; vertical-align: middle;">CALIDAD</th>
								      		<th style="text-align: center; vertical-align: middle;">VALOR</th>
								      		<th style="text-align: center; vertical-align: middle;">PAÍS</th>
								      	</tr>
								    </thead>
								    <tbody>
								    	<%
								    		JSONArray fideicomisosArray = JSONFactoryUtil.createJSONArray();
								    		 if(!conflicto_intereses.getString("otras_inversiones_fideicomiso").equals("")){
								    			 fideicomisosArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("otras_inversiones_fideicomiso"));
								    		} 
								    		int cuentaFideicomisos = fideicomisosArray.length();
								    		if(cuentaFideicomisos==0)
								    			cuentaFideicomisos=1;
								    		for(int i=1 ; i<=cuentaFideicomisos ; i++){
								    			
								    			JSONObject f = JSONFactoryUtil.createJSONObject();
								    			if(fideicomisosArray.getJSONObject(i-1)!=null)
								    				f = fideicomisosArray.getJSONObject(i-1);
								    	%>
									    	<tr>
									    		<td>
									    			<%=f.getString("nombreFideicomiso") %>
									    		</td>
									    		<td>
									    			<%=f.getString("calidadFideicomiso") %>
									    		</td>
									    		<td>
									    			<%=f.getString("valorFideicomiso") %>
									    		</td>
									    		<td>
									    			<%=f.getString("paisFideicomiso") %>
									    		</td>
									    	</tr>
								    	<% } %>
								    </tbody>
								</table><br>
								<br>						  	
							</div>
							<div class="col-md-12">
								<p>Las inversiones en bonos, fondos de inversión, fondos de ahorro voluntario en Colombia y en el exterior u otros son</p>	
								<br>
								<table class="table table-bordered" id="inversionTable">
								    <thead>
								      	<tr>
								      		<th style="text-align: center; vertical-align: middle;">TIPO DE INVERSIÓN</th>
								      		<th style="text-align: center; vertical-align: middle;">VALOR</th>
								      		<th style="text-align: center; vertical-align: middle;">PAÍS</th>
								      	</tr>
								    </thead>
								    <tbody>
								    	<%
								    		JSONArray inversionArray = JSONFactoryUtil.createJSONArray();
								    		 if(!conflicto_intereses.getString("otras_inversiones_inversiones").equals("")){
								    			inversionArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("otras_inversiones_inversiones"));
								    		} 
								    		int cuentaInversion = inversionArray.length();
								    		if(cuentaInversion==0)
								    			cuentaInversion=1;
								    		for(int i=1 ; i<=cuentaInversion ; i++){
								    			
								    			JSONObject in = JSONFactoryUtil.createJSONObject();
								    			if(inversionArray.getJSONObject(i-1)!=null)
								    				in = inversionArray.getJSONObject(i-1);
								    	%>
									    	<tr id="<%="inversion"+i %>">
									    		<td>
									    			<%=in.getString("tipoInversion") %>
									    		</td>
									    		<td>
									    			<%=in.getString("valorInversion") %>
									    		</td>
									    		<td>
									    			<%=in.getString("paisInversion") %>
									    		</td>
									    	</tr>
								    	<% } %>
								    </tbody>
								</table>
								<br>
								<br>						  	
							</div>
						</div>
					</div>
					<div class="form-group col-md-12">
						<label for="participacionGremios">DONACIONES QUE REPRESENTARON REDUCCIONES EN LA DECLARACIÓN DE RENTA</label>
						<div id="participacionGremios">
							<div class="col-md-12">
								<table class="table table-bordered" id="donacionesTable">
								    <thead>
								      	<tr>
								      		<th style="text-align: center; vertical-align: middle;">NOMBRE</th>
								      		<th style="text-align: center; vertical-align: middle;">VALOR DE LA DONACIÓN</th>
								      	</tr>
								    </thead>
								    <tbody>
								    	<%
								    		JSONArray donacionesArray = JSONFactoryUtil.createJSONArray();
								    		 if(!conflicto_intereses.getString("donaciones").equals("")){
								    			donacionesArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("donaciones"));
								    		} 
								    		int cuentaDonaciones = donacionesArray.length();
								    		if(cuentaDonaciones==0)
								    			cuentaDonaciones=1;
								    		for(int i=1 ; i<=cuentaDonaciones ; i++){
								    			
								    			JSONObject d = JSONFactoryUtil.createJSONObject();
								    			if(donacionesArray.getJSONObject(i-1)!=null)
								    				d = donacionesArray.getJSONObject(i-1);
								    	%>
									    	<tr id="<%="donacion"+i %>">
									    		<td>
									    			<%=d.getString("nombreDonacion") %>
									    		</td>
									    		<td>
									    			<%=d.getString("valorDonacion") %>
									    		</td>
									    	</tr>
								    	<% } %>
								    </tbody>
								</table>
								<br>
								<br>						  	
							</div>
						</div>
					</div>
					<div class="form-group col-md-12">
						<label for="participacionGremios">POTENCIALES CONFLICTOS DE INTERÉS</label>
						<div id="participacionGremios">
							<div class="col-md-12">
								<p>Escriba otros intereses personales que podrían constituir una posible situación de conflicto de intereses, por ejemplo: - Actividades que desempeño, negocios, establecimientos que poseo etc. - Actividades o negocios de mi cónyuge o compañero(a) permanente y parientes hasta el cuarto grado de consanguinidad, segundo de afinidad y primero civil, de acuerdo con lo descrito en el numeral 2.2 - Actividades o negocios de mi socio de derecho o hecho</p>
								<br>
								<table class="table table-bordered" id="potencialesTable">
								    <thead>
								      	<tr>
								      		<th style="text-align: center; vertical-align: middle;">DESCRIPCIÓN DEL POTENCIAL CONFLICTO DE INTERESES</th>
								      	</tr>
								    </thead>
								    <tbody>
								    	<%
								    		JSONArray potencialesArray = JSONFactoryUtil.createJSONArray();
								    		 if(!conflicto_intereses.getString("potenciales").equals("")){
								    			potencialesArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("potenciales"));
								    		} 
								    		int cuentaPotenciales = potencialesArray.length();
								    		if(cuentaPotenciales==0)
								    			cuentaPotenciales=1;
								    		for(int i=1 ; i<=cuentaPotenciales ; i++){
								    			
								    			JSONObject po = JSONFactoryUtil.createJSONObject();
								    			if(potencialesArray.getJSONObject(i-1)!=null)
								    				po = potencialesArray.getJSONObject(i-1);
								    	%>
									    	<tr>
									    		<td>
									    			<%=po.getString("descripcionPotenciales") %>
									    		</td>
									    	</tr>
								    	<% } %>
								    </tbody>
								</table>
								<br>
								<br>						  	
							</div>
						</div>
					</div>				
				</div>
		<% } %>
	</div>
	<div class="col-md-6" style="font-size: 10px;">
		<div class="row">
			<div class="col-md-12 text-center">
				Nuevo
				<br>
				<br>
			</div>
		</div>								
		<% if( !audi.getLog_nuevo().isEmpty() ){
			JSONObject conflicto_intereses = JSONFactoryUtil.createJSONObject(audi.getLog_nuevo());
		%>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label for="informacionConyuge">INFORMACIÓN DE CÓNYUGE Y/O COMPAÑERO(A) PERMANENTE</label>
					<div id="informacionConyuge">
						<div class="col-md-12">
							<p>En la actualidad tengo sociedad conyugal o de hecho vigente</p>
							<br>
							<%=conflicto_intereses.getString("respuesta") %>
							<br>
							<br>
							<table class="table table-bordered" id="sociedadConyugalTable">
							    <thead>
							      	<tr>
							      		<th style="text-align: center; vertical-align: middle;">NOMBRE COMPLETO (nombres y apellidos)</th>
							      		<th style="text-align: center; vertical-align: middle;">TIPO DE SOCIEDAD</th>
							      		<th style="text-align: center; vertical-align: middle;">DOCUMENTO DE IDENTIDAD</th>
							      	</tr>
							    </thead>
							    <tbody>
							    	<%
							    		JSONArray conyugeArray = JSONFactoryUtil.createJSONArray();
							    		if(!conflicto_intereses.getString("informacion_coyuge").equals("")){
							    			conyugeArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("informacion_coyuge"));
							    		} 
							    		int cuentaConyuge = conyugeArray.length();
							    		if(cuentaConyuge==0)
							    			cuentaConyuge=1;
							    		for(int i=1 ; i<=cuentaConyuge ; i++){							    			
							    			JSONObject sc = JSONFactoryUtil.createJSONObject();
							    			if(conyugeArray.getJSONObject(i-1)!=null)
							    				sc = conyugeArray.getJSONObject(i-1);
							    	%>
								    	<tr>
								    		<td>
								    			<%=sc.getString("nombreConyuge") %>
								    		</td>
								    		<td>
								    			<%=sc.getString("tipoSociedad") %>
								    		</td>
								    		<td>
								    			<%=sc.getString("numeroDocumento") %>
								    		</td>
								    	</tr>
							    	<% } %>
							    </tbody>
							</table>
							<br>
							<br>						  	
						</div>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label for="informacionParientes">INFORMACIÓN DE PARIENTES DE CONSANGUINIDAD, AFINIDAD Y PRIMERO CIVIL</label>
					<div id="informacionParientes">
						<div class="col-md-12">
							<p>A continuación, se solicitará información de los parientes hasta el cuarto grado de consanguinidad, segundo de afinidad y primero civil que sea susceptible de generar conflicto de interés frente a la labor o actividad que desempeña</p>	
							<br>
							<table class="table table-bordered" id="parientesTable">
							    <thead>
							      	<tr>
							      		<th colspan="6">PARIENTES HASTA EL CUARTO GRADO DE CONSANGUINIDAD, SEGUNDO GRADO DE AFINIDAD Y PRIMERO CIVIL</th>
							      	</tr>
							      	<tr>
							      		<th style="text-align: center; vertical-align: middle;" rowspan="2">PARENTESCO</th>
							      		<th style="text-align: center; vertical-align: middle;" colspan="4">NOMBRE COMPLETO(nombres y apellidos)</th>
							      		<th style="text-align: center; vertical-align: middle;" rowspan="2">DOCUMENTO DE IDENTIDAD</th>
							      	</tr>
							      	<tr>
							      		<th style="text-align: center; vertical-align: middle;">Primer Nombre</th>
							      		<th style="text-align: center; vertical-align: middle;">Segundo Nombre</th>
							      		<th style="text-align: center; vertical-align: middle;">Primer Apellido</th>
							      		<th style="text-align: center; vertical-align: middle;">Segundo Apellido</th>
							      	</tr>
							    </thead>
							    <tbody>
							    	<%
							    		JSONArray parienteArray = JSONFactoryUtil.createJSONArray();
							    		 if(!conflicto_intereses.getString("informacion_parientes").equals("")){
							    			 parienteArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("informacion_parientes"));
							    		} 
							    		int cuentaPariente = parienteArray.length();
							    		if(cuentaPariente==0)
							    			cuentaPariente=1;
							    		for(int i=1 ; i<=cuentaPariente ; i++){
							    			
							    			JSONObject ip = JSONFactoryUtil.createJSONObject();
							    			if(parienteArray.getJSONObject(i-1)!=null)
							    				ip = parienteArray.getJSONObject(i-1);
							    	%>
								    	<tr>
								    		<td>
								    			<%=ip.getString("parentesco") %>
								    		</td>
								    		<td>
								    			<%=ip.getString("primerNombre") %>
								    		</td>
								    		<td>
								    			<%=ip.getString("segundoNombre") %>
								    		</td>
								    		<td>
								    			<%=ip.getString("primerApellido") %>
								    		</td>
								    		<td>
								    			<%=ip.getString("segundoApellido") %>
								    		</td>
								    		<td>
								    			<%=ip.getString("numeroDocumento") %>
								    		</td>
								    	</tr>
							    	<% } %>
							    </tbody>
							</table>
							<br>
							<br>						  	
						</div>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label for="participacionGremios">DE PARTICIPACIÓN EN GREMIOS, SINDICATOS, GRUPOS SOCIALES O ECONÓMICOS U ORGANIZACIONES CON ÁNIMO Y SIN ÁNIMO DE LUCRO</label>
					<div id="participacionGremios">
						<div class="col-md-12">
							<p>Participación en gremios, sindicatos, grupos sociales o económicos u organizaciones con ánimo o sin ánimo de lucro (nacional o extranjera):</p>	
							<br>
							<table class="table table-bordered" id="gremiosTable">
							    <thead>
							      	<tr>
							      		<th style="text-align: center; vertical-align: middle;">GREMIO, SINDICATO, GRUPO SOCIAL O ECONÓMICO U ORGANIZACIÓN</th>
							      		<th style="text-align: center; vertical-align: middle;">CALIDAD DE MIEMBRO</th>
							      		<th style="text-align: center; vertical-align: middle;">PAÍS</th>
							      	</tr>
							    </thead>
							    <tbody>
							    	<%
							    		JSONArray gremiosArray = JSONFactoryUtil.createJSONArray();
							    		 if(!conflicto_intereses.getString("participacion_gremios").equals("")){
							    			 gremiosArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("participacion_gremios"));
							    		} 
							    		int cuentaGremios = gremiosArray.length();
							    		if(cuentaGremios==0)
							    			cuentaGremios=1;
							    		for(int i=1 ; i<=cuentaGremios ; i++){
							    			
							    			JSONObject pg = JSONFactoryUtil.createJSONObject();
							    			if(gremiosArray.getJSONObject(i-1)!=null)
							    				pg = gremiosArray.getJSONObject(i-1);
							    	%>
								    	<tr>
								    		<td>
								    			<%=pg.getString("gremio") %>
								    		</td>
								    		<td>
								    			<%=pg.getString("calidadMiembro") %>
								    		</td>
								    		<td>
								    			<%=pg.getString("pais") %>
								    		</td>
								    	</tr>
							    	<% } %>
							    </tbody>
							</table>
							<br>
							<br>						  	
						</div>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label for="otrasInversiones">OTRAS INVERSIONES</label>
					<div id="otrasInversiones">
						<div class="col-md-12">
							<p>Los fideicomisos y encargos fiduciarios de los cuales soy constituyente o beneficiario en Colombia y en el exterior son</p>	
							<br>
							<table class="table table-bordered" id="fideicomisosTable">
							    <thead>
							      	<tr>
							      		<th style="text-align: center; vertical-align: middle;">NOMBRE DEL FIDEICOMISO O ENCARGO FIDUCIARIO</th>
							      		<th style="text-align: center; vertical-align: middle;">CALIDAD</th>
							      		<th style="text-align: center; vertical-align: middle;">VALOR</th>
							      		<th style="text-align: center; vertical-align: middle;">PAÍS</th>
							      	</tr>
							    </thead>
							    <tbody>
							    	<%
							    		JSONArray fideicomisosArray = JSONFactoryUtil.createJSONArray();
							    		 if(!conflicto_intereses.getString("otras_inversiones_fideicomiso").equals("")){
							    			 fideicomisosArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("otras_inversiones_fideicomiso"));
							    		} 
							    		int cuentaFideicomisos = fideicomisosArray.length();
							    		if(cuentaFideicomisos==0)
							    			cuentaFideicomisos=1;
							    		for(int i=1 ; i<=cuentaFideicomisos ; i++){
							    			
							    			JSONObject f = JSONFactoryUtil.createJSONObject();
							    			if(fideicomisosArray.getJSONObject(i-1)!=null)
							    				f = fideicomisosArray.getJSONObject(i-1);
							    	%>
								    	<tr>
								    		<td>
								    			<%=f.getString("nombreFideicomiso") %>
								    		</td>
								    		<td>
								    			<%=f.getString("calidadFideicomiso") %>
								    		</td>
								    		<td>
								    			<%=f.getString("valorFideicomiso") %>
								    		</td>
								    		<td>
								    			<%=f.getString("paisFideicomiso") %>
								    		</td>
								    	</tr>
							    	<% } %>
							    </tbody>
							</table><br>
							<br>						  	
						</div>
						<div class="col-md-12">
							<p>Las inversiones en bonos, fondos de inversión, fondos de ahorro voluntario en Colombia y en el exterior u otros son</p>	
							<br>
							<table class="table table-bordered" id="inversionTable">
							    <thead>
							      	<tr>
							      		<th style="text-align: center; vertical-align: middle;">TIPO DE INVERSIÓN</th>
							      		<th style="text-align: center; vertical-align: middle;">VALOR</th>
							      		<th style="text-align: center; vertical-align: middle;">PAÍS</th>
							      	</tr>
							    </thead>
							    <tbody>
							    	<%
							    		JSONArray inversionArray = JSONFactoryUtil.createJSONArray();
							    		 if(!conflicto_intereses.getString("otras_inversiones_inversiones").equals("")){
							    			inversionArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("otras_inversiones_inversiones"));
							    		} 
							    		int cuentaInversion = inversionArray.length();
							    		if(cuentaInversion==0)
							    			cuentaInversion=1;
							    		for(int i=1 ; i<=cuentaInversion ; i++){
							    			
							    			JSONObject in = JSONFactoryUtil.createJSONObject();
							    			if(inversionArray.getJSONObject(i-1)!=null)
							    				in = inversionArray.getJSONObject(i-1);
							    	%>
								    	<tr id="<%="inversion"+i %>">
								    		<td>
								    			<%=in.getString("tipoInversion") %>
								    		</td>
								    		<td>
								    			<%=in.getString("valorInversion") %>
								    		</td>
								    		<td>
								    			<%=in.getString("paisInversion") %>
								    		</td>
								    	</tr>
							    	<% } %>
							    </tbody>
							</table>
							<br>
							<br>						  	
						</div>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label for="participacionGremios">DONACIONES QUE REPRESENTARON REDUCCIONES EN LA DECLARACIÓN DE RENTA</label>
					<div id="participacionGremios">
						<div class="col-md-12">
							<table class="table table-bordered" id="donacionesTable">
							    <thead>
							      	<tr>
							      		<th style="text-align: center; vertical-align: middle;">NOMBRE</th>
							      		<th style="text-align: center; vertical-align: middle;">VALOR DE LA DONACIÓN</th>
							      	</tr>
							    </thead>
							    <tbody>
							    	<%
							    		JSONArray donacionesArray = JSONFactoryUtil.createJSONArray();
							    		 if(!conflicto_intereses.getString("donaciones").equals("")){
							    			donacionesArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("donaciones"));
							    		} 
							    		int cuentaDonaciones = donacionesArray.length();
							    		if(cuentaDonaciones==0)
							    			cuentaDonaciones=1;
							    		for(int i=1 ; i<=cuentaDonaciones ; i++){
							    			
							    			JSONObject d = JSONFactoryUtil.createJSONObject();
							    			if(donacionesArray.getJSONObject(i-1)!=null)
							    				d = donacionesArray.getJSONObject(i-1);
							    	%>
								    	<tr id="<%="donacion"+i %>">
								    		<td>
								    			<%=d.getString("nombreDonacion") %>
								    		</td>
								    		<td>
								    			<%=d.getString("valorDonacion") %>
								    		</td>
								    	</tr>
							    	<% } %>
							    </tbody>
							</table>
							<br>
							<br>						  	
						</div>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label for="participacionGremios">POTENCIALES CONFLICTOS DE INTERÉS</label>
					<div id="participacionGremios">
						<div class="col-md-12">
							<p>Escriba otros intereses personales que podrían constituir una posible situación de conflicto de intereses, por ejemplo: - Actividades que desempeño, negocios, establecimientos que poseo etc. - Actividades o negocios de mi cónyuge o compañero(a) permanente y parientes hasta el cuarto grado de consanguinidad, segundo de afinidad y primero civil, de acuerdo con lo descrito en el numeral 2.2 - Actividades o negocios de mi socio de derecho o hecho</p>
							<br>
							<table class="table table-bordered" id="potencialesTable">
							    <thead>
							      	<tr>
							      		<th style="text-align: center; vertical-align: middle;">DESCRIPCIÓN DEL POTENCIAL CONFLICTO DE INTERESES</th>
							      	</tr>
							    </thead>
							    <tbody>
							    	<%
							    		JSONArray potencialesArray = JSONFactoryUtil.createJSONArray();
							    		 if(!conflicto_intereses.getString("potenciales").equals("")){
							    			potencialesArray = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("potenciales"));
							    		} 
							    		int cuentaPotenciales = potencialesArray.length();
							    		if(cuentaPotenciales==0)
							    			cuentaPotenciales=1;
							    		for(int i=1 ; i<=cuentaPotenciales ; i++){
							    			
							    			JSONObject po = JSONFactoryUtil.createJSONObject();
							    			if(potencialesArray.getJSONObject(i-1)!=null)
							    				po = potencialesArray.getJSONObject(i-1);
							    	%>
								    	<tr>
								    		<td>
								    			<%=po.getString("descripcionPotenciales") %>
								    		</td>
								    	</tr>
							    	<% } %>
							    </tbody>
							</table>
							<br>
							<br>						  	
						</div>
					</div>
				</div>				
			</div>
		<% } %>
	</div>
</div>
<% } %>

<% } %>
<br>
<div class="row">
	<div class="col-md-12 text-center">
		<button type="button" class="btn" onclick="volver()">Vovler</button>
	</div>
</div>
<script type="text/javascript">
function volver(){
	window.location.href = '<%=volver%>';
}
</script>