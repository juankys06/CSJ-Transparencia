<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.co.csj.service.service.auditoriaLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.auditoria"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.usuario_data"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="java.util.List"%>
<%@page import="com.co.csj.service.service.publicacionesLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.publicaciones"%>
<%@ include file="/html/init-panel-control.jsp"%>

<%
	List<modeloBasico> depa = consultas.getDepartamentos();
	List<modeloBasico> enti = consultas.getEntidad();
	List<modeloBasico> espe = consultas.getEspecialidad();
	List<modeloBasico> anos = consultas.getAnosVigencia();
	
	JSONObject resultadoDSF = JSONFactoryUtil.createJSONObject();
	
	if(renderRequest.getPortletSession().getAttribute("resultadoRDSF")!=null){
		resultadoDSF = (JSONObject) renderRequest.getPortletSession().getAttribute("resultadoRDSF");
	}
	
%>

<div class="progreso" id="progreso">
	<div class="progress centroBarra">
	    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:100%">
	    </div>
	</div>
</div>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/administracion/auditoria.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="generarReporteDSF" name="generarReporteDSF"></portlet:actionURL>

<div class="container-fluid">

	<div style="display: inline-block; vertical-align: top; width: 14%; min-height: 430px">
		<jsp:include page="/html/administracion/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 85%;">
		<div class="container-fluid">
			<div class="row text-center">
				<h2>REPORTE DESPACHOS SIN FUNCIONARIOS</h2>
			</div>
			<br>
			<form action="<%=generarReporteDSF %>" method="post">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="departamento">Departamento</label>
							<select name="departamento" id="departamento" class="anchoCompleto select-option inputsPanel" onchange="municipiofiltro()" >
								<option value="">Seleccione</option>
								<% for(modeloBasico m : depa){ %>
									<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
								<% } %>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="municipio">Municipio</label>
							<select name="municipio" id="municipio" class="anchoCompleto select-option inputsPanel">
								<option value="">Seleccione</option>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="entidad">Entidad</label>
							<select name="entidad" class="anchoCompleto select-option inputsPanel" >
								<option value="">Seleccione</option>
								<% for(modeloBasico m : enti){ %>
									<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
								<% } %>
							</select>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="especialidad">Especialidad</label>
							<select name="especialidad" class="anchoCompleto select-option inputsPanel" >
								<option value="">Seleccione</option>
								<% for(modeloBasico m : espe){ %>
									<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
								<% } %>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="ano">Año de Vigencia</label>
							<select name="ano" class="anchoCompleto select-option inputsPanel" required="required" >
								<option value="">Seleccione</option>
								<% for(modeloBasico m : anos){ %>
									<option value="<%=m.getNombre() %>"><%=m.getNombre() %></option>
								<% } %>
							</select>
						</div>
					</div>
					<div class="col-md-4 text-center">
						<button type="submit" class="btn " >Buscar</button>
					</div>				
				</div>
			</form>
			<br>
			<% if(renderRequest.getPortletSession().getAttribute("resultadoRDSF")!=null){ 
					String dep = "";
					String mun = "";
					String ent = "";
					String esp = "";
					if(!resultadoDSF.getString("departamento").isEmpty()){
						for(modeloBasico d : depa){
							if(d.getCodigo().equals(resultadoDSF.getString("departamento")))
								dep = d.getNombre();
						}
					}
					if(!resultadoDSF.getString("municipio").isEmpty()){
						List<modeloBasico> muni = consultas.getMunicipiosR(resultadoDSF.getString("departamento"));
						for(modeloBasico d : muni){
							if(d.getCodigo().equals(resultadoDSF.getString("municipio")))
								mun = d.getNombre();
						}
					}
					if(!resultadoDSF.getString("entidad").isEmpty()){
						for(modeloBasico d : enti){
							if(d.getCodigo().equals(resultadoDSF.getString("entidad")))
								ent = d.getNombre();
						}
					}
					if(!resultadoDSF.getString("especialidad").isEmpty()){
						for(modeloBasico d : espe){
							if(d.getCodigo().equals(resultadoDSF.getString("especialidad")))
								esp = d.getNombre();
						}
					}
			%>
			<div class="row">
				<div class="col-md-6">
					<strong>Filtros Usados:</strong>
					<br>
					Departamento:  <%=dep %>
					<br>
					Municipio:   <%= mun %>
					<br>
					Entidad:   <%=ent %>
					<br>
					Especialidad: <%=esp %>
					<br>
					Año de vigencia: <%= resultadoDSF.getString("ano") %>
					<br>
					<br>
					<% 
						int cantidad = resultadoDSF.getJSONArray("data").length();
					%>
					Cantidad de despachos sin funcionarios:   <%=cantidad %>
				</div>
				<portlet:resourceURL var="ReporteExcel">
					<portlet:param name="pagina" value="1"/>
				</portlet:resourceURL>
				<div class="col-md-6 text-center" style="min-height: 160px; ">
					<a href="<%=ReporteExcel %>" target="_blank" style="position: absolute ; margin-top: 60px; left: 190px">
						<button class="btn" >Exportar a Excel</button>
					</a>
				</div>
			</div>
			<% } %>
		</div>
	</div>
</div>

<portlet:resourceURL var="filtro">
	<portlet:param name="pagina" value="fitroMuni"/>
</portlet:resourceURL>

<script type="text/javascript">
$('#collapse3').addClass("in");
$('#reporteDespachoSF').addClass("active");

function municipiofiltro(){
	var departamento = document.getElementById('departamento').value;

	$.ajax({
		url: '<%=filtro%>',
	    type:  'post',
	    dataType: 'json',
	    data:  {tipo_sol : 1 ,departamento : departamento },
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