<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.List"%>
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
		List<modeloBasico> decision = consultas.getDecision();
		int cantidadRR = 1;
		String idsRR = "";
		int cantidadRI = 1;
		String idsRI = "";
		int cantidadIP = 1;
		String idsIP = "";
		int cantidadEP = 1;
		String idsEP = "";
		int cantidadIS = 1;
		String idsIS = "";
		int cantidadDU = 1;
		String idsDU = "";
		JSONObject informacion_complementaria = JSONFactoryUtil.createJSONObject();
		if(!usuario.getInformacion_complementaria().isEmpty()){
			informacion_complementaria = JSONFactoryUtil.createJSONObject(usuario.getInformacion_complementaria());
			cantidadRR = informacion_complementaria.getInt("cantidadRR");
			if(cantidadRR==0)
				cantidadRR=1;
			cantidadRI = informacion_complementaria.getInt("cantidadRI");
			if(cantidadRI==0)
				cantidadRI=1;
			cantidadIP = informacion_complementaria.getInt("cantidadIP");
			if(cantidadIP==0)
				cantidadIP=1;
			cantidadEP = informacion_complementaria.getInt("cantidadEP");
			if(cantidadEP==0)
				cantidadEP=1;
			cantidadIS = informacion_complementaria.getInt("cantidadIS");
			if(cantidadIS==0)
				cantidadIS=1;
			cantidadDU = informacion_complementaria.getInt("cantidadDU");
			if(cantidadDU==0)
				cantidadDU=1;
		}
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
		
	 	Date hoy = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechaHoy = formato.format(hoy);
%>

