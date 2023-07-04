<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.co.csj.service.model.usuario_data"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.List"%>
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
		usuario_data usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		
		int cantidadConyuge = 1;
		String idsConyuge = "";
		int cantidadPariente = 1;
		String idsPariente = "";
		int cantidadGremios = 1;
		String idsGremios = "";
		int cantidadFideicomisos = 1;
		String idsFideicomisos = "";
		int cantidadInversiones = 1;
		String idsInversiones = "";
		int cantidadDonaciones = 1;
		String idsDonaciones = "";
		int cantidadPotenciales = 1;
		String idsPotenciales = "";
		
		JSONObject conflicto_intereses = JSONFactoryUtil.createJSONObject();
		if(!usuario.getConflicto_intereses().isEmpty()){
			conflicto_intereses = JSONFactoryUtil.createJSONObject(usuario.getConflicto_intereses());
			cantidadConyuge = conflicto_intereses.getInt("cantidadConyuge");
			cantidadPariente = conflicto_intereses.getInt("cantidadPariente");
			cantidadGremios = conflicto_intereses.getInt("cantidadGremios");
			cantidadFideicomisos = conflicto_intereses.getInt("cantidadFideicomisos");
			cantidadInversiones = conflicto_intereses.getInt("cantidadInversiones");
			cantidadDonaciones = conflicto_intereses.getInt("cantidadDonaciones");
			cantidadPotenciales = conflicto_intereses.getInt("cantidadPotenciales");
			if(cantidadConyuge==0)
				cantidadConyuge=1;
			if(cantidadPariente==0)
				cantidadPariente=1;
			if(cantidadGremios==0)
				cantidadGremios=1;
			if(cantidadFideicomisos==0)
				cantidadFideicomisos=1;
			if(cantidadInversiones==0)
				cantidadInversiones=1;
			if(cantidadDonaciones==0)
				cantidadDonaciones=1;
			if(cantidadPotenciales==0)
				cantidadPotenciales=1;
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
			
%>
<portlet:actionURL var="guardarConfictoInteres" name="guardarConfictoInteres"></portlet:actionURL>

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
		<div class="content-fliud">
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
			<div class="row text-center">
				<h2>Conflicto de intereses</h2>
			</div>
			<br>
			<form action="<%= guardarConfictoInteres %>" method="post">
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<div class="form-group col-md-12">
							<label for="informacionConyuge">INFORMACIÓN DE CÓNYUGE Y/O COMPAÑERO(A) PERMANENTE</label>
							<div id="informacionConyuge">
								<div class="col-md-12">
									<p>En la actualidad tengo sociedad conyugal o de hecho vigente</p>
									<br>
									<label for="sc">SI</label>
									<% if(conflicto_intereses.getString("respuesta").equalsIgnoreCase("si")){ %>
										<input type="radio" id="sct" name="sociedadconyugal" value="si" checked="checked" required="required">
									<% }else{ %>
										<input type="radio" id="sct" name="sociedadconyugal" value="si" required="required">
									<% } %>
									<br>	
								  	<label for="sc">NO</label>	
								  	<% if(conflicto_intereses.getString("respuesta").equalsIgnoreCase("no")){ %>
										<input type="radio" id="scf" name="sociedadconyugal" value="no" checked="checked">
									<% }else{ %>
										<input type="radio" id="scf" name="sociedadconyugal" value="no">
									<% } %>	
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
									    			if(i<cuentaConyuge)
									    				idsConyuge+=i+",";
									    			else
									    				idsConyuge+=i;
									    			
									    			JSONObject sc = JSONFactoryUtil.createJSONObject();
									    			if(conyugeArray.getJSONObject(i-1)!=null)
									    				sc = conyugeArray.getJSONObject(i-1);
									    	%>
										    	<tr id="<%="conyuge"+i %>">
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="nombreConyuge"+i %>" name="<%="nombreConyuge"+i %>" style="max-width: 100% !important;" value="<%=sc.getString("nombreConyuge") %>"  >
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="tipoSociedad"+i %>" name="<%="tipoSociedad"+i %>" style="max-width: 100% !important;" value="<%=sc.getString("tipoSociedad") %>">
										    		</td>
										    		<td>
										    			<% String formatoCedula = "formatoCedula('numeroDocumentoConyuge"+i+"')"; %>
										    			<input type="text"  onkeyup="<%=formatoCedula %>" class="anchoCompleto" id="<%="numeroDocumentoConyuge"+i %>" name="<%="numeroDocumentoConyuge"+i %>" style="max-width: 100% !important;" value="<%=sc.getString("numeroDocumentoConyuge") %>" >
										    		</td>
										    	</tr>
									    	<% } %>
									    </tbody>
									</table>
									<input type="hidden" name="idsConyuge" id="idsConyuge" value="<%=idsConyuge %>">
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
									    			if(i<cuentaPariente)
									    				idsPariente+=i+",";
									    			else
									    				idsPariente+=i;
									    			
									    			JSONObject ip = JSONFactoryUtil.createJSONObject();
									    			if(parienteArray.getJSONObject(i-1)!=null)
									    				ip = parienteArray.getJSONObject(i-1);
									    	%>
										    	<tr id="<%="pariente"+i %>">
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="parentesco"+i %>" name="<%="parentesco"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("parentesco") %>"  >
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="primerNombre"+i %>" name="<%="primerNombre"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("primerNombre") %>">
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="segundoNombre"+i %>" name="<%="segundoNombre"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("segundoNombre") %>" >
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="primerApellido"+i %>" name="<%="primerApellido"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("primerApellido") %>" >
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="segundoApellido"+i %>" name="<%="segundoApellido"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("segundoApellido") %>" >
										    		</td>
										    		<td>
										    			<% String formatoCedula = "formatoCedula('numeroDocumentoParentesco"+i+"')"; %>
										    			<input type="text" onkeyup="<%=formatoCedula %>" class="anchoCompleto" id="<%="numeroDocumentoParentesco"+i %>" name="<%="numeroDocumentoParentesco"+i %>" style="max-width: 100% !important;" value="<%=ip.getString("numeroDocumentoParentesco") %>" >
										    		</td>
										    		<td style="vertical-align: middle;">
										    			<% String EliFila = "eliminarPariente('pariente"+i+"')"; %>
										    			<a onclick="<%=EliFila %>">
										    				<i class="fa fa-times"></i>
										    			</a>
										    		</td>
										    	</tr>
									    	<% } %>
									    </tbody>
									</table>
									<input type="hidden" name="idsPariente" id="idsPariente" value="<%=idsPariente %>">
									<button class="btn" style="color: white;" type="button" onclick="agregarOtroPariente()">Agregar Pariente</button>
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
									    			if(i<cuentaGremios)
									    				idsGremios+=i+",";
									    			else
									    				idsGremios+=i;
									    			
									    			JSONObject pg = JSONFactoryUtil.createJSONObject();
									    			if(gremiosArray.getJSONObject(i-1)!=null)
									    				pg = gremiosArray.getJSONObject(i-1);
									    	%>
										    	<tr id="<%="gremio"+i %>">
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="gremio"+i %>" name="<%="gremio"+i %>" style="max-width: 100% !important;" value="<%=pg.getString("gremio") %>"  >
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="calidadMiembro"+i %>" name="<%="calidadMiembro"+i %>" style="max-width: 100% !important;" value="<%=pg.getString("calidadMiembro") %>">
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="paisGremio"+i %>" name="<%="paisGremio"+i %>" style="max-width: 100% !important;" value="<%=pg.getString("paisGremio") %>" >
										    		</td>
										    		<td style="vertical-align: middle;">
										    			<% String EliFila = "eliminarGremio('gremio"+i+"')"; %>
										    			<a onclick="<%=EliFila %>">
										    				<i class="fa fa-times"></i>
										    			</a>
										    		</td>
										    	</tr>
									    	<% } %>
									    </tbody>
									</table>
									<input type="hidden" name="idsGremios" id="idsGremios" value="<%=idsGremios %>">
									<button class="btn" style="color: white;" type="button" onclick="agregarOtroGremio()">Agregar Gremio</button>
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
									    			if(i<cuentaFideicomisos)
									    				idsFideicomisos+=i+",";
									    			else
									    				idsFideicomisos+=i;
									    			
									    			JSONObject f = JSONFactoryUtil.createJSONObject();
									    			if(fideicomisosArray.getJSONObject(i-1)!=null)
									    				f = fideicomisosArray.getJSONObject(i-1);
									    	%>
										    	<tr id="<%="fideicomiso"+i %>">
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="nombreFideicomiso"+i %>" name="<%="nombreFideicomiso"+i %>" style="max-width: 100% !important;" value="<%=f.getString("nombreFideicomiso") %>"  >
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="calidadFideicomiso"+i %>" name="<%="calidadFideicomiso"+i %>" style="max-width: 100% !important;" value="<%=f.getString("calidadFideicomiso") %>">
										    		</td>
										    		<td>
										    			<%
										    				String cop = "agregarCop('valorFideicomiso"+i+"')";
										    				String form = "formato('valorFideicomiso"+i+"')";
										    			%>
										    			<input type="text" class="anchoCompleto" id="<%="valorFideicomiso"+i %>" name="<%="valorFideicomiso"+i %>" style="max-width: 100% !important;" value="<%=f.getString("valorFideicomiso") %>" onblur="<%=cop %>" onkeyup="<%=form %>" >
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="paisFideicomiso"+i %>" name="<%="paisFideicomiso"+i %>" style="max-width: 100% !important;" value="<%=f.getString("paisFideicomiso") %>" >
										    		</td>
										    		<td style="vertical-align: middle;">
										    			<% String EliFila = "eliminarFideicomisos('fideicomiso"+i+"')"; %>
										    			<a onclick="<%=EliFila %>">
										    				<i class="fa fa-times"></i>
										    			</a>
										    		</td>
										    	</tr>
									    	<% } %>
									    </tbody>
									</table>
									<input type="hidden" name="idsFideicomisos" id="idsFideicomisos" value="<%=idsFideicomisos %>">
									<button class="btn" style="color: white;" type="button" onclick="agregarOtroFideicomiso()">Agregar Fideicomiso</button>
									<br>
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
									    			if(i<cuentaInversion)
									    				idsInversiones+=i+",";
									    			else
									    				idsInversiones+=i;
									    			
									    			JSONObject in = JSONFactoryUtil.createJSONObject();
									    			if(inversionArray.getJSONObject(i-1)!=null)
									    				in = inversionArray.getJSONObject(i-1);
									    	%>
										    	<tr id="<%="inversion"+i %>">
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="tipoInversion"+i %>" name="<%="tipoInversion"+i %>" style="max-width: 100% !important;" value="<%=in.getString("tipoInversion") %>"  >
										    		</td>
										    		<td>
										    			<%
										    				String cop = "agregarCop('valorInversion"+i+"')";
										    				String form = "formato('valorInversion"+i+"')";
										    			%>
										    			<input type="text" class="anchoCompleto" id="<%="valorInversion"+i %>" name="<%="valorInversion"+i %>" style="max-width: 100% !important;" value="<%=in.getString("valorInversion") %>" onblur="<%=cop %>" onkeyup="<%=form %>">
										    		</td>
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="paisInversion"+i %>" name="<%="paisInversion"+i %>" style="max-width: 100% !important;" value="<%=in.getString("paisInversion") %>" >
										    		</td>
										    		<td style="vertical-align: middle;">
										    			<% String EliFila = "eliminarInversion('inversion"+i+"')"; %>
										    			<a onclick="<%=EliFila %>">
										    				<i class="fa fa-times"></i>
										    			</a>
										    		</td>
										    	</tr>
									    	<% } %>
									    </tbody>
									</table>
									<input type="hidden" name="idsInversiones" id="idsInversiones" value="<%=idsInversiones %>">
									<button class="btn" style="color: white;" type="button" onclick="agregarOtroInversion()">Agregar Inversion</button>
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
									    			if(i<cuentaDonaciones)
									    				idsDonaciones+=i+",";
									    			else
									    				idsDonaciones+=i;
									    			
									    			JSONObject d = JSONFactoryUtil.createJSONObject();
									    			if(donacionesArray.getJSONObject(i-1)!=null)
									    				d = donacionesArray.getJSONObject(i-1);
									    	%>
										    	<tr id="<%="donacion"+i %>">
										    		<td>
										    			<input type="text" class="anchoCompleto" id="<%="nombreDonacion"+i %>" name="<%="nombreDonacion"+i %>" style="max-width: 100% !important;" value="<%=d.getString("nombreDonacion") %>"  >
										    		</td>
										    		<td>
										    			<%
										    				String cop = "agregarCop('valorDonacion"+i+"')";
										    				String form = "formato('valorDonacion"+i+"')";
										    			%>
										    			<input type="text" class="anchoCompleto" id="<%="valorDonacion"+i %>" name="<%="valorDonacion"+i %>" style="max-width: 100% !important;" value="<%=d.getString("valorDonacion") %>" onblur="<%=cop %>" onkeyup="<%=form %>">
										    		</td>
										    		<td style="vertical-align: middle;">
										    			<% String EliFila = "eliminarDonacion('donacion"+i+"')"; %>
										    			<a onclick="<%=EliFila %>">
										    				<i class="fa fa-times"></i>
										    			</a>
										    		</td>
										    	</tr>
									    	<% } %>
									    </tbody>
									</table>
									<input type="hidden" name="idsDonaciones" id="idsDonaciones" value="<%=idsDonaciones %>">
									<button class="btn" style="color: white;" type="button" onclick="agregarOtroDonacion()">Agregar Donacion</button>
									<br>
									<br>						  	
								</div>
							</div>
						</div>
						<div class="form-group col-md-12">
							<label for="participacionGremios">POTENCIALES CONFLICTOS DE INTERÉS</label>
							<div id="participacionGremios">
								<div class="col-md-12">
									<p>Escriba otros intereses personales que podrían constituir una posible situación de conflicto de intereses, por ejemplo:<br> - Actividades que desempeño, negocios, establecimientos que poseo etc.<br> - Actividades o negocios de mi cónyuge o compañero(a) permanente y parientes hasta el cuarto grado de consanguinidad, segundo de afinidad y primero civil, de acuerdo con lo descrito en el numeral<br> 2.2 - Actividades o negocios de mi socio de derecho o hecho</p>
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
									    			if(i<cuentaPotenciales)
									    				idsPotenciales+=i+",";
									    			else
									    				idsPotenciales+=i;
									    			
									    			JSONObject po = JSONFactoryUtil.createJSONObject();
									    			if(potencialesArray.getJSONObject(i-1)!=null)
									    				po = potencialesArray.getJSONObject(i-1);
									    	%>
										    	<tr id="<%="potencial"+i %>">
										    		<td>
										    			<textarea rows="5" class="anchoCompleto" id="<%="descripcionPotenciales"+i %>" name="<%="descripcionPotenciales"+i %>" style="max-width: 100% !important;" value="<%=po.getString("descripcionPotenciales") %>"  ></textarea>
										    		</td>
										    	</tr>
									    	<% } %>
									    </tbody>
									</table>
									<input type="hidden" name="idsPotenciales" id="idsPotenciales" value="<%=idsPotenciales %>">
									<br>
									<br>						  	
								</div>
							</div>
						</div>
						<div class="col-md-12 text-center">
				  			<button class="btn" type="submit">Guardar</button>
				  		</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<portlet:resourceURL var="filtro">
	<portlet:param name="pagina" value="despachoAsignado"/>
