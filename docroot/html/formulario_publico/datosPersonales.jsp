<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.co.csj.registro.consultas"%>
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
		if(!usuario.getDatos_personales().isEmpty()){
			datos_personales = JSONFactoryUtil.createJSONObject(usuario.getDatos_personales());
		}
		List<modeloBasico> departamentos = consultas.getDepartamentosNombre();
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
<portlet:actionURL var="guardarDatosPersonales" name="guardarDatosPersonales"></portlet:actionURL>

<div class="progreso" id="progreso">
	<div class="progress centroBarra">
	    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:100%">
	    </div>
	</div>
</div>

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
				<h2>Datos Personales</h2>
			</div>
			<br>
			<form action="<%=guardarDatosPersonales %>" method="post">
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<div class="col-md-6">
							<div class="form-group">
								<label for="apellidos">APELLIDOS</label>
								<div id="apellidos">
									<%= usuario.getApellidos() %>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="nombres">NOMBRES</label>
								<div id="nombres">
									<%= usuario.getNombres() %>
								</div>
							</div>
						</div>
					</div>	
				</div>
				<br>
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<div class="col-md-4">
							<div class="form-group">
								<label for="documento">DOCUMENTO DE IDENTIFICACIÓN</label>
								<div id="documento">
									<strong><%=consultas.getTipoDocumentoDiminutivo(usuario.getTipoDocumento()) %>:</strong> <%= usuario.getNumeroDocumento() %>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label for="sexo">SEXO</label>
								<div id="sexo">
									<label for="male">M</label>
									<% if(datos_personales.getString("sexo").equals("MASCULINO")){ %>
										<input type="radio" id="masculino" name="sexo" value="MASCULINO" checked="checked"  required="required">
									<% }else{ %>
										<input type="radio" id="masculino" name="sexo" value="MASCULINO"  required="required">
									<% } %>
								  	<label for="female">F</label>	
								  	<% if(datos_personales.getString("sexo").equals("FEMENINO")){ %>
										<input type="radio" id="femenino" name="sexo" value="FEMENINO" checked="checked">
									<% }else{ %>
										<input type="radio" id="femenino" name="sexo" value="FEMENINO">
									<% } %>							
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label for="nacionalidadDiv">NACIONALIDAD</label>
								<div id="nacionalidadDiv">
									<label for="col">Colombiano</label>
									<% if(datos_personales.getString("nacionalidad").equals("COLOMBIANO")){ %>
										<input type="radio" id="col" name="nacionalidad" value="COLOMBIANO" checked="checked" required="required">
									<% }else{ %>
										<input type="radio" id="col" name="nacionalidad" value="COLOMBIANO" required="required">
									<% } %>
								  	&nbsp;&nbsp;&nbsp; 
								  	<label for="ext">Extranjero</label>	
								  	<% if(datos_personales.getString("nacionalidad").equals("EXTRANJERO")){ %>
										<input type="radio" id="ext" name="nacionalidad" value="EXTRANJERO" checked="checked">
									<% }else{ %>
										<input type="radio" id="ext" name="nacionalidad" value="EXTRANJERO">
									<% } %>							  	
								</div>
							</div>
						</div>
						<div id="nacionalidadPais" class="col-md-4" style="display: none;">
							<div class="form-group">
								<label for="pais">PAÍS</label>
								<input type="text" class="anchoCompleto" id="pais" name="pais" style="padding: 0; max-width: 100% !important;" value="<%=datos_personales.getString("pais") %>">
							</div>
						</div>	
					</div>	
				</div>
				<br>
				<div class="row" id="filaLibretaMilitar">
					<div class="col-md-11 col-md-offset-1">
						<div class="form-group col-md-12">
							<label for="libretaMilitar">LIBRETA MILITAR</label>
							<div id="libretaMilitar">
								<div class="col-md-4">
									<label for="lmpc">PRIMERA CLASE</label>
									<% if(datos_personales.getString("tipoLibretaMilitar").equals("primeraclase")){ %>
										<input type="radio" id="lmpc" name="tipoLibretaMilitar" value="primeraclase" checked="checked">
									<% }else{ %>
										<input type="radio" id="lmpc" name="tipoLibretaMilitar" value="primeraclase">
									<% } %>	
								  	<br> 
								  	<label for="lmsc">SEGUNDA CLASE</label>	
								  	<% if(datos_personales.getString("tipoLibretaMilitar").equals("segundaclase")){ %>
										<input type="radio" id="lmsc" name="tipoLibretaMilitar" value="segundaclase" checked="checked">
									<% }else{ %>
										<input type="radio" id="lmsc" name="tipoLibretaMilitar" value="segundaclase">
									<% } %>							  	
								</div>
								<div class="col-md-4">
									<label for="numero">NÚMERO</label>&nbsp;&nbsp;&nbsp;
									<input style="padding: 0; max-width: 100% !important;" type="text" id="numero" name="numero" class="anchoCompleto" value="<%=datos_personales.getString("numeroLibretaMilitar")%>">							  	
								</div>
								<div class="col-md-4">
									<label for="dm">D.M</label>&nbsp;&nbsp;&nbsp;
									<input style="padding: 0; max-width: 100% !important;" type="text" id="dm" name="dm" class="anchoCompleto" value="<%=datos_personales.getString("dmLibretaMilitar")%>">							  	
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<div class="form-group col-md-12">
							<label for="fln">FECHA Y LUGAR DE NACIMIENTO</label>
							<div id="fln">
								<div class="form-group col-md-6">
									<label for="fn">FECHA</label>
									<input type="date" class="anchoCompleto select-option" style="max-width: 100% !important;" id="fechaNacimiento" name="fechaNacimiento" value="<%=datos_personales.getString("fechaNacimiento")%>" max="<%=fechaHoy %>">
								</div>
								<div class="form-group col-md-6">
									<label for="pn">PAÍS</label>
									<input type="text" class="anchoCompleto" onblur="validarPaisNacimiento()" style="max-width: 100% !important;" id="paisNacimiento" name="paisNacimiento" value="<%=datos_personales.getString("paisNacimiento")%>">
								</div>
								<div id="escrito">
									<div class="form-group col-md-6">
										<label for="dn">DEPARTAMENTO</label>
										<input type="text" class="anchoCompleto" style="max-width: 100% !important;" id="depNacimiento" name="depNacimiento" value="<%=datos_personales.getString("departamentoNacimiento")%>">
									</div>
									<div class="form-group col-md-6">
										<label for="mn">MUNICIPIO</label>
										<input type="text" class="anchoCompleto" style="max-width: 100% !important;" id="munNacimiento" name="munNacimiento"  value="<%=datos_personales.getString("municipioNacimiento")%>">
									</div>
								</div>
								<div id="listas">
									<div class="form-group col-md-6">
										<label for="dn">DEPARTAMENTO</label>
										<select class="anchoCompleto" style="max-width: 100% !important;" id="depNacimientoL" name="depNacimiento" onchange="filtroMunicipio('depNacimientoL','munNacimientoL')">
											<option value="">Seleccione</option>
											<% for(modeloBasico d : departamentos){ %>
												<% if(datos_personales.getString("departamentoNacimiento").equals(d.getNombre())){ %>
													<option value="<%=d.getNombre() %>" selected="selected"><%= d.getNombre() %></option>
												<% }else{ %>
													<option value="<%=d.getNombre() %>"><%= d.getNombre() %></option>
												<% } %>
											<% } %>
										</select>
									</div>
									<div class="form-group col-md-6">
										<label for="mn">MUNICIPIO</label>
										<select class="anchoCompleto" style="max-width: 100% !important;" id="munNacimientoL" name="munNacimiento">
											<option value="" >Seleccione</option>
											<% 
												if(!datos_personales.getString("departamentoNacimiento").isEmpty() && ( datos_personales.getString("paisNacimiento").equalsIgnoreCase("colombia") || datos_personales.getString("paisNacimiento").isEmpty() ) ){
													List<modeloBasico> municipios = consultas.getMunicipiosNombre(datos_personales.getString("departamentoNacimiento"));
											%>	
													<% for(modeloBasico m : municipios){ %>
														<% if(datos_personales.getString("municipioNacimiento").equals(m.getNombre())){ %>
															<option value="<%=m.getNombre() %>" selected="selected"><%= m.getNombre() %></option>
														<% }else{ %>
															<option value="<%=m.getNombre() %>"><%= m.getNombre() %></option>
														<% } %>
													<% } %>											
											<%	} %>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<div class="form-group col-md-12">
							<label for="ddc">DIRECCIÓN DE CORRESPONDENCIA</label>
							<div id="ddc">
								<div class="form-group col-md-12">
									<input type="text" class="anchoCompleto" style="max-width: 100% !important;" id="direccionCorrespondencia" name="direccionCorrespondencia" value="<%=datos_personales.getString("direccionCorrespondencia")%>">
								</div>
								<div class="form-group col-md-4">
									<label for="paisCorespondencia">PAÍS</label>
									<input type="text" class="anchoCompleto" id="paisCorrespondencia" name="paisCorrespondencia" style="max-width: 100% !important;" value="<%=datos_personales.getString("paisCorrespondencia")%>" onblur="validarPaisCorrespondencia()">
								</div>
								<div id="escritoC">
									<div class="form-group col-md-4">
										<label for="depCorespondencia">DEPARTAMENTO</label>
										<input type="text" class="anchoCompleto" id="depCorrespondencia" name="depCorrespondencia" style="max-width: 100% !important;" value="<%=datos_personales.getString("departamentoCorrespondencia")%>">
									</div>
									<div class="form-group col-md-4">
										<label for="munCorespondencia">MUNICIPIO</label>
										<input type="text" class="anchoCompleto" id="munCorrespondencia" name="munCorrespondencia" style="max-width: 100% !important;" value="<%=datos_personales.getString("municipioCorrespondencia")%>">
									</div>
								</div>
								<div id="listasC">
									<div class="form-group col-md-4">
										<label for="depCorespondencia">DEPARTAMENTO</label>
										<select class="anchoCompleto" id="depCorrespondenciaL" name="depCorrespondencia" style="margin-bottom : 1px; max-width: 100% !important;" onchange="filtroMunicipio('depCorrespondenciaL','munCorrespondenciaL')">
											<option value="">Seleccione</option>
											<% for(modeloBasico d : departamentos){ %>
												<% if(datos_personales.getString("departamentoCorrespondencia").equals(d.getNombre())){ %>
													<option value="<%=d.getNombre() %>" selected="selected"><%= d.getNombre() %></option>
												<% }else{ %>
													<option value="<%=d.getNombre() %>"><%= d.getNombre() %></option>
												<% } %>
											<% } %>
										</select>
									</div>
									<div class="form-group col-md-4">
										<label for="munCorespondencia">MUNICIPIO</label>
										<select class="anchoCompleto" id="munCorrespondenciaL" name="munCorrespondencia" style="margin-bottom : 1px; max-width: 100% !important;">
											<option value="" >Seleccione</option>
											<% 
												if(!datos_personales.getString("departamentoCorrespondencia").isEmpty() && ( datos_personales.getString("paisCorrespondencia").equalsIgnoreCase("colombia") || datos_personales.getString("paisCorrespondencia").isEmpty() ) ){
													List<modeloBasico> municipios = consultas.getMunicipiosNombre(datos_personales.getString("departamentoCorrespondencia"));
											%>	
													<% for(modeloBasico m : municipios){ %>
														<% if(datos_personales.getString("municipioCorrespondencia").equals(m.getNombre())){ %>
															<option value="<%=m.getNombre() %>" selected="selected"><%= m.getNombre() %></option>
														<% }else{ %>
															<option value="<%=m.getNombre() %>"><%= m.getNombre() %></option>
														<% } %>
													<% } %>											
											<%	} %>
										</select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label for="telCorespondencia">TELÉFONO</label>
									<input type="text" class="anchoCompleto" style="max-width: 100% !important" id="telCorrespondencia" name="telCorrespondencia" value="<%=datos_personales.getString("telefonoCorrespondencia")%>">
								</div>
								<div class="form-group col-md-6">
									<label for="emailCorespondencia">EMAIL</label>
									<input type="email" class="anchoCompleto select-option" id="emailCorrespondencia" name="emailCorrespondencia" style="max-width: 100% !important;" value="<%=datos_personales.getString("emailCorrespondencia")%>">
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row text-center">
					<button class="btn" value="Guardar" type="submit">Guardar</button>
				</div>
			</form>
		</div>
	</div>