<portlet:actionURL var="guardarInformacionComplementaria" name="guardarInformacionComplementaria"></portlet:actionURL>

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
				<h2>Información Complementaria</h2>
			</div>
		</div>
		<br>
		<form action="<%=guardarInformacionComplementaria %>" method="post">
			<div class="row">
				<div class="col-md-11 col-md-offset-1">
					<table class="table table-bordered" id="relacionDeRecusaciones">
					    <thead>
					    	<tr>
					        	<th colspan="5" style="text-align: center; vertical-align: middle;">RELACIÓN DE RECUSACIONES</th>
					      	</tr>
					      	<tr>
					      		<th style="text-align: center; vertical-align: middle;">QUIEN RECUSA<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">CAUSAL<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">RECUSADO<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">DECISIÓN TOMADA<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      	</tr>
					    </thead>
					    <tbody>
					    	<%
					    		JSONArray rrArray = JSONFactoryUtil.createJSONArray();
					    		if(!informacion_complementaria.getString("relacion_recusaciones").equals("")){
					    			rrArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("relacion_recusaciones"));
					    		}
					    		int cuentarr = rrArray.length();
					    		if(cuentarr==0)
					    			cuentarr=1;
					    		for(int i=1 ; i<=cuentarr ; i++){
					    			if(i<cuentarr)
					    				idsRR+=i+",";
					    			else
					    				idsRR+=i;
					    			
					    			JSONObject rr = JSONFactoryUtil.createJSONObject();
					    			if(rrArray.getJSONObject(i-1)!=null)
					    				rr = rrArray.getJSONObject(i-1);
					    	%>
						    	<tr id="<%="relacionRecusaciones"+i %>">
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="quien_recusaRR"+i %>" name="<%="quien_recusaRR"+i %>" style="max-width: 100% !important;" value="<%=rr.getString("quien_recusa") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="causalRR"+i %>" name="<%="causalRR"+i %>" style="max-width: 100% !important;" value="<%=rr.getString("causal") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="recusadoRR"+i %>" name="<%="recusadoRR"+i %>" style="max-width: 100% !important;" value="<%=rr.getString("recusado") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="decision_tomadaRR"+i %>" name="<%="decision_tomadaRR"+i %>" style="max-width: 100% !important;" value="<%=rr.getString("decision_tomada") %>">
						    		</td>
						    		<td style="vertical-align: middle;">
						    			<% String EliFila = "eliminarRR('relacionRecusaciones"+i+"')"; %>
						    			<a onclick="<%=EliFila %>">
						    				<i class="fa fa-times"></i>
						    			</a>
						    		</td>
						    	</tr>
					    	<% } %>
					    </tbody>
					</table>
					<input type="hidden" name="idsRR" id="idsRR" value="<%=idsRR %>">
					<button class="btn" style="color: white;" type="button" onclick="agregarOtroRR()">Agregar Relación de Recusaciones</button>
					<br>
					<br>
					<table class="table table-bordered" id="relacionDeImpedimentos">
					    <thead>
					    	<tr>
					        	<th colspan="5" style="text-align: center; vertical-align: middle;">RELACIÓN DE IMPEDIMENTOS</th>
					      	</tr>
					      	<tr>
					      		<th style="text-align: center; vertical-align: middle;">QUIEN SE DECLARA IMPEDIDO<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">FECHA</th>
					      		<th style="text-align: center; vertical-align: middle;">CAUSAL<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">DECISIÓN TOMADA<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      	</tr>
					    </thead>
					    <tbody>
					    	<%
					    		JSONArray riArray = JSONFactoryUtil.createJSONArray();
					    		if(!informacion_complementaria.getString("relacion_impedimentos").equals("")){
					    			riArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("relacion_impedimentos"));
					    		}
					    		int cuentari = riArray.length();
					    		if(cuentari==0)
					    			cuentari=1;
					    		for(int i=1 ; i<=cuentari ; i++){
					    			if(i<cuentari)
					    				idsRI+=i+",";
					    			else
					    				idsRI+=i;
					    			
					    			JSONObject ri = JSONFactoryUtil.createJSONObject();
					    			if(riArray.getJSONObject(i-1)!=null)
					    				ri = riArray.getJSONObject(i-1);
					    	%>
						    	<tr id="<%="relacionImpedimentos"+i %>">
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="quien_impedidori"+i %>" name="<%="quien_impedidori"+i %>" style="max-width: 100% !important;" value="<%=ri.getString("quien_impedido") %>">
						    		</td>
						    		<td>
						    			<input type="date" class="anchoCompleto select-option" id="<%="fechari"+i %>" name="<%="fechari"+i %>" style="max-width: 100% !important;" value="<%=ri.getString("fecha") %>" max="<%=fechaHoy %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="causalri"+i %>" name="<%="causalri"+i %>" style="max-width: 100% !important;" value="<%=ri.getString("causal") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="decision_tomadari"+i %>" name="<%="decision_tomadari"+i %>" style="max-width: 100% !important;" value="<%=ri.getString("decision_tomada") %>">
						    		</td>
						    		<td style="vertical-align: middle;">
						    			<% String EliFila = "eliminarRI('relacionImpedimentos"+i+"')"; %>
						    			<a onclick="<%=EliFila %>">
						    				<i class="fa fa-times"></i>
						    			</a>
						    		</td>
						    	</tr>
					    	<% } %>
					    </tbody>
					</table>
					<input type="hidden" name="idsRI" id="idsRI" value="<%=idsRI %>">
					<button class="btn" style="color: white;" type="button" onclick="agregarOtroRI()">Agregar Relación de Impedimento</button>
					<br>
					<br>
					<table class="table table-bordered" id="comisionServiciosInteriorPais">
					    <thead>
					    	<tr>
					        	<th colspan="8" style="text-align: center; vertical-align: middle;">COMISIÓN DE SERVICIOS AL INTERIOR DEL PAÍS</th>
					      	</tr>
					      	<tr>
					      		<th style="text-align: center; vertical-align: middle;">N. RESOLUCIÓN<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">DESTINO<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">OBJETO DE LA COMISIÓN<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">VIÁTICOS</th>
					      		<th style="text-align: center; vertical-align: middle;">N. DÍAS</th>
					      		<th style="text-align: center; vertical-align: middle;">ENTIDAD QUE ASUME COSTOS<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">OBSERVACIONES<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      	</tr>
					    </thead>
					    <tbody>
					    	<%
					    		JSONArray ipArray = JSONFactoryUtil.createJSONArray();
					    		if(!informacion_complementaria.getString("comision_interior").equals("")){
					    			ipArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("comision_interior"));
					    		}
					    		int cuentaip = ipArray.length();
					    		if(cuentaip==0)
					    			cuentaip=1;
					    		for(int i=1 ; i<=cuentaip ; i++){
					    			if(i<cuentaip)
					    				idsIP+=i+",";
					    			else
					    				idsIP+=i;
					    			
					    			JSONObject ip = JSONFactoryUtil.createJSONObject();
					    			if(ipArray.getJSONObject(i-1)!=null)
					    				ip = ipArray.getJSONObject(i-1);
					    	%>
						    	<tr id="<%="comisionInterior"+i %>">
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="resolucionip"+i %>" name="<%="resolucionip"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("numero_resolucion") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="destinoip"+i %>" name="<%="destinoip"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("destino") %>"><%=ip.getString("destino") %>
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="objetoip"+i %>" name="<%="objetoip"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("objeto_comision") %>">
						    		</td>
						    		<td>
						    			<select name="<%= "viaticosip"+i %>" id="<%= "viaticosip"+i %>" class="anchoCompleto" style="max-width: 100% !important;" >
						    				<option value="">Seleccione</option>
						    				<% for(modeloBasico b : decision){ 
						    					if(ip.getString("viaticos").equals(b.getCodigo())){
							    			%>
							    					<option value="<%=b.getCodigo() %>" selected="selected"><%=b.getNombre() %></option>
							    			<% }else{ %>
							    					<option value="<%=b.getCodigo() %>" ><%=b.getNombre() %></option>
							    			<% }} %>
						    			</select>
						    		</td>
						    		<td>
						    			<input type="number" class="anchoCompleto select-option" id="<%="diasip"+i %>" name="<%="diasip"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("dias") %>" min="0" max="999" step="1">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="entidadip"+i %>" name="<%="entidadip"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("entidad") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="observacionesip"+i %>" name="<%="observacionesip"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("observaciones") %>">
						    		</td>
						    		<td style="vertical-align: middle;">
						    			<% String EliFila = "eliminarIP('comisionInterior"+i+"')"; %>
						    			<a onclick="<%=EliFila %>">
						    				<i class="fa fa-times"></i>
						    			</a>
						    		</td>
						    	</tr>
					    	<% } %>
					    </tbody>
					</table>
					<input type="hidden" name="idsIP" id="idsIP" value="<%=idsIP%>">
					<button class="btn" style="color: white;" type="button" onclick="agregarOtroIP()">Agregar Comisión</button>
					<br>
					<br>
					<table class="table table-bordered" id="comisionServiciosExteriorPais">
					    <thead>
					    	<tr>
					        	<th colspan="8" style="text-align: center; vertical-align: middle;">COMISIÓN DE SERVICIOS AL EXTERIOR DEL PAÍS</th>
					      	</tr>
					      	<tr>
					      		<th style="text-align: center; vertical-align: middle;">N. RESOLUCIÓN<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">DESTINO<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">OBJETO DE LA COMISIÓN<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">VIÁTICOS</th>
					      		<th style="text-align: center; vertical-align: middle;">N. DÍAS</th>
					      		<th style="text-align: center; vertical-align: middle;">ENTIDAD QUE ASUME COSTOS<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">OBSERVACIONES<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      	</tr>
					    </thead>
					    <tbody>
					    	<%
					    		JSONArray epArray = JSONFactoryUtil.createJSONArray();
					    		if(!informacion_complementaria.getString("comision_exterior").equals("")){
					    			epArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("comision_exterior"));
					    		}
					    		int cuentaep = epArray.length();
					    		if(cuentaep==0)
					    			cuentaep=1;
					    		for(int i=1 ; i<=cuentaep ; i++){
					    			if(i<cuentaep)
					    				idsEP+=i+",";
					    			else
					    				idsEP+=i;
					    			
					    			JSONObject ep = JSONFactoryUtil.createJSONObject();
					    			if(epArray.getJSONObject(i-1)!=null)
					    				ep = epArray.getJSONObject(i-1);
					    	%>
						    	<tr id="<%="comisionExterior"+i %>">
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="resolucionep"+i %>" name="<%="resolucionep"+i %>" style="max-width: 100% !important;" value="<%=ep.getString("numero_resolucion") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="destinoep"+i %>" name="<%="destinoep"+i %>" style="max-width: 100% !important;" value="<%=ep.getString("destino") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="objetoep"+i %>" name="<%="objetoep"+i %>" style="max-width: 100% !important;" value="<%=ep.getString("objeto_comision") %>">
						    		</td>
						    		<td>
						    			<select name="<%= "viaticosep"+i %>" id="<%= "viaticosep"+i %>" class="anchoCompleto" style="max-width: 100% !important;" >
						    				<option value="">Seleccione</option>
						    				<% for(modeloBasico b : decision){ 
						    					if(ep.getString("viaticos").equals(b.getCodigo())){
							    			%>
							    					<option value="<%=b.getCodigo() %>" selected="selected"><%=b.getNombre() %></option>
							    			<% }else{ %>
							    					<option value="<%=b.getCodigo() %>" ><%=b.getNombre() %></option>
							    			<% }} %>
						    			</select>
						    		</td>
						    		<td>
						    			<input type="number" class="anchoCompleto select-option" id="<%="diasep"+i %>" name="<%="diasep"+i %>" style="max-width: 100% !important;" value="<%=ep.getString("dias") %>" min="0" max="999" step="1">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="entidadep"+i %>" name="<%="entidadep"+i %>" style="max-width: 100% !important;" value="<%=ep.getString("entidad") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="observacionesep"+i %>" name="<%="observacionesep"+i %>" style="max-width: 100% !important;" value="<%=ep.getString("observaciones") %>">
						    		</td>
						    		<td style="vertical-align: middle;">
						    			<% String EliFila = "eliminarEP('comisionExterior"+i+"')"; %>
						    			<a onclick="<%=EliFila %>">
						    				<i class="fa fa-times"></i>
						    			</a>
						    		</td>
						    	</tr>
					    	<% } %>
					    </tbody>
					</table>
					<input type="hidden" name="idsEP" id="idsEP" value="<%=idsEP%>">
					<button class="btn" style="color: white;" type="button" onclick="agregarOtroEP()">Agregar Comisión</button>
					<br>
					<br>
					<table class="table table-bordered" id="inasistenciaSesion">
					    <thead>
					    	<tr>
					        	<th colspan="3" style="text-align: center; vertical-align: middle;">INASISTENCIA A SESIONES ORDINARIAS</th>
					      	</tr>
					      	<tr>
					      		<th style="text-align: center; vertical-align: middle; width: 60%;">INASISTENCIA<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">CAUSA<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      	</tr>
					    </thead>
					    <tbody>
					    	<%
					    		JSONArray isArray = JSONFactoryUtil.createJSONArray();
					    		if(!informacion_complementaria.getString("inasistencia_sesiones_ordinarias").equals("")){
					    			isArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("inasistencia_sesiones_ordinarias"));
					    		}
					    		int cuentais = isArray.length();
					    		if(cuentais==0)
					    			cuentais=1;
					    		for(int i=1 ; i<=cuentais ; i++){
					    			if(i<cuentais)
					    				idsIS+=i+",";
					    			else
					    				idsIS+=i;
					    			
					    			JSONObject is = JSONFactoryUtil.createJSONObject();
					    			if(isArray.getJSONObject(i-1)!=null)
					    				is = isArray.getJSONObject(i-1);
					    	%>
						    	<tr id="<%="inasistencias"+i %>">
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="inasistencia"+i %>" name="<%="inasistencia"+i %>" style="max-width: 100% !important;" value="<%=is.getString("inasistencia") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="causa"+i %>" name="<%="causa"+i %>" style="max-width: 100% !important;" value="<%=is.getString("causa") %>">
						    		</td>
						    		<td style="vertical-align: middle;">
						    			<% String EliFila = "eliminarIS('inasistencias"+i+"')"; %>
						    			<a onclick="<%=EliFila %>">
						    				<i class="fa fa-times"></i>
						    			</a>
						    		</td>
						    	</tr>
					    	<% } %>
					    </tbody>
					</table>
					<input type="hidden" name="idsIS" id="idsIS" value="<%=idsIS%>">
					<button class="btn" style="color: white;" type="button" onclick="agregarOtroIS()">Agregar Inasistencia</button>
					<br>
					<br>
					<table class="table table-bordered" id="docenciaUniversitaria">
					    <thead>
					    	<tr>
					        	<th colspan="7" style="text-align: center; vertical-align: middle;">DOCENCIA UNIVERSITARIAS</th>
					      	</tr>
					      	<tr>
					      		<th style="text-align: center; vertical-align: middle;">SEMESTRE O AÑO</th>
					      		<th style="text-align: center; vertical-align: middle;">UNIVERSIDAD<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">FACULTAD<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">CÁTEDRA<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">HORARIO Y DÍA<br><p style="font-size: 10px;margin: 0;color: red;">Máximo 255 caracteres</p></th>
					      		<th style="text-align: center; vertical-align: middle;">HORAS SEMANALES</th>
					      	</tr>
					    </thead>
					    <tbody>
					    	<%
					    		JSONArray duArray = JSONFactoryUtil.createJSONArray();
					    		if(!informacion_complementaria.getString("docencia_universitarias").equals("")){
					    			duArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("docencia_universitarias"));
					    		}
					    		int cuentadu = duArray.length();
					    		if(cuentadu==0)
					    			cuentadu=1;
					    		for(int i=1 ; i<=cuentadu ; i++){
					    			if(i<cuentadu)
					    				idsDU+=i+",";
					    			else
					    				idsDU+=i;
					    			
					    			JSONObject du = JSONFactoryUtil.createJSONObject();
					    			if(duArray.getJSONObject(i-1)!=null)
					    				du = duArray.getJSONObject(i-1);
					    	%>
						    	<tr id="<%="docencias"+i %>">
						    		<td>
						    			<input type="number" class="anchoCompleto select-option" id="<%="semestre"+i %>" name="<%="semestre"+i %>" style="max-width: 100% !important;" value="<%=du.getString("semestre") %>" min="0" max="999" step="1">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="universidad"+i %>" name="<%="universidad"+i %>" style="max-width: 100% !important;" value="<%=du.getString("universidad") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="facultad"+i %>" name="<%="facultad"+i %>" style="max-width: 100% !important;" value="<%=du.getString("facultad") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="catedra"+i %>" name="<%="catedra"+i %>" style="max-width: 100% !important;" value="<%=du.getString("catedra") %>">
						    		</td>
						    		<td>
						    			<input type="text" maxlength="255" class="anchoCompleto" id="<%="horario"+i %>" name="<%="horario"+i %>" style="max-width: 100% !important;" value="<%=du.getString("horario") %>">
						    		</td>
						    		<td>
						    			<input type="number" class="anchoCompleto select-option" id="<%="horas"+i %>" name="<%="horas"+i %>" style="max-width: 100% !important;" value="<%=du.getString("horas") %>" min="0" max="999" step="1">
						    		</td>
						    		<td style="vertical-align: middle;">
						    			<% String EliFila = "eliminarDU('docencias"+i+"')"; %>
						    			<a onclick="<%=EliFila %>">
						    				<i class="fa fa-times"></i>
						    			</a>
						    		</td>
						    	</tr>
					    	<% } %>
					    </tbody>
					</table>
					<input type="hidden" name="idsDU" id="idsDU" value="<%=idsDU%>">
					<button class="btn" style="color: white;" type="button" onclick="agregarOtroDU()">Agregar Docencia</button>
					<br>
					<br>
					<div class="row">
				  		<div class="col-md-12 text-center">
				  			<button class="btn" type="submit">Guardar</button>
				  		</div>
				  	</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script>