</portlet:resourceURL>

<script>
$('#conflictoIntereses').addClass("active");

function formatoCedula(campo) {
	  var x = document.getElementById(campo);
	  x.value =  x.value.replace(/\D/g, "");
	}

function formato(campo) {
  var x = document.getElementById(campo);
  x.value =  x.value.replace(/\D/g, "")
        .replace(/([0-9])([0-9]{2})$/, '$1,$2')
        .replace(/\B(?=(\d{3})+(?!\d)\.?)/g, ".");
}

function agregarCop(campo) {
  var x = document.getElementById(campo);
  x.value = x.value.replace(/\D/g, "");
  x.value =  x.value+" COP";
}

$(document).ready(function(){
	$("input:radio[name=sociedadconyugal]").click(function () {	 
		var valor = $('input:radio[name=sociedadconyugal]:checked').val();
		if(valor == 'no'){
			$('#sociedadConyugalTable').hide();
		}else{
			$('#sociedadConyugalTable').show();
		}
	});
	 
	var valor = $('input:radio[name=sociedadconyugal]:checked').val();
	if(valor == 'si'){
		$('#sociedadConyugalTable').show();
	}else{
		$('#sociedadConyugalTable').hide();
	}
});


var cantidadPariente = <%=cantidadPariente%>;
var cantidadGremios = <%=cantidadGremios%>;
var cantidadFideicomisos = <%=cantidadFideicomisos%>;
var cantidadInversion = <%=cantidadInversiones%>;
var cantidadDonaciones = <%=cantidadDonaciones%>;
var cantidadPotenciales = <%=cantidadPotenciales%>;