</div>
<portlet:resourceURL var="filtro">
	<portlet:param name="pagina" value="municipiosNombre"/>
</portlet:resourceURL>
<script>
$('#datosPersonales').addClass("active");

$(document).ready(function(){
	$("input:radio[name=nacionalidad]").click(function () {	 
		var valor = $('input:radio[name=nacionalidad]:checked').val();
		if(valor == 'COLOMBIANO'){
			$('#nacionalidadPais').hide();
			$("#pais").prop('required',false);
		}else{
			$('#nacionalidadPais').show();
			$("#pais").prop('required',true);
		}
	});
	 
	var valor = $('input:radio[name=nacionalidad]:checked').val();
	if(valor == 'COLOMBIANO'){
		$('#nacionalidadPais').hide();
		$("#pais").prop('required',false);
	}
	if(valor == 'EXTRANJERO'){
		$('#nacionalidadPais').show();
		$("#pais").prop('required',true);
	}
	
	$("input:radio[name=sexo]").click(function () {	 
		var valor = $('input:radio[name=sexo]:checked').val();
		if(valor == 'FEMENINO')
			$('#filaLibretaMilitar').hide();
		else
			$('#filaLibretaMilitar').show();
	});
	 
	var valor = $('input:radio[name=sexo]:checked').val();
	if(valor == 'FEMENINO')
		$('#filaLibretaMilitar').hide();
	if(valor == 'MASCULINO')
		$('#filaLibretaMilitar').show();
	
	var valor = new String($('#paisNacimiento').val());
	var paisC = 'colombia';
	if( valor.toLowerCase().includes(paisC.toLowerCase()) ){
		$('#escrito').hide();
		$('#listas').show();
		
		$("#listas").find("input,button,textarea,select").attr("disabled", false);
		$("#escrito").find("input,button,textarea,select").attr("disabled", true);
	}else{		
		$('#escrito').show();
		$('#listas').hide();
		
		$("#escrito").find("input,button,textarea,select").attr("disabled", false);
		$("#listas").find("input,button,textarea,select").attr("disabled", true); 
	}
	
	var valor = new String($('#paisCorrespondencia').val());
	var paisC = 'colombia';
	if( valor.toLowerCase().includes(paisC.toLowerCase()) ){
		$('#escritoC').hide();
		$('#listasC').show();
		
		$("#listasC").find("input,button,textarea,select").attr("disabled", false);
		$("#escritoC").find("input,button,textarea,select").attr("disabled", true);
	}else{
		
		$('#escritoC').show();
		$('#listasC').hide();
		
		$("#escritoC").find("input,button,textarea,select").attr("disabled", false);
		$("#listasC").find("input,button,textarea,select").attr("disabled", true); 
	}
		
 });
 
 function validarPaisNacimiento(){
	 var paisN = document.getElementById("paisNacimiento").value;
	 var paisC = 'colombia';
	 if( paisN.toLowerCase().includes(paisC.toLowerCase()) ){
		$('#escrito').hide();
		$('#listas').show();
		
		$("#listas").find("input,button,textarea,select").attr("disabled", false);
		$("#escrito").find("input,button,textarea,select").attr("disabled", true);
	 }else{
		$('#escrito').show();
		$('#listas').hide();
		
		$("#listas").find("input,button,textarea,select").attr("disabled", true);
		$("#escrito").find("input,button,textarea,select").attr("disabled", false);
	 }
 }
 
 function validarPaisCorrespondencia(){
	 var paisN = document.getElementById("paisCorrespondencia").value;
	 var paisC = 'colombia';
	 if( paisN.toLowerCase().includes(paisC.toLowerCase()) ){
		$('#escritoC').hide();
		$('#listasC').show();
		
		$("#listasC").find("input,button,textarea,select").attr("disabled", false);
		$("#escritoC").find("input,button,textarea,select").attr("disabled", true);
	 }else{
		$('#escritoC').show();
		$('#listasC').hide();
		
		$("#listasC").find("input,button,textarea,select").attr("disabled", true);
		$("#escritoC").find("input,button,textarea,select").attr("disabled", false);
	 }
 }
 
 function filtroMunicipio(inputSolicitud,inputRespuesta){
	 
	 var departamento = document.getElementById(inputSolicitud).value;

	 $.ajax({
	 	url: '<%=filtro%>',
	     type:  'post',
	     dataType: 'json',
	     data:  {departamento : departamento },
	     success:  function (response) {
	     	var data = response;
	     	$('#'+inputRespuesta).html('');
	     	$('#'+inputRespuesta).append(new Option('Seleccione', ""));
	     	$.each(data, function(i, des) {
	     		$('#'+inputRespuesta).append(new Option(des.nombre, des.id));
	         });
	     }
	 });
 }
 
 $(document).ajaxStart(function() {
	    // show loader on start
	    $('#progreso').show();
	}).ajaxSuccess(function() {
	    // hide loader on success
		$('#progreso').hide();
	}).ajaxError(function() {
	    // hide loader on success
		$('#progreso').hide();
	});
 
</script>
<% }else{ %>
<script type="text/javascript">
$(document).ready( function(){
	window.location.href = '<%=home%>';
});
</script>
<% } %>