$('#informacionComplementaria').addClass("active");

var cantidadRR = <%=cantidadRR%>;
var cantidadRI = <%=cantidadRI%>;
var cantidadIP = <%=cantidadIP%>;
var cantidadEP = <%=cantidadEP%>;
var cantidadIS = <%=cantidadIS%>;
var cantidadDU = <%=cantidadDU%>;

var decision = ["NO","SI"];

function agregarOtroDU(){
	cantidadDU++;
	
	var filaEli = "eliminarDU('docencias"+cantidadDU+"')";
	
	$('#docenciaUniversitaria tbody').append('<tr id="docencias'+cantidadDU+'">'+
			'	<td>'+
			'		<input type="number" class="anchoCompleto select-option" id="semestre'+cantidadDU+'" name="semestre'+cantidadDU+'" style="max-width: 100% !important;" min="0" max="999" step="1">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="universidad'+cantidadDU+'" name="universidad'+cantidadDU+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="facultad'+cantidadDU+'" name="facultad'+cantidadDU+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="catedra'+cantidadDU+'" name="catedra'+cantidadDU+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="horario'+cantidadDU+'" name="horario'+cantidadDU+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="number" class="anchoCompleto select-option" id="horas'+cantidadDU+'" name="horas'+cantidadDU+'" style="max-width: 100% !important;" min="0" max="999" step="0.5">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsDU').val();
	if(ids=="")
		ids=cantidadDU;
	else
		ids = ids+','+cantidadDU;
	$('#idsDU').val(ids);
}

function eliminarDU(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("docencias","");
		var ids = $('#idsDU').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsDU').val(a);
		$('#'+fila).remove();
	}
}