function agregarOtroPariente(){
	cantidadPariente++;
	
	
	var filaEli = "eliminarPariente('pariente"+cantidadPariente+"')";
	var formCedula = "formatoCedula('numeroDocumentoParentesco"+cantidadPariente+"')";
	
	$('#parientesTable tbody').append('<tr id="pariente'+cantidadPariente+'">'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="parentesco'+cantidadPariente+'" name="parentesco'+cantidadPariente+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="primerNombre'+cantidadPariente+'" name="primerNombre'+cantidadPariente+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="segundoNombre'+cantidadPariente+'" name="segundoNombre'+cantidadPariente+'" style="max-width: 100% !important;" >'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="primerApellido'+cantidadPariente+'" name="primerApellido'+cantidadPariente+'" style="max-width: 100% !important;" >'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="segundoApellido'+cantidadPariente+'" name="segundoApellido'+cantidadPariente+'" style="max-width: 100% !important;" >'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" onkeyup="'+formCedula+'" class="anchoCompleto" id="numeroDocumentoParentesco'+cantidadPariente+'" name="numeroDocumentoParentesco'+cantidadPariente+'" style="max-width: 100% !important;" >'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsPariente').val();
	if(ids=="")
		ids=cantidadPariente;
	else
		ids = ids+','+cantidadPariente;
	$('#idsPariente').val(ids);
}

function eliminarPariente(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("pariente","");
		var ids = $('#idsPariente').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsPariente').val(a);
		$('#'+fila).remove();
	}
}

