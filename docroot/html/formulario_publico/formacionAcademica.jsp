<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
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
		List<modeloBasico> meses = consultas.getMeses();
		List<modeloBasico> anhios = consultas.getAnios();
		List<modeloBasico> educacionMedia = consultas.getEducacionMedia();
		List<modeloBasico> modalidadEducacionSuperior = consultas.getModalidadEducacionSuperior();
		List<modeloBasico> dominioIdioma = consultas.getDominioIdioma();
		int cantidadES = 1;
		int cantidadI = 1;
		String idsES = "";
		String idsI = "";
		JSONObject formacion_academica = JSONFactoryUtil.createJSONObject();
		if(!usuario.getFormacion_academica().isEmpty()){
			formacion_academica = JSONFactoryUtil.createJSONObject(usuario.getFormacion_academica());
			cantidadES = formacion_academica.getInt("cantidadES");
			cantidadI = formacion_academica.getInt("cantidadI");
			if(cantidadES==0)
				cantidadES=1;
			if(cantidadI==0)
				cantidadI=1;
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
<portlet:actionURL var="guardarFormacionAcademica" name="guardarFormacionAcademica"></portlet:actionURL>

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
				<h2>Formación Académica</h2>
			</div>
			<br>
			<form action="<%=guardarFormacionAcademica %>" method="post">
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
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
						    			<select name="educacionMedia" id="educacionMedia" style="max-width: 100% !important;" class="anchoCompleto">
						    				<option value="" >Seleccione</option>
						    				<% for(modeloBasico m : educacionMedia){ 
						    					if(formacion_academica.getString("educacionMedia").equals(m.getCodigo())){
						    				%>
						    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
						    				<% }else{ %>
						    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
						    				<% }} %>
						    			</select>
						    		</td>
						    		<td>
						    			<input type="text" class="anchoCompleto" id="tituloEB" name="tituloEB" style="max-width: 100% !important;" value="<%=formacion_academica.getString("tituloEducacionMedia")%>">
						    		</td>
						    		<td>
						    			<select name="mesEM" id="mesEM" style="max-width: 100% !important;">
						    				<option value="" >Seleccione</option>
						    				<% for(modeloBasico m : meses){ 
						    					if(formacion_academica.getString("mesEducacionMedia").equals(m.getCodigo())){
						    				%>
						    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
						    				<% }else{ %>
						    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
						    				<% }} %>
						    			</select>
						    			<select name="anhioEM" id="anhioEM" style="max-width: 100% !important;" >
						    				<option value="" >Seleccione</option>
						    				<% for(modeloBasico m : anhios){ 
						    					if(formacion_academica.getString("anhioEducacionMedia").equals(m.getCodigo())){
						    				%>
						    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
						    				<% }else{ %>
						    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
						    				<% }} %>
						    			</select>
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
					  	<input type="hidden" name="cantidadES" id="cantidadES" value="<%=cantidadES%>">
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
						    		if(!formacion_academica.getString("formacion").equals("")){
						    			esArray = JSONFactoryUtil.createJSONArray(formacion_academica.getString("formacion"));
						    		}
						    		int cuenta = esArray.length();
						    		if(cuenta==0)
						    			cuenta=1;
						    		for(int i=1 ; i<=cuenta ; i++){
						    			if(i<cuenta)
						    				idsES+=i+",";
						    			else
						    				idsES+=i;
						    			JSONObject es = JSONFactoryUtil.createJSONObject();
						    			if(esArray.getJSONObject(i-1)!=null)
						    				es = esArray.getJSONObject(i-1);
						    	%>
								    	<tr id="<%="filaES"+i %>">
								    		<td>
								    			<select name="<%="modalidadES"+i%>" id="<%="modalidadES"+i%>" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;">
								    				<option value="" >Seleccione</option>
								    				<% for(modeloBasico m : modalidadEducacionSuperior){ 
							    						if(es.getString("modalidadEducacionSuperior").equals(m.getCodigo())){
								    				%>
								    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
								    				<% }else{ %>
								    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
								    				<% }} %>
								    			</select>
								    		</td>
								    		<td>
								    			<input type="text" class="anchoCompleto" id="<%="semestresES"+i %>" name="<%="semestresES"+i %>" style="max-width: 100% !important;" value="<%=es.getString("semestresEducacionSuperior")%>">
								    		</td>
								    		<td>
								    			<select name="<%="graduadoES"+i %>" id="<%="graduadoES"+i %>" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;">
								    				<option value="" >Seleccione</option>
								    				<% 
								    					if(es.getString("graduadoEducacionSuperior").equals("NO")){
								    				%>
								    					<option value="NO" selected="selected">NO</option>
								    				<% }else{ %>
								    					<option value="NO" >NO</option>
								    				<% } %>
								    				<% 
								    					if(es.getString("graduadoEducacionSuperior").equals("SI")){
								    				%>
								    					<option value="SI" selected="selected">SI</option>
								    				<% }else{ %>
								    					<option value="SI" >SI</option>
								    				<% } %>
								    				
								    			</select>
								    		</td>
								    		<td>
								    			<input type="text" class="anchoCompleto" id="<%="tituloES"+i %>" name="<%="tituloES"+i %>" style="max-width: 100% !important;" value="<%=es.getString("tituloEducacionSuperior")%>">
								    		</td>
								    		<td>
								    			<select name="<%="mesES"+i %>" id="<%="mesES"+i %>" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;">
								    				<option value="" >Seleccione</option>
								    				<% for(modeloBasico m : meses){ 
								    					if(es.getString("mesEducacionSuperior").equals(m.getCodigo())){
								    				%>
								    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
								    				<% }else{ %>
								    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
								    				<% }} %>
								    			</select>
								    			<select name="<%="anhioES"+i %>" id="<%="anhioES"+i %>" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;" >
								    				<option value="" >Seleccione</option>
								    				<% for(modeloBasico m : anhios){ 
								    					if(es.getString("anhioEducacionSuperior").equals(m.getCodigo())){
								    				%>
								    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
								    				<% }else{ %>
								    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
								    				<% }} %>
								    			</select>
								    		</td>
								    		<td>
								    			<input type="text" class="anchoCompleto" id="<%="tarjetaES"+i %>" name="<%="tarjetaES"+i %>" style="max-width: 100% !important;" value="<%=es.getString("tarjetaEducacionSuperior")%>">
								    		</td>
								    		<td style="vertical-align: middle;">
								    			<% String EliFila = "eliminarFilaES('filaES"+i+"')"; %>
								    			<a onclick="<%=EliFila %>">
								    				<i class="fa fa-times"></i>
								    			</a>
								    		</td>
								    	</tr>
								    <% } %>
						    </tbody>
					  	</table>
					  	<input type="hidden" name="idsES" id="idsES" value="<%=idsES %>">
					  	<button class="btn" style="color: white;" type="button" onclick="agregarOtroES()">Agregar Educación Superior</button>
					  	<br>
					  	<br>
					  	ESPECIFIQUE LOS IDIOMAS DIFERENTES AL ESPAÑOL QUE: HABLA, LEE, ESCRIBE DE FORMA, REGULAR, BIEN O MUY BIEN.
					  	<br>
					  	<input type="hidden" name="cantidadI" id="cantidadI" value="<%=cantidadI%>">
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
						    		if(!formacion_academica.getString("idiomas").equals("")){
						    			iArray = JSONFactoryUtil.createJSONArray(formacion_academica.getString("idiomas"));
						    		}
						    		int cuentai = iArray.length();
						    		if(cuentai==0)
						    			cuentai=1;
						    		for(int i=1 ; i<=cuentai ; i++){
						    			if(i<cuentai)
						    				idsI+=i+",";
						    			else
						    				idsI+=i;
						    			JSONObject es = JSONFactoryUtil.createJSONObject();
						    			if(iArray.getJSONObject(i-1)!=null)
						    				es = iArray.getJSONObject(i-1);
						    	%>
							    	<tr id="<%="filaI"+i %>">
							    		<td>
							    			<input type="text" class="anchoCompleto" id="<%="idioma"+i %>" name="<%="idioma"+i %>" style="max-width: 100% !important;" value="<%=es.getString("idioma") %>">
							    		</td>
							    		<td>
							    			<select name="<%="hi"+i %>" id="<%="hi"+i %>" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;" >
							    				<option value="" >Seleccione</option>
							    				<% for(modeloBasico m : dominioIdioma){ 
							    					if(es.getString("habla").equals(m.getCodigo())){
								    			%>
								    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
								    			<% }else{ %>
								    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
								    			<% }} %>
							    			</select>
							    		</td>
							    		<td>
							    			<select name="<%="li"+i %>" id="<%="li"+i %>" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;" >
							    				<option value="" >Seleccione</option>
							    				<% for(modeloBasico m : dominioIdioma){ 
							    				if(es.getString("lee").equals(m.getCodigo())){
								    			%>
								    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
								    			<% }else{ %>
								    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
								    			<% }} %>
							    			</select>
							    		</td>
							    		<td>
							    			<select name="<%="ei"+i %>" id="<%="ei"+i %>" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;" >
							    				<option value="" >Seleccione</option>
							    				<% for(modeloBasico m : dominioIdioma){ 
							    				if(es.getString("escribe").equals(m.getCodigo())){
								    			%>
								    					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
								    			<% }else{ %>
								    					<option value="<%=m.getCodigo() %>" ><%=m.getNombre() %></option>
								    			<% }} %>
							    			</select>
							    		</td>
							    		<td style="vertical-align: middle;">
							    			<% String EliFila = "eliminarFilaI('filaI"+i+"')"; %>
							    			<a onclick="<%=EliFila %>">
							    				<i class="fa fa-times"></i>
							    			</a>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
					  	</table>
					  	<input type="hidden" name="idsI" id="idsI" value="<%=idsI %>">
					  	<button class="btn" style="color: white;" type="button" onclick="agregarOtroI()">Agregar Idioma</button>
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
</div>

<portlet:resourceURL var="filtro">
	<portlet:param name="pagina" value="despachoAsignado"/>
</portlet:resourceURL>

<script>
$('#formacionAcademica').addClass("active");

var cantidadES = <%=cantidadES%>;
var cantidadI = <%=cantidadI%>;

var modalidadEducacionSuperior = ["TÉCNICA","TECNOLÓGICA","TECNOLÓGICA ESPECIALIZADA","UNIVERSITARIA","ESPECIALIZACIÓN","MAESTRÍA O MAGISTER","DOCTORADO O PHD","DIPLOMADO"];

var meses = [{codigo:1,nombre:"ENERO"},
             {codigo:2,nombre:"FEBRERO"},
             {codigo:3,nombre:"MARZO"},
             {codigo:4,nombre:"ABRIL"},
             {codigo:5,nombre:"MAYO"},
             {codigo:6,nombre:"JUNIO"},
             {codigo:7,nombre:"JULIO"},
             {codigo:8,nombre:"AGOSTO"},
             {codigo:9,nombre:"SEPTIEMBRE"},
             {codigo:10,nombre:"OCTUBRE"},
             {codigo:11,nombre:"NOVIEMBRE"},
             {codigo:12,nombre:"DICIEMBRE"}];

var fecha = new Date();

var ano = fecha. getFullYear();
var anhios = [];
for(var i = ano; i>= 1950 ; i--){
	anhios.push(i);
}

var dominioIdioma = ["REGULAR","BIEN","MUY BIEN"];

function agregarOtroES(){
	cantidadES++;
	var optionsModalidad = '<option value="" >Seleccione</option>';
	var mesesES = '<option value="" >Seleccione</option>';
	var anosES = '<option value="" >Seleccione</option>';
	
	modalidadEducacionSuperior.forEach(function (elemento , indice,array){
		optionsModalidad = optionsModalidad+'<option value="'+elemento+'" >'+elemento+'</option>';
	});
	$.each(meses, function(i, elemento) {
		mesesES = mesesES+'<option value="'+elemento.codigo+'" >'+elemento.nombre+'</option>';
	});
	anhios.forEach(function (elemento , indice,array){
		anosES = anosES+'<option value="'+elemento+'" >'+elemento+'</option>';
	});
	var filaEli = "eliminarFilaES('filaES"+cantidadES+"')";
	
	$('#TES tbody').append('<tr id="filaES'+cantidadES+'">'+
			'	<td>'+
			'		<select name="modalidadES'+cantidadES+'" id="modalidadES'+cantidadES+'" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;">'+
			optionsModalidad+
			'		</select>'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="semestresES'+cantidadES+'" name="semestresES'+cantidadES+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<select name="graduadoES'+cantidadES+'" id="graduadoES'+cantidadES+'" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;">'+
			'			<option value="" >Seleccione</option>'+
			'			<option value="NO" >NO</option>'+
			'			<option value="SI" >SI</option>'+
			'		</select>'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="tituloES'+cantidadES+'" name="tituloES'+cantidadES+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<select name="mesES'+cantidadES+'" id="mesES'+cantidadES+'" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;">'+
			mesesES+
			'		</select>'+
			'		<select name="anhioES'+cantidadES+'" id="anhioES'+cantidadES+'" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;" >'+
			anosES+
			'		</select>'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="tarjetaES'+cantidadES+'" name="tarjetaES'+cantidadES+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');
	
	$("#cantidadES").val(cantidadES);
	var ids = $('#idsES').val();
	if(ids=="")
		ids=cantidadES;
	else
		ids = ids+','+cantidadES;
	$('#idsES').val(ids);
}

function agregarOtroI(){
	cantidadI++;
	var optionsIdioma = '<option value="" >Seleccione</option>';
	
	dominioIdioma.forEach(function (elemento , indice,array){
		optionsIdioma = optionsIdioma+'<option value="'+elemento+'" >'+elemento+'</option>';
	});
	
	var filaEli = "eliminarFilaI('filaI"+cantidadI+"')";
	
	$('#IDIOMA tbody').append('<tr id="filaI'+cantidadI+'">'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="idioma'+cantidadI+'" name="idioma'+cantidadI+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<select name="hi'+cantidadI+'" id="hi'+cantidadI+'" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;" >'+
			optionsIdioma+
			'		</select>'+
			'	</td>'+
			'	<td>'+
			'		<select name="li'+cantidadI+'" id="li'+cantidadI+'" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;" >'+
			optionsIdioma+
			'		</select>'+
			'	</td>'+
			'	<td>'+
			'		<select name="ei'+cantidadI+'" id="ei'+cantidadI+'" class="texto-pequeno anchoCompleto" style="max-width: 100% !important;" >'+
			optionsIdioma+
			'		</select>'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');
	$("#cantidadI").val(cantidadI);
	var ids = $('#idsI').val();
	if(ids=="")
		ids=cantidadI;
	else
		ids = ids+','+cantidadI;
	$('#idsI').val(ids);
}

function eliminarFilaES(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("filaES","");
		var ids = $('#idsES').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsES').val(a);
		$('#'+fila).remove();
	}
}

function eliminarFilaI(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("filaI","");
		var ids = $('#idsI').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsI').val(a);
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