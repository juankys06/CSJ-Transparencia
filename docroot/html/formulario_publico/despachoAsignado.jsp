<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
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
		List<modeloBasico> depa = consultas.getDepartamentos();
		List<modeloBasico> enti = consultas.getEntidad();
		List<modeloBasico> espe = consultas.getEspecialidad();
		String departamento = "";
		String municipio = "";
		String entidad = "";
		String especialidad = "";
		List<modeloBasico> muni = new ArrayList<modeloBasico>();
		List<modeloBasico> despa = new ArrayList<modeloBasico>();
		if(!usuario.getDespacho().isEmpty()){
			departamento = usuario.getDespacho().substring(0, 2);
			municipio = usuario.getDespacho().substring(0, 5);
			entidad = usuario.getDespacho().substring(5, 7);
			especialidad = usuario.getDespacho().substring(7, 9);
			muni = consultas.getMunicipios(departamento);
			despa = consultas.getDespachos(municipio, entidad, especialidad);
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
<portlet:actionURL var="guardarDespachoAsignado" name="guardarDespachoAsignado"></portlet:actionURL>

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
				<h2>Despacho Asignado</h2>
			</div>
			<br>
			<form action="<%=guardarDespachoAsignado %>" method="post">
				<div class="row">
					<div class="form-group col-md-6 col-md-offset-3">
			    		<label for="departamento" >DEPARTAMENTO:</label>
		      			<select class="anchoCompleto" name="departamento" id="departamento" onchange="municipiofiltro()">
		      				<option value="">Seleccione un departamento</option>
		      				<% for(modeloBasico m : depa){ 
		      					if(departamento.equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
		      			</select>
			    	</div>
		    	</div>
				<div class="row">
					<div class="form-group col-md-6 col-md-offset-3">
			    		<label for="municipio" >MUNICIPIO:</label>
			    		<select class="anchoCompleto" name="municipio" id="municipio" onchange="despachofiltro()">
			      			<option value="">Seleccione un municipio</option>
			      			<% for(modeloBasico m : muni){ 
		      					if(municipio.equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
			      		</select>
			    	</div>
			    </div>
		    	<div class="row">
					<div class="form-group col-md-6 col-md-offset-3">
						<label for="entidad" >ENTIDAD:</label>
		      			<select class="anchoCompleto" name="entidad" id="entidad" onchange="despachofiltro()">
		      				<option value="">Seleccione una entidad</option>
		      				<% for(modeloBasico m : enti){ 
		      					if(entidad.equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
		      			</select>
		      		</div>
		    	</div>
		    	<div class="row">
					<div class="form-group col-md-6 col-md-offset-3">
			    		<label for="especialidad" >ESPECIALIDAD:</label>
		      			<select class="anchoCompleto" name="especialidad" id="especialidad" onchange="despachofiltro()">
		      				<option value="">Seleccione una especialidad</option>
		      				<% for(modeloBasico m : espe){ 
			      				if(especialidad.equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
		      			</select>
		      		</div>
		    	</div>
		    	<div class="row">
					<div class="form-group col-md-6 col-md-offset-3">
			    		<label for="despacho" >DESPACHO:</label>
		      			<select class="anchoCompleto" name="despacho" id="despacho" required="required">
		      				<option value="">Seleccione un Despacho</option>
		      				<% for(modeloBasico m : despa){ 
		      					if(usuario.getDespacho().equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
		      			</select>
		      		</div>
		    	</div>
		    	<div class="row text-center">
					<h2>Cargo que Desempeña</h2>
				</div>
				<div class="row">
					<div class="form-group col-md-6 col-md-offset-3">
			    		<label for="cg" >CARGO:</label>
		      			<input type="text" class="anchoCompleto" style="max-width: 100% !important;" name="cargo" id="cargo" required="required" value="<%=usuario.getCargo() %>">
		      		</div>
		    	</div>
		    	<br>
		    	<div class="row text-center">
		    		<button class="btn" type="button" onclick="limpiar()">Limpiar</button>
		    		&nbsp;&nbsp;&nbsp;
					<button class="btn" value="Guardar" type="submit">Guardar</button>
				</div>
			</form>
		</div>
	</div>
</div>

<portlet:resourceURL var="filtro">
	<portlet:param name="pagina" value="despachoAsignado"/>
</portlet:resourceURL>

<script>
$('#despachoAsignado').addClass("active");

function limpiar(){
	$('#departamento option').removeAttr('selected');
	$('#municipio option').removeAttr('selected');
	$('#entidad option').removeAttr('selected');
	$('#especialidad option').removeAttr('selected');
	$('#despacho option').removeAttr('selected');
}

function municipiofiltro(){
var departamento = document.getElementById('departamento').value;

$.ajax({
	url: '<%=filtro%>',
    type:  'post',
    dataType: 'json',
    data:  {tipo_sol : 2 ,departamento : departamento },
    success:  function (response) {
    	var data = response;
    	$('#municipio').html('');
    	$('#municipio').append(new Option('Seleccione un municipio', ""));
    	$.each(data, function(i, des) {
    		$('#municipio').append(new Option(des.nombre, des.id));
        });
    }
});
}

function despachofiltro(){
var municipio = document.getElementById('municipio').value;
var entidad = document.getElementById('entidad').value;
var especialidad = document.getElementById('especialidad').value;

$.ajax({
	url: '<%=filtro%>',
    type:  'post',
    dataType: 'json',
    data:  {tipo_sol : 1 ,municipio : municipio, entidad : entidad, especialidad : especialidad },
    success:  function (response) {
    	var data = response;
    	$('#despacho').html('');
    	$('#despacho').append(new Option('Seleccione un Despacho', ""));
    	$.each(data, function(i, des) {
    		$('#despacho').append(new Option(des.nombre, des.id));
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