function agregarOtroGremio(){
	cantidadGremios++;
	
	
	var filaEli = "eliminarGremio('gremio"+cantidadGremios+"')";
	
	$('#gremiosTable tbody').append('<tr id="gremio'+cantidadGremios+'">'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="gremio'+cantidadGremios+'" name="gremio'+cantidadGremios+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="calidadMiembro'+cantidadGremios+'" name="calidadMiembro'+cantidadGremios+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="paisGremio'+cantidadGremios+'" name="paisGremio'+cantidadGremios+'" style="max-width: 100% !important;" >'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsGremios').val();
	if(ids=="")
		ids=cantidadGremios;
	else
		ids = ids+','+cantidadGremios;
	$('#idsGremios').val(ids);
}

function eliminarGremio(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("gremio","");
		var ids = $('#idsGremios').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsGremios').val(a);
		$('#'+fila).remove();
	}
}

function agregarOtroFideicomiso(){
	cantidadFideicomisos++;
	
	
	var filaEli = "eliminarFideicomiso('fideicomiso"+cantidadFideicomisos+"')";
	var acop = "agregarCop('valorFideicomiso"+cantidadFideicomisos+"')";
	var form = "formato('valorFideicomiso"+cantidadFideicomisos+"')";
	
	$('#fideicomisosTable tbody').append('<tr id="fideicomiso'+cantidadFideicomisos+'">'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="nombreFideicomiso'+cantidadFideicomisos+'" name="nombreFideicomiso'+cantidadFideicomisos+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="calidadFideicomiso'+cantidadFideicomisos+'" name="calidadFideicomiso'+cantidadFideicomisos+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="valorFideicomiso'+cantidadFideicomisos+'" name="valorFideicomiso'+cantidadFideicomisos+'" style="max-width: 100% !important;" onblur="'+acop+'" onkeyup="'+form+'">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="paisFideicomiso'+cantidadFideicomisos+'" name="paisFideicomiso'+cantidadFideicomisos+'" style="max-width: 100% !important;" >'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsFideicomisos').val();
	if(ids=="")
		ids=cantidadFideicomisos;
	else
		ids = ids+','+cantidadFideicomisos;
	$('#idsFideicomisos').val(ids);
}

function eliminarFideicomiso(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("fideicomiso","");
		var ids = $('#idsFideicomisos').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsFideicomisos').val(a);
		$('#'+fila).remove();
	}
}