function agregarOtroIS(){
	cantidadIS++;
	
	var filaEli = "eliminarIS('inasistencias"+cantidadIS+"')";
	
	$('#inasistenciaSesion tbody').append('<tr id="inasistencias'+cantidadIS+'">'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="inasistencia'+cantidadIS+'" name="inasistencia'+cantidadIS+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="causa'+cantidadIS+'" name="causa'+cantidadIS+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsIS').val();
	if(ids=="")
		ids=cantidadIS;
	else
		ids = ids+','+cantidadIS;
	$('#idsIS').val(ids);
}

function eliminarIS(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("inasistencias","");
		var ids = $('#idsIS').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsIS').val(a);
		$('#'+fila).remove();
	}
}

function agregarOtroEP(){
	cantidadEP++;
	
	var optionsDecision = '<option value="" >Seleccione</option>';
	
	decision.forEach(function (elemento , indice,array){
		optionsDecision = optionsDecision+'<option value="'+elemento+'" >'+elemento+'</option>';
	});
	
	var filaEli = "eliminarEP('comisionExterior"+cantidadEP+"')";
	
	$('#comisionServiciosExteriorPais tbody').append('<tr id="comisionExterior'+cantidadEP+'">'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="resolucionep'+cantidadEP+'" name="resolucionep'+cantidadEP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="destinoep'+cantidadEP+'" name="destinoep'+cantidadEP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="objetoep'+cantidadEP+'" name="objetoep'+cantidadEP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<select name="viaticosep'+cantidadEP+'" id="viaticosep'+cantidadEP+'" class="anchoCompleto" style="max-width: 100% !important;" >'+
			optionsDecision+
			'		</select>'+
			'	</td>'+
			'	<td>'+
			'		<input type="number" class="anchoCompleto select-option" id="diasep'+cantidadEP+'" name="diasep'+cantidadEP+'" style="max-width: 100% !important;" min="0" max="999" step="1">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="entidadep'+cantidadEP+'" name="entidadep'+cantidadEP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="observacionesep'+cantidadEP+'" name="observacionesep'+cantidadEP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsEP').val();
	if(ids=="")
		ids=cantidadEP;
	else
		ids = ids+','+cantidadEP;
	$('#idsEP').val(ids);
}

function eliminarEP(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("comisionExterior","");
		var ids = $('#idsEP').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsEP').val(a);
		$('#'+fila).remove();
	}
}

