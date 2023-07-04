<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
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
		JSONObject tiempo_experiencia = JSONFactoryUtil.createJSONObject();
		if(!usuario.getTiempo_experiencia().isEmpty()){
			tiempo_experiencia = JSONFactoryUtil.createJSONObject(usuario.getTiempo_experiencia());
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
<portlet:actionURL var="guardarTiempoExperiencia" name="guardarTiempoExperiencia"></portlet:actionURL>

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
				<h2>Tiempo Total de Experiencia</h2>
			</div>
			<br>
			<div class="row">
				<h5 class="col-md-12">INDIQUE EL TIEMPO DE SU EXPERIENCIA LABORAL EN NÚMERO DE AÑOS Y MESES.</h5>
			</div>
			<br>
			<form action="<%=guardarTiempoExperiencia %>" method="post">
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
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("anosServidorPublico") %>" step="1" type="number" name="anosSP" id="anosSP" onchange="calcularAnos()" >
							        </td>
							        <td>
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("mesesServidorPublico") %>" step="1" type="number" name="mesesSP" id="mesesSP" onchange="calcularMesesPu()">
							        </td>
						      	</tr>
						      	<tr>
							        <td>EMPLEADO DEL SECTOR PRIVADO</td>
							        <td>
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("anosSectorPrivado") %>" step="1" type="number" name="anosESP" id="anosESP" onchange="calcularAnos()">
							        </td>
							        <td>
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("mesesSectorPrivado") %>" step="1" type="number" name="mesesESP" id="mesesESP" onchange="calcularMesesPr()">
							        </td>
						      	</tr>
						      	<tr>
							        <td>TRABAJADOR INDEPENDIENTE</td>
							        <td>
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("anosTrabajadorIndependiente") %>" step="1" type="number" name="anosTI" id="anosTI" onchange="calcularAnos()">
							        </td>
							        <td>
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("mesesTrabajadorIndependiente") %>" step="1" type="number" name="mesesTI" id="mesesTI" onchange="calcularMesesI()">
							        </td>
						      	</tr>
						      	<tr>
							        <td>TIEMPO TOTAL DE EXPERIENCIA</td>
							        <td>
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("anosM") %>"type="hidden" name="anosM" id="anosM">
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("anosTotales") %>" readonly="readonly" step="1" type="number" name="anosTotal" id="anosTotal">
							        </td>
							        <td>
							        	<input class="select-option" value="<%=tiempo_experiencia.getInt("mesesTotales") %>" readonly="readonly" step="1" type="number" name="mesesTotal" id="mesesTotal">
							        </td>
						      	</tr>
						    </tbody>
					  	</table>
					  	<div class="row text-center">
							<button class="btn" value="Guardar" type="submit">Guardar</button>
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
$('#tiempoExperiencia').addClass("active");

function calcularAnos(){
	var anos1 = $('#anosSP').val();
	var anos2 = $('#anosESP').val();
	var anos3 = $('#anosTI').val();
	var anos4 = $('#anosM').val();
	$('#anosTotal').val(parseInt(anos1)+parseInt(anos2)+parseInt(anos3)+parseInt(anos4));
	
}
function calcularMeses(){
	var meses1 = $('#mesesSP').val();
	var meses2 = $('#mesesESP').val();
	var meses3 = $('#mesesTI').val();
	var anos = $('#anosTotal').val();
	var anosM = $('#anosM').val();
	var meses = parseInt(meses1)+parseInt(meses2)+parseInt(meses3);
	var x = meses % 12;
	var y = meses / 12;
	y = Math.trunc(y);
	console.log(meses);
	console.log(x);
	console.log(y);
	$('#mesesTotal').val(x);
	$('#anosM').val(y);
	calcularAnos();
}
function calcularMesesPu(){
	var meses = $('#mesesSP').val();
	var anos = $('#anosSP').val();
	var x = meses % 12;
	var y = meses / 12;
	y = Math.trunc(y);
	anos = parseInt(anos)+parseInt(y);
	$('#mesesSP').val(x);
	$('#anosSP').val(anos);
	calcularAnos();
	calcularMeses();
}
function calcularMesesPr(){
	var meses = $('#mesesESP').val();
	var anos = $('#anosESP').val();
	var x = meses % 12;
	var y = meses / 12;
	y = Math.trunc(y);
	anos = parseInt(anos)+parseInt(y);
	$('#mesesESP').val(x);
	$('#anosESP').val(anos);
	calcularAnos();
	calcularMeses();
}
function calcularMesesI(){
	var meses = $('#mesesTI').val();
	var anos = $('#anosTI').val();
	var x = meses % 12;
	var y = meses / 12;
	y = Math.trunc(y);
	anos = parseInt(anos)+parseInt(y);
	$('#mesesTI').val(x);
	$('#anosTI').val(anos);
	calcularAnos();
	calcularMeses();
}

</script>
<% }else{ %>
<script type="text/javascript">
$(document).ready( function(){
	window.location.href = '<%=home%>';
});
</script>
<% } %>