function agregarOtroInversion(){
	cantidadInversion++;
	
	
	var filaEli = "eliminarInversion('inversion"+cantidadInversion+"')";
	var acop = "agregarCop('valorInversion"+cantidadInversion+"')";
	var form = "formato('valorInversion"+cantidadInversion+"')";
	
	$('#inversionTable tbody').append('<tr id="inversion'+cantidadInversion+'">'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="tipoInversion'+cantidadInversion+'" name="tipoInversion'+cantidadInversion+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="valorInversion'+cantidadInversion+'" name="valorInversion'+cantidadInversion+'" style="max-width: 100% !important;" onblur="'+acop+'" onkeyup="'+form+'">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="paisInversion'+cantidadInversion+'" name="paisInversion'+cantidadInversion+'" style="max-width: 100% !important;" >'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsInversiones').val();
	if(ids=="")
		ids=cantidadInversion;
	else
		ids = ids+','+cantidadInversion;
	$('#idsInversiones').val(ids);
}

function eliminarInversion(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("inversion","");
		var ids = $('#idsInversiones').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsInversiones').val(a);
		$('#'+fila).remove();
	}
}

function agregarOtroDonacion(){
	cantidadDonaciones++;
	
	
	var filaEli = "eliminarDonacion('donacion"+cantidadDonaciones+"')";
	var acop = "agregarCop('valorDonacion"+cantidadDonaciones+"')";
	var form = "formato('valorDonacion"+cantidadDonaciones+"')";
	
	$('#donacionesTable tbody').append('<tr id="donacion'+cantidadDonaciones+'">'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="nombreDocacion'+cantidadDonaciones+'" name="nombreDocacion'+cantidadDonaciones+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="valorDonacion'+cantidadDonaciones+'" name="valorDonacion'+cantidadDonaciones+'" style="max-width: 100% !important;" onblur="'+acop+'" onkeyup="'+form+'">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsDonaciones').val();
	if(ids=="")
		ids=cantidadDonaciones;
	else
		ids = ids+','+cantidadDonaciones;
	$('#idsDonaciones').val(ids);
}

function eliminarDonacion(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("donacion","");
		var ids = $('#idsDonaciones').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsDonaciones').val(a);
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