function agregarOtroIP(){
	cantidadIP++;
	
	var optionsDecision = '<option value="" >Seleccione</option>';
	
	decision.forEach(function (elemento , indice,array){
		optionsDecision = optionsDecision+'<option value="'+elemento+'" >'+elemento+'</option>';
	});
	
	var filaEli = "eliminarIP('comisionInterior"+cantidadIP+"')";
	
	$('#comisionServiciosInteriorPais tbody').append('<tr id="comisionInterior'+cantidadIP+'">'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="resolucionip'+cantidadIP+'" name="resolucionip'+cantidadIP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="destinoip'+cantidadIP+'" name="destinoip'+cantidadIP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="objetoip'+cantidadIP+'" name="objetoip'+cantidadIP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<select name="viaticosip'+cantidadIP+'" id="viaticosip'+cantidadIP+'" class="anchoCompleto" style="max-width: 100% !important;" >'+
			optionsDecision+
			'		</select>'+
			'	</td>'+
			'	<td>'+
			'		<input type="number" class="anchoCompleto select-option" id="diasip'+cantidadIP+'" name="diasip'+cantidadIP+'" style="max-width: 100% !important;" min="0" max="999" step="1">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="entidadip'+cantidadIP+'" name="entidadip'+cantidadIP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="observacionesip'+cantidadIP+'" name="observacionesip'+cantidadIP+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsIP').val();
	if(ids=="")
		ids=cantidadIP;
	else
		ids = ids+','+cantidadIP;
	$('#idsIP').val(ids);
}

function eliminarIP(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("comisionInterior","");
		var ids = $('#idsIP').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsIP').val(a);
		$('#'+fila).remove();
	}
}


