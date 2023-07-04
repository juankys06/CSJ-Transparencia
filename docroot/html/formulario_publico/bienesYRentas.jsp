<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
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
		List<modeloBasico> tipoBiene = consultas.getTipoBien();
		int cantidadB = 1;
		int cantidadO = 1;
		String idsB = "";
		String idsO = "";
		JSONObject bienes_y_rentas = JSONFactoryUtil.createJSONObject();
		if(!usuario.getBienes_y_rentas().isEmpty()){
			bienes_y_rentas = JSONFactoryUtil.createJSONObject(usuario.getBienes_y_rentas());
			cantidadB = bienes_y_rentas.getInt("cantidadB");
			cantidadO = bienes_y_rentas.getInt("cantidadO");
			if(cantidadB==0)
				cantidadB=1;
			if(cantidadO==0)
				cantidadO=1;
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

<portlet:actionURL var="guardarBienesRentas" name="guardarBienesRentas"></portlet:actionURL>

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
				<h2>Información de Bienes y Rentas</h2>
			</div>
			<br>
			<form action="<%=guardarBienesRentas %>" method="post">
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
						    		if(!bienes_y_rentas.getString("bienes").equals("")){
						    			bArray = JSONFactoryUtil.createJSONArray(bienes_y_rentas.getString("bienes"));
						    		}
						    		int cuentab = bArray.length();
						    		if(cuentab==0)
						    			cuentab=1;
						    		for(int i=1 ; i<=cuentab ; i++){
						    			if(i<cuentab)
						    				idsB+=i+",";
						    			else
						    				idsB+=i;
						    			
						    			JSONObject bp = JSONFactoryUtil.createJSONObject();
						    			if(bArray.getJSONObject(i-1)!=null)
						    				bp = bArray.getJSONObject(i-1);
						    	%>
							    	<tr id="<%="bien"+i %>">
							    		<td>
							    			<select name="<%="tipoBien"+i %>" id="<%="tipoBien"+i %>" class="anchoCompleto" style="max-width: 100% !important;" >
							    				<option value="" >Seleccione</option>
							    				<% for(modeloBasico b : tipoBiene){ 
							    					if(bp.getString("tipo_bien").equals(b.getCodigo())){
								    			%>
								    					<option value="<%=b.getCodigo() %>" selected="selected"><%=b.getNombre() %></option>
								    			<% }else{ %>
								    					<option value="<%=b.getCodigo() %>" ><%=b.getNombre() %></option>
								    			<% }} %>
							    			</select>
							    		</td>
							    		<td>
							    			<input type="text" class="anchoCompleto" id="<%="descripcionBien"+i %>" name="<%="descripcionBien"+i %>" style="max-width: 100% !important;" value="<%=bp.getString("descripcionBien") %>">
							    		</td>
							    		<td>
							    			<%
							    				String cop = "agregarCop('valorBien"+i+"')";
							    				String form = "formato('valorBien"+i+"')";
							    			%>
							    			<input type="text" class="anchoCompleto" id="<%="valorBien"+i %>" name="<%="valorBien"+i %>" style="max-width: 100% !important;" value="<%=bp.getString("valorBien") %>" title="El formato aceptado es solo valores numéricos el separador de miles es (.)" onblur="<%=cop %>" onkeyup="<%=form %>">
							    		</td>
							    		<td style="vertical-align: middle;">
							    			<% String EliFila = "eliminarBien('bien"+i+"')"; %>
							    			<a onclick="<%=EliFila %>">
							    				<i class="fa fa-times"></i>
							    			</a>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<input type="hidden" name="idsB" id="idsB" value="<%=idsB %>">
						<button class="btn" style="color: white;" type="button" onclick="agregarOtroB()">Agregar Bien Patrimonial</button>
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
						    		if(!bienes_y_rentas.getString("obligaciones").equals("")){
						    			oArray = JSONFactoryUtil.createJSONArray(bienes_y_rentas.getString("obligaciones"));
						    		}
						    		int cuentao = oArray.length();
						    		if(cuentao==0)
						    			cuentao=1;
						    		for(int i=1 ; i<=cuentao ; i++){
						    			if(i<cuentao)
						    				idsO+=i+",";
						    			else
						    				idsO+=i;
						    			
						    			JSONObject o = JSONFactoryUtil.createJSONObject();
						    			if(oArray.getJSONObject(i-1)!=null)
						    				o = oArray.getJSONObject(i-1);
						    	%>
							    	<tr id="<%="obligacion"+i %>">
							    		<td>
							    			<input type="text" class="anchoCompleto" id="<%="tipoObligacion"+i %>" name="<%="tipoObligacion"+i %>" style="max-width: 100% !important;" value="<%=o.getString("tipoObligacion") %>">
							    		</td>
							    		<td>
							    			<%
							    				String cop = "agregarCop('valorObligacion"+i+"')";
							    				String form = "formato('valorObligacion"+i+"')";
							    			%>
							    			<input type="text" class="anchoCompleto" id="<%="valorObligacion"+i %>" name="<%="valorObligacion"+i %>" style="max-width: 100% !important;" value="<%=o.getString("valorObligacion") %>" title="El formato aceptado es solo valores numéricos el separador de miles es (.)" onblur="<%=cop %>" onkeyup="<%=form %>">
							    		</td>
							    		<td style="vertical-align: middle;">
							    			<% String EliFila = "eliminarObligacion('obligacion"+i+"')"; %>
							    			<a onclick="<%=EliFila %>">
							    				<i class="fa fa-times"></i>
							    			</a>
							    		</td>
							    	</tr>
						    	<% } %>
						    </tbody>
						</table>
						<input type="hidden" name="idsO" id="idsO" value="<%=idsO %>">
						<button class="btn" style="color: white;" type="button" onclick="agregarOtroO()">Agregar Obligación</button>
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
<script>
$('#bienesYRentas').addClass("active");


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


var cantidadB = <%=cantidadB%>;
var cantidadO = <%=cantidadO%>;

var tipoBien = ["MUEBLES","INMUEBLES","OTROS"];

function agregarOtroB(){
	cantidadB++;
	var optionsTipo = '<option value="" >Seleccione</option>';
	
	tipoBien.forEach(function (elemento , indice,array){
		optionsTipo = optionsTipo+'<option value="'+elemento+'" >'+elemento+'</option>';
	});
	
	var filaEli = "eliminarBien('bien"+cantidadB+"')";
	var acop = "agregarCop('valorBien"+cantidadB+"')";
	var form = "formato('valorBien"+cantidadB+"')";
	
	$('#bienPatrimonial tbody').append('<tr id="bien'+cantidadB+'">'+
			'	<td>'+
			'		<select name="tipoBien'+cantidadB+'" id="tipoBien'+cantidadB+'" class="anchoCompleto" style="max-width: 100% !important;" >'+
			optionsTipo+
			'		</select>'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="descripcionBien'+cantidadB+'" name="descripcionBien'+cantidadB+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="valorBien'+cantidadB+'" name="valorBien'+cantidadB+'" style="max-width: 100% !important;" title="El formato aceptado es solo valores numéricos el separador de miles es (.)" onblur="'+acop+'" onkeyup="'+form+'">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsB').val();
	if(ids=="")
		ids=cantidadB;
	else
		ids = ids+','+cantidadB;
	$('#idsB').val(ids);
}

function eliminarBien(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("bien","");
		var ids = $('#idsB').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsB').val(a);
		$('#'+fila).remove();
	}
}

function agregarOtroO(){
	cantidadO++;
	
	var filaEli = "eliminarObligacion('obligacion"+cantidadO+"')";
	var acop = "agregarCop('valorObligacion"+cantidadB+"')";
	var form = "formato('valorObligacion"+cantidadB+"')";
	
	$('#Obligaciones tbody').append('<tr id="obligacion'+cantidadO+'">'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="tipoObligacion'+cantidadO+'" name="tipoObligacion'+cantidadO+'" style="max-width: 100% !important;">'+
			'	</td>'+
			'	<td>'+
			'		<input type="text" class="anchoCompleto" id="valorObligacion'+cantidadO+'" name="valorObligacion'+cantidadO+'" style="max-width: 100% !important;" title="El formato aceptado es solo valores numéricos el separador de miles es (.)" onblur="'+acop+'" onkeyup="'+form+'">'+
			'	</td>'+
			'	<td style="vertical-align: middle;">'+
			'		<a onclick="'+filaEli+'">'+
			'			<i class="fa fa-times"></i>'+
			'		</a>'+
			'	</td>'+
			'</tr>');

	var ids = $('#idsO').val();
	if(ids=="")
		ids=cantidadO;
	else
		ids = ids+','+cantidadO;
	$('#idsO').val(ids);
}

function eliminarObligacion(fila){
	respuesta = confirm("Esta seguro que desea eliminar esta fila");
	
	if(respuesta == true){
		var id = fila.replace("obligacion","");
		var ids = $('#idsO').val();
		var ids = ids.split(",");
		  var a =[];
		  for(i=1;i<=ids.length;i++){
		  	if(ids[i-1]!=id){
		    	a.push(ids[i-1]);
		    }
		  }
		$('#idsO').val(a);
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