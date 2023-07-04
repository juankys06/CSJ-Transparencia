<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.co.csj.service.model.usuario_data"%>
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
		//String usuarioId = (String) renderRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		int cantidadEL = 1;
		String ids = "";
		JSONObject formacion_academica = JSONFactoryUtil.createJSONObject();
		if(!usuario.getExperiencia_laboral().isEmpty()){
			formacion_academica = JSONFactoryUtil.createJSONObject(usuario.getExperiencia_laboral());
			cantidadEL = formacion_academica.getInt("cantidadEL");
			if(cantidadEL==0)
				cantidadEL=1;
		}
		List<modeloBasico> departamentos = consultas.getDepartamentosNombre();
		String depJava = "[";
		for(modeloBasico d : departamentos){
			depJava+="'"+d.getNombre()+"',";
		}
		depJava = depJava.substring(0, depJava.length() - 1);
		depJava += "]";
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
<portlet:actionURL var="guardarExperienciaLaboral" name="guardarExperienciaLaboral"></portlet:actionURL>

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
				<h2>Experiencia Laboral</h2>
			</div>
			<br>
			<div class="row">
				<h5 class="col-md-12">RELACIONE SU EXPERIENCIA LABORAL O DE PRESTACIÓN DE SERVICIOS EN ESTRICTO ORDEN CRONOLÓGICO COMENZANDO POR EL ACTUAL.</h5>
			</div>
			<br>
			<form action="<%=guardarExperienciaLaboral %>" method="post">
				<input type="hidden" id="cantidadEL" name="cantidadEL" value="<%=cantidadEL %>">
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<%
				    		JSONArray elArray = JSONFactoryUtil.createJSONArray();
				    		if(!formacion_academica.getString("experiencia").equals("")){
				    			elArray = JSONFactoryUtil.createJSONArray(formacion_academica.getString("experiencia"));
				    		}
				    		int cuenta = elArray.length();
				    		if(cuenta==0)
				    			cuenta=1;
				    		for(int i=1 ; i<=cuenta ; i++){
				    			if(i<cuenta)
				    				ids+=i+",";
				    			else
				    				ids+=i;
				    			JSONObject el = JSONFactoryUtil.createJSONObject();
				    			if(elArray.getJSONObject(i-1)!=null)
				    				el = elArray.getJSONObject(i-1);
				    	%>
							<table class="table table-bordered" id="<%="exp"+i %>">
							    <thead>
							    	<tr>
							        	<%
							        		if(i==1){
							        	%>
							        		<th colspan="3" style="text-align: center; vertical-align: middle;">EMPLEO ACTUAL O CONTRATO VIGENTE</th>
							        	<%	}else{ %>
							        		<th colspan="3" style="text-align: center; vertical-align: middle;">EMPLEO O CONTRATO ANTERIOR</th>
							        		<th style="text-align: center; vertical-align: middle;">
							        			<% String EliTabla = "eliminarTabla('exp"+i+"')"; %>
							        			<a onclick="<%=EliTabla %>">
								    				<i class="fa fa-times"></i>
								    			</a>
							        		</th>
							        	<%	} %>
							      	</tr>
							    </thead>
							    <tbody>
						    	   	<tr>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="empresa"+i %>">EMPRESA O ENTIDAD</label>
												<input type="text" class="anchoCompleto" id="<%="empresa"+i %>" name="<%="empresa"+i %>" style="max-width: 100% !important;" value="<%=el.getString("empresa")%>">
											</div>
							    		</td>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="sector"+i %>">SECTOR</label>
												<select class="anchoCompleto" id="<%="sector"+i %>" name="<%="sector"+i %>" style="max-width: 100% !important;">
													<option value="">Seleccione</option>
													<% if(el.getString("sector").equals("publico")){ %>
														<option value="publico" selected="selected">Público</option>
													<% }else{ %>
														<option value="publico">Público</option>
													<% } %>
													<% if(el.getString("sector").equals("privado")){ %>
														<option value="privado" selected="selected">Privado</option>
													<% }else{ %>
														<option value="privado">Privado</option>
													<% } %>
												</select>
											</div>
							    		</td>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="pais"+i %>">PAÍS</label>
												<input type="text" class="anchoCompleto" id="<%="pais"+i %>" name="<%="pais"+i %>" style="max-width: 100% !important;" value="<%=el.getString("pais")%>" onblur="<%= "verificarPais('"+i+"')" %>">
											</div>
							    		</td>
							    	</tr>
							    	<tr>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="departamento"+i %>">DEPARTAMENTO</label>
												<div id="<%="escritoD"+i %>">
													<input type="text" class="anchoCompleto" id="<%="departamento"+i %>" name="<%="departamento"+i %>" style="max-width: 100% !important;" value="<%=el.getString("departamento")%>">
												</div>
												<div id="<%="listasD"+i %>">
													<select class="anchoCompleto" id="<%="departamentoL"+i %>" name="<%="departamento"+i %>" style="margin-bottom : 1px; max-width: 100% !important;" onchange="<%= "filtroMunicipio('departamentoL"+i+"','municipioL"+i+"')" %>">
														<option value="">Seleccione</option>
														<% for(modeloBasico d : departamentos){ %>
															<% if(el.getString("departamento").equals(d.getNombre())){ %>
																<option value="<%=d.getNombre() %>" selected="selected"><%= d.getNombre() %></option>
															<% }else{ %>
																<option value="<%=d.getNombre() %>"><%= d.getNombre() %></option>
															<% } %>
														<% } %>
													</select>
												</div>
											</div>
							    		</td>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="municipio"+i %>">MUNICIPIO</label>
												<div id="<%="escritoM"+i %>">
													<input type="text" class="anchoCompleto" id="<%="municipio"+i %>" name="<%="municipio"+i %>" style="max-width: 100% !important;" value="<%=el.getString("municipio")%>">
												</div>
												<div id="<%="listasM"+i %>">
													<select class="anchoCompleto" id="<%="municipioL"+i %>" name="<%="municipio"+i %>" style="margin-bottom : 1px; max-width: 100% !important;">
														<option value="" >Seleccione</option>
														<% 
															if(!el.getString("departamento").isEmpty() && ( el.getString("pais").equalsIgnoreCase("colombia") || el.getString("pais").isEmpty() ) ){
																List<modeloBasico> municipios = consultas.getMunicipiosNombre(el.getString("departamento"));
														%>	
																<% for(modeloBasico m : municipios){ %>
																	<% if(el.getString("municipio").equals(m.getNombre())){ %>
																		<option value="<%=m.getNombre() %>" selected="selected"><%= m.getNombre() %></option>
																	<% }else{ %>
																		<option value="<%=m.getNombre() %>"><%= m.getNombre() %></option>
																	<% } %>
																<% } %>											
														<%	} %>
													</select>
												</div>
											</div>
							    		</td>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="correo"+i %>">CORREO ELECTRÓNICO ENTIDAD</label>
												<input type="text" class="anchoCompleto" id="<%="correo"+i %>" name="<%="correo"+i %>" style="max-width: 100% !important;" value="<%=el.getString("correo")%>">
											</div>
							    		</td>
							    	</tr>
							    	<tr>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="telefono"+i %>">TELÉFONOS</label>
												<input type="text" class="anchoCompleto" id="<%="telefono"+i %>" name="<%="telefono"+i %>" style="max-width: 100% !important;" value="<%=el.getString("telefono")%>">
											</div>
							    		</td>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="fechai"+i %>">FECHA DE INGRESO</label>
												<input type="date" class="anchoCompleto select-option" id="<%="fechai"+i %>" name="<%="fechai"+i %>" style="max-width: 100% !important;" value="<%=el.getString("fechaIngreso")%>" max="<%=fechaHoy %>">
											</div>
							    		</td>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="fechar"+i %>">FECHA DE RETIRO</label>
												<input type="date" class="anchoCompleto select-option" id="<%="fechar"+i %>" name="<%="fechar"+i %>" style="max-width: 100% !important;" value="<%=el.getString("fechaRetiro")%>" max="<%=fechaHoy %>">
											</div>
							    		</td>
							    	</tr>
							    	<tr>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="cargo"+i %>">CARGO O CONTRATO  ACTUAL</label>
												<input type="text" class="anchoCompleto" id="<%="cargo"+i %>" name="<%="cargo"+i %>" style="max-width: 100% !important;" value="<%=el.getString("cargo")%>">
											</div>
							    		</td>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="dependencia"+i %>">DEPENDENCIA</label>
												<input type="text" class="anchoCompleto" id="<%="dependencia"+i %>" name="<%="dependencia"+i %>" style="max-width: 100% !important;" value="<%=el.getString("dependencia")%>">
											</div>
							    		</td>
							    		<td>
							    			<div class="form-group" style="margin-bottom: 0;">
												<label for="<%="direccion"+i %>">DIRECCIÓN</label>
												<input type="text" class="anchoCompleto" id="<%="direccion"+i %>" name="<%="direccion"+i %>" style="max-width: 100% !important;" value="<%=el.getString("direccion")%>">
											</div>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
					  	</table>
					  	<p id="otro" hidden="true"></p>
					  	<input type="hidden" name="ids" id="ids" value="<%=ids %>">
					  	<div class="row">
					  		<div class="col-md-12">
					  			<button class="btn" style="color: white;" type="button" onclick="agregarOtro()">Agregar Experiencia Laboral</button>
					  		</div>
					  		<div class="col-md-12 text-center">
					  			<button class="btn" type="submit">Guardar</button>
					  		</div>
					  	</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<portlet:resourceURL var="filtro">
	<portlet:param name="pagina" value="municipiosNombre"/>
</portlet:resourceURL>

<script>
$('#experienciaLaboral').addClass("active");

var cantidad = <%= cantidadEL%>;
var departamentos = <%=depJava %>;

$(document).ready(function(){
	
	for(var i =0 ; i<=cantidad ; i++){
		var valor = new String($('#pais'+i).val());
		var paisC = 'colombia';
		if( valor.toLowerCase().includes(paisC.toLowerCase()) ){
			$('#escritoD'+i).hide();
			$('#listasD'+i).show();
			
			$("#listasD"+i).find("input,button,textarea,select").attr("disabled", false);
			$("#escritoD"+i).find("input,button,textarea,select").attr("disabled", true);
			
			$('#escritoM'+i).hide();
			$('#listasM'+i).show();
			
			$("#listasM"+i).find("input,button,textarea,select").attr("disabled", false);
			$("#escritoM"+i).find("input,button,textarea,select").attr("disabled", true);
		}else{			
			$('#escritoD'+i).show();
			$('#listasD'+i).hide();
			
			$("#escritoD"+i).find("input,button,textarea,select").attr("disabled", false);
			$("#listasD"+i).find("input,button,textarea,select").attr("disabled", true); 
			
			$('#escritoM'+i).show();
			$('#listasM'+i).hide();
			
			$("#escritoM"+i).find("input,button,textarea,select").attr("disabled", false);
			$("#listasM"+i).find("input,button,textarea,select").attr("disabled", true); 
		}
	}
});

function verificarPais(i){
	 var valor = document.getElementById("pais"+i).value;
	 var paisC = 'colombia';
	 if( valor.toLowerCase().includes(paisC.toLowerCase()) ){
		$('#escritoD'+i).hide();
		$('#listasD'+i).show();
		
		$("#listasD"+i).find("input,button,textarea,select").attr("disabled", false);
		$("#escritoD"+i).find("input,button,textarea,select").attr("disabled", true);
		
		$('#escritoM'+i).hide();
		$('#listasM'+i).show();
		
		$("#listasM"+i).find("input,button,textarea,select").attr("disabled", false);
		$("#escritoM"+i).find("input,button,textarea,select").attr("disabled", true);
	}else{			
		$('#escritoD'+i).show();
		$('#listasD'+i).hide();
		
		$("#escritoD"+i).find("input,button,textarea,select").attr("disabled", false);
		$("#listasD"+i).find("input,button,textarea,select").attr("disabled", true); 
		
		$('#escritoM'+i).show();
		$('#listasM'+i).hide();
		
		$("#escritoM"+i).find("input,button,textarea,select").attr("disabled", false);
		$("#listasM"+i).find("input,button,textarea,select").attr("disabled", true); 
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

function agregarOtro(){
	cantidad++;
	
	var optionsDep = '<option value="" >Seleccione</option>';
	
	departamentos.forEach(function (elemento , indice,array){
		optionsDep = optionsDep+'<option value="'+elemento+'" >'+elemento+'</option>';
	});
	
	var eliTabla = "eliminarTabla('exp"+cantidad+"')";
	var muni = "filtroMunicipio('departamentoL"+cantidad+"','municipioL"+cantidad+"')";
	
	$("#otro").replaceWith('<table class="table table-bordered" id="exp'+cantidad+'">'+
			'    <thead>'+
			'    	<tr>'+
			'        	<th colspan="3" style="text-align: center; vertical-align: middle;">EMPLEO O CONTRATO ANTERIOR</th>'+
			'			<th style="text-align: center; vertical-align: middle;">'+
			'				<a onclick="'+eliTabla+'">'+
			'					<i class="fa fa-times"></i>'+
			'				</a>'+
			'			</th>'+
			'      	</tr>'+
			'    </thead>'+
			'    <tbody>'+
			'    	<tr>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="empresa'+cantidad+'">EMPRESA O ENTIDAD</label>'+
			'					<input type="text" class="anchoCompleto" id="empresa'+cantidad+'" name="empresa'+cantidad+'" style="max-width: 100% !important;">'+
			'				</div>'+
			'    		</td>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="sector'+cantidad+'">SECTOR</label>'+
			'					<select class="anchoCompleto" id="sector'+cantidad+'" name="sector'+cantidad+'" style="max-width: 100% !important;">'+
			'						<option value="">Seleccione</option>'+
			'						<option value="publico">Público</option>'+
			'						<option value="privado">Privado</option>'+
			'					</select>'+
			'				</div>'+
			'    		</td>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="pais'+cantidad+'">PAÍS</label>'+
			'					<input type="text" class="anchoCompleto" id="pais'+cantidad+'" name="pais'+cantidad+'" style="max-width: 100% !important;" onblur="verificarPais('+cantidad+')">'+
			'				</div>'+
			'    		</td>'+
			'    	</tr>'+
			'    	<tr>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="departamento'+cantidad+'">DEPARTAMENTO</label>'+
			'					<div id="escritoD'+cantidad+'">'+
			'						<input type="text" class="anchoCompleto" id="departamento'+cantidad+'" name="departamento'+cantidad+'" style="max-width: 100% !important;">'+
			'					</div>'+
			'					<div id="listasD'+cantidad+'">'+
			'						<select name="departamento'+cantidad+'" id="departamentoL'+cantidad+'" class="anchoCompleto" style="max-width: 100% !important;" onchange="'+muni+'">'+
										optionsDep+
			'						</select>'+
			'					</div>'+
			'				</div>'+
			'    		</td>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="municipio'+cantidad+'">MUNICIPIO</label>'+
			'					<div id="escritoM'+cantidad+'">'+
			'						<input type="text" class="anchoCompleto" id="municipio'+cantidad+'" name="municipio'+cantidad+'" style="max-width: 100% !important;">'+
			'					</div>'+
			'					<div id="listasM'+cantidad+'">'+
			'						<select name="municipio'+cantidad+'" id="municipioL'+cantidad+'" class="anchoCompleto" style="max-width: 100% !important;">'+
			'							<option value="">Seleccione</option>'+
			'						</select>'+
			'					</div>'+
			'				</div>'+
			'    		</td>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="correo'+cantidad+'">CORREO ELECTRÓNICO ENTIDAD</label>'+
			'					<input type="text" class="anchoCompleto" id="correo'+cantidad+'" name="correo'+cantidad+'" style="max-width: 100% !important;">'+
			'				</div>'+
			'    		</td>'+
			'    	</tr>'+
			'    	<tr>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="telefono'+cantidad+'">TELÉFONOS</label>'+
			'					<input type="text" class="anchoCompleto" id="telefono'+cantidad+'" name="telefono'+cantidad+'" style="max-width: 100% !important;">'+
			'				</div>'+
			'    		</td>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="fechai'+cantidad+'">FECHA DE INGRESO</label>'+
			'					<input type="date" class="anchoCompleto select-option" id="fechai'+cantidad+'" name="fechai'+cantidad+'" style="max-width: 100% !important;" max="<%=fechaHoy %>">'+
			'				</div>'+
			'    		</td>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="fechar'+cantidad+'">FECHA DE RETIRO</label>'+
			'					<input type="date" class="anchoCompleto select-option" id="fechar'+cantidad+'" name="fechar'+cantidad+'" style="max-width: 100% !important;" max="<%=fechaHoy %>">'+
			'				</div>'+
			'    		</td>'+
			'    	</tr>'+
			'    	<tr>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="cargo'+cantidad+'">CARGO O CONTRATO</label>'+
			'					<input type="text" class="anchoCompleto" id="cargo'+cantidad+'" name="cargo'+cantidad+'" style="max-width: 100% !important;">'+
			'				</div>'+
			'    		</td>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="dependencia'+cantidad+'">DEPENDENCIA</label>'+
			'					<input type="text" class="anchoCompleto" id="dependencia'+cantidad+'" name="dependencia'+cantidad+'" style="max-width: 100% !important;">'+
			'				</div>'+
			'    		</td>'+
			'    		<td>'+
			'    			<div class="form-group" style="margin-bottom: 0;">'+
			'					<label for="direccion'+cantidad+'">DIRECCIÓN</label>'+
			'					<input type="text" class="anchoCompleto" id="direccion'+cantidad+'" name="direccion'+cantidad+'" style="max-width: 100% !important;">'+
			'				</div>'+
			'    		</td>'+
			'    	</tr>'+
			'    </tbody>'+
			'</table>'+
			'<br>'+
			'<p id="otro" hidden="true"></p>');
	$('#cantidadEL').val(cantidad);
	var ids = $('#ids').val();
	if(ids=="")
		ids=cantidad;
	else
		ids = ids+','+cantidad;
	$('#ids').val(ids);
	verificarPais(cantidad);
}

function eliminarTabla(tabla){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = tabla.replace("exp","");
		var ids = $('#ids').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#ids').val(a);
		$('#'+tabla).remove();
	}
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