function agregarOtroRI(){
	cantidadRI++;
	
	var filaEli = "eliminarRI('relacionImpedimentos"+cantidadRI+"')";
	
	$('#relacionDeImpedimentos tbody').append('<tr id="relacionImpedimentos'+cantidadRI+'">'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="quien_impedidori'+cantidadRI+'" name="quien_impedidori'+cantidadRI+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="date" class="anchoCompleto select-option" id="fechari'+cantidadRI+'" name="fechari'+cantidadRI+'" style="max-width: 100% !important;" max="<%=fechaHoy %>">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="causalri'+cantidadRI+'" name="causalri'+cantidadRI+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="decision_tomadari'+cantidadRI+'" name="decision_tomadari'+cantidadRI+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsRI').val();
	if(ids=="")
		ids=cantidadRI;
	else
		ids = ids+','+cantidadRI;
	$('#idsRI').val(ids);
}

function eliminarRI(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("relacionImpedimentos","");
		var ids = $('#idsRI').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsRI').val(a);
		$('#'+fila).remove();
	}
}


function agregarOtroRR(){
	cantidadRR++;
	
	var filaEli = "eliminarRR('relacionRecusaciones"+cantidadRR+"')";
	
	$('#relacionDeRecusaciones tbody').append('<tr id="relacionRecusaciones'+cantidadRR+'">'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="quien_recusaRR'+cantidadRR+'" name="quien_recusaRR'+cantidadRR+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="causalRR'+cantidadRR+'" name="causalRR'+cantidadRR+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="recusadoRR'+cantidadRR+'" name="recusadoRR'+cantidadRR+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" maxlength="255" class="anchoCompleto" id="decision_tomadaRR'+cantidadRR+'" name="decision_tomadaRR'+cantidadRR+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsRR').val();
	if(ids=="")
		ids=cantidadRR;
	else
		ids = ids+','+cantidadRR;
	$('#idsRR').val(ids);
}

function eliminarRR(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("relacionRecusaciones","");
		var ids = $('#idsRR').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsRR').val(a);
		$('#'+fila).